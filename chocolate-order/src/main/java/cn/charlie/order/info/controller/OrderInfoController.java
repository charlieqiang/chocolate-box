package cn.charlie.order.info.controller;

import cn.charlie.order.base.service.OrderBaseService;
import cn.charlie.order.info.entity.OrderInfo;
import cn.charlie.order.info.entity.OrderParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author charlie
 * @date 3/7/2023 10:34 AM
 **/
@RestController
@RequestMapping("/info")
public class OrderInfoController {
    @Autowired
    OrderBaseService orderBaseService;

    @PostMapping("")
    public OrderInfo bookingOrder(@RequestBody OrderParam orderParam) throws Exception {
        return orderBaseService.bookingOrder(orderParam);
    }
}
