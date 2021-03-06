package xyz.iamray.weiboapi.spider.action;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import xyz.iamray.action.impl.AbstractJsonObjectCrawlerAction;
import xyz.iamray.repo.CrawlMes;
import xyz.iamray.weiboapi.common.constant.TextConstant;
import xyz.iamray.weiboapi.common.exception.WbException;
import xyz.iamray.weiboapi.pojo.Blog;

/**
 * @author winray
 * @since v1.0.1
 * {@link xyz.iamray.weiboapi.api.impl.DeliverBlogAPI}
 */
@Slf4j
public class DeliverBlogAction extends AbstractJsonObjectCrawlerAction<Blog> {

    public static final DeliverBlogAction INSTANCE = new DeliverBlogAction();

    @Override
    public Blog crawl(JSONObject jsonObject, CrawlMes crawlMes) {
        if(jsonObject.getInteger("code") == 100000){
            //进行一些属性的设置

            return getAttribute(TextConstant.API_INPUT,Blog.class);
        }else{
            throw new WbException(jsonObject.toJSONString());
        }
    }
}
