package cn.charlie.customer.base.controller;

import cn.charlie.customer.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author charlie
 * @date 3/5/2023 9:42 PM
 **/
@RestController
@RequestMapping("/customer/base")
public class BaseController {
    @Autowired
    private BaseService baseService;

    @GetMapping("")
    public String echo(@RequestParam String str) {
        return baseService.echo(str);
    }
}
