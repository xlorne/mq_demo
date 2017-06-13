package com.shop.order.dao.impl;

import com.common.mysql.entity.Order;
import com.shop.order.dao.OrderDao;
import com.shop.user.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * Created by lorne on 2017/6/12.
 */
@Repository
public class OrderDaoImpl implements OrderDao {


    @Override
    public void createOrder(Order order) {
        //todo 业务处理
    }
}
