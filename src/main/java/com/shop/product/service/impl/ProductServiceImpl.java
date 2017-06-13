package com.shop.product.service.impl;

import com.common.mysql.entity.Product;
import com.lorne.core.framework.exception.ServiceException;
import com.shop.product.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * Created by lorne on 2017/6/13.
 */
@Service
public class ProductServiceImpl implements ProductService {


    @Override
    public Product checkProductCount(int productId) throws ServiceException {
        //todo 业务处理

        return null;
    }
}
