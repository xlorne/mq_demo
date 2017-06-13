package com.shop.order.service;

import com.lorne.core.framework.exception.ServiceException;

import java.util.Map;

/**
 * Created by lorne on 2017/6/13.
 */
public interface OrderService {


    Map<String,Object> createOrder(String json) throws ServiceException;
}
