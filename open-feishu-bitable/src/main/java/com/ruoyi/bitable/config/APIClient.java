package com.ruoyi.bitable.config;

import com.lark.oapi.Client;
import com.lark.oapi.core.enums.AppType;
import com.lark.oapi.core.enums.BaseUrlEnum;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Component
public class APIClient {

    private static ConcurrentHashMap<String, Client> clientBeanMap = new ConcurrentHashMap<>();

    /**
     * 多个自建应用配置
     * @param appID
     * @param appSecret
     * @param appType
     * @return
     */
    public Client getClient(String appID, String appSecret, int appType) {
        Client client = clientBeanMap.get(appID);
        if(client!=null){
            return client;
        }
        Client.Builder clientBuilder = Client.newBuilder(appID, appSecret)
                //.marketplaceApp() // 设置 app 类型为商店应用
                .openBaseUrl(BaseUrlEnum.FeiShu) // 设置域名，默认为飞书
                //.helpDeskCredential("helpDeskId","helpDeskSecret") // 服务台应用才需要设置
                .requestTimeout(10, TimeUnit.SECONDS); // 设置httpclient 超时时间，默认永不超时
                //.logReqAtDebug(true) // 在 debug 模式下会打印 http 请求和响应的 headers,body 等信息。
        if(AppType.MARKETPLACE.ordinal() == appType){
            clientBuilder.marketplaceApp();
        }
        client = clientBuilder.build();
        clientBeanMap.put(appID, client);
        return client;
    }
}
