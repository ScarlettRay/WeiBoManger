package xyz.iamray.weiboapi.api.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import xyz.iamray.weiboapi.api.APIManager;
import xyz.iamray.weiboapi.api.APINumber;
import xyz.iamray.weiboapi.api.ContextBuilder;
import xyz.iamray.weiboapi.api.context.Context;
import xyz.iamray.weiboapi.common.R;
import xyz.iamray.weiboapi.pojo.Blog;
import xyz.iamray.weiboapi.pojo.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

@Slf4j
public class GetMobalHotCommentAPITest {

    @Test
    public void testCrawlComment(){
        List<String> apis = new ArrayList<>();
        apis.add(APINumber.GETMOBALHOTCOMMENTAPI);
        Blog blog = new Blog();
        blog.setMid("4482129221905543");
        Context context = ContextBuilder.buildContext(Executors.newSingleThreadExecutor());
        R<List<Comment>> r =  APIManager.call(blog,apis,null,context);
        r.getRe().forEach(e->log.info(e.toString()));
    }

}
