package com.shop.mq.service;

import com.common.mysql.entity.Product;
import com.lorne.core.framework.exception.ServiceException;

/**
 * Created by lorne on 2017/6/13.
 */
public interface MQProductService {

    Product checkProductCount(int productId) throws ServiceException;
}
