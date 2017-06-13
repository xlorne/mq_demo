package test;


import com.lorne.core.framework.utils.encode.MD5Util;
import com.lorne.core.framework.utils.http.HttpUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;

import java.util.List;
import java.util.Map;

/**
 * Created by yuliang on 2016/7/8.
 */
public class BaseTest {

    private String json;
    private String action;
    private JSONObject params;
    private String token = "";


    @Before
    public void before() {
        json = "";
        action = "";
        params = new JSONObject();
    }

    public JsonResult execute(String action, IMapParam param) {
        return execute(action, false, param);
    }

    public JsonResult execute(String action, boolean hasToken, IMapParam param) {
        setParams(action, param);
        Object rets = null;
        if (hasToken) {
            token = TokenHolder.getInstance().getToken();
        }
        json = params.toString();
        try {
            long start = System.currentTimeMillis();
            String url = Url.url + "/" + action;
            String sign = null;
            if (token == null || token.equals("")) {
                sign = MD5Util.md5("content=" + json);
            } else {
                sign = MD5Util.md5("token=" + token + "&content=" + json);
            }
            url += "?sign=" + sign + "&token=" + token;
            System.out.println(url);
            System.out.println(json);
            String result = HttpUtils.postJson(url, json);
            long end = System.currentTimeMillis();
            System.out.println("执行时间(毫秒):" + (end - start));
            System.out.println(result);
            JSONObject jsonObject = JSONObject.fromObject(result);
            int state = jsonObject.getInt("state");
            Assert.assertEquals(state, 1);
            JSONObject res = jsonObject.getJSONObject("res");
            Object data = res.get("data");
            if (data instanceof JSONObject) {
                JsonResult<Map<String, Object>> mdata = new JsonResult<Map<String, Object>>();

                mdata.setCode(res.getInt("code"));
                mdata.setMsg(res.getString("msg"));

                Map<String, Object> map = (Map<String, Object>) data;
                mdata.setData(map);

                Assert.assertNotNull(map);

                rets = mdata;
            } else if (data instanceof JSONArray) {
                JsonResult<List<Map<String, Object>>> mdata = new JsonResult<List<Map<String, Object>>>();
                List<Map<String, Object>> list = (List<Map<String, Object>>) data;
                mdata.setCode(res.getInt("code"));
                mdata.setMsg(res.getString("msg"));

                Assert.assertNotNull(list);
                Assert.assertTrue(list.size() > 0);

                mdata.setData(list);
                rets = mdata;
            }else if(data instanceof Boolean){
                JsonResult<Boolean> mdata = new JsonResult<Boolean>();
                Boolean bool = (Boolean) data;
                mdata.setCode(res.getInt("code"));
                mdata.setMsg(res.getString("msg"));
                Assert.assertNotNull(bool);
                mdata.setData(bool);
                rets = mdata;
            }
            Assert.assertNotNull(rets);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (JsonResult) rets;
    }

    private void setParams(String action, IMapParam param) {
        this.action = action;
        if (param != null) {
            param.setParams(params);
        }
    }
}
