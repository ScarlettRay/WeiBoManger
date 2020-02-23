package xyz.iamray.weibomanger.spider.action;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import xyz.iamray.action.impl.AbstractDocumentCrawlerAction;
import xyz.iamray.repo.CrawlMes;
import xyz.iamray.weibomanger.common.PropCrawlAction;
import xyz.iamray.weibomanger.pojo.Blog;

import java.util.ArrayList;
import java.util.List;

/**
 * @author winray
 * @since v1.0.1
 */
@Slf4j
public class CrawlWeiBoAction extends AbstractDocumentCrawlerAction<List<Blog>> {

    public static CrawlWeiBoAction INSTANCE = new CrawlWeiBoAction();

    private static final PropCrawlAction[] propCrawlActions = PropCrawlAction.values();

    @Override
    public List<Blog> crawl(Document document, CrawlMes crawlMes) {
        Elements els = document.select("div[action-type=feed_list_item]");//获取全部列表
        //自定义要抓取的属性
        PropCrawlAction[] customPropActions = getAttr("cutsom_prop",PropCrawlAction[].class);
        if(customPropActions == null || customPropActions.length == 0)customPropActions = propCrawlActions;
        List<Blog> blogs = new ArrayList<>();
        for (Element el : els) {
            Blog blog = new Blog();
            for (PropCrawlAction action : customPropActions) {
                action.crawl(el,blog);
            }
            blogs.add(blog);
        }

        return blogs;
    }

}
