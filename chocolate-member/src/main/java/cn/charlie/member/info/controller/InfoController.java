package cn.charlie.member.info.controller;

import cn.charlie.member.info.entity.Info;
import cn.charlie.member.info.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author charlie
 * @date 3/5/2023 10:32 PM
 **/
@RestController
@RequestMapping("/member/info")
public class InfoController {
    @Autowired
    private InfoService infoService;

    @GetMapping("")
    public List<Info> getAllMemberInfo() {
        return infoService.getAllMemberInfo();
    }
}
