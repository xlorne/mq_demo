package com.shop.mq.service.impl;

import com.common.mysql.entity.Product;
import com.lorne.core.framework.exception.ServiceException;
import com.shop.mq.service.MQProductService;
import com.shop.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lorne on 2017/6/13.
 */
@Service
public class MQProductServiceImpl implements MQProductService {


    @Autowired
    private ProductService productService;

    @Override
    public Product checkProductCount(int productId) throws ServiceException {
        return productService.checkProductCount(productId);
    }
}
