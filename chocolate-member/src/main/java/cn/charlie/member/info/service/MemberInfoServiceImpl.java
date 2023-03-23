package cn.charlie.member.info.service;

import cn.charlie.member.info.builder.MemberInfoBuilder;
import cn.charlie.member.info.constant.KeyConstant;
import cn.charlie.member.info.constant.LockConstant;
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
import org.springframework.transaction.annotation.Transactional;
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
        MemberInfo memberInfo = MemberInfoBuilder.buildMemberInfo(memberInfoParam);
        Integer affectedRows = memberInfoEeMapper.insert(memberInfo);
        if (affectedRows > 0) {
            return memberInfo;
        } else {
            throw new Exception("用户创建失败: es服务出错!");
        }
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

    @Override
    public MemberInfo addMemberByRedis(MemberInfoParam memberInfoParam) throws Exception {
        if (ObjectUtils.isEmpty(memberInfoParam)) {
            throw new Exception("参数不能为空");
        }
        RLock nameLock = redissonClient.getLock(LockConstant.MEMBER_INFO_NAME_LOCK);

        if (nameLock.isLocked()) {
            throw new Exception("用户添加中...");
        }
        nameLock.lock();
        try {
            redisTemplate.opsForValue().set(KeyConstant.MEMBER_INFO_NAME_KEY, memberInfoParam.getName());
        } catch (Exception e) {
            System.out.println("用户添加失败: " + e);
            throw new Exception("用户添加失败", e);
        } finally {
            nameLock.unlock();
        }
        MemberInfo memberInfo = MemberInfoBuilder.buildMemberInfo(memberInfoParam);
        return memberInfo;
    }

    @Override
    public String getMemberNameByRedis() {
        Object name = redisTemplate.opsForValue().get(KeyConstant.MEMBER_INFO_NAME_KEY);
        if (null == name) {
            return "";
        }
        System.out.println(name);
        return name.toString();
    }

    @Override
    @Transactional
    public MemberInfo addMemberInTransactionByRedis(MemberInfoParam memberInfoParam) throws Exception {
        if (ObjectUtils.isEmpty(memberInfoParam)) {
            throw new Exception("参数不能为空");
        }
        redisTemplate.opsForValue().set(KeyConstant.MEMBER_INFO_NAME_KEY, memberInfoParam.getName());
        MemberInfo memberInfo = MemberInfoBuilder.buildMemberInfo(memberInfoParam);
        return memberInfo;
    }
}
