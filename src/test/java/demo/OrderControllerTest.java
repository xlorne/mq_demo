package demo;

import net.sf.json.JSONObject;
import org.junit.Test;
import test.BaseTest;
import test.IMapParam;

/**
 * RestController 测试
 * Created by lorne on 2017/6/12.
 */
public class OrderControllerTest extends BaseTest {


    /**
     * token sign机制
     * RestController封装
     * 自定义异常逻辑处理
     */
    @Test
    public void index(){
        execute("demo/list",true, new IMapParam() {
            @Override
            public void setParams(JSONObject params) {

            }
        });
    }


}
