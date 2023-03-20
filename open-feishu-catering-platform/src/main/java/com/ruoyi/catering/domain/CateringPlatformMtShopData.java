package com.ruoyi.catering.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 美团门店数据对象 catering_platform_mt_shop_data
 * 
 * @author liuxiaodong
 * @date 2023-03-16
 */
public class CateringPlatformMtShopData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyyMMdd")
    private Date date;

    /** 门店所在城市 */
    @Excel(name = "门店所在城市")
    private String shopCity;

    /** 店铺名称 */
    @Excel(name = "店铺名称")
    private String shopName;

    /** 门店id */
    @Excel(name = "门店id")
    private String shopId;

    /** 收入 */
    @Excel(name = "收入")
    private BigDecimal income;

    /** 商品原价 */
    @Excel(name = "商品原价")
    private BigDecimal goodsOriginalPrice;

    /** 包装费 */
    @Excel(name = "包装费")
    private BigDecimal packagingFee;

    /** 顾客配送费（跑腿/自配送） */
    @Excel(name = "顾客配送费（跑腿/自配送）")
    private BigDecimal customerDeliveryFee;

    /** 支出 */
    @Excel(name = "支出")
    private BigDecimal pay;

    /** 商家活动支出 */
    @Excel(name = "商家活动支出")
    private BigDecimal merchantActivityExpenditure;

    /** 公益捐款 */
    @Excel(name = "公益捐款")
    private BigDecimal publicContributions;

    /** 其他支出 */
    @Excel(name = "其他支出")
    private BigDecimal otherExpenses;

    /** 营业额 */
    @Excel(name = "营业额")
    private BigDecimal turnover;

    /** 顾客实付 */
    @Excel(name = "顾客实付")
    private BigDecimal customerActualPayment;

    /** 有效订单 */
    @Excel(name = "有效订单")
    private Long validOrder;

    /** 实付单均价 */
    @Excel(name = "实付单均价")
    private BigDecimal paidAveragePrice;

    /** 活动补贴 */
    @Excel(name = "活动补贴")
    private BigDecimal activitySubsidy;

    /** 平台活动补贴 */
    @Excel(name = "平台活动补贴")
    private BigDecimal subsidyPlatformActivities;

    /** 平台服务费(含佣金和配送服务费) */
    @Excel(name = "平台服务费(含佣金和配送服务费)")
    private BigDecimal platformServiceFee;

    /** 曝光人数 */
    @Excel(name = "曝光人数")
    private String exposedPeopleNum;

    /** 入店人数 */
    @Excel(name = "入店人数")
    private Long enterShopPeopleNum;

    /** 入店转化率 */
    @Excel(name = "入店转化率")
    private BigDecimal shopConversionRate;

    /** 下单转化率 */
    @Excel(name = "下单转化率")
    private BigDecimal orderConversionRate;

    /** 曝光新客 */
    @Excel(name = "曝光新客")
    private Long exposeNewCustomers;

    /** 入店新客 */
    @Excel(name = "入店新客")
    private Long enterShopNewCustomers;

    /** 新客入店转化率 */
    @Excel(name = "新客入店转化率")
    private BigDecimal enterShopNewCustomersRate;

    /** 新客下单转化率 */
    @Excel(name = "新客下单转化率")
    private BigDecimal newOrdersConversionRate;

    /** 曝光老客 */
    @Excel(name = "曝光老客")
    private Long exposeRegularCustomers;

    /** 入店老客 */
    @Excel(name = "入店老客")
    private Long regularCustomers;

    /** 老客入店转化率 */
    @Excel(name = "老客入店转化率")
    private BigDecimal regularCustomersConversionRate;

    /** 老客下单转化率 */
    @Excel(name = "老客下单转化率")
    private BigDecimal regularOrdersConversionRate;

    /** 下单人数 */
    @Excel(name = "下单人数")
    private Long ordersPeopleNum;

    /** 下单新客 */
    @Excel(name = "下单新客")
    private Long orderNewCustomers;

    /** 下单老客 */
    @Excel(name = "下单老客")
    private Long orderRegularCustomer;

    /** 取消订单 */
    @Excel(name = "取消订单")
    private Long cancelOrder;

    /** 商责取消订单 */
    @Excel(name = "商责取消订单")
    private Long cancellationOrders;

    /** 商责取消率 */
    @Excel(name = "商责取消率")
    private BigDecimal cancellationRate;

    /** 店铺分 */
    @Excel(name = "店铺分")
    private Long shopScore;

    /** 高峰营业时长得分 */
    @Excel(name = "高峰营业时长得分")
    private Long peakHoursScore;

    /** 优质商品率得分 */
    @Excel(name = "优质商品率得分")
    private Long highQualityRateScore;

    /** 有效活动丰富度得分 */
    @Excel(name = "有效活动丰富度得分")
    private Long effectiveActivityAbundanceScore;

    /** 商家不接单率得分 */
    @Excel(name = "商家不接单率得分")
    private Long nonAcceptanceScore;

    /** 差评回复率得分 */
    @Excel(name = "差评回复率得分")
    private Long negativeFeedbackScore;

    /** 在线联系回复率得分 */
    @Excel(name = "在线联系回复率得分")
    private Long onlineContactResponseScore;

    /** 商家评分得分 */
    @Excel(name = "商家评分得分")
    private Long merchantScore;

    /** 近30日日均高峰营业时长 */
    @Excel(name = "近30日日均高峰营业时长")
    private Long averageDailyPeakRecent30days;

    /** 优质商品率 */
    @Excel(name = "优质商品率")
    private String highQualityCommodityRate;

    /** 有效活动丰富度 */
    @Excel(name = "有效活动丰富度")
    private String abundanceEffectiveActivities;

    /** 近30日商家不接单率 */
    @Excel(name = "近30日商家不接单率")
    private String recent30daysNonReceivingRate;

    /** 近30日差评回复率 */
    @Excel(name = "近30日差评回复率")
    private String recent30daysNegativeResponseRate;

    /** 近7日日均在线联系回复率 */
    @Excel(name = "近7日日均在线联系回复率")
    private String past7daysDailyAverageResponseRate;

    /** 商家评分 */
    @Excel(name = "商家评分")
    private BigDecimal merchantRate;

    /** 菜单丰富度得分 */
    @Excel(name = "菜单丰富度得分")
    private Long menuRichnessScore;

    /** 装修丰富度得分 */
    @Excel(name = "装修丰富度得分")
    private Long decorationAbundanceScore;

    /** 服务功能丰富度得分 */
    @Excel(name = "服务功能丰富度得分")
    private Long serviceFunctionRichnessScore;

    /** 菜单丰富度 */
    @Excel(name = "菜单丰富度")
    private String menuRichness;

    /** 装修丰富度 */
    @Excel(name = "装修丰富度")
    private String abundanceDecoration;

    /** 服务功能丰富度 */
    @Excel(name = "服务功能丰富度")
    private String abundanceServiceFunctions;

    /** 出餐完成上报率/配送准时率 */
    @Excel(name = "出餐完成上报率/配送准时率")
    private String deliveryPunctualityRate;

    /** 基础营业时长得分 */
    @Excel(name = "基础营业时长得分")
    private Long basicOperatingHoursScore;

    /** 基础营业时长 */
    @Excel(name = "基础营业时长")
    private Long basicOperatingHours;

    /** 出餐完成上报率得分/配送准时率得分 */
    @Excel(name = "出餐完成上报率得分/配送准时率得分")
    private Long deliveryPunctualityRateScore;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDate(Date date) 
    {
        this.date = date;
    }

    public Date getDate() 
    {
        return date;
    }
    public void setShopCity(String shopCity) 
    {
        this.shopCity = shopCity;
    }

    public String getShopCity() 
    {
        return shopCity;
    }
    public void setShopName(String shopName) 
    {
        this.shopName = shopName;
    }

    public String getShopName() 
    {
        return shopName;
    }
    public void setShopId(String shopId) 
    {
        this.shopId = shopId;
    }

    public String getShopId() 
    {
        return shopId;
    }
    public void setIncome(BigDecimal income) 
    {
        this.income = income;
    }

    public BigDecimal getIncome() 
    {
        return income;
    }
    public void setGoodsOriginalPrice(BigDecimal goodsOriginalPrice) 
    {
        this.goodsOriginalPrice = goodsOriginalPrice;
    }

    public BigDecimal getGoodsOriginalPrice() 
    {
        return goodsOriginalPrice;
    }
    public void setPackagingFee(BigDecimal packagingFee) 
    {
        this.packagingFee = packagingFee;
    }

    public BigDecimal getPackagingFee() 
    {
        return packagingFee;
    }
    public void setCustomerDeliveryFee(BigDecimal customerDeliveryFee) 
    {
        this.customerDeliveryFee = customerDeliveryFee;
    }

    public BigDecimal getCustomerDeliveryFee() 
    {
        return customerDeliveryFee;
    }
    public void setPay(BigDecimal pay) 
    {
        this.pay = pay;
    }

    public BigDecimal getPay() 
    {
        return pay;
    }
    public void setMerchantActivityExpenditure(BigDecimal merchantActivityExpenditure) 
    {
        this.merchantActivityExpenditure = merchantActivityExpenditure;
    }

    public BigDecimal getMerchantActivityExpenditure() 
    {
        return merchantActivityExpenditure;
    }
    public void setPublicContributions(BigDecimal publicContributions) 
    {
        this.publicContributions = publicContributions;
    }

    public BigDecimal getPublicContributions() 
    {
        return publicContributions;
    }
    public void setOtherExpenses(BigDecimal otherExpenses) 
    {
        this.otherExpenses = otherExpenses;
    }

    public BigDecimal getOtherExpenses() 
    {
        return otherExpenses;
    }
    public void setTurnover(BigDecimal turnover) 
    {
        this.turnover = turnover;
    }

    public BigDecimal getTurnover() 
    {
        return turnover;
    }
    public void setCustomerActualPayment(BigDecimal customerActualPayment) 
    {
        this.customerActualPayment = customerActualPayment;
    }

    public BigDecimal getCustomerActualPayment() 
    {
        return customerActualPayment;
    }
    public void setValidOrder(Long validOrder) 
    {
        this.validOrder = validOrder;
    }

    public Long getValidOrder() 
    {
        return validOrder;
    }
    public void setPaidAveragePrice(BigDecimal paidAveragePrice) 
    {
        this.paidAveragePrice = paidAveragePrice;
    }

    public BigDecimal getPaidAveragePrice() 
    {
        return paidAveragePrice;
    }
    public void setActivitySubsidy(BigDecimal activitySubsidy) 
    {
        this.activitySubsidy = activitySubsidy;
    }

    public BigDecimal getActivitySubsidy() 
    {
        return activitySubsidy;
    }
    public void setSubsidyPlatformActivities(BigDecimal subsidyPlatformActivities) 
    {
        this.subsidyPlatformActivities = subsidyPlatformActivities;
    }

    public BigDecimal getSubsidyPlatformActivities() 
    {
        return subsidyPlatformActivities;
    }
    public void setPlatformServiceFee(BigDecimal platformServiceFee) 
    {
        this.platformServiceFee = platformServiceFee;
    }

    public BigDecimal getPlatformServiceFee() 
    {
        return platformServiceFee;
    }
    public void setExposedPeopleNum(String exposedPeopleNum) 
    {
        this.exposedPeopleNum = exposedPeopleNum;
    }

    public String getExposedPeopleNum() 
    {
        return exposedPeopleNum;
    }
    public void setEnterShopPeopleNum(Long enterShopPeopleNum) 
    {
        this.enterShopPeopleNum = enterShopPeopleNum;
    }

    public Long getEnterShopPeopleNum() 
    {
        return enterShopPeopleNum;
    }
    public void setShopConversionRate(BigDecimal shopConversionRate) 
    {
        this.shopConversionRate = shopConversionRate;
    }

    public BigDecimal getShopConversionRate() 
    {
        return shopConversionRate;
    }
    public void setOrderConversionRate(BigDecimal orderConversionRate) 
    {
        this.orderConversionRate = orderConversionRate;
    }

    public BigDecimal getOrderConversionRate() 
    {
        return orderConversionRate;
    }
    public void setExposeNewCustomers(Long exposeNewCustomers) 
    {
        this.exposeNewCustomers = exposeNewCustomers;
    }

    public Long getExposeNewCustomers() 
    {
        return exposeNewCustomers;
    }
    public void setEnterShopNewCustomers(Long enterShopNewCustomers) 
    {
        this.enterShopNewCustomers = enterShopNewCustomers;
    }

    public Long getEnterShopNewCustomers() 
    {
        return enterShopNewCustomers;
    }
    public void setEnterShopNewCustomersRate(BigDecimal enterShopNewCustomersRate) 
    {
        this.enterShopNewCustomersRate = enterShopNewCustomersRate;
    }

    public BigDecimal getEnterShopNewCustomersRate() 
    {
        return enterShopNewCustomersRate;
    }
    public void setNewOrdersConversionRate(BigDecimal newOrdersConversionRate)
    {
        this.newOrdersConversionRate = newOrdersConversionRate;
    }

    public BigDecimal getNewOrdersConversionRate()
    {
        return newOrdersConversionRate;
    }
    public void setExposeRegularCustomers(Long exposeRegularCustomers) 
    {
        this.exposeRegularCustomers = exposeRegularCustomers;
    }

    public Long getExposeRegularCustomers() 
    {
        return exposeRegularCustomers;
    }
    public void setRegularCustomers(Long regularCustomers) 
    {
        this.regularCustomers = regularCustomers;
    }

    public Long getRegularCustomers() 
    {
        return regularCustomers;
    }
    public void setRegularCustomersConversionRate(BigDecimal regularCustomersConversionRate) 
    {
        this.regularCustomersConversionRate = regularCustomersConversionRate;
    }

    public BigDecimal getRegularCustomersConversionRate() 
    {
        return regularCustomersConversionRate;
    }
    public void setRegularOrdersConversionRate(BigDecimal regularOrdersConversionRate) 
    {
        this.regularOrdersConversionRate = regularOrdersConversionRate;
    }

    public BigDecimal getRegularOrdersConversionRate() 
    {
        return regularOrdersConversionRate;
    }
    public void setOrdersPeopleNum(Long ordersPeopleNum) 
    {
        this.ordersPeopleNum = ordersPeopleNum;
    }

    public Long getOrdersPeopleNum() 
    {
        return ordersPeopleNum;
    }
    public void setOrderNewCustomers(Long orderNewCustomers) 
    {
        this.orderNewCustomers = orderNewCustomers;
    }

    public Long getOrderNewCustomers() 
    {
        return orderNewCustomers;
    }
    public void setOrderRegularCustomer(Long orderRegularCustomer) 
    {
        this.orderRegularCustomer = orderRegularCustomer;
    }

    public Long getOrderRegularCustomer() 
    {
        return orderRegularCustomer;
    }
    public void setCancelOrder(Long cancelOrder) 
    {
        this.cancelOrder = cancelOrder;
    }

    public Long getCancelOrder() 
    {
        return cancelOrder;
    }
    public void setCancellationOrders(Long cancellationOrders) 
    {
        this.cancellationOrders = cancellationOrders;
    }

    public Long getCancellationOrders() 
    {
        return cancellationOrders;
    }
    public void setCancellationRate(BigDecimal cancellationRate) 
    {
        this.cancellationRate = cancellationRate;
    }

    public BigDecimal getCancellationRate() 
    {
        return cancellationRate;
    }
    public void setShopScore(Long shopScore) 
    {
        this.shopScore = shopScore;
    }

    public Long getShopScore() 
    {
        return shopScore;
    }
    public void setPeakHoursScore(Long peakHoursScore) 
    {
        this.peakHoursScore = peakHoursScore;
    }

    public Long getPeakHoursScore() 
    {
        return peakHoursScore;
    }
    public void setHighQualityRateScore(Long highQualityRateScore) 
    {
        this.highQualityRateScore = highQualityRateScore;
    }

    public Long getHighQualityRateScore() 
    {
        return highQualityRateScore;
    }
    public void setEffectiveActivityAbundanceScore(Long effectiveActivityAbundanceScore) 
    {
        this.effectiveActivityAbundanceScore = effectiveActivityAbundanceScore;
    }

    public Long getEffectiveActivityAbundanceScore() 
    {
        return effectiveActivityAbundanceScore;
    }
    public void setNonAcceptanceScore(Long nonAcceptanceScore) 
    {
        this.nonAcceptanceScore = nonAcceptanceScore;
    }

    public Long getNonAcceptanceScore() 
    {
        return nonAcceptanceScore;
    }
    public void setNegativeFeedbackScore(Long negativeFeedbackScore) 
    {
        this.negativeFeedbackScore = negativeFeedbackScore;
    }

    public Long getNegativeFeedbackScore() 
    {
        return negativeFeedbackScore;
    }
    public void setOnlineContactResponseScore(Long onlineContactResponseScore) 
    {
        this.onlineContactResponseScore = onlineContactResponseScore;
    }

    public Long getOnlineContactResponseScore() 
    {
        return onlineContactResponseScore;
    }
    public void setMerchantScore(Long merchantScore) 
    {
        this.merchantScore = merchantScore;
    }

    public Long getMerchantScore() 
    {
        return merchantScore;
    }
    public void setAverageDailyPeakRecent30days(Long averageDailyPeakRecent30days) 
    {
        this.averageDailyPeakRecent30days = averageDailyPeakRecent30days;
    }

    public Long getAverageDailyPeakRecent30days() 
    {
        return averageDailyPeakRecent30days;
    }
    public void setHighQualityCommodityRate(String highQualityCommodityRate) 
    {
        this.highQualityCommodityRate = highQualityCommodityRate;
    }

    public String getHighQualityCommodityRate() 
    {
        return highQualityCommodityRate;
    }
    public void setAbundanceEffectiveActivities(String abundanceEffectiveActivities) 
    {
        this.abundanceEffectiveActivities = abundanceEffectiveActivities;
    }

    public String getAbundanceEffectiveActivities() 
    {
        return abundanceEffectiveActivities;
    }
    public void setRecent30daysNonReceivingRate(String recent30daysNonReceivingRate) 
    {
        this.recent30daysNonReceivingRate = recent30daysNonReceivingRate;
    }

    public String getRecent30daysNonReceivingRate() 
    {
        return recent30daysNonReceivingRate;
    }
    public void setRecent30daysNegativeResponseRate(String recent30daysNegativeResponseRate) 
    {
        this.recent30daysNegativeResponseRate = recent30daysNegativeResponseRate;
    }

    public String getRecent30daysNegativeResponseRate() 
    {
        return recent30daysNegativeResponseRate;
    }
    public void setPast7daysDailyAverageResponseRate(String past7daysDailyAverageResponseRate) 
    {
        this.past7daysDailyAverageResponseRate = past7daysDailyAverageResponseRate;
    }

    public String getPast7daysDailyAverageResponseRate() 
    {
        return past7daysDailyAverageResponseRate;
    }
    public void setMerchantRate(BigDecimal merchantRate) 
    {
        this.merchantRate = merchantRate;
    }

    public BigDecimal getMerchantRate() 
    {
        return merchantRate;
    }
    public void setMenuRichnessScore(Long menuRichnessScore) 
    {
        this.menuRichnessScore = menuRichnessScore;
    }

    public Long getMenuRichnessScore() 
    {
        return menuRichnessScore;
    }
    public void setDecorationAbundanceScore(Long decorationAbundanceScore) 
    {
        this.decorationAbundanceScore = decorationAbundanceScore;
    }

    public Long getDecorationAbundanceScore() 
    {
        return decorationAbundanceScore;
    }
    public void setServiceFunctionRichnessScore(Long serviceFunctionRichnessScore) 
    {
        this.serviceFunctionRichnessScore = serviceFunctionRichnessScore;
    }

    public Long getServiceFunctionRichnessScore() 
    {
        return serviceFunctionRichnessScore;
    }
    public void setMenuRichness(String menuRichness) 
    {
        this.menuRichness = menuRichness;
    }

    public String getMenuRichness() 
    {
        return menuRichness;
    }
    public void setAbundanceDecoration(String abundanceDecoration) 
    {
        this.abundanceDecoration = abundanceDecoration;
    }

    public String getAbundanceDecoration() 
    {
        return abundanceDecoration;
    }
    public void setAbundanceServiceFunctions(String abundanceServiceFunctions) 
    {
        this.abundanceServiceFunctions = abundanceServiceFunctions;
    }

    public String getAbundanceServiceFunctions() 
    {
        return abundanceServiceFunctions;
    }
    public void setDeliveryPunctualityRate(String deliveryPunctualityRate) 
    {
        this.deliveryPunctualityRate = deliveryPunctualityRate;
    }

    public String getDeliveryPunctualityRate() 
    {
        return deliveryPunctualityRate;
    }
    public void setBasicOperatingHoursScore(Long basicOperatingHoursScore) 
    {
        this.basicOperatingHoursScore = basicOperatingHoursScore;
    }

    public Long getBasicOperatingHoursScore() 
    {
        return basicOperatingHoursScore;
    }
    public void setBasicOperatingHours(Long basicOperatingHours) 
    {
        this.basicOperatingHours = basicOperatingHours;
    }

    public Long getBasicOperatingHours() 
    {
        return basicOperatingHours;
    }
    public void setDeliveryPunctualityRateScore(Long deliveryPunctualityRateScore) 
    {
        this.deliveryPunctualityRateScore = deliveryPunctualityRateScore;
    }

    public Long getDeliveryPunctualityRateScore() 
    {
        return deliveryPunctualityRateScore;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("date", getDate())
            .append("shopCity", getShopCity())
            .append("shopName", getShopName())
            .append("shopId", getShopId())
            .append("income", getIncome())
            .append("goodsOriginalPrice", getGoodsOriginalPrice())
            .append("packagingFee", getPackagingFee())
            .append("customerDeliveryFee", getCustomerDeliveryFee())
            .append("pay", getPay())
            .append("merchantActivityExpenditure", getMerchantActivityExpenditure())
            .append("publicContributions", getPublicContributions())
            .append("otherExpenses", getOtherExpenses())
            .append("turnover", getTurnover())
            .append("customerActualPayment", getCustomerActualPayment())
            .append("validOrder", getValidOrder())
            .append("paidAveragePrice", getPaidAveragePrice())
            .append("activitySubsidy", getActivitySubsidy())
            .append("subsidyPlatformActivities", getSubsidyPlatformActivities())
            .append("platformServiceFee", getPlatformServiceFee())
            .append("exposedPeopleNum", getExposedPeopleNum())
            .append("enterShopPeopleNum", getEnterShopPeopleNum())
            .append("shopConversionRate", getShopConversionRate())
            .append("orderConversionRate", getOrderConversionRate())
            .append("exposeNewCustomers", getExposeNewCustomers())
            .append("enterShopNewCustomers", getEnterShopNewCustomers())
            .append("enterShopNewCustomersRate", getEnterShopNewCustomersRate())
            .append("newOrdersConversionrate", getNewOrdersConversionRate())
            .append("exposeRegularCustomers", getExposeRegularCustomers())
            .append("regularCustomers", getRegularCustomers())
            .append("regularCustomersConversionRate", getRegularCustomersConversionRate())
            .append("regularOrdersConversionRate", getRegularOrdersConversionRate())
            .append("ordersPeopleNum", getOrdersPeopleNum())
            .append("orderNewCustomers", getOrderNewCustomers())
            .append("orderRegularCustomer", getOrderRegularCustomer())
            .append("cancelOrder", getCancelOrder())
            .append("cancellationOrders", getCancellationOrders())
            .append("cancellationRate", getCancellationRate())
            .append("shopScore", getShopScore())
            .append("peakHoursScore", getPeakHoursScore())
            .append("highQualityRateScore", getHighQualityRateScore())
            .append("effectiveActivityAbundanceScore", getEffectiveActivityAbundanceScore())
            .append("nonAcceptanceScore", getNonAcceptanceScore())
            .append("negativeFeedbackScore", getNegativeFeedbackScore())
            .append("onlineContactResponseScore", getOnlineContactResponseScore())
            .append("merchantScore", getMerchantScore())
            .append("averageDailyPeakRecent30days", getAverageDailyPeakRecent30days())
            .append("highQualityCommodityRate", getHighQualityCommodityRate())
            .append("abundanceEffectiveActivities", getAbundanceEffectiveActivities())
            .append("recent30daysNonReceivingRate", getRecent30daysNonReceivingRate())
            .append("recent30daysNegativeResponseRate", getRecent30daysNegativeResponseRate())
            .append("past7daysDailyAverageResponseRate", getPast7daysDailyAverageResponseRate())
            .append("merchantRate", getMerchantRate())
            .append("menuRichnessScore", getMenuRichnessScore())
            .append("decorationAbundanceScore", getDecorationAbundanceScore())
            .append("serviceFunctionRichnessScore", getServiceFunctionRichnessScore())
            .append("menuRichness", getMenuRichness())
            .append("abundanceDecoration", getAbundanceDecoration())
            .append("abundanceServiceFunctions", getAbundanceServiceFunctions())
            .append("deliveryPunctualityRate", getDeliveryPunctualityRate())
            .append("basicOperatingHoursScore", getBasicOperatingHoursScore())
            .append("basicOperatingHours", getBasicOperatingHours())
            .append("deliveryPunctualityRateScore", getDeliveryPunctualityRateScore())
            .toString();
    }
}
