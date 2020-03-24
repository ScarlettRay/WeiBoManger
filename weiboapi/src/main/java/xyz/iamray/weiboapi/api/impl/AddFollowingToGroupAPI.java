package xyz.iamray.weiboapi.api.impl;

import xyz.iamray.core.PostSpider;
import xyz.iamray.link.Result;
import xyz.iamray.weiboapi.api.API;
import xyz.iamray.weiboapi.api.APINumber;
import xyz.iamray.weiboapi.api.Context;
import xyz.iamray.weiboapi.common.R;
import xyz.iamray.weiboapi.common.constant.AutoWeiBoSpiderConstant;
import xyz.iamray.weiboapi.common.constant.Constant;
import xyz.iamray.weiboapi.pojo.WeiBoer;
import xyz.iamray.weiboapi.spider.action.CommonResponseHandleAction;
import xyz.iamray.weiboapi.utils.PostBodyBuildUtil;

import java.util.Map;

/**
 * @author winray
 * @since v1.0.1
 * 将用户加入指定分组
 */
public class AddFollowingToGroupAPI implements API<WeiBoer,WeiBoer> {

    @Override
    public String getNumber() {
        return APINumber.ADDFOLLOWINGTOGROUPAPI;
    }

    @Override
    public R<WeiBoer> exe(WeiBoer weiBoer, Context context) {
        Map<String,String> postBody = PostBodyBuildUtil.buildGroupAddParam(weiBoer.getGid(),weiBoer.getUid());
        Result<WeiBoer> re = PostSpider.make().defaultThreadPool().
                setRequestHeader(Constant.COMMON_HEADER)
                .setStarterConfiger(AutoWeiBoSpiderConstant.UpdateGroup_URL+System.currentTimeMillis(),
                        postBody, CommonResponseHandleAction.INSTANCE, context.getHttpClient())
                .start();
        return R.ok(re.getObj());
    }
}