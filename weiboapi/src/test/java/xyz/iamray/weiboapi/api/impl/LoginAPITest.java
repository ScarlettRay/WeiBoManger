package xyz.iamray.weiboapi.api.impl;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import xyz.iamray.weiboapi.api.APIManager;
import xyz.iamray.weiboapi.api.APINumber;
import xyz.iamray.weiboapi.api.ContextBuilder;
import xyz.iamray.weiboapi.common.R;
import xyz.iamray.weiboapi.pojo.WeiBoer;
import xyz.iamray.weiboapi.utils.TestConstant;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class LoginAPITest {

    @Test
    public void testLoginAPI(){
        List<String> apis = new ArrayList<>();
        apis.add(APINumber.LOGINAPI);
        R<WeiBoer> r = APIManager.call(TestConstant.WEIBOER,apis, null,ContextBuilder.buildContext());
        log.info("登陆成功：" + r.getRe().getUid());

    }

    @Test
    public void testLength(){
    }
}
