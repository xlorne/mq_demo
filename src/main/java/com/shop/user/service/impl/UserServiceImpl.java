package com.shop.user.service.impl;

import com.common.mysql.entity.User;
import com.lorne.core.framework.exception.ServiceException;
import com.shop.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by lorne on 2017/6/13.
 */
@Service
public class UserServiceImpl implements UserService {


    @Override
    public User checkUserMoney(int userId) throws ServiceException {
        //todo 业务处理
        return null;
    }
}
