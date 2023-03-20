<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="日期" prop="date">
        <el-date-picker clearable
          v-model="queryParams.date"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="门店名称" prop="shopName">
        <el-input
          v-model="queryParams.shopName"
          placeholder="请输入门店名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="门店编号" prop="shopId">
        <el-input
          v-model="queryParams.shopId"
          placeholder="请输入门店编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['platform:elmData:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['platform:elmData:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['platform:elmData:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="info"
          plain
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
          v-hasPermi="['platform:elmData:import']"
        >导入</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['platform:elmData:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="elmDataList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="日期" align="center" prop="date" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.date, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="门店名称" align="center" prop="shopName" />
      <el-table-column label="门店编号" align="center" prop="shopId" />
      <el-table-column label="营业时长" align="center" prop="operatingHours" />
      <el-table-column label="高峰期营业时长" align="center" prop="peakHours" />
      <el-table-column label="省份" align="center" prop="province" />
      <el-table-column label="城市名称" align="center" prop="cityName" />
      <el-table-column label="有效订单" align="center" prop="validOrder" />
      <el-table-column label="无效订单" align="center" prop="invalidOrder" />
      <el-table-column label="收入" align="center" prop="income" />
      <el-table-column label="营业额" align="center" prop="turnover" />
      <el-table-column label="支出" align="center" prop="pay" />
      <el-table-column label="顾客实付总额" align="center" prop="customersActuallyAmountTotal" />
      <el-table-column label="单均实付" align="center" prop="actualAveragePrice" />
      <el-table-column label="单均收入" align="center" prop="averageIncomePrice" />
      <el-table-column label="商品销售额" align="center" prop="salesGoods" />
      <el-table-column label="餐盒费" align="center" prop="packagingFee" />
      <el-table-column label="自配送费" align="center" prop="selfDeliveryFee" />
      <el-table-column label="其他营业额" align="center" prop="otherTurnover" />
      <el-table-column label="抽佣" align="center" prop="drawServant" />
      <el-table-column label="活动补贴" align="center" prop="activitySubsidy" />
      <el-table-column label="代金券补贴" align="center" prop="voucherSubsidy" />
      <el-table-column label="配送费补贴" align="center" prop="distributionFeeSubsidy" />
      <el-table-column label="智能满减补贴" align="center" prop="smartReductionSubsidy" />
      <el-table-column label="智能满减服务费" align="center" prop="smartReductionServiceCharge" />
      <el-table-column label="履约技术服务费" align="center" prop="technicalServiceFee" />
      <el-table-column label="其他费用支出" align="center" prop="otherExpenses" />
      <el-table-column label="商户原因无效订单数" align="center" prop="merchantInvalidOrders" />
      <el-table-column label="曝光人数" align="center" prop="exposedPeopleNum" />
      <el-table-column label="曝光次数" align="center" prop="exposureTimes" />
      <el-table-column label="进店次数" align="center" prop="enterShopTimes" />
      <el-table-column label="进店人数" align="center" prop="enterShopPeopleNum" />
      <el-table-column label="进店转化率" align="center" prop="shopConversionRate" />
      <el-table-column label="下单转化率" align="center" prop="orderConversionRate" />
      <el-table-column label="新客下单转化率" align="center" prop="newOrdersConversionRate" />
      <el-table-column label="老客下单转化率" align="center" prop="regularCustomersConversionRate" />
      <el-table-column label="参与活动数" align="center" prop="activitiesNum" />
      <el-table-column label="活动订单数" align="center" prop="activeOrdersNum" />
      <el-table-column label="活动订单占比" align="center" prop="activeOrdersProportion" />
      <el-table-column label="满减活动订单数" align="center" prop="activeOrdersFullReduction" />
      <el-table-column label="超会活动订单数" align="center" prop="beyondMeetingOrders" />
      <el-table-column label="配送活动订单数" align="center" prop="deliveryActivityOrders" />
      <el-table-column label="投入产出比" align="center" prop="inputOutputRatio" />
      <el-table-column label="活动总补贴" align="center" prop="activitiesSubsidyTotal" />
      <el-table-column label="饿了么补贴" align="center" prop="elmSubsidy" />
      <el-table-column label="代理商补贴" align="center" prop="agentSubsidy" />
      <el-table-column label="商家活动成本" align="center" prop="merchantActivityCosts" />
      <el-table-column label="商家活动成本" align="center" prop="excludingMerchantActivityCosts" />
      <el-table-column label="营销力度" align="center" prop="marketingEfforts" />
      <el-table-column label="营销力度" align="center" prop="excludingMarketingEfforts" />
      <el-table-column label="下单人数" align="center" prop="ordersPeopleNum" />
      <el-table-column label="近7日复购人数" align="center" prop="recent7daysRepurchasesNum" />
      <el-table-column label="近7日复购率" align="center" prop="recent7daysRepurchasesRate" />
      <el-table-column label="近30日复购人数" align="center" prop="recent30daysRepurchaseNum" />
      <el-table-column label="近30日复购率" align="center" prop="recent30daysRepurchaseRate" />
      <el-table-column label="新客人数" align="center" prop="newCustomersNum" />
      <el-table-column label="老客人数" align="center" prop="regularCustomersNum" />
      <el-table-column label="上架商品数" align="center" prop="onShelfGoodsNum" />
      <el-table-column label="有交易商品数" align="center" prop="tradedGoodsNum" />
      <el-table-column label="库存不足商品数" align="center" prop="insufficientInventoryGoodsNum" />
      <el-table-column label="新上架商品数" align="center" prop="newProductsMarketNum" />
      <el-table-column label="活动商品数" align="center" prop="activeProductsNum" />
      <el-table-column label="差评订单数" align="center" prop="negativeEvaluationOrderNum" />
      <el-table-column label="投诉订单数" align="center" prop="complaintOrdersNum" />
      <el-table-column label="投诉订单id" align="center" prop="complaintOrderId" />
      <el-table-column label="出餐超时订单数" align="center" prop="overtimeOrdersNum" />
      <el-table-column label="出餐超时订单id" align="center" prop="mealTimeoutOrderId" />
      <el-table-column label="单均出餐时长" align="center" prop="averageMealTime" />
      <el-table-column label="催单数" align="center" prop="remindersNum" />
      <el-table-column label="拒单数" align="center" prop="rejectedOrdersNum" />
      <el-table-column label="出餐宝扫码出餐订单数" align="center" prop="scannedFoodTreasureNum" />
      <el-table-column label="商责取消数" align="center" prop="cancelNum" />
      <el-table-column label="商责超时数" align="center" prop="responsibilityTimeoutNum" />
      <el-table-column label="商责退单数" align="center" prop="chargebacksNum" />
      <el-table-column label="商责催单数" align="center" prop="reminderNum" />
      <el-table-column label="商责取消率" align="center" prop="cancelRate" />
      <el-table-column label="商责超时率" align="center" prop="overtimeRate" />
      <el-table-column label="商责退单率" align="center" prop="chargebackRate" />
      <el-table-column label="商责催单率" align="center" prop="reminderRate" />
      <el-table-column label="店铺评分" align="center" prop="shopScore" />
      <el-table-column label="满意度得分" align="center" prop="satisfactionScore" />
      <el-table-column label="味道得分" align="center" prop="tasteScore" />
      <el-table-column label="包装得分" align="center" prop="packagingScore" />
      <el-table-column label="近30日好评率" align="center" prop="recent30daysPositiveRate" />
      <el-table-column label="近30日好评数" align="center" prop="recent30daysPositiveComments" />
      <el-table-column label="近30日中评率" align="center" prop="recent30daysEvaluationRate" />
      <el-table-column label="近30日中评数" align="center" prop="recent30daysMidNum" />
      <el-table-column label="近30日差评率" align="center" prop="recent30daysBadEvaluationRate" />
      <el-table-column label="近30日差评数" align="center" prop="recent30daysNegativeCommentsNum" />
      <el-table-column label="近30日优质评价率" align="center" prop="recent30daysQualityEvaluationRate" />
      <el-table-column label="近30日优质评价数" align="center" prop="recent30daysHighQualityEvaluationsNum" />
      <el-table-column label="近30日订单评价率" align="center" prop="recent30daysOrderEvaluationRate" />
      <el-table-column label="近30日订单评价数" align="center" prop="recent30daysOrderEvaluationNum" />
      <el-table-column label="近30日差评人工回复率" align="center" prop="recent30daysManualResponseRate" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['platform:elmData:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['platform:elmData:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改饿了么门店数据对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="日期" prop="date">
          <el-date-picker clearable
            v-model="form.date"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="门店名称" prop="shopName">
          <el-input v-model="form.shopName" placeholder="请输入门店名称" />
        </el-form-item>
        <el-form-item label="门店编号" prop="shopId">
          <el-input v-model="form.shopId" placeholder="请输入门店编号" />
        </el-form-item>
        <el-form-item label="营业时长" prop="operatingHours">
          <el-input v-model="form.operatingHours" placeholder="请输入营业时长" />
        </el-form-item>
        <el-form-item label="高峰期营业时长" prop="peakHours">
          <el-input v-model="form.peakHours" placeholder="请输入高峰期营业时长" />
        </el-form-item>
        <el-form-item label="省份" prop="province">
          <el-input v-model="form.province" placeholder="请输入省份" />
        </el-form-item>
        <el-form-item label="城市名称" prop="cityName">
          <el-input v-model="form.cityName" placeholder="请输入城市名称" />
        </el-form-item>
        <el-form-item label="有效订单" prop="validOrder">
          <el-input v-model="form.validOrder" placeholder="请输入有效订单" />
        </el-form-item>
        <el-form-item label="无效订单" prop="invalidOrder">
          <el-input v-model="form.invalidOrder" placeholder="请输入无效订单" />
        </el-form-item>
        <el-form-item label="收入" prop="income">
          <el-input v-model="form.income" placeholder="请输入收入" />
        </el-form-item>
        <el-form-item label="营业额" prop="turnover">
          <el-input v-model="form.turnover" placeholder="请输入营业额" />
        </el-form-item>
        <el-form-item label="支出" prop="pay">
          <el-input v-model="form.pay" placeholder="请输入支出" />
        </el-form-item>
        <el-form-item label="顾客实付总额" prop="customersActuallyAmountTotal">
          <el-input v-model="form.customersActuallyAmountTotal" placeholder="请输入顾客实付总额" />
        </el-form-item>
        <el-form-item label="单均实付" prop="actualAveragePrice">
          <el-input v-model="form.actualAveragePrice" placeholder="请输入单均实付" />
        </el-form-item>
        <el-form-item label="单均收入" prop="averageIncomePrice">
          <el-input v-model="form.averageIncomePrice" placeholder="请输入单均收入" />
        </el-form-item>
        <el-form-item label="商品销售额" prop="salesGoods">
          <el-input v-model="form.salesGoods" placeholder="请输入商品销售额" />
        </el-form-item>
        <el-form-item label="餐盒费" prop="packagingFee">
          <el-input v-model="form.packagingFee" placeholder="请输入餐盒费" />
        </el-form-item>
        <el-form-item label="自配送费" prop="selfDeliveryFee">
          <el-input v-model="form.selfDeliveryFee" placeholder="请输入自配送费" />
        </el-form-item>
        <el-form-item label="其他营业额" prop="otherTurnover">
          <el-input v-model="form.otherTurnover" placeholder="请输入其他营业额" />
        </el-form-item>
        <el-form-item label="抽佣" prop="drawServant">
          <el-input v-model="form.drawServant" placeholder="请输入抽佣" />
        </el-form-item>
        <el-form-item label="活动补贴" prop="activitySubsidy">
          <el-input v-model="form.activitySubsidy" placeholder="请输入活动补贴" />
        </el-form-item>
        <el-form-item label="代金券补贴" prop="voucherSubsidy">
          <el-input v-model="form.voucherSubsidy" placeholder="请输入代金券补贴" />
        </el-form-item>
        <el-form-item label="配送费补贴" prop="distributionFeeSubsidy">
          <el-input v-model="form.distributionFeeSubsidy" placeholder="请输入配送费补贴" />
        </el-form-item>
        <el-form-item label="智能满减补贴" prop="smartReductionSubsidy">
          <el-input v-model="form.smartReductionSubsidy" placeholder="请输入智能满减补贴" />
        </el-form-item>
        <el-form-item label="智能满减服务费" prop="smartReductionServiceCharge">
          <el-input v-model="form.smartReductionServiceCharge" placeholder="请输入智能满减服务费" />
        </el-form-item>
        <el-form-item label="履约技术服务费" prop="technicalServiceFee">
          <el-input v-model="form.technicalServiceFee" placeholder="请输入履约技术服务费" />
        </el-form-item>
        <el-form-item label="其他费用支出" prop="otherExpenses">
          <el-input v-model="form.otherExpenses" placeholder="请输入其他费用支出" />
        </el-form-item>
        <el-form-item label="商户原因无效订单数" prop="merchantInvalidOrders">
          <el-input v-model="form.merchantInvalidOrders" placeholder="请输入商户原因无效订单数" />
        </el-form-item>
        <el-form-item label="曝光人数" prop="exposedPeopleNum">
          <el-input v-model="form.exposedPeopleNum" placeholder="请输入曝光人数" />
        </el-form-item>
        <el-form-item label="曝光次数" prop="exposureTimes">
          <el-input v-model="form.exposureTimes" placeholder="请输入曝光次数" />
        </el-form-item>
        <el-form-item label="进店次数" prop="enterShopTimes">
          <el-input v-model="form.enterShopTimes" placeholder="请输入进店次数" />
        </el-form-item>
        <el-form-item label="进店人数" prop="enterShopPeopleNum">
          <el-input v-model="form.enterShopPeopleNum" placeholder="请输入进店人数" />
        </el-form-item>
        <el-form-item label="进店转化率" prop="shopConversionRate">
          <el-input v-model="form.shopConversionRate" placeholder="请输入进店转化率" />
        </el-form-item>
        <el-form-item label="下单转化率" prop="orderConversionRate">
          <el-input v-model="form.orderConversionRate" placeholder="请输入下单转化率" />
        </el-form-item>
        <el-form-item label="新客下单转化率" prop="newOrdersConversionRate">
          <el-input v-model="form.newOrdersConversionRate" placeholder="请输入新客下单转化率" />
        </el-form-item>
        <el-form-item label="老客下单转化率" prop="regularCustomersConversionRate">
          <el-input v-model="form.regularCustomersConversionRate" placeholder="请输入老客下单转化率" />
        </el-form-item>
        <el-form-item label="参与活动数" prop="activitiesNum">
          <el-input v-model="form.activitiesNum" placeholder="请输入参与活动数" />
        </el-form-item>
        <el-form-item label="活动订单数" prop="activeOrdersNum">
          <el-input v-model="form.activeOrdersNum" placeholder="请输入活动订单数" />
        </el-form-item>
        <el-form-item label="活动订单占比" prop="activeOrdersProportion">
          <el-input v-model="form.activeOrdersProportion" placeholder="请输入活动订单占比" />
        </el-form-item>
        <el-form-item label="满减活动订单数" prop="activeOrdersFullReduction">
          <el-input v-model="form.activeOrdersFullReduction" placeholder="请输入满减活动订单数" />
        </el-form-item>
        <el-form-item label="超会活动订单数" prop="beyondMeetingOrders">
          <el-input v-model="form.beyondMeetingOrders" placeholder="请输入超会活动订单数" />
        </el-form-item>
        <el-form-item label="配送活动订单数" prop="deliveryActivityOrders">
          <el-input v-model="form.deliveryActivityOrders" placeholder="请输入配送活动订单数" />
        </el-form-item>
        <el-form-item label="投入产出比" prop="inputOutputRatio">
          <el-input v-model="form.inputOutputRatio" placeholder="请输入投入产出比" />
        </el-form-item>
        <el-form-item label="活动总补贴" prop="activitiesSubsidyTotal">
          <el-input v-model="form.activitiesSubsidyTotal" placeholder="请输入活动总补贴" />
        </el-form-item>
        <el-form-item label="饿了么补贴" prop="elmSubsidy">
          <el-input v-model="form.elmSubsidy" placeholder="请输入饿了么补贴" />
        </el-form-item>
        <el-form-item label="代理商补贴" prop="agentSubsidy">
          <el-input v-model="form.agentSubsidy" placeholder="请输入代理商补贴" />
        </el-form-item>
        <el-form-item label="商家活动成本" prop="merchantActivityCosts">
          <el-input v-model="form.merchantActivityCosts" placeholder="请输入商家活动成本" />
        </el-form-item>
        <el-form-item label="商家活动成本" prop="excludingMerchantActivityCosts">
          <el-input v-model="form.excludingMerchantActivityCosts" placeholder="请输入商家活动成本" />
        </el-form-item>
        <el-form-item label="营销力度" prop="marketingEfforts">
          <el-input v-model="form.marketingEfforts" placeholder="请输入营销力度" />
        </el-form-item>
        <el-form-item label="营销力度" prop="excludingMarketingEfforts">
          <el-input v-model="form.excludingMarketingEfforts" placeholder="请输入营销力度" />
        </el-form-item>
        <el-form-item label="下单人数" prop="ordersPeopleNum">
          <el-input v-model="form.ordersPeopleNum" placeholder="请输入下单人数" />
        </el-form-item>
        <el-form-item label="近7日复购人数" prop="recent7daysRepurchasesNum">
          <el-input v-model="form.recent7daysRepurchasesNum" placeholder="请输入近7日复购人数" />
        </el-form-item>
        <el-form-item label="近7日复购率" prop="recent7daysRepurchasesRate">
          <el-input v-model="form.recent7daysRepurchasesRate" placeholder="请输入近7日复购率" />
        </el-form-item>
        <el-form-item label="近30日复购人数" prop="recent30daysRepurchaseNum">
          <el-input v-model="form.recent30daysRepurchaseNum" placeholder="请输入近30日复购人数" />
        </el-form-item>
        <el-form-item label="近30日复购率" prop="recent30daysRepurchaseRate">
          <el-input v-model="form.recent30daysRepurchaseRate" placeholder="请输入近30日复购率" />
        </el-form-item>
        <el-form-item label="新客人数" prop="newCustomersNum">
          <el-input v-model="form.newCustomersNum" placeholder="请输入新客人数" />
        </el-form-item>
        <el-form-item label="老客人数" prop="regularCustomersNum">
          <el-input v-model="form.regularCustomersNum" placeholder="请输入老客人数" />
        </el-form-item>
        <el-form-item label="上架商品数" prop="onShelfGoodsNum">
          <el-input v-model="form.onShelfGoodsNum" placeholder="请输入上架商品数" />
        </el-form-item>
        <el-form-item label="有交易商品数" prop="tradedGoodsNum">
          <el-input v-model="form.tradedGoodsNum" placeholder="请输入有交易商品数" />
        </el-form-item>
        <el-form-item label="库存不足商品数" prop="insufficientInventoryGoodsNum">
          <el-input v-model="form.insufficientInventoryGoodsNum" placeholder="请输入库存不足商品数" />
        </el-form-item>
        <el-form-item label="新上架商品数" prop="newProductsMarketNum">
          <el-input v-model="form.newProductsMarketNum" placeholder="请输入新上架商品数" />
        </el-form-item>
        <el-form-item label="活动商品数" prop="activeProductsNum">
          <el-input v-model="form.activeProductsNum" placeholder="请输入活动商品数" />
        </el-form-item>
        <el-form-item label="差评订单数" prop="negativeEvaluationOrderNum">
          <el-input v-model="form.negativeEvaluationOrderNum" placeholder="请输入差评订单数" />
        </el-form-item>
        <el-form-item label="投诉订单数" prop="complaintOrdersNum">
          <el-input v-model="form.complaintOrdersNum" placeholder="请输入投诉订单数" />
        </el-form-item>
        <el-form-item label="投诉订单id" prop="complaintOrderId">
          <el-input v-model="form.complaintOrderId" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="出餐超时订单数" prop="overtimeOrdersNum">
          <el-input v-model="form.overtimeOrdersNum" placeholder="请输入出餐超时订单数" />
        </el-form-item>
        <el-form-item label="出餐超时订单id" prop="mealTimeoutOrderId">
          <el-input v-model="form.mealTimeoutOrderId" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="单均出餐时长" prop="averageMealTime">
          <el-input v-model="form.averageMealTime" placeholder="请输入单均出餐时长" />
        </el-form-item>
        <el-form-item label="催单数" prop="remindersNum">
          <el-input v-model="form.remindersNum" placeholder="请输入催单数" />
        </el-form-item>
        <el-form-item label="拒单数" prop="rejectedOrdersNum">
          <el-input v-model="form.rejectedOrdersNum" placeholder="请输入拒单数" />
        </el-form-item>
        <el-form-item label="出餐宝扫码出餐订单数" prop="scannedFoodTreasureNum">
          <el-input v-model="form.scannedFoodTreasureNum" placeholder="请输入出餐宝扫码出餐订单数" />
        </el-form-item>
        <el-form-item label="商责取消数" prop="cancelNum">
          <el-input v-model="form.cancelNum" placeholder="请输入商责取消数" />
        </el-form-item>
        <el-form-item label="商责超时数" prop="responsibilityTimeoutNum">
          <el-input v-model="form.responsibilityTimeoutNum" placeholder="请输入商责超时数" />
        </el-form-item>
        <el-form-item label="商责退单数" prop="chargebacksNum">
          <el-input v-model="form.chargebacksNum" placeholder="请输入商责退单数" />
        </el-form-item>
        <el-form-item label="商责催单数" prop="reminderNum">
          <el-input v-model="form.reminderNum" placeholder="请输入商责催单数" />
        </el-form-item>
        <el-form-item label="商责取消率" prop="cancelRate">
          <el-input v-model="form.cancelRate" placeholder="请输入商责取消率" />
        </el-form-item>
        <el-form-item label="商责超时率" prop="overtimeRate">
          <el-input v-model="form.overtimeRate" placeholder="请输入商责超时率" />
        </el-form-item>
        <el-form-item label="商责退单率" prop="chargebackRate">
          <el-input v-model="form.chargebackRate" placeholder="请输入商责退单率" />
        </el-form-item>
        <el-form-item label="商责催单率" prop="reminderRate">
          <el-input v-model="form.reminderRate" placeholder="请输入商责催单率" />
        </el-form-item>
        <el-form-item label="店铺评分" prop="shopScore">
          <el-input v-model="form.shopScore" placeholder="请输入店铺评分" />
        </el-form-item>
        <el-form-item label="满意度得分" prop="satisfactionScore">
          <el-input v-model="form.satisfactionScore" placeholder="请输入满意度得分" />
        </el-form-item>
        <el-form-item label="味道得分" prop="tasteScore">
          <el-input v-model="form.tasteScore" placeholder="请输入味道得分" />
        </el-form-item>
        <el-form-item label="包装得分" prop="packagingScore">
          <el-input v-model="form.packagingScore" placeholder="请输入包装得分" />
        </el-form-item>
        <el-form-item label="近30日好评率" prop="recent30daysPositiveRate">
          <el-input v-model="form.recent30daysPositiveRate" placeholder="请输入近30日好评率" />
        </el-form-item>
        <el-form-item label="近30日好评数" prop="recent30daysPositiveComments">
          <el-input v-model="form.recent30daysPositiveComments" placeholder="请输入近30日好评数" />
        </el-form-item>
        <el-form-item label="近30日中评率" prop="recent30daysEvaluationRate">
          <el-input v-model="form.recent30daysEvaluationRate" placeholder="请输入近30日中评率" />
        </el-form-item>
        <el-form-item label="近30日中评数" prop="recent30daysMidNum">
          <el-input v-model="form.recent30daysMidNum" placeholder="请输入近30日中评数" />
        </el-form-item>
        <el-form-item label="近30日差评率" prop="recent30daysBadEvaluationRate">
          <el-input v-model="form.recent30daysBadEvaluationRate" placeholder="请输入近30日差评率" />
        </el-form-item>
        <el-form-item label="近30日差评数" prop="recent30daysNegativeCommentsNum">
          <el-input v-model="form.recent30daysNegativeCommentsNum" placeholder="请输入近30日差评数" />
        </el-form-item>
        <el-form-item label="近30日优质评价率" prop="recent30daysQualityEvaluationRate">
          <el-input v-model="form.recent30daysQualityEvaluationRate" placeholder="请输入近30日优质评价率" />
        </el-form-item>
        <el-form-item label="近30日优质评价数" prop="recent30daysHighQualityEvaluationsNum">
          <el-input v-model="form.recent30daysHighQualityEvaluationsNum" placeholder="请输入近30日优质评价数" />
        </el-form-item>
        <el-form-item label="近30日订单评价率" prop="recent30daysOrderEvaluationRate">
          <el-input v-model="form.recent30daysOrderEvaluationRate" placeholder="请输入近30日订单评价率" />
        </el-form-item>
        <el-form-item label="近30日订单评价数" prop="recent30daysOrderEvaluationNum">
          <el-input v-model="form.recent30daysOrderEvaluationNum" placeholder="请输入近30日订单评价数" />
        </el-form-item>
        <el-form-item label="近30日差评人工回复率" prop="recent30daysManualResponseRate">
          <el-input v-model="form.recent30daysManualResponseRate" placeholder="请输入近30日差评人工回复率" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 数据导入对话框 -->
    <el-dialog :title="upload.title" :visible.sync="upload.open" width="400px" append-to-body>
      <el-upload
        ref="upload"
        :limit="1"
        accept=".xlsx, .xls"
        :headers="upload.headers"
        :action="upload.url + '?updateSupport=' + upload.updateSupport"
        :disabled="upload.isUploading"
        :on-progress="handleFileUploadProgress"
        :on-success="handleFileSuccess"
        :auto-upload="false"
        drag
      >
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
        <div class="el-upload__tip text-center" slot="tip">
          <div class="el-upload__tip" slot="tip">
            <el-checkbox v-model="upload.updateSupport" /> 是否更新已经存在的用户数据
          </div>
          <span>仅允许导入xls、xlsx、csv格式文件。</span>
          <el-link type="primary" :underline="false" style="font-size:12px;vertical-align: baseline;" @click="importTemplate">下载模板</el-link>
        </div>
      </el-upload>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitFileForm">确 定</el-button>
        <el-button @click="upload.open = false">取 消</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
import { listElmData, getElmData, delElmData, addElmData, updateElmData } from "@/api/platform/elmData";
import {getToken} from "@/utils/auth";

export default {
  name: "ElmData",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 饿了么门店数据表格数据
      elmDataList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 数据导入参数
      upload: {
        // 是否显示弹出层（用户导入）
        open: false,
        // 弹出层标题（用户导入）
        title: "",
        // 是否禁用上传
        isUploading: false,
        // 是否更新已经存在的用户数据
        updateSupport: 0,
        // 设置上传的请求头部
        headers: { Authorization: "Bearer " + getToken() },
        // 上传的地址
        url: process.env.VUE_APP_BASE_API + "/platform/elmData/importData"
      },
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        date: null,
        shopName: null,
        shopId: null,
        operatingHours: null,
        peakHours: null,
        province: null,
        cityName: null,
        validOrder: null,
        invalidOrder: null,
        income: null,
        turnover: null,
        pay: null,
        customersActuallyAmountTotal: null,
        actualAveragePrice: null,
        averageIncomePrice: null,
        salesGoods: null,
        packagingFee: null,
        selfDeliveryFee: null,
        otherTurnover: null,
        drawServant: null,
        activitySubsidy: null,
        voucherSubsidy: null,
        distributionFeeSubsidy: null,
        smartReductionSubsidy: null,
        smartReductionServiceCharge: null,
        technicalServiceFee: null,
        otherExpenses: null,
        merchantInvalidOrders: null,
        exposedPeopleNum: null,
        exposureTimes: null,
        enterShopTimes: null,
        enterShopPeopleNum: null,
        shopConversionRate: null,
        orderConversionRate: null,
        newOrdersConversionRate: null,
        regularCustomersConversionRate: null,
        activitiesNum: null,
        activeOrdersNum: null,
        activeOrdersProportion: null,
        activeOrdersFullReduction: null,
        beyondMeetingOrders: null,
        deliveryActivityOrders: null,
        inputOutputRatio: null,
        activitiesSubsidyTotal: null,
        elmSubsidy: null,
        agentSubsidy: null,
        merchantActivityCosts: null,
        excludingMerchantActivityCosts: null,
        marketingEfforts: null,
        excludingMarketingEfforts: null,
        ordersPeopleNum: null,
        recent7daysRepurchasesNum: null,
        recent7daysRepurchasesRate: null,
        recent30daysRepurchaseNum: null,
        recent30daysRepurchaseRate: null,
        newCustomersNum: null,
        regularCustomersNum: null,
        onShelfGoodsNum: null,
        tradedGoodsNum: null,
        insufficientInventoryGoodsNum: null,
        newProductsMarketNum: null,
        activeProductsNum: null,
        negativeEvaluationOrderNum: null,
        complaintOrdersNum: null,
        complaintOrderId: null,
        overtimeOrdersNum: null,
        mealTimeoutOrderId: null,
        averageMealTime: null,
        remindersNum: null,
        rejectedOrdersNum: null,
        scannedFoodTreasureNum: null,
        cancelNum: null,
        responsibilityTimeoutNum: null,
        chargebacksNum: null,
        reminderNum: null,
        cancelRate: null,
        overtimeRate: null,
        chargebackRate: null,
        reminderRate: null,
        shopScore: null,
        satisfactionScore: null,
        tasteScore: null,
        packagingScore: null,
        recent30daysPositiveRate: null,
        recent30daysPositiveComments: null,
        recent30daysEvaluationRate: null,
        recent30daysMidNum: null,
        recent30daysBadEvaluationRate: null,
        recent30daysNegativeCommentsNum: null,
        recent30daysQualityEvaluationRate: null,
        recent30daysHighQualityEvaluationsNum: null,
        recent30daysOrderEvaluationRate: null,
        recent30daysOrderEvaluationNum: null,
        recent30daysManualResponseRate: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        date: [
          { required: true, message: "日期不能为空", trigger: "blur" }
        ],
        shopName: [
          { required: true, message: "门店名称不能为空", trigger: "blur" }
        ],
        shopId: [
          { required: true, message: "门店编号不能为空", trigger: "blur" }
        ],
        operatingHours: [
          { required: true, message: "营业时长不能为空", trigger: "blur" }
        ],
        peakHours: [
          { required: true, message: "高峰期营业时长不能为空", trigger: "blur" }
        ],
        province: [
          { required: true, message: "省份不能为空", trigger: "blur" }
        ],
        cityName: [
          { required: true, message: "城市名称不能为空", trigger: "blur" }
        ],
        validOrder: [
          { required: true, message: "有效订单不能为空", trigger: "blur" }
        ],
        invalidOrder: [
          { required: true, message: "无效订单不能为空", trigger: "blur" }
        ],
        income: [
          { required: true, message: "收入不能为空", trigger: "blur" }
        ],
        turnover: [
          { required: true, message: "营业额不能为空", trigger: "blur" }
        ],
        pay: [
          { required: true, message: "支出不能为空", trigger: "blur" }
        ],
        customersActuallyAmountTotal: [
          { required: true, message: "顾客实付总额不能为空", trigger: "blur" }
        ],
        actualAveragePrice: [
          { required: true, message: "单均实付不能为空", trigger: "blur" }
        ],
        averageIncomePrice: [
          { required: true, message: "单均收入不能为空", trigger: "blur" }
        ],
        salesGoods: [
          { required: true, message: "商品销售额不能为空", trigger: "blur" }
        ],
        packagingFee: [
          { required: true, message: "餐盒费不能为空", trigger: "blur" }
        ],
        selfDeliveryFee: [
          { required: true, message: "自配送费不能为空", trigger: "blur" }
        ],
        otherTurnover: [
          { required: true, message: "其他营业额不能为空", trigger: "blur" }
        ],
        drawServant: [
          { required: true, message: "抽佣不能为空", trigger: "blur" }
        ],
        activitySubsidy: [
          { required: true, message: "活动补贴不能为空", trigger: "blur" }
        ],
        voucherSubsidy: [
          { required: true, message: "代金券补贴不能为空", trigger: "blur" }
        ],
        distributionFeeSubsidy: [
          { required: true, message: "配送费补贴不能为空", trigger: "blur" }
        ],
        smartReductionSubsidy: [
          { required: true, message: "智能满减补贴不能为空", trigger: "blur" }
        ],
        smartReductionServiceCharge: [
          { required: true, message: "智能满减服务费不能为空", trigger: "blur" }
        ],
        technicalServiceFee: [
          { required: true, message: "履约技术服务费不能为空", trigger: "blur" }
        ],
        otherExpenses: [
          { required: true, message: "其他费用支出不能为空", trigger: "blur" }
        ],
        merchantInvalidOrders: [
          { required: true, message: "商户原因无效订单数不能为空", trigger: "blur" }
        ],
        exposedPeopleNum: [
          { required: true, message: "曝光人数不能为空", trigger: "blur" }
        ],
        exposureTimes: [
          { required: true, message: "曝光次数不能为空", trigger: "blur" }
        ],
        enterShopTimes: [
          { required: true, message: "进店次数不能为空", trigger: "blur" }
        ],
        enterShopPeopleNum: [
          { required: true, message: "进店人数不能为空", trigger: "blur" }
        ],
        shopConversionRate: [
          { required: true, message: "进店转化率不能为空", trigger: "blur" }
        ],
        orderConversionRate: [
          { required: true, message: "下单转化率不能为空", trigger: "blur" }
        ],
        newOrdersConversionRate: [
          { required: true, message: "新客下单转化率不能为空", trigger: "blur" }
        ],
        regularCustomersConversionRate: [
          { required: true, message: "老客下单转化率不能为空", trigger: "blur" }
        ],
        activitiesNum: [
          { required: true, message: "参与活动数不能为空", trigger: "blur" }
        ],
        activeOrdersNum: [
          { required: true, message: "活动订单数不能为空", trigger: "blur" }
        ],
        activeOrdersProportion: [
          { required: true, message: "活动订单占比不能为空", trigger: "blur" }
        ],
        activeOrdersFullReduction: [
          { required: true, message: "满减活动订单数不能为空", trigger: "blur" }
        ],
        beyondMeetingOrders: [
          { required: true, message: "超会活动订单数不能为空", trigger: "blur" }
        ],
        deliveryActivityOrders: [
          { required: true, message: "配送活动订单数不能为空", trigger: "blur" }
        ],
        inputOutputRatio: [
          { required: true, message: "投入产出比不能为空", trigger: "blur" }
        ],
        activitiesSubsidyTotal: [
          { required: true, message: "活动总补贴不能为空", trigger: "blur" }
        ],
        elmSubsidy: [
          { required: true, message: "饿了么补贴不能为空", trigger: "blur" }
        ],
        agentSubsidy: [
          { required: true, message: "代理商补贴不能为空", trigger: "blur" }
        ],
        merchantActivityCosts: [
          { required: true, message: "商家活动成本不能为空", trigger: "blur" }
        ],
        excludingMerchantActivityCosts: [
          { required: true, message: "商家活动成本不能为空", trigger: "blur" }
        ],
        marketingEfforts: [
          { required: true, message: "营销力度不能为空", trigger: "blur" }
        ],
        excludingMarketingEfforts: [
          { required: true, message: "营销力度不能为空", trigger: "blur" }
        ],
        ordersPeopleNum: [
          { required: true, message: "下单人数不能为空", trigger: "blur" }
        ],
        recent7daysRepurchasesNum: [
          { required: true, message: "近7日复购人数不能为空", trigger: "blur" }
        ],
        recent7daysRepurchasesRate: [
          { required: true, message: "近7日复购率不能为空", trigger: "blur" }
        ],
        recent30daysRepurchaseNum: [
          { required: true, message: "近30日复购人数不能为空", trigger: "blur" }
        ],
        recent30daysRepurchaseRate: [
          { required: true, message: "近30日复购率不能为空", trigger: "blur" }
        ],
        newCustomersNum: [
          { required: true, message: "新客人数不能为空", trigger: "blur" }
        ],
        regularCustomersNum: [
          { required: true, message: "老客人数不能为空", trigger: "blur" }
        ],
        onShelfGoodsNum: [
          { required: true, message: "上架商品数不能为空", trigger: "blur" }
        ],
        tradedGoodsNum: [
          { required: true, message: "有交易商品数不能为空", trigger: "blur" }
        ],
        insufficientInventoryGoodsNum: [
          { required: true, message: "库存不足商品数不能为空", trigger: "blur" }
        ],
        newProductsMarketNum: [
          { required: true, message: "新上架商品数不能为空", trigger: "blur" }
        ],
        activeProductsNum: [
          { required: true, message: "活动商品数不能为空", trigger: "blur" }
        ],
        negativeEvaluationOrderNum: [
          { required: true, message: "差评订单数不能为空", trigger: "blur" }
        ],
        complaintOrdersNum: [
          { required: true, message: "投诉订单数不能为空", trigger: "blur" }
        ],
        complaintOrderId: [
          { required: true, message: "投诉订单id不能为空", trigger: "blur" }
        ],
        overtimeOrdersNum: [
          { required: true, message: "出餐超时订单数不能为空", trigger: "blur" }
        ],
        mealTimeoutOrderId: [
          { required: true, message: "出餐超时订单id不能为空", trigger: "blur" }
        ],
        averageMealTime: [
          { required: true, message: "单均出餐时长不能为空", trigger: "blur" }
        ],
        remindersNum: [
          { required: true, message: "催单数不能为空", trigger: "blur" }
        ],
        rejectedOrdersNum: [
          { required: true, message: "拒单数不能为空", trigger: "blur" }
        ],
        scannedFoodTreasureNum: [
          { required: true, message: "出餐宝扫码出餐订单数不能为空", trigger: "blur" }
        ],
        cancelNum: [
          { required: true, message: "商责取消数不能为空", trigger: "blur" }
        ],
        responsibilityTimeoutNum: [
          { required: true, message: "商责超时数不能为空", trigger: "blur" }
        ],
        chargebacksNum: [
          { required: true, message: "商责退单数不能为空", trigger: "blur" }
        ],
        reminderNum: [
          { required: true, message: "商责催单数不能为空", trigger: "blur" }
        ],
        cancelRate: [
          { required: true, message: "商责取消率不能为空", trigger: "blur" }
        ],
        overtimeRate: [
          { required: true, message: "商责超时率不能为空", trigger: "blur" }
        ],
        chargebackRate: [
          { required: true, message: "商责退单率不能为空", trigger: "blur" }
        ],
        reminderRate: [
          { required: true, message: "商责催单率不能为空", trigger: "blur" }
        ],
        shopScore: [
          { required: true, message: "店铺评分不能为空", trigger: "blur" }
        ],
        satisfactionScore: [
          { required: true, message: "满意度得分不能为空", trigger: "blur" }
        ],
        tasteScore: [
          { required: true, message: "味道得分不能为空", trigger: "blur" }
        ],
        packagingScore: [
          { required: true, message: "包装得分不能为空", trigger: "blur" }
        ],
        recent30daysPositiveRate: [
          { required: true, message: "近30日好评率不能为空", trigger: "blur" }
        ],
        recent30daysPositiveComments: [
          { required: true, message: "近30日好评数不能为空", trigger: "blur" }
        ],
        recent30daysEvaluationRate: [
          { required: true, message: "近30日中评率不能为空", trigger: "blur" }
        ],
        recent30daysMidNum: [
          { required: true, message: "近30日中评数不能为空", trigger: "blur" }
        ],
        recent30daysBadEvaluationRate: [
          { required: true, message: "近30日差评率不能为空", trigger: "blur" }
        ],
        recent30daysNegativeCommentsNum: [
          { required: true, message: "近30日差评数不能为空", trigger: "blur" }
        ],
        recent30daysQualityEvaluationRate: [
          { required: true, message: "近30日优质评价率不能为空", trigger: "blur" }
        ],
        recent30daysHighQualityEvaluationsNum: [
          { required: true, message: "近30日优质评价数不能为空", trigger: "blur" }
        ],
        recent30daysOrderEvaluationRate: [
          { required: true, message: "近30日订单评价率不能为空", trigger: "blur" }
        ],
        recent30daysOrderEvaluationNum: [
          { required: true, message: "近30日订单评价数不能为空", trigger: "blur" }
        ],
        recent30daysManualResponseRate: [
          { required: true, message: "近30日差评人工回复率不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询饿了么门店数据列表 */
    getList() {
      this.loading = true;
      listElmData(this.queryParams).then(response => {
        this.elmDataList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        date: null,
        shopName: null,
        shopId: null,
        operatingHours: null,
        peakHours: null,
        province: null,
        cityName: null,
        validOrder: null,
        invalidOrder: null,
        income: null,
        turnover: null,
        pay: null,
        customersActuallyAmountTotal: null,
        actualAveragePrice: null,
        averageIncomePrice: null,
        salesGoods: null,
        packagingFee: null,
        selfDeliveryFee: null,
        otherTurnover: null,
        drawServant: null,
        activitySubsidy: null,
        voucherSubsidy: null,
        distributionFeeSubsidy: null,
        smartReductionSubsidy: null,
        smartReductionServiceCharge: null,
        technicalServiceFee: null,
        otherExpenses: null,
        merchantInvalidOrders: null,
        exposedPeopleNum: null,
        exposureTimes: null,
        enterShopTimes: null,
        enterShopPeopleNum: null,
        shopConversionRate: null,
        orderConversionRate: null,
        newOrdersConversionRate: null,
        regularCustomersConversionRate: null,
        activitiesNum: null,
        activeOrdersNum: null,
        activeOrdersProportion: null,
        activeOrdersFullReduction: null,
        beyondMeetingOrders: null,
        deliveryActivityOrders: null,
        inputOutputRatio: null,
        activitiesSubsidyTotal: null,
        elmSubsidy: null,
        agentSubsidy: null,
        merchantActivityCosts: null,
        excludingMerchantActivityCosts: null,
        marketingEfforts: null,
        excludingMarketingEfforts: null,
        ordersPeopleNum: null,
        recent7daysRepurchasesNum: null,
        recent7daysRepurchasesRate: null,
        recent30daysRepurchaseNum: null,
        recent30daysRepurchaseRate: null,
        newCustomersNum: null,
        regularCustomersNum: null,
        onShelfGoodsNum: null,
        tradedGoodsNum: null,
        insufficientInventoryGoodsNum: null,
        newProductsMarketNum: null,
        activeProductsNum: null,
        negativeEvaluationOrderNum: null,
        complaintOrdersNum: null,
        complaintOrderId: null,
        overtimeOrdersNum: null,
        mealTimeoutOrderId: null,
        averageMealTime: null,
        remindersNum: null,
        rejectedOrdersNum: null,
        scannedFoodTreasureNum: null,
        cancelNum: null,
        responsibilityTimeoutNum: null,
        chargebacksNum: null,
        reminderNum: null,
        cancelRate: null,
        overtimeRate: null,
        chargebackRate: null,
        reminderRate: null,
        shopScore: null,
        satisfactionScore: null,
        tasteScore: null,
        packagingScore: null,
        recent30daysPositiveRate: null,
        recent30daysPositiveComments: null,
        recent30daysEvaluationRate: null,
        recent30daysMidNum: null,
        recent30daysBadEvaluationRate: null,
        recent30daysNegativeCommentsNum: null,
        recent30daysQualityEvaluationRate: null,
        recent30daysHighQualityEvaluationsNum: null,
        recent30daysOrderEvaluationRate: null,
        recent30daysOrderEvaluationNum: null,
        recent30daysManualResponseRate: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加饿了么门店数据";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getElmData(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改饿了么门店数据";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateElmData(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addElmData(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除饿了么门店数据编号为"' + ids + '"的数据项？').then(function() {
        return delElmData(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "饿了么门店数据导入";
      this.upload.open = true;
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('platform/elmData/export', {
        ...this.queryParams
      }, `elmData_${new Date().getTime()}.xlsx`)
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('platform/elmData/importTemplate', {
      }, `elmShopData_template_${new Date().getTime()}.xlsx`)
    },
    // 文件上传中处理
    handleFileUploadProgress(event, file, fileList) {
      this.upload.isUploading = true;
    },
    // 文件上传成功处理
    handleFileSuccess(response, file, fileList) {
      this.upload.open = false;
      this.upload.isUploading = false;
      this.$refs.upload.clearFiles();
      this.$alert("<div style='overflow: auto;overflow-x: hidden;max-height: 70vh;padding: 10px 20px 0;'>" + response.msg + "</div>", "导入结果", { dangerouslyUseHTMLString: true });
      this.getList();
    },
    // 提交上传文件
    submitFileForm() {
      this.$refs.upload.submit();
    }
  }
};
</script>
