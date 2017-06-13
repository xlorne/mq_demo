package com.shop.mq.service.impl;

import com.common.mysql.entity.User;
import com.lorne.core.framework.exception.ServiceException;
import com.shop.mq.service.MQUserService;
import com.shop.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lorne on 2017/6/13.
 */
@Service
public class MQUserServiceImpl implements MQUserService {

    @Autowired
    private UserService userService;

    @Override
    public User checkUserMoney(int userId) throws ServiceException {
        return userService.checkUserMoney(userId);
    }
}
