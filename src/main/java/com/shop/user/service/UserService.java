package com.shop.user.service;

import com.common.mysql.entity.User;
import com.lorne.core.framework.exception.ServiceException;

/**
 * Created by lorne on 2017/6/13.
 */
public interface UserService {

    User checkUserMoney(int userId) throws ServiceException;
}
