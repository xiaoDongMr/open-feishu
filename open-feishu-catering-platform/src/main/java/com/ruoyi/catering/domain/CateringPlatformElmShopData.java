package com.ruoyi.catering.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 饿了么门店数据对象 catering_platform_elm_shop_data
 * 
 * @author liuxiaodong
 * @date 2023-03-16
 */
public class CateringPlatformElmShopData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    /** 门店名称 */
    @Excel(name = "门店名称")
    private String shopName;

    /** 门店编号 */
    @Excel(name = "门店编号")
    private Long shopId;

    /** 营业时长 */
    @Excel(name = "营业时长")
    private String operatingHours;

    /** 高峰期营业时长 */
    @Excel(name = "高峰期营业时长")
    private String peakHours;

    /** 省份 */
    @Excel(name = "省份")
    private String province;

    /** 城市名称 */
    @Excel(name = "城市名称")
    private String cityName;

    /** 有效订单 */
    @Excel(name = "有效订单")
    private Long validOrder;

    /** 无效订单 */
    @Excel(name = "无效订单")
    private Long invalidOrder;

    /** 收入 */
    @Excel(name = "收入")
    private BigDecimal income;

    /** 营业额 */
    @Excel(name = "营业额")
    private BigDecimal turnover;

    /** 支出 */
    @Excel(name = "支出")
    private BigDecimal pay;

    /** 顾客实付总额 */
    @Excel(name = "顾客实付总额")
    private BigDecimal customersActuallyAmountTotal;

    /** 单均实付 */
    @Excel(name = "单均实付")
    private BigDecimal actualAveragePrice;

    /** 单均收入 */
    @Excel(name = "单均收入")
    private BigDecimal averageIncomePrice;

    /** 商品销售额 */
    @Excel(name = "商品销售额")
    private BigDecimal salesGoods;

    /** 餐盒费 */
    @Excel(name = "餐盒费")
    private BigDecimal packagingFee;

    /** 自配送费 */
    @Excel(name = "自配送费")
    private BigDecimal selfDeliveryFee;

    /** 其他营业额 */
    @Excel(name = "其他营业额")
    private BigDecimal otherTurnover;

    /** 抽佣 */
    @Excel(name = "抽佣")
    private BigDecimal drawServant;

    /** 活动补贴 */
    @Excel(name = "活动补贴")
    private BigDecimal activitySubsidy;

    /** 代金券补贴 */
    @Excel(name = "代金券补贴")
    private BigDecimal voucherSubsidy;

    /** 配送费补贴 */
    @Excel(name = "配送费补贴")
    private BigDecimal distributionFeeSubsidy;

    /** 智能满减补贴 */
    @Excel(name = "智能满减补贴")
    private BigDecimal smartReductionSubsidy;

    /** 智能满减服务费 */
    @Excel(name = "智能满减服务费")
    private BigDecimal smartReductionServiceCharge;

    /** 履约技术服务费 */
    @Excel(name = "履约技术服务费")
    private BigDecimal technicalServiceFee;

    /** 其他费用支出 */
    @Excel(name = "其他费用支出")
    private BigDecimal otherExpenses;

    /** 商户原因无效订单数 */
    @Excel(name = "商户原因无效订单数")
    private Long merchantInvalidOrders;

    /** 曝光人数 */
    @Excel(name = "曝光人数")
    private Long exposedPeopleNum;

    /** 曝光次数 */
    @Excel(name = "曝光次数")
    private Long exposureTimes;

    /** 进店次数 */
    @Excel(name = "进店次数")
    private Long enterShopTimes;

    /** 进店人数 */
    @Excel(name = "进店人数")
    private Long enterShopPeopleNum;

    /** 进店转化率 */
    @Excel(name = "进店转化率")
    private BigDecimal shopConversionRate;

    /** 下单转化率 */
    @Excel(name = "下单转化率")
    private BigDecimal orderConversionRate;

    /** 新客下单转化率 */
    @Excel(name = "新客下单转化率")
    private BigDecimal newOrdersConversionRate;

    /** 老客下单转化率 */
    @Excel(name = "老客下单转化率")
    private BigDecimal regularCustomersConversionRate;

    /** 参与活动数 */
    @Excel(name = "参与活动数")
    private Long activitiesNum;

    /** 活动订单数 */
    @Excel(name = "活动订单数")
    private Long activeOrdersNum;

    /** 活动订单占比 */
    @Excel(name = "活动订单占比")
    private String activeOrdersProportion;

    /** 满减活动订单数 */
    @Excel(name = "满减活动订单数")
    private Long activeOrdersFullReduction;

    /** 超会活动订单数 */
    @Excel(name = "超会活动订单数")
    private Long beyondMeetingOrders;

    /** 配送活动订单数 */
    @Excel(name = "配送活动订单数")
    private Long deliveryActivityOrders;

    /** 投入产出比 */
    @Excel(name = "投入产出比")
    private BigDecimal inputOutputRatio;

    /** 活动总补贴 */
    @Excel(name = "活动总补贴")
    private BigDecimal activitiesSubsidyTotal;

    /** 饿了么补贴 */
    @Excel(name = "饿了么补贴")
    private BigDecimal elmSubsidy;

    /** 代理商补贴 */
    @Excel(name = "代理商补贴")
    private BigDecimal agentSubsidy;

    /** 商家活动成本（含满减活动） */
    @Excel(name = "商家活动成本", readConverterExp = "含=满减活动")
    private BigDecimal merchantActivityCosts;

    /** 商家活动成本（不含满减活动） */
    @Excel(name = "商家活动成本", readConverterExp = "不=含满减活动")
    private BigDecimal excludingMerchantActivityCosts;

    /** 营销力度（含满减活动） */
    @Excel(name = "营销力度", readConverterExp = "含=满减活动")
    private BigDecimal marketingEfforts;

    /** 营销力度（不含满减活动） */
    @Excel(name = "营销力度", readConverterExp = "不=含满减活动")
    private BigDecimal excludingMarketingEfforts;

    /** 下单人数 */
    @Excel(name = "下单人数")
    private Long ordersPeopleNum;

    /** 近7日复购人数 */
    @Excel(name = "近7日复购人数")
    private Long recent7daysRepurchasesNum;

    /** 近7日复购率 */
    @Excel(name = "近7日复购率")
    private BigDecimal recent7daysRepurchasesRate;

    /** 近30日复购人数 */
    @Excel(name = "近30日复购人数")
    private Long recent30daysRepurchaseNum;

    /** 近30日复购率 */
    @Excel(name = "近30日复购率")
    private BigDecimal recent30daysRepurchaseRate;

    /** 新客人数 */
    @Excel(name = "新客人数")
    private Long newCustomersNum;

    /** 老客人数 */
    @Excel(name = "老客人数")
    private Long regularCustomersNum;

    /** 上架商品数 */
    @Excel(name = "上架商品数")
    private Long onShelfGoodsNum;

    /** 有交易商品数 */
    @Excel(name = "有交易商品数")
    private Long tradedGoodsNum;

    /** 库存不足商品数 */
    @Excel(name = "库存不足商品数")
    private Long insufficientInventoryGoodsNum;

    /** 新上架商品数 */
    @Excel(name = "新上架商品数")
    private Long newProductsMarketNum;

    /** 活动商品数 */
    @Excel(name = "活动商品数")
    private Long activeProductsNum;

    /** 差评订单数 */
    @Excel(name = "差评订单数")
    private Long negativeEvaluationOrderNum;

    /** 投诉订单数 */
    @Excel(name = "投诉订单数")
    private Long complaintOrdersNum;

    /** 投诉订单id */
    @Excel(name = "投诉订单id")
    private String complaintOrderId;

    /** 出餐超时订单数 */
    @Excel(name = "出餐超时订单数")
    private Long overtimeOrdersNum;

    /** 出餐超时订单id */
    @Excel(name = "出餐超时订单id")
    private String mealTimeoutOrderId;

    /** 单均出餐时长 */
    @Excel(name = "单均出餐时长")
    private BigDecimal averageMealTime;

    /** 催单数 */
    @Excel(name = "催单数")
    private Long remindersNum;

    /** 拒单数 */
    @Excel(name = "拒单数")
    private Long rejectedOrdersNum;

    /** 出餐宝扫码出餐订单数 */
    @Excel(name = "出餐宝扫码出餐订单数")
    private Long scannedFoodTreasureNum;

    /** 商责取消数 */
    @Excel(name = "商责取消数")
    private Long cancelNum;

    /** 商责超时数 */
    @Excel(name = "商责超时数")
    private Long responsibilityTimeoutNum;

    /** 商责退单数 */
    @Excel(name = "商责退单数")
    private Long chargebacksNum;

    /** 商责催单数 */
    @Excel(name = "商责催单数")
    private Long reminderNum;

    /** 商责取消率 */
    @Excel(name = "商责取消率")
    private BigDecimal cancelRate;

    /** 商责超时率 */
    @Excel(name = "商责超时率")
    private BigDecimal overtimeRate;

    /** 商责退单率 */
    @Excel(name = "商责退单率")
    private BigDecimal chargebackRate;

    /** 商责催单率 */
    @Excel(name = "商责催单率")
    private BigDecimal reminderRate;

    /** 店铺评分 */
    @Excel(name = "店铺评分")
    private BigDecimal shopScore;

    /** 满意度得分 */
    @Excel(name = "满意度得分")
    private BigDecimal satisfactionScore;

    /** 味道得分 */
    @Excel(name = "味道得分")
    private BigDecimal tasteScore;

    /** 包装得分 */
    @Excel(name = "包装得分")
    private BigDecimal packagingScore;

    /** 近30日好评率 */
    @Excel(name = "近30日好评率")
    private BigDecimal recent30daysPositiveRate;

    /** 近30日好评数 */
    @Excel(name = "近30日好评数")
    private Long recent30daysPositiveComments;

    /** 近30日中评率 */
    @Excel(name = "近30日中评率")
    private BigDecimal recent30daysEvaluationRate;

    /** 近30日中评数 */
    @Excel(name = "近30日中评数")
    private Long recent30daysMidNum;

    /** 近30日差评率 */
    @Excel(name = "近30日差评率")
    private BigDecimal recent30daysBadEvaluationRate;

    /** 近30日差评数 */
    @Excel(name = "近30日差评数")
    private Long recent30daysNegativeCommentsNum;

    /** 近30日优质评价率 */
    @Excel(name = "近30日优质评价率")
    private BigDecimal recent30daysQualityEvaluationRate;

    /** 近30日优质评价数 */
    @Excel(name = "近30日优质评价数")
    private Long recent30daysHighQualityEvaluationsNum;

    /** 近30日订单评价率 */
    @Excel(name = "近30日订单评价率")
    private BigDecimal recent30daysOrderEvaluationRate;

    /** 近30日订单评价数 */
    @Excel(name = "近30日订单评价数")
    private Long recent30daysOrderEvaluationNum;

    /** 近30日差评人工回复率 */
    @Excel(name = "近30日差评人工回复率")
    private BigDecimal recent30daysManualResponseRate;

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
    public void setShopName(String shopName) 
    {
        this.shopName = shopName;
    }

    public String getShopName() 
    {
        return shopName;
    }
    public void setShopId(Long shopId) 
    {
        this.shopId = shopId;
    }

    public Long getShopId() 
    {
        return shopId;
    }
    public void setOperatingHours(String operatingHours) 
    {
        this.operatingHours = operatingHours;
    }

    public String getOperatingHours() 
    {
        return operatingHours;
    }
    public void setPeakHours(String peakHours) 
    {
        this.peakHours = peakHours;
    }

    public String getPeakHours() 
    {
        return peakHours;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setCityName(String cityName) 
    {
        this.cityName = cityName;
    }

    public String getCityName() 
    {
        return cityName;
    }
    public void setValidOrder(Long validOrder) 
    {
        this.validOrder = validOrder;
    }

    public Long getValidOrder() 
    {
        return validOrder;
    }
    public void setInvalidOrder(Long invalidOrder) 
    {
        this.invalidOrder = invalidOrder;
    }

    public Long getInvalidOrder() 
    {
        return invalidOrder;
    }
    public void setIncome(BigDecimal income) 
    {
        this.income = income;
    }

    public BigDecimal getIncome() 
    {
        return income;
    }
    public void setTurnover(BigDecimal turnover) 
    {
        this.turnover = turnover;
    }

    public BigDecimal getTurnover() 
    {
        return turnover;
    }
    public void setPay(BigDecimal pay) 
    {
        this.pay = pay;
    }

    public BigDecimal getPay() 
    {
        return pay;
    }
    public void setCustomersActuallyAmountTotal(BigDecimal customersActuallyAmountTotal) 
    {
        this.customersActuallyAmountTotal = customersActuallyAmountTotal;
    }

    public BigDecimal getCustomersActuallyAmountTotal() 
    {
        return customersActuallyAmountTotal;
    }
    public void setActualAveragePrice(BigDecimal actualAveragePrice) 
    {
        this.actualAveragePrice = actualAveragePrice;
    }

    public BigDecimal getActualAveragePrice() 
    {
        return actualAveragePrice;
    }
    public void setAverageIncomePrice(BigDecimal averageIncomePrice) 
    {
        this.averageIncomePrice = averageIncomePrice;
    }

    public BigDecimal getAverageIncomePrice() 
    {
        return averageIncomePrice;
    }
    public void setSalesGoods(BigDecimal salesGoods) 
    {
        this.salesGoods = salesGoods;
    }

    public BigDecimal getSalesGoods() 
    {
        return salesGoods;
    }
    public void setPackagingFee(BigDecimal packagingFee) 
    {
        this.packagingFee = packagingFee;
    }

    public BigDecimal getPackagingFee() 
    {
        return packagingFee;
    }
    public void setSelfDeliveryFee(BigDecimal selfDeliveryFee) 
    {
        this.selfDeliveryFee = selfDeliveryFee;
    }

    public BigDecimal getSelfDeliveryFee() 
    {
        return selfDeliveryFee;
    }
    public void setOtherTurnover(BigDecimal otherTurnover) 
    {
        this.otherTurnover = otherTurnover;
    }

    public BigDecimal getOtherTurnover() 
    {
        return otherTurnover;
    }
    public void setDrawServant(BigDecimal drawServant) 
    {
        this.drawServant = drawServant;
    }

    public BigDecimal getDrawServant() 
    {
        return drawServant;
    }
    public void setActivitySubsidy(BigDecimal activitySubsidy) 
    {
        this.activitySubsidy = activitySubsidy;
    }

    public BigDecimal getActivitySubsidy() 
    {
        return activitySubsidy;
    }
    public void setVoucherSubsidy(BigDecimal voucherSubsidy) 
    {
        this.voucherSubsidy = voucherSubsidy;
    }

    public BigDecimal getVoucherSubsidy() 
    {
        return voucherSubsidy;
    }
    public void setDistributionFeeSubsidy(BigDecimal distributionFeeSubsidy) 
    {
        this.distributionFeeSubsidy = distributionFeeSubsidy;
    }

    public BigDecimal getDistributionFeeSubsidy() 
    {
        return distributionFeeSubsidy;
    }
    public void setSmartReductionSubsidy(BigDecimal smartReductionSubsidy) 
    {
        this.smartReductionSubsidy = smartReductionSubsidy;
    }

    public BigDecimal getSmartReductionSubsidy() 
    {
        return smartReductionSubsidy;
    }
    public void setSmartReductionServiceCharge(BigDecimal smartReductionServiceCharge) 
    {
        this.smartReductionServiceCharge = smartReductionServiceCharge;
    }

    public BigDecimal getSmartReductionServiceCharge() 
    {
        return smartReductionServiceCharge;
    }
    public void setTechnicalServiceFee(BigDecimal technicalServiceFee) 
    {
        this.technicalServiceFee = technicalServiceFee;
    }

    public BigDecimal getTechnicalServiceFee() 
    {
        return technicalServiceFee;
    }
    public void setOtherExpenses(BigDecimal otherExpenses) 
    {
        this.otherExpenses = otherExpenses;
    }

    public BigDecimal getOtherExpenses() 
    {
        return otherExpenses;
    }
    public void setMerchantInvalidOrders(Long merchantInvalidOrders) 
    {
        this.merchantInvalidOrders = merchantInvalidOrders;
    }

    public Long getMerchantInvalidOrders() 
    {
        return merchantInvalidOrders;
    }
    public void setExposedPeopleNum(Long exposedPeopleNum) 
    {
        this.exposedPeopleNum = exposedPeopleNum;
    }

    public Long getExposedPeopleNum() 
    {
        return exposedPeopleNum;
    }
    public void setExposureTimes(Long exposureTimes) 
    {
        this.exposureTimes = exposureTimes;
    }

    public Long getExposureTimes() 
    {
        return exposureTimes;
    }
    public void setEnterShopTimes(Long enterShopTimes) 
    {
        this.enterShopTimes = enterShopTimes;
    }

    public Long getEnterShopTimes() 
    {
        return enterShopTimes;
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
    public void setNewOrdersConversionRate(BigDecimal newOrdersConversionRate) 
    {
        this.newOrdersConversionRate = newOrdersConversionRate;
    }

    public BigDecimal getNewOrdersConversionRate() 
    {
        return newOrdersConversionRate;
    }
    public void setRegularCustomersConversionRate(BigDecimal regularCustomersConversionRate) 
    {
        this.regularCustomersConversionRate = regularCustomersConversionRate;
    }

    public BigDecimal getRegularCustomersConversionRate() 
    {
        return regularCustomersConversionRate;
    }
    public void setActivitiesNum(Long activitiesNum) 
    {
        this.activitiesNum = activitiesNum;
    }

    public Long getActivitiesNum() 
    {
        return activitiesNum;
    }
    public void setActiveOrdersNum(Long activeOrdersNum) 
    {
        this.activeOrdersNum = activeOrdersNum;
    }

    public Long getActiveOrdersNum() 
    {
        return activeOrdersNum;
    }
    public void setActiveOrdersProportion(String activeOrdersProportion) 
    {
        this.activeOrdersProportion = activeOrdersProportion;
    }

    public String getActiveOrdersProportion() 
    {
        return activeOrdersProportion;
    }
    public void setActiveOrdersFullReduction(Long activeOrdersFullReduction) 
    {
        this.activeOrdersFullReduction = activeOrdersFullReduction;
    }

    public Long getActiveOrdersFullReduction() 
    {
        return activeOrdersFullReduction;
    }
    public void setBeyondMeetingOrders(Long beyondMeetingOrders) 
    {
        this.beyondMeetingOrders = beyondMeetingOrders;
    }

    public Long getBeyondMeetingOrders() 
    {
        return beyondMeetingOrders;
    }
    public void setDeliveryActivityOrders(Long deliveryActivityOrders) 
    {
        this.deliveryActivityOrders = deliveryActivityOrders;
    }

    public Long getDeliveryActivityOrders() 
    {
        return deliveryActivityOrders;
    }
    public void setInputOutputRatio(BigDecimal inputOutputRatio) 
    {
        this.inputOutputRatio = inputOutputRatio;
    }

    public BigDecimal getInputOutputRatio() 
    {
        return inputOutputRatio;
    }
    public void setActivitiesSubsidyTotal(BigDecimal activitiesSubsidyTotal) 
    {
        this.activitiesSubsidyTotal = activitiesSubsidyTotal;
    }

    public BigDecimal getActivitiesSubsidyTotal() 
    {
        return activitiesSubsidyTotal;
    }
    public void setElmSubsidy(BigDecimal elmSubsidy) 
    {
        this.elmSubsidy = elmSubsidy;
    }

    public BigDecimal getElmSubsidy() 
    {
        return elmSubsidy;
    }
    public void setAgentSubsidy(BigDecimal agentSubsidy) 
    {
        this.agentSubsidy = agentSubsidy;
    }

    public BigDecimal getAgentSubsidy() 
    {
        return agentSubsidy;
    }
    public void setMerchantActivityCosts(BigDecimal merchantActivityCosts) 
    {
        this.merchantActivityCosts = merchantActivityCosts;
    }

    public BigDecimal getMerchantActivityCosts() 
    {
        return merchantActivityCosts;
    }
    public void setExcludingMerchantActivityCosts(BigDecimal excludingMerchantActivityCosts) 
    {
        this.excludingMerchantActivityCosts = excludingMerchantActivityCosts;
    }

    public BigDecimal getExcludingMerchantActivityCosts() 
    {
        return excludingMerchantActivityCosts;
    }
    public void setMarketingEfforts(BigDecimal marketingEfforts) 
    {
        this.marketingEfforts = marketingEfforts;
    }

    public BigDecimal getMarketingEfforts() 
    {
        return marketingEfforts;
    }
    public void setExcludingMarketingEfforts(BigDecimal excludingMarketingEfforts) 
    {
        this.excludingMarketingEfforts = excludingMarketingEfforts;
    }

    public BigDecimal getExcludingMarketingEfforts() 
    {
        return excludingMarketingEfforts;
    }
    public void setOrdersPeopleNum(Long ordersPeopleNum) 
    {
        this.ordersPeopleNum = ordersPeopleNum;
    }

    public Long getOrdersPeopleNum() 
    {
        return ordersPeopleNum;
    }
    public void setRecent7daysRepurchasesNum(Long recent7daysRepurchasesNum) 
    {
        this.recent7daysRepurchasesNum = recent7daysRepurchasesNum;
    }

    public Long getRecent7daysRepurchasesNum() 
    {
        return recent7daysRepurchasesNum;
    }
    public void setRecent7daysRepurchasesRate(BigDecimal recent7daysRepurchasesRate) 
    {
        this.recent7daysRepurchasesRate = recent7daysRepurchasesRate;
    }

    public BigDecimal getRecent7daysRepurchasesRate() 
    {
        return recent7daysRepurchasesRate;
    }
    public void setRecent30daysRepurchaseNum(Long recent30daysRepurchaseNum) 
    {
        this.recent30daysRepurchaseNum = recent30daysRepurchaseNum;
    }

    public Long getRecent30daysRepurchaseNum() 
    {
        return recent30daysRepurchaseNum;
    }
    public void setRecent30daysRepurchaseRate(BigDecimal recent30daysRepurchaseRate) 
    {
        this.recent30daysRepurchaseRate = recent30daysRepurchaseRate;
    }

    public BigDecimal getRecent30daysRepurchaseRate() 
    {
        return recent30daysRepurchaseRate;
    }
    public void setNewCustomersNum(Long newCustomersNum) 
    {
        this.newCustomersNum = newCustomersNum;
    }

    public Long getNewCustomersNum() 
    {
        return newCustomersNum;
    }
    public void setRegularCustomersNum(Long regularCustomersNum) 
    {
        this.regularCustomersNum = regularCustomersNum;
    }

    public Long getRegularCustomersNum() 
    {
        return regularCustomersNum;
    }
    public void setOnShelfGoodsNum(Long onShelfGoodsNum) 
    {
        this.onShelfGoodsNum = onShelfGoodsNum;
    }

    public Long getOnShelfGoodsNum() 
    {
        return onShelfGoodsNum;
    }
    public void setTradedGoodsNum(Long tradedGoodsNum) 
    {
        this.tradedGoodsNum = tradedGoodsNum;
    }

    public Long getTradedGoodsNum() 
    {
        return tradedGoodsNum;
    }
    public void setInsufficientInventoryGoodsNum(Long insufficientInventoryGoodsNum) 
    {
        this.insufficientInventoryGoodsNum = insufficientInventoryGoodsNum;
    }

    public Long getInsufficientInventoryGoodsNum() 
    {
        return insufficientInventoryGoodsNum;
    }
    public void setNewProductsMarketNum(Long newProductsMarketNum) 
    {
        this.newProductsMarketNum = newProductsMarketNum;
    }

    public Long getNewProductsMarketNum() 
    {
        return newProductsMarketNum;
    }
    public void setActiveProductsNum(Long activeProductsNum) 
    {
        this.activeProductsNum = activeProductsNum;
    }

    public Long getActiveProductsNum() 
    {
        return activeProductsNum;
    }
    public void setNegativeEvaluationOrderNum(Long negativeEvaluationOrderNum) 
    {
        this.negativeEvaluationOrderNum = negativeEvaluationOrderNum;
    }

    public Long getNegativeEvaluationOrderNum() 
    {
        return negativeEvaluationOrderNum;
    }
    public void setComplaintOrdersNum(Long complaintOrdersNum) 
    {
        this.complaintOrdersNum = complaintOrdersNum;
    }

    public Long getComplaintOrdersNum() 
    {
        return complaintOrdersNum;
    }
    public void setComplaintOrderId(String complaintOrderId) 
    {
        this.complaintOrderId = complaintOrderId;
    }

    public String getComplaintOrderId() 
    {
        return complaintOrderId;
    }
    public void setOvertimeOrdersNum(Long overtimeOrdersNum) 
    {
        this.overtimeOrdersNum = overtimeOrdersNum;
    }

    public Long getOvertimeOrdersNum() 
    {
        return overtimeOrdersNum;
    }
    public void setMealTimeoutOrderId(String mealTimeoutOrderId) 
    {
        this.mealTimeoutOrderId = mealTimeoutOrderId;
    }

    public String getMealTimeoutOrderId() 
    {
        return mealTimeoutOrderId;
    }
    public void setAverageMealTime(BigDecimal averageMealTime) 
    {
        this.averageMealTime = averageMealTime;
    }

    public BigDecimal getAverageMealTime() 
    {
        return averageMealTime;
    }
    public void setRemindersNum(Long remindersNum) 
    {
        this.remindersNum = remindersNum;
    }

    public Long getRemindersNum() 
    {
        return remindersNum;
    }
    public void setRejectedOrdersNum(Long rejectedOrdersNum) 
    {
        this.rejectedOrdersNum = rejectedOrdersNum;
    }

    public Long getRejectedOrdersNum() 
    {
        return rejectedOrdersNum;
    }
    public void setScannedFoodTreasureNum(Long scannedFoodTreasureNum) 
    {
        this.scannedFoodTreasureNum = scannedFoodTreasureNum;
    }

    public Long getScannedFoodTreasureNum() 
    {
        return scannedFoodTreasureNum;
    }
    public void setCancelNum(Long cancelNum) 
    {
        this.cancelNum = cancelNum;
    }

    public Long getCancelNum() 
    {
        return cancelNum;
    }
    public void setResponsibilityTimeoutNum(Long responsibilityTimeoutNum) 
    {
        this.responsibilityTimeoutNum = responsibilityTimeoutNum;
    }

    public Long getResponsibilityTimeoutNum() 
    {
        return responsibilityTimeoutNum;
    }
    public void setChargebacksNum(Long chargebacksNum) 
    {
        this.chargebacksNum = chargebacksNum;
    }

    public Long getChargebacksNum() 
    {
        return chargebacksNum;
    }
    public void setReminderNum(Long reminderNum) 
    {
        this.reminderNum = reminderNum;
    }

    public Long getReminderNum() 
    {
        return reminderNum;
    }
    public void setCancelRate(BigDecimal cancelRate) 
    {
        this.cancelRate = cancelRate;
    }

    public BigDecimal getCancelRate() 
    {
        return cancelRate;
    }
    public void setOvertimeRate(BigDecimal overtimeRate) 
    {
        this.overtimeRate = overtimeRate;
    }

    public BigDecimal getOvertimeRate() 
    {
        return overtimeRate;
    }
    public void setChargebackRate(BigDecimal chargebackRate) 
    {
        this.chargebackRate = chargebackRate;
    }

    public BigDecimal getChargebackRate() 
    {
        return chargebackRate;
    }
    public void setReminderRate(BigDecimal reminderRate) 
    {
        this.reminderRate = reminderRate;
    }

    public BigDecimal getReminderRate() 
    {
        return reminderRate;
    }
    public void setShopScore(BigDecimal shopScore) 
    {
        this.shopScore = shopScore;
    }

    public BigDecimal getShopScore() 
    {
        return shopScore;
    }
    public void setSatisfactionScore(BigDecimal satisfactionScore) 
    {
        this.satisfactionScore = satisfactionScore;
    }

    public BigDecimal getSatisfactionScore() 
    {
        return satisfactionScore;
    }
    public void setTasteScore(BigDecimal tasteScore) 
    {
        this.tasteScore = tasteScore;
    }

    public BigDecimal getTasteScore() 
    {
        return tasteScore;
    }
    public void setPackagingScore(BigDecimal packagingScore) 
    {
        this.packagingScore = packagingScore;
    }

    public BigDecimal getPackagingScore() 
    {
        return packagingScore;
    }
    public void setRecent30daysPositiveRate(BigDecimal recent30daysPositiveRate) 
    {
        this.recent30daysPositiveRate = recent30daysPositiveRate;
    }

    public BigDecimal getRecent30daysPositiveRate() 
    {
        return recent30daysPositiveRate;
    }
    public void setRecent30daysPositiveComments(Long recent30daysPositiveComments) 
    {
        this.recent30daysPositiveComments = recent30daysPositiveComments;
    }

    public Long getRecent30daysPositiveComments() 
    {
        return recent30daysPositiveComments;
    }
    public void setRecent30daysEvaluationRate(BigDecimal recent30daysEvaluationRate) 
    {
        this.recent30daysEvaluationRate = recent30daysEvaluationRate;
    }

    public BigDecimal getRecent30daysEvaluationRate() 
    {
        return recent30daysEvaluationRate;
    }
    public void setRecent30daysMidNum(Long recent30daysMidNum) 
    {
        this.recent30daysMidNum = recent30daysMidNum;
    }

    public Long getRecent30daysMidNum() 
    {
        return recent30daysMidNum;
    }
    public void setRecent30daysBadEvaluationRate(BigDecimal recent30daysBadEvaluationRate) 
    {
        this.recent30daysBadEvaluationRate = recent30daysBadEvaluationRate;
    }

    public BigDecimal getRecent30daysBadEvaluationRate() 
    {
        return recent30daysBadEvaluationRate;
    }
    public void setRecent30daysNegativeCommentsNum(Long recent30daysNegativeCommentsNum) 
    {
        this.recent30daysNegativeCommentsNum = recent30daysNegativeCommentsNum;
    }

    public Long getRecent30daysNegativeCommentsNum() 
    {
        return recent30daysNegativeCommentsNum;
    }
    public void setRecent30daysQualityEvaluationRate(BigDecimal recent30daysQualityEvaluationRate) 
    {
        this.recent30daysQualityEvaluationRate = recent30daysQualityEvaluationRate;
    }

    public BigDecimal getRecent30daysQualityEvaluationRate() 
    {
        return recent30daysQualityEvaluationRate;
    }
    public void setRecent30daysHighQualityEvaluationsNum(Long recent30daysHighQualityEvaluationsNum) 
    {
        this.recent30daysHighQualityEvaluationsNum = recent30daysHighQualityEvaluationsNum;
    }

    public Long getRecent30daysHighQualityEvaluationsNum() 
    {
        return recent30daysHighQualityEvaluationsNum;
    }
    public void setRecent30daysOrderEvaluationRate(BigDecimal recent30daysOrderEvaluationRate) 
    {
        this.recent30daysOrderEvaluationRate = recent30daysOrderEvaluationRate;
    }

    public BigDecimal getRecent30daysOrderEvaluationRate() 
    {
        return recent30daysOrderEvaluationRate;
    }
    public void setRecent30daysOrderEvaluationNum(Long recent30daysOrderEvaluationNum) 
    {
        this.recent30daysOrderEvaluationNum = recent30daysOrderEvaluationNum;
    }

    public Long getRecent30daysOrderEvaluationNum() 
    {
        return recent30daysOrderEvaluationNum;
    }
    public void setRecent30daysManualResponseRate(BigDecimal recent30daysManualResponseRate) 
    {
        this.recent30daysManualResponseRate = recent30daysManualResponseRate;
    }

    public BigDecimal getRecent30daysManualResponseRate() 
    {
        return recent30daysManualResponseRate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("date", getDate())
            .append("shopName", getShopName())
            .append("shopId", getShopId())
            .append("operatingHours", getOperatingHours())
            .append("peakHours", getPeakHours())
            .append("province", getProvince())
            .append("cityName", getCityName())
            .append("validOrder", getValidOrder())
            .append("invalidOrder", getInvalidOrder())
            .append("income", getIncome())
            .append("turnover", getTurnover())
            .append("pay", getPay())
            .append("customersActuallyAmountTotal", getCustomersActuallyAmountTotal())
            .append("actualAveragePrice", getActualAveragePrice())
            .append("averageIncomePrice", getAverageIncomePrice())
            .append("salesGoods", getSalesGoods())
            .append("packagingFee", getPackagingFee())
            .append("selfDeliveryFee", getSelfDeliveryFee())
            .append("otherTurnover", getOtherTurnover())
            .append("drawServant", getDrawServant())
            .append("activitySubsidy", getActivitySubsidy())
            .append("voucherSubsidy", getVoucherSubsidy())
            .append("distributionFeeSubsidy", getDistributionFeeSubsidy())
            .append("smartReductionSubsidy", getSmartReductionSubsidy())
            .append("smartReductionServiceCharge", getSmartReductionServiceCharge())
            .append("technicalServiceFee", getTechnicalServiceFee())
            .append("otherExpenses", getOtherExpenses())
            .append("merchantInvalidOrders", getMerchantInvalidOrders())
            .append("exposedPeopleNum", getExposedPeopleNum())
            .append("exposureTimes", getExposureTimes())
            .append("enterShopTimes", getEnterShopTimes())
            .append("enterShopPeopleNum", getEnterShopPeopleNum())
            .append("shopConversionRate", getShopConversionRate())
            .append("orderConversionRate", getOrderConversionRate())
            .append("newOrdersConversionRate", getNewOrdersConversionRate())
            .append("regularCustomersConversionRate", getRegularCustomersConversionRate())
            .append("activitiesNum", getActivitiesNum())
            .append("activeOrdersNum", getActiveOrdersNum())
            .append("activeOrdersProportion", getActiveOrdersProportion())
            .append("activeOrdersFullReduction", getActiveOrdersFullReduction())
            .append("beyondMeetingOrders", getBeyondMeetingOrders())
            .append("deliveryActivityOrders", getDeliveryActivityOrders())
            .append("inputOutputRatio", getInputOutputRatio())
            .append("activitiesSubsidyTotal", getActivitiesSubsidyTotal())
            .append("elmSubsidy", getElmSubsidy())
            .append("agentSubsidy", getAgentSubsidy())
            .append("merchantActivityCosts", getMerchantActivityCosts())
            .append("excludingMerchantActivityCosts", getExcludingMerchantActivityCosts())
            .append("marketingEfforts", getMarketingEfforts())
            .append("excludingMarketingEfforts", getExcludingMarketingEfforts())
            .append("ordersPeopleNum", getOrdersPeopleNum())
            .append("recent7daysRepurchasesNum", getRecent7daysRepurchasesNum())
            .append("recent7daysRepurchasesRate", getRecent7daysRepurchasesRate())
            .append("recent30daysRepurchaseNum", getRecent30daysRepurchaseNum())
            .append("recent30daysRepurchaseRate", getRecent30daysRepurchaseRate())
            .append("newCustomersNum", getNewCustomersNum())
            .append("regularCustomersNum", getRegularCustomersNum())
            .append("onShelfGoodsNum", getOnShelfGoodsNum())
            .append("tradedGoodsNum", getTradedGoodsNum())
            .append("insufficientInventoryGoodsNum", getInsufficientInventoryGoodsNum())
            .append("newProductsMarketNum", getNewProductsMarketNum())
            .append("activeProductsNum", getActiveProductsNum())
            .append("negativeEvaluationOrderNum", getNegativeEvaluationOrderNum())
            .append("complaintOrdersNum", getComplaintOrdersNum())
            .append("complaintOrderId", getComplaintOrderId())
            .append("overtimeOrdersNum", getOvertimeOrdersNum())
            .append("mealTimeoutOrderId", getMealTimeoutOrderId())
            .append("averageMealTime", getAverageMealTime())
            .append("remindersNum", getRemindersNum())
            .append("rejectedOrdersNum", getRejectedOrdersNum())
            .append("scannedFoodTreasureNum", getScannedFoodTreasureNum())
            .append("cancelNum", getCancelNum())
            .append("responsibilityTimeoutNum", getResponsibilityTimeoutNum())
            .append("chargebacksNum", getChargebacksNum())
            .append("reminderNum", getReminderNum())
            .append("cancelRate", getCancelRate())
            .append("overtimeRate", getOvertimeRate())
            .append("chargebackRate", getChargebackRate())
            .append("reminderRate", getReminderRate())
            .append("shopScore", getShopScore())
            .append("satisfactionScore", getSatisfactionScore())
            .append("tasteScore", getTasteScore())
            .append("packagingScore", getPackagingScore())
            .append("recent30daysPositiveRate", getRecent30daysPositiveRate())
            .append("recent30daysPositiveComments", getRecent30daysPositiveComments())
            .append("recent30daysEvaluationRate", getRecent30daysEvaluationRate())
            .append("recent30daysMidNum", getRecent30daysMidNum())
            .append("recent30daysBadEvaluationRate", getRecent30daysBadEvaluationRate())
            .append("recent30daysNegativeCommentsNum", getRecent30daysNegativeCommentsNum())
            .append("recent30daysQualityEvaluationRate", getRecent30daysQualityEvaluationRate())
            .append("recent30daysHighQualityEvaluationsNum", getRecent30daysHighQualityEvaluationsNum())
            .append("recent30daysOrderEvaluationRate", getRecent30daysOrderEvaluationRate())
            .append("recent30daysOrderEvaluationNum", getRecent30daysOrderEvaluationNum())
            .append("recent30daysManualResponseRate", getRecent30daysManualResponseRate())
            .toString();
    }
}
