package com.shop.product.service;

import com.common.mysql.entity.Product;
import com.lorne.core.framework.exception.ServiceException;

/**
 * Created by lorne on 2017/6/13.
 */
public interface ProductService {

    Product checkProductCount(int productId) throws ServiceException;
}
