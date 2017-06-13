package com.common.interceptor;

import com.lorne.core.framework.interceptor.BaseMobileRESTAPIInterceptorAdapter;

import java.util.List;

/**
 * Created by lorne on 2017/6/12.
 */
public class MobileInterceptorAdapter extends BaseMobileRESTAPIInterceptorAdapter {

    @Override
    public void loadVerificationPath(List<String> list) {

        list.add("/mobile/shop/login");
    }
}
