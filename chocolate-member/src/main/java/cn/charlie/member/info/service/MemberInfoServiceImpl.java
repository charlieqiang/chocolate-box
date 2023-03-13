package cn.charlie.member.info.service;

import cn.charlie.common.entity.snowflakeid.SnowflakeIdWorker;
import cn.charlie.member.info.eemapper.MemberInfoEeMapper;
import cn.charlie.member.info.entity.MemberInfo;
import cn.charlie.member.info.entity.MemberInfoParam;
import cn.charlie.member.info.mapper.MemberInfoMapper;
import cn.easyes.core.conditions.LambdaEsQueryWrapper;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author charlie
 * @date 3/5/2023 10:42 PM
 **/
@Service
public class MemberInfoServiceImpl implements MemberInfoService {
    @Autowired
    private MemberInfoMapper memberInfoMapper;

    @Override
    public List<MemberInfo> getAllMemberInfo() {
        return memberInfoMapper.selectAll();
    }

    @Autowired
    private MemberInfoEeMapper memberInfoEeMapper;

    @Override
    public MemberInfo createMemberInfoByEs(MemberInfoParam memberInfoParam) throws Exception {
        MemberInfo memberInfo = buildMemberInfo(memberInfoParam);
        Integer affectedRows = memberInfoEeMapper.insert(memberInfo);
        if (affectedRows > 0) {
            return memberInfo;
        } else {
            throw new Exception("用户创建失败: es服务出错!");
        }
    }

    private MemberInfo buildMemberInfo(MemberInfoParam memberInfoParam) throws Exception {
        MemberInfo memberInfo = new MemberInfo();
        if (ObjectUtils.isEmpty(memberInfoParam)) {
            throw new Exception("用户创建失败: 参数不能为空!");
        }
        long id = SnowflakeIdWorker.getInstance().nextId();
        memberInfo.setId(id);
        memberInfo.setName(memberInfoParam.getName());
        memberInfo.setSex(memberInfoParam.getSex());
        memberInfo.setAge(memberInfoParam.getAge());
        return memberInfo;
    }

    @Override
    public List<MemberInfo> getAllMemberInfoByEs() {
        LambdaEsQueryWrapper<MemberInfo> memberInfoWrapper = new LambdaEsQueryWrapper<>();
        List<MemberInfo> memberInfoList = memberInfoEeMapper.selectList(memberInfoWrapper);
        return memberInfoList;
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    private static final String MEMBER_INFO_NAME_KEY = "MEMBER_INFO_NAME_KEY";
    private static final String MEMBER_INFO_NAME_LOCK = "MEMBER_INFO_NAME_LOCK";

    @Override
    public String addMemberNameByRedis(String name) throws Exception {
        RLock nameLock = redissonClient.getLock(MEMBER_INFO_NAME_LOCK);

        if (nameLock.isLocked()) {
            throw new Exception("用户名称添加中...");
        }
        nameLock.lock();
        try {
            redisTemplate.opsForValue().set(MEMBER_INFO_NAME_KEY, name);
        } catch (Exception e) {
            System.out.println("用户名称添加失败: " + e);
            throw new Exception("用户名称添加失败", e);
        } finally {
            nameLock.unlock();
        }
        return name;
    }

    @Override
    public String getMemberNameByRedis() {
        Object name = redisTemplate.opsForValue().get(MEMBER_INFO_NAME_KEY);
        if (null == name) {
            return "";
        }
        System.out.println(name);
        return name.toString();
    }
}
