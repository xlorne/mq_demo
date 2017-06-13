package com.shop.order.dao;

import com.common.mysql.entity.Order;

/**
 * Created by lorne on 2017/6/12.
 */
public interface OrderDao {

    void createOrder(Order order);

}
