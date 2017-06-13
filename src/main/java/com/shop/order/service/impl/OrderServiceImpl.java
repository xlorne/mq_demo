package com.shop.order.service.impl;

import com.common.mysql.entity.Order;
import com.common.mysql.entity.Product;
import com.common.mysql.entity.User;
import com.lorne.core.framework.exception.ServiceException;
import com.lorne.core.framework.utils.json.JsonUtils;
import com.shop.mq.service.MQProductService;
import com.shop.mq.service.MQUserService;
import com.shop.order.dao.OrderDao;
import com.shop.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lorne on 2017/6/13.
 */
@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private MQUserService mqUserService;

    @Autowired
    private MQProductService mqProductService;

    @Autowired
    private OrderDao orderDao;

    @Override
    public Map<String, Object> createOrder(String json) throws ServiceException {
        int productId = JsonUtils.getInt(json,"productId",0);
        int userId = JsonUtils.getInt(json,"userId",0);
        //todo 检查商品库存

        Product product =  mqProductService.checkProductCount(productId);

        //todo 检查用户金额

        User user =  mqUserService.checkUserMoney(userId);

        //todo 组装订单数据
        Order order = null;


        //todo 创建订单
        orderDao.createOrder(order);

        Map<String, Object> res = new HashMap<>();
        res.put("order",order);
        res.put("product",product);
        res.put("user",user);

        return res;
    }
}
