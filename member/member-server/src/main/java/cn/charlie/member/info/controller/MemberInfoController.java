package cn.charlie.member.info.controller;

import cn.charlie.member.info.entity.MemberInfo;
import cn.charlie.member.info.service.MemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author charlie
 * @date 2/28/2023 4:09 PM
 **/
@RestController
@RequestMapping("/member_info")
public class MemberInfoController {

    @Autowired
    private MemberInfoService memberInfoService;

    @GetMapping("")
    public List<MemberInfo> getAllMemberInfo() {
        return memberInfoService.getAllMemberInfo();
    }
}