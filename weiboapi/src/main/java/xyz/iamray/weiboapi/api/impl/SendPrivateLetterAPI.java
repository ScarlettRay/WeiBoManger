package xyz.iamray.weiboapi.api.impl;

import xyz.iamray.core.PostSpider;
import xyz.iamray.link.Result;
import xyz.iamray.weiboapi.api.API;
import xyz.iamray.weiboapi.api.APINumber;
import xyz.iamray.weiboapi.api.Context;
import xyz.iamray.weiboapi.common.R;
import xyz.iamray.weiboapi.common.constant.AutoWeiBoSpiderConstant;
import xyz.iamray.weiboapi.common.constant.Constant;
import xyz.iamray.weiboapi.pojo.PrivateLetter;
import xyz.iamray.weiboapi.spider.action.SendPrivateLetterAction;
import xyz.iamray.weiboapi.utils.PostBodyBuildUtil;

import java.util.Map;

/**
 * @author winray
 * @since v1.0.1
 * 私信api
 */
public class SendPrivateLetterAPI implements API<PrivateLetter,PrivateLetter> {

    @Override
    public String getNumber() {
        return APINumber.SENDPRIVATELETTERAPI;
    }

    @Override
    public R<PrivateLetter> exe(PrivateLetter letter, Context context) {
        Map<String,String> postBody = PostBodyBuildUtil.buildPrivateMesParam(letter.getUid(),letter.getContent());
        Result<PrivateLetter> re = PostSpider.make().defaultThreadPool().setRequestHeader(Constant.COMMON_HEADER)
                .setStarterConfiger(AutoWeiBoSpiderConstant.SendPrivateMes_URL+System.currentTimeMillis(),
                        postBody, SendPrivateLetterAction.INSTANCE,context.getHttpClient())
                .start();
        return R.ok(re.getObj());
    }
}