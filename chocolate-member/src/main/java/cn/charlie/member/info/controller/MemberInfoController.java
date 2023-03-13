package cn.charlie.member.info.controller;

import cn.charlie.member.info.entity.MemberInfo;
import cn.charlie.member.info.entity.MemberInfoParam;
import cn.charlie.member.info.service.MemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("")
    public List<MemberInfo> getAllMemberInfo() {
        return memberInfoService.getAllMemberInfo();
    }

    @PostMapping("/name")
    public String addMemberNameByRedis(@RequestBody String name) throws Exception {
        return memberInfoService.addMemberNameByRedis(name);
    }

    @GetMapping("/name")
    public String getMemberNameByRedis() {
        return memberInfoService.getMemberNameByRedis();
    }

    @PostMapping("/es")
    public MemberInfo createMemberInfoByEs(@RequestBody MemberInfoParam memberInfoParam) throws Exception {
        return memberInfoService.createMemberInfoByEs(memberInfoParam);
    }

    @GetMapping("/es")
    public List<MemberInfo> getAllMemberInfoByEs() {
        return memberInfoService.getAllMemberInfoByEs();
    }
}
