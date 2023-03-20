package com.ruoyi.bitable.manager;

import com.lark.oapi.Client;
import com.lark.oapi.service.bitable.v1.model.ListAppTableRecordReq;
import com.lark.oapi.service.bitable.v1.model.ListAppTableRecordResp;
import com.ruoyi.bitable.config.APIClient;
import com.ruoyi.bitable.domain.BitableAppConfig;
import com.ruoyi.bitable.service.IBitableAppConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BitableApiCall {
    @Autowired
    private APIClient apiClient;
    @Autowired
    private IBitableAppConfigService bitableAppConfigService;


    public void listRecords(BitableAppConfig appConfig, ListAppTableRecordReq req){
        Client client = apiClient.getClient(appConfig.getAppId(), appConfig.getAppSecret(), appConfig.getAppType());
        ListAppTableRecordResp resp = null;
        try {
            resp = client.bitable().appTableRecord().list(req);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 处理服务端错误
        if (!resp.success()) {
            System.out.println(String.format("code:%s,msg:%s,reqId:%s"
                    , resp.getCode(), resp.getMsg(), resp.getRequestId()));
            return;
        }

    }

}
