package xyz.iamray.weiboapi.api.impl;

import lombok.extern.slf4j.Slf4j;
import xyz.iamray.core.PostSpider;
import xyz.iamray.link.Result;
import xyz.iamray.weiboapi.api.API;
import xyz.iamray.weiboapi.api.APINumber;
import xyz.iamray.weiboapi.api.Context;
import xyz.iamray.weiboapi.common.R;
import xyz.iamray.weiboapi.common.constant.AutoWeiBoSpiderConstant;
import xyz.iamray.weiboapi.common.constant.Constant;
import xyz.iamray.weiboapi.pojo.GroupMessage;
import xyz.iamray.weiboapi.spider.action.SendGroupMessageAction;
import xyz.iamray.weiboapi.utils.PostBodyBuildUtil;

import java.util.Map;

/**
 * @author winray
 * @since v1.0.1
 * 发送群消息
 */
@Slf4j
public class SendGroupMessageAPI implements API<GroupMessage,GroupMessage> {

    @Override
    public String getNumber() {
        return APINumber.SENDGROUPMESSAGEAPI;
    }

    @Override
    public R<GroupMessage> exe(GroupMessage groupMessage, Context context) {
        String url = AutoWeiBoSpiderConstant.GROUP_CHAT_ADD_URL+System.currentTimeMillis();
        Map<String,String> postBody = PostBodyBuildUtil.buildGroupChatParam(groupMessage.getGid(),groupMessage.getContent());
        PostSpider spider = PostSpider.make();
        spider.customThreadPool(context.getExecutorService(),true);
        Result<GroupMessage> result = spider.setRequestHeader(Constant.COMMON_HEADER)
                .setStarterConfiger(url,postBody, SendGroupMessageAction.INSTANCE,context.getHttpClient())
                .start();
        return R.ok(result.getObj());
    }
}