package cn.charlie.member.info.controller;

import cn.charlie.member.info.entity.MemberInfo;
import cn.charlie.member.info.service.MemberInfoService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author charlie
 * @date 3/5/2023 10:32 PM
 **/
@RestController
@RequestMapping("/info")
public class MemberInfoController {
    @Autowired
    private MemberInfoService memberInfoService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("")
    public List<MemberInfo> getAllMemberInfo() {
        return memberInfoService.getAllMemberInfo();
    }

    private static final String MEMBER_INFO_NAME_KEY = "MEMBER_INFO_NAME_KEY";
    private static final String MEMBER_INFO_NAME_LOCK = "MEMBER_INFO_NAME_LOCK";

    @PostMapping("/name")
    public String addMemberName(@RequestBody String name) throws Exception {
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

    @GetMapping("/name")
    public String getMemberName() {
        Object name = redisTemplate.opsForValue().get(MEMBER_INFO_NAME_KEY);
        if (null == name) {
            return "";
        }
        System.out.println(name);
        return name.toString();
    }
}
