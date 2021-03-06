package xyz.iamray.weiboapi.api.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import xyz.iamray.weiboapi.api.APIManager;
import xyz.iamray.weiboapi.api.APINumber;
import xyz.iamray.weiboapi.api.ContextBuilder;
import xyz.iamray.weiboapi.api.context.Context;
import xyz.iamray.weiboapi.common.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

@Slf4j
public class CrawlMobalHotListAPITest {

    @Test
    public void testAPI(){
        String url = "https://m.weibo.cn/api/container/getIndex?containerid=106003type%3D25%26t%3D3%26disable_hot%3D1%26filter_type%3Drealtimehot&title=%E5%BE%AE%E5%8D%9A%E7%83%AD%E6%90%9C&extparam=pos%3D0_0%26mi_cid%3D100103%26cate%3D10103%26filter_type%3Drealtimehot%26c_type%3D30%26display_time%3D1584597807";
        List<String> apis = new ArrayList<>();
        apis.add(APINumber.CRAWLMOBALHOTLISTAPI);
        Context context = ContextBuilder.buildContext(Executors.newSingleThreadExecutor());
        R<List<String>> r = APIManager.call(url,apis,null,context);
        r.getRe().forEach(e->log.info(e.toString()));
    }
}
