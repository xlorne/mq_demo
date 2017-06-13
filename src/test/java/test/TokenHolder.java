package test;

import com.lorne.core.framework.utils.encode.MD5Util;
import com.lorne.core.framework.utils.http.HttpUtils;
import net.sf.json.JSONObject;

/**
 * Created by yuliang on 2016/7/8.
 */
public class TokenHolder {

    private static TokenHolder holder = null;

    private TokenHolder() {
    }

    public static TokenHolder getInstance() {
        if (holder == null) {
            holder = new TokenHolder();
        }
        return holder;
    }

    private String json;
    private String action;
    private JSONObject params;
    private String token = "";

    public void setParams(String action, IMapParam param) {
        this.action = action;
        if (param != null) {
            param.setParams(params);
        }
    }

    public String getToken() {
        json = "";
        action = "";
        params = new JSONObject();

        setParams("demo/login", new IMapParam() {
            @Override
            public void setParams(JSONObject params) {
                params.put("name","admin");
                params.put("pwd","admin");
            }
        });
        json = params.toString();
        try {
            String url = Url.url + "/" + action;
            String sign = null;
            if (token == null || token.equals("")) {
                sign = MD5Util.md5("content=" + json);
            } else {
                sign = MD5Util.md5("token=" + token + "&content=" + json);
            }
            url += "?sign=" + sign + "&token=" + token;
            String result = HttpUtils.postJson(url, json);
            JSONObject jsonObject = JSONObject.fromObject(result);
            JSONObject res = jsonObject.getJSONObject("res");
            JSONObject data = res.getJSONObject("data");
            token = data.getString("token");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

}
