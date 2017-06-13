package com.shop.order.api.model.controller;

import com.lorne.core.framework.controller.IService;
import com.lorne.core.framework.controller.RestController;
import com.lorne.core.framework.exception.ServiceException;
import com.shop.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lorne on 2017/6/12.
 */
@Controller
@RequestMapping("/mobile/order")
public class OrderController extends RestController {


    @Autowired
    private OrderService orderService;

    @RequestMapping("/createOrder")
    public void createOrder(HttpServletRequest request, HttpServletResponse response){
        initEncode(request, response, new IService() {
            @Override
            public Object init(HttpServletRequest request, HttpServletResponse response, String json) throws ServiceException {
                return orderService.createOrder(json);
            }
        });
    }

}
