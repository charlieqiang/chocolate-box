package cn.charlie.member.info.controller;

import cn.charlie.common.entity.base.Result;
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
    public Result<List<MemberInfo>> getAllMemberInfo() {
        return Result.success(memberInfoService.getAllMemberInfo());
    }

    @PostMapping("")
    public Result<MemberInfo> addMemberByRedis(@RequestBody MemberInfoParam memberInfoParam) throws Exception {
        return Result.success(memberInfoService.addMemberByRedis(memberInfoParam));
    }

    @GetMapping("/name")
    public Result<String> getMemberNameByRedis() {
        return Result.success(memberInfoService.getMemberNameByRedis());
    }

    @PostMapping("/es")
    public Result<MemberInfo> createMemberInfoByEs(@RequestBody MemberInfoParam memberInfoParam) throws Exception {
        return Result.success(memberInfoService.createMemberInfoByEs(memberInfoParam));
    }

    @GetMapping("/es")
    public Result<List<MemberInfo>> getAllMemberInfoByEs() {
        return Result.success(memberInfoService.getAllMemberInfoByEs());
    }

    @PostMapping("/tx")
    public Result<MemberInfo> addMemberInTransactionByRedis(@RequestBody MemberInfoParam memberInfoParam) throws Exception {
        return Result.success(memberInfoService.addMemberInTransactionByRedis(memberInfoParam));
    }
}
