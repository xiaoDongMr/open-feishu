package com.ruoyi.bitable.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 多维格应用配置对象 bitable_app_config
 * 
 * @author 刘晓东
 * @date 2023-02-21
 */
public class BitableAppConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 应用配置id */
    private String id;

    /** 飞书appID */
    @Excel(name = "飞书appID")
    private String appId;

    /** 飞书secret */
    @Excel(name = "飞书secret")
    private String appSecret;

    /** 应用类型0:ISV 1:企业自建应用 */
    @Excel(name = "应用类型0:ISV 1:企业自建应用")
    private Integer appType;

    /** URL中app_token */
    @Excel(name = "URL中app_token")
    private String appToken;

    /** URL中table_id */
    @Excel(name = "URL中table_id")
    private String tableId;

    /** URL中view_id */
    @Excel(name = "URL中view_id")
    private String viewId;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setAppId(String appId) 
    {
        this.appId = appId;
    }

    public String getAppId() 
    {
        return appId;
    }
    public void setAppSecret(String appSecret) 
    {
        this.appSecret = appSecret;
    }

    public String getAppSecret() 
    {
        return appSecret;
    }
    public void setAppType(Integer appType) 
    {
        this.appType = appType;
    }

    public Integer getAppType() 
    {
        return appType;
    }
    public void setAppToken(String appToken) 
    {
        this.appToken = appToken;
    }

    public String getAppToken() 
    {
        return appToken;
    }
    public void setTableId(String tableId) 
    {
        this.tableId = tableId;
    }

    public String getTableId() 
    {
        return tableId;
    }
    public void setViewId(String viewId) 
    {
        this.viewId = viewId;
    }

    public String getViewId() 
    {
        return viewId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("appId", getAppId())
            .append("appSecret", getAppSecret())
            .append("appType", getAppType())
            .append("appToken", getAppToken())
            .append("tableId", getTableId())
            .append("viewId", getViewId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
