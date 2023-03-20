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
      <el-form-item label="门店所在城市" prop="shopCity">
        <el-input
          v-model="queryParams.shopCity"
          placeholder="请输入门店所在城市"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="店铺名称" prop="shopName">
        <el-input
          v-model="queryParams.shopName"
          placeholder="请输入店铺名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="门店id" prop="shopId">
        <el-input
          v-model="queryParams.shopId"
          placeholder="请输入门店id"
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
          v-hasPermi="['platform:mtData:add']"
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
          v-hasPermi="['platform:mtData:edit']"
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
          v-hasPermi="['platform:mtData:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="info"
          plain
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
          v-hasPermi="['platform:mtData:import']"
        >导入</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['platform:mtData:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="mtDataList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="日期" align="center" prop="date" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.date, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="门店所在城市" align="center" prop="shopCity" />
      <el-table-column label="店铺名称" align="center" prop="shopName" />
      <el-table-column label="门店id" align="center" prop="shopId" />
      <el-table-column label="收入" align="center" prop="income" />
      <el-table-column label="商品原价" align="center" prop="goodsOriginalPrice" />
      <el-table-column label="包装费" align="center" prop="packagingFee" />
      <el-table-column label="顾客配送费" align="center" prop="customerDeliveryFee" />
      <el-table-column label="支出" align="center" prop="pay" />
      <el-table-column label="商家活动支出" align="center" prop="merchantActivityExpenditure" />
      <el-table-column label="公益捐款" align="center" prop="publicContributions" />
      <el-table-column label="其他支出" align="center" prop="otherExpenses" />
      <el-table-column label="营业额" align="center" prop="turnover" />
      <el-table-column label="顾客实付" align="center" prop="customerActualPayment" />
      <el-table-column label="有效订单" align="center" prop="validOrder" />
      <el-table-column label="实付单均价" align="center" prop="paidAveragePrice" />
      <el-table-column label="活动补贴" align="center" prop="activitySubsidy" />
      <el-table-column label="平台活动补贴" align="center" prop="subsidyPlatformActivities" />
      <el-table-column label="平台服务费(含佣金和配送服务费)" align="center" prop="platformServiceFee" />
      <el-table-column label="曝光人数" align="center" prop="exposedPeopleNum" />
      <el-table-column label="入店人数" align="center" prop="enterShopPeopleNum" />
      <el-table-column label="入店转化率" align="center" prop="shopConversionRate" />
      <el-table-column label="下单转化率" align="center" prop="orderConversionRate" />
      <el-table-column label="曝光新客" align="center" prop="exposeNewCustomers" />
      <el-table-column label="入店新客" align="center" prop="enterShopNewCustomers" />
      <el-table-column label="新客入店转化率" align="center" prop="enterShopNewCustomersRate" />
      <el-table-column label="新客下单转化率" align="center" prop="newOrdersConversionRate" />
      <el-table-column label="曝光老客" align="center" prop="exposeRegularCustomers" />
      <el-table-column label="入店老客" align="center" prop="regularCustomers" />
      <el-table-column label="老客入店转化率" align="center" prop="regularCustomersConversionRate" />
      <el-table-column label="老客下单转化率" align="center" prop="regularOrdersConversionRate" />
      <el-table-column label="下单人数" align="center" prop="ordersPeopleNum" />
      <el-table-column label="下单新客" align="center" prop="orderNewCustomers" />
      <el-table-column label="下单老客" align="center" prop="orderRegularCustomer" />
      <el-table-column label="取消订单" align="center" prop="cancelOrder" />
      <el-table-column label="商责取消订单" align="center" prop="cancellationOrders" />
      <el-table-column label="商责取消率" align="center" prop="cancellationRate" />
      <el-table-column label="店铺分" align="center" prop="shopScore" />
      <el-table-column label="高峰营业时长得分" align="center" prop="peakHoursScore" />
      <el-table-column label="优质商品率得分" align="center" prop="highQualityRateScore" />
      <el-table-column label="有效活动丰富度得分" align="center" prop="effectiveActivityAbundanceScore" />
      <el-table-column label="商家不接单率得分" align="center" prop="nonAcceptanceScore" />
      <el-table-column label="差评回复率得分" align="center" prop="negativeFeedbackScore" />
      <el-table-column label="在线联系回复率得分" align="center" prop="onlineContactResponseScore" />
      <el-table-column label="商家评分得分" align="center" prop="merchantScore" />
      <el-table-column label="近30日日均高峰营业时长" align="center" prop="averageDailyPeakRecent30days" />
      <el-table-column label="优质商品率" align="center" prop="highQualityCommodityRate" />
      <el-table-column label="有效活动丰富度" align="center" prop="abundanceEffectiveActivities" />
      <el-table-column label="近30日商家不接单率" align="center" prop="recent30daysNonReceivingRate" />
      <el-table-column label="近30日差评回复率" align="center" prop="recent30daysNegativeResponseRate" />
      <el-table-column label="近7日日均在线联系回复率" align="center" prop="past7daysDailyAverageResponseRate" />
      <el-table-column label="商家评分" align="center" prop="merchantRate" />
      <el-table-column label="菜单丰富度得分" align="center" prop="menuRichnessScore" />
      <el-table-column label="装修丰富度得分" align="center" prop="decorationAbundanceScore" />
      <el-table-column label="服务功能丰富度得分" align="center" prop="serviceFunctionRichnessScore" />
      <el-table-column label="菜单丰富度" align="center" prop="menuRichness" />
      <el-table-column label="装修丰富度" align="center" prop="abundanceDecoration" />
      <el-table-column label="服务功能丰富度" align="center" prop="abundanceServiceFunctions" />
      <el-table-column label="出餐完成上报率/配送准时率" align="center" prop="deliveryPunctualityRate" />
      <el-table-column label="基础营业时长得分" align="center" prop="basicOperatingHoursScore" />
      <el-table-column label="基础营业时长" align="center" prop="basicOperatingHours" />
      <el-table-column label="出餐完成上报率得分/配送准时率得分" align="center" prop="deliveryPunctualityRateScore" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['platform:mtData:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['platform:mtData:remove']"
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

    <!-- 添加或修改美团门店数据对话框 -->
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
        <el-form-item label="门店所在城市" prop="shopCity">
          <el-input v-model="form.shopCity" placeholder="请输入门店所在城市" />
        </el-form-item>
        <el-form-item label="店铺名称" prop="shopName">
          <el-input v-model="form.shopName" placeholder="请输入店铺名称" />
        </el-form-item>
        <el-form-item label="门店id" prop="shopId">
          <el-input v-model="form.shopId" placeholder="请输入门店id" />
        </el-form-item>
        <el-form-item label="收入" prop="income">
          <el-input v-model="form.income" placeholder="请输入收入" />
        </el-form-item>
        <el-form-item label="商品原价" prop="goodsOriginalPrice">
          <el-input v-model="form.goodsOriginalPrice" placeholder="请输入商品原价" />
        </el-form-item>
        <el-form-item label="包装费" prop="packagingFee">
          <el-input v-model="form.packagingFee" placeholder="请输入包装费" />
        </el-form-item>
        <el-form-item label="顾客配送费" prop="customerDeliveryFee">
          <el-input v-model="form.customerDeliveryFee" placeholder="请输入顾客配送费" />
        </el-form-item>
        <el-form-item label="支出" prop="pay">
          <el-input v-model="form.pay" placeholder="请输入支出" />
        </el-form-item>
        <el-form-item label="商家活动支出" prop="merchantActivityExpenditure">
          <el-input v-model="form.merchantActivityExpenditure" placeholder="请输入商家活动支出" />
        </el-form-item>
        <el-form-item label="公益捐款" prop="publicContributions">
          <el-input v-model="form.publicContributions" placeholder="请输入公益捐款" />
        </el-form-item>
        <el-form-item label="其他支出" prop="otherExpenses">
          <el-input v-model="form.otherExpenses" placeholder="请输入其他支出" />
        </el-form-item>
        <el-form-item label="营业额" prop="turnover">
          <el-input v-model="form.turnover" placeholder="请输入营业额" />
        </el-form-item>
        <el-form-item label="顾客实付" prop="customerActualPayment">
          <el-input v-model="form.customerActualPayment" placeholder="请输入顾客实付" />
        </el-form-item>
        <el-form-item label="有效订单" prop="validOrder">
          <el-input v-model="form.validOrder" placeholder="请输入有效订单" />
        </el-form-item>
        <el-form-item label="实付单均价" prop="paidAveragePrice">
          <el-input v-model="form.paidAveragePrice" placeholder="请输入实付单均价" />
        </el-form-item>
        <el-form-item label="活动补贴" prop="activitySubsidy">
          <el-input v-model="form.activitySubsidy" placeholder="请输入活动补贴" />
        </el-form-item>
        <el-form-item label="平台活动补贴" prop="subsidyPlatformActivities">
          <el-input v-model="form.subsidyPlatformActivities" placeholder="请输入平台活动补贴" />
        </el-form-item>
        <el-form-item label="平台服务费(含佣金和配送服务费)" prop="platformServiceFee">
          <el-input v-model="form.platformServiceFee" placeholder="请输入平台服务费(含佣金和配送服务费)" />
        </el-form-item>
        <el-form-item label="入店人数" prop="enterShopPeopleNum">
          <el-input v-model="form.enterShopPeopleNum" placeholder="请输入入店人数" />
        </el-form-item>
        <el-form-item label="入店转化率" prop="shopConversionRate">
          <el-input v-model="form.shopConversionRate" placeholder="请输入入店转化率" />
        </el-form-item>
        <el-form-item label="下单转化率" prop="orderConversionRate">
          <el-input v-model="form.orderConversionRate" placeholder="请输入下单转化率" />
        </el-form-item>
        <el-form-item label="曝光新客" prop="exposeNewCustomers">
          <el-input v-model="form.exposeNewCustomers" placeholder="请输入曝光新客" />
        </el-form-item>
        <el-form-item label="入店新客" prop="enterShopNewCustomers">
          <el-input v-model="form.enterShopNewCustomers" placeholder="请输入入店新客" />
        </el-form-item>
        <el-form-item label="新客入店转化率" prop="enterShopNewCustomersRate">
          <el-input v-model="form.enterShopNewCustomersRate" placeholder="请输入新客入店转化率" />
        </el-form-item>
        <el-form-item label="新客下单转化率" prop="newOrdersConversionRate">
          <el-input v-model="form.newOrdersConversionRate" placeholder="请输入新客下单转化率" />
        </el-form-item>
        <el-form-item label="曝光老客" prop="exposeRegularCustomers">
          <el-input v-model="form.exposeRegularCustomers" placeholder="请输入曝光老客" />
        </el-form-item>
        <el-form-item label="入店老客" prop="regularCustomers">
          <el-input v-model="form.regularCustomers" placeholder="请输入入店老客" />
        </el-form-item>
        <el-form-item label="老客入店转化率" prop="regularCustomersConversionRate">
          <el-input v-model="form.regularCustomersConversionRate" placeholder="请输入老客入店转化率" />
        </el-form-item>
        <el-form-item label="老客下单转化率" prop="regularOrdersConversionRate">
          <el-input v-model="form.regularOrdersConversionRate" placeholder="请输入老客下单转化率" />
        </el-form-item>
        <el-form-item label="下单人数" prop="ordersPeopleNum">
          <el-input v-model="form.ordersPeopleNum" placeholder="请输入下单人数" />
        </el-form-item>
        <el-form-item label="下单新客" prop="orderNewCustomers">
          <el-input v-model="form.orderNewCustomers" placeholder="请输入下单新客" />
        </el-form-item>
        <el-form-item label="下单老客" prop="orderRegularCustomer">
          <el-input v-model="form.orderRegularCustomer" placeholder="请输入下单老客" />
        </el-form-item>
        <el-form-item label="取消订单" prop="cancelOrder">
          <el-input v-model="form.cancelOrder" placeholder="请输入取消订单" />
        </el-form-item>
        <el-form-item label="商责取消订单" prop="cancellationOrders">
          <el-input v-model="form.cancellationOrders" placeholder="请输入商责取消订单" />
        </el-form-item>
        <el-form-item label="商责取消率" prop="cancellationRate">
          <el-input v-model="form.cancellationRate" placeholder="请输入商责取消率" />
        </el-form-item>
        <el-form-item label="店铺分" prop="shopScore">
          <el-input v-model="form.shopScore" placeholder="请输入店铺分" />
        </el-form-item>
        <el-form-item label="高峰营业时长得分" prop="peakHoursScore">
          <el-input v-model="form.peakHoursScore" placeholder="请输入高峰营业时长得分" />
        </el-form-item>
        <el-form-item label="优质商品率得分" prop="highQualityRateScore">
          <el-input v-model="form.highQualityRateScore" placeholder="请输入优质商品率得分" />
        </el-form-item>
        <el-form-item label="有效活动丰富度得分" prop="effectiveActivityAbundanceScore">
          <el-input v-model="form.effectiveActivityAbundanceScore" placeholder="请输入有效活动丰富度得分" />
        </el-form-item>
        <el-form-item label="商家不接单率得分" prop="nonAcceptanceScore">
          <el-input v-model="form.nonAcceptanceScore" placeholder="请输入商家不接单率得分" />
        </el-form-item>
        <el-form-item label="差评回复率得分" prop="negativeFeedbackScore">
          <el-input v-model="form.negativeFeedbackScore" placeholder="请输入差评回复率得分" />
        </el-form-item>
        <el-form-item label="在线联系回复率得分" prop="onlineContactResponseScore">
          <el-input v-model="form.onlineContactResponseScore" placeholder="请输入在线联系回复率得分" />
        </el-form-item>
        <el-form-item label="商家评分得分" prop="merchantScore">
          <el-input v-model="form.merchantScore" placeholder="请输入商家评分得分" />
        </el-form-item>
        <el-form-item label="近30日日均高峰营业时长" prop="averageDailyPeakRecent30days">
          <el-input v-model="form.averageDailyPeakRecent30days" placeholder="请输入近30日日均高峰营业时长" />
        </el-form-item>
        <el-form-item label="优质商品率" prop="highQualityCommodityRate">
          <el-input v-model="form.highQualityCommodityRate" placeholder="请输入优质商品率" />
        </el-form-item>
        <el-form-item label="有效活动丰富度" prop="abundanceEffectiveActivities">
          <el-input v-model="form.abundanceEffectiveActivities" placeholder="请输入有效活动丰富度" />
        </el-form-item>
        <el-form-item label="近30日商家不接单率" prop="recent30daysNonReceivingRate">
          <el-input v-model="form.recent30daysNonReceivingRate" placeholder="请输入近30日商家不接单率" />
        </el-form-item>
        <el-form-item label="近30日差评回复率" prop="recent30daysNegativeResponseRate">
          <el-input v-model="form.recent30daysNegativeResponseRate" placeholder="请输入近30日差评回复率" />
        </el-form-item>
        <el-form-item label="近7日日均在线联系回复率" prop="past7daysDailyAverageResponseRate">
          <el-input v-model="form.past7daysDailyAverageResponseRate" placeholder="请输入近7日日均在线联系回复率" />
        </el-form-item>
        <el-form-item label="商家评分" prop="merchantRate">
          <el-input v-model="form.merchantRate" placeholder="请输入商家评分" />
        </el-form-item>
        <el-form-item label="菜单丰富度得分" prop="menuRichnessScore">
          <el-input v-model="form.menuRichnessScore" placeholder="请输入菜单丰富度得分" />
        </el-form-item>
        <el-form-item label="装修丰富度得分" prop="decorationAbundanceScore">
          <el-input v-model="form.decorationAbundanceScore" placeholder="请输入装修丰富度得分" />
        </el-form-item>
        <el-form-item label="服务功能丰富度得分" prop="serviceFunctionRichnessScore">
          <el-input v-model="form.serviceFunctionRichnessScore" placeholder="请输入服务功能丰富度得分" />
        </el-form-item>
        <el-form-item label="菜单丰富度" prop="menuRichness">
          <el-input v-model="form.menuRichness" placeholder="请输入菜单丰富度" />
        </el-form-item>
        <el-form-item label="装修丰富度" prop="abundanceDecoration">
          <el-input v-model="form.abundanceDecoration" placeholder="请输入装修丰富度" />
        </el-form-item>
        <el-form-item label="服务功能丰富度" prop="abundanceServiceFunctions">
          <el-input v-model="form.abundanceServiceFunctions" placeholder="请输入服务功能丰富度" />
        </el-form-item>
        <el-form-item label="出餐完成上报率/配送准时率" prop="deliveryPunctualityRate">
          <el-input v-model="form.deliveryPunctualityRate" placeholder="请输入出餐完成上报率/配送准时率" />
        </el-form-item>
        <el-form-item label="基础营业时长得分" prop="basicOperatingHoursScore">
          <el-input v-model="form.basicOperatingHoursScore" placeholder="请输入基础营业时长得分" />
        </el-form-item>
        <el-form-item label="基础营业时长" prop="basicOperatingHours">
          <el-input v-model="form.basicOperatingHours" placeholder="请输入基础营业时长" />
        </el-form-item>
        <el-form-item label="出餐完成上报率得分/配送准时率得分" prop="deliveryPunctualityRateScore">
          <el-input v-model="form.deliveryPunctualityRateScore" placeholder="请输入出餐完成上报率得分/配送准时率得分" />
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
import { listMtData, getMtData, delMtData, addMtData, updateMtData } from "@/api/platform/mtData";
import {getToken} from "@/utils/auth";

export default {
  name: "MtData",
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
      // 美团门店数据表格数据
      mtDataList: [],
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
        url: process.env.VUE_APP_BASE_API + "/platform/mtData/importData"
      },
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        date: null,
        shopCity: null,
        shopName: null,
        shopId: null,
        income: null,
        goodsOriginalPrice: null,
        packagingFee: null,
        customerDeliveryFee: null,
        pay: null,
        merchantActivityExpenditure: null,
        publicContributions: null,
        otherExpenses: null,
        turnover: null,
        customerActualPayment: null,
        validOrder: null,
        paidAveragePrice: null,
        activitySubsidy: null,
        subsidyPlatformActivities: null,
        platformServiceFee: null,
        exposedPeopleNum: null,
        enterShopPeopleNum: null,
        shopConversionRate: null,
        orderConversionRate: null,
        exposeNewCustomers: null,
        enterShopNewCustomers: null,
        enterShopNewCustomersRate: null,
        newOrdersConversionRate: null,
        exposeRegularCustomers: null,
        regularCustomers: null,
        regularCustomersConversionRate: null,
        regularOrdersConversionRate: null,
        ordersPeopleNum: null,
        orderNewCustomers: null,
        orderRegularCustomer: null,
        cancelOrder: null,
        cancellationOrders: null,
        cancellationRate: null,
        shopScore: null,
        peakHoursScore: null,
        highQualityRateScore: null,
        effectiveActivityAbundanceScore: null,
        nonAcceptanceScore: null,
        negativeFeedbackScore: null,
        onlineContactResponseScore: null,
        merchantScore: null,
        averageDailyPeakRecent30days: null,
        highQualityCommodityRate: null,
        abundanceEffectiveActivities: null,
        recent30daysNonReceivingRate: null,
        recent30daysNegativeResponseRate: null,
        past7daysDailyAverageResponseRate: null,
        merchantRate: null,
        menuRichnessScore: null,
        decorationAbundanceScore: null,
        serviceFunctionRichnessScore: null,
        menuRichness: null,
        abundanceDecoration: null,
        abundanceServiceFunctions: null,
        deliveryPunctualityRate: null,
        basicOperatingHoursScore: null,
        basicOperatingHours: null,
        deliveryPunctualityRateScore: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        date: [
          { required: true, message: "日期不能为空", trigger: "blur" }
        ],
        shopCity: [
          { required: true, message: "门店所在城市不能为空", trigger: "blur" }
        ],
        shopName: [
          { required: true, message: "店铺名称不能为空", trigger: "blur" }
        ],
        shopId: [
          { required: true, message: "门店id不能为空", trigger: "blur" }
        ],
        income: [
          { required: true, message: "收入不能为空", trigger: "blur" }
        ],
        goodsOriginalPrice: [
          { required: true, message: "商品原价不能为空", trigger: "blur" }
        ],
        packagingFee: [
          { required: true, message: "包装费不能为空", trigger: "blur" }
        ],
        customerDeliveryFee: [
          { required: true, message: "顾客配送费不能为空", trigger: "blur" }
        ],
        pay: [
          { required: true, message: "支出不能为空", trigger: "blur" }
        ],
        merchantActivityExpenditure: [
          { required: true, message: "商家活动支出不能为空", trigger: "blur" }
        ],
        publicContributions: [
          { required: true, message: "公益捐款不能为空", trigger: "blur" }
        ],
        otherExpenses: [
          { required: true, message: "其他支出不能为空", trigger: "blur" }
        ],
        turnover: [
          { required: true, message: "营业额不能为空", trigger: "blur" }
        ],
        customerActualPayment: [
          { required: true, message: "顾客实付不能为空", trigger: "blur" }
        ],
        validOrder: [
          { required: true, message: "有效订单不能为空", trigger: "blur" }
        ],
        paidAveragePrice: [
          { required: true, message: "实付单均价不能为空", trigger: "blur" }
        ],
        activitySubsidy: [
          { required: true, message: "活动补贴不能为空", trigger: "blur" }
        ],
        subsidyPlatformActivities: [
          { required: true, message: "平台活动补贴不能为空", trigger: "blur" }
        ],
        platformServiceFee: [
          { required: true, message: "平台服务费(含佣金和配送服务费)不能为空", trigger: "blur" }
        ],
        exposedPeopleNum: [
          { required: true, message: "曝光人数不能为空", trigger: "blur" }
        ],
        enterShopPeopleNum: [
          { required: true, message: "入店人数不能为空", trigger: "blur" }
        ],
        shopConversionRate: [
          { required: true, message: "入店转化率不能为空", trigger: "blur" }
        ],
        orderConversionRate: [
          { required: true, message: "下单转化率不能为空", trigger: "blur" }
        ],
        exposeNewCustomers: [
          { required: true, message: "曝光新客不能为空", trigger: "blur" }
        ],
        enterShopNewCustomers: [
          { required: true, message: "入店新客不能为空", trigger: "blur" }
        ],
        enterShopNewCustomersRate: [
          { required: true, message: "新客入店转化率不能为空", trigger: "blur" }
        ],
        newOrdersConversionRate: [
          { required: true, message: "新客下单转化率不能为空", trigger: "blur" }
        ],
        exposeRegularCustomers: [
          { required: true, message: "曝光老客不能为空", trigger: "blur" }
        ],
        regularCustomers: [
          { required: true, message: "入店老客不能为空", trigger: "blur" }
        ],
        regularCustomersConversionRate: [
          { required: true, message: "老客入店转化率不能为空", trigger: "blur" }
        ],
        regularOrdersConversionRate: [
          { required: true, message: "老客下单转化率不能为空", trigger: "blur" }
        ],
        ordersPeopleNum: [
          { required: true, message: "下单人数不能为空", trigger: "blur" }
        ],
        orderNewCustomers: [
          { required: true, message: "下单新客不能为空", trigger: "blur" }
        ],
        orderRegularCustomer: [
          { required: true, message: "下单老客不能为空", trigger: "blur" }
        ],
        cancelOrder: [
          { required: true, message: "取消订单不能为空", trigger: "blur" }
        ],
        cancellationOrders: [
          { required: true, message: "商责取消订单不能为空", trigger: "blur" }
        ],
        cancellationRate: [
          { required: true, message: "商责取消率不能为空", trigger: "blur" }
        ],
        shopScore: [
          { required: true, message: "店铺分不能为空", trigger: "blur" }
        ],
        peakHoursScore: [
          { required: true, message: "高峰营业时长得分不能为空", trigger: "blur" }
        ],
        highQualityRateScore: [
          { required: true, message: "优质商品率得分不能为空", trigger: "blur" }
        ],
        effectiveActivityAbundanceScore: [
          { required: true, message: "有效活动丰富度得分不能为空", trigger: "blur" }
        ],
        nonAcceptanceScore: [
          { required: true, message: "商家不接单率得分不能为空", trigger: "blur" }
        ],
        negativeFeedbackScore: [
          { required: true, message: "差评回复率得分不能为空", trigger: "blur" }
        ],
        onlineContactResponseScore: [
          { required: true, message: "在线联系回复率得分不能为空", trigger: "blur" }
        ],
        merchantScore: [
          { required: true, message: "商家评分得分不能为空", trigger: "blur" }
        ],
        averageDailyPeakRecent30days: [
          { required: true, message: "近30日日均高峰营业时长不能为空", trigger: "blur" }
        ],
        highQualityCommodityRate: [
          { required: true, message: "优质商品率不能为空", trigger: "blur" }
        ],
        abundanceEffectiveActivities: [
          { required: true, message: "有效活动丰富度不能为空", trigger: "blur" }
        ],
        recent30daysNonReceivingRate: [
          { required: true, message: "近30日商家不接单率不能为空", trigger: "blur" }
        ],
        recent30daysNegativeResponseRate: [
          { required: true, message: "近30日差评回复率不能为空", trigger: "blur" }
        ],
        past7daysDailyAverageResponseRate: [
          { required: true, message: "近7日日均在线联系回复率不能为空", trigger: "blur" }
        ],
        merchantRate: [
          { required: true, message: "商家评分不能为空", trigger: "blur" }
        ],
        menuRichnessScore: [
          { required: true, message: "菜单丰富度得分不能为空", trigger: "blur" }
        ],
        decorationAbundanceScore: [
          { required: true, message: "装修丰富度得分不能为空", trigger: "blur" }
        ],
        serviceFunctionRichnessScore: [
          { required: true, message: "服务功能丰富度得分不能为空", trigger: "blur" }
        ],
        menuRichness: [
          { required: true, message: "菜单丰富度不能为空", trigger: "blur" }
        ],
        abundanceDecoration: [
          { required: true, message: "装修丰富度不能为空", trigger: "blur" }
        ],
        abundanceServiceFunctions: [
          { required: true, message: "服务功能丰富度不能为空", trigger: "blur" }
        ],
        deliveryPunctualityRate: [
          { required: true, message: "出餐完成上报率/配送准时率不能为空", trigger: "blur" }
        ],
        basicOperatingHoursScore: [
          { required: true, message: "基础营业时长得分不能为空", trigger: "blur" }
        ],
        basicOperatingHours: [
          { required: true, message: "基础营业时长不能为空", trigger: "blur" }
        ],
        deliveryPunctualityRateScore: [
          { required: true, message: "出餐完成上报率得分/配送准时率得分不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询美团门店数据列表 */
    getList() {
      this.loading = true;
      listMtData(this.queryParams).then(response => {
        this.mtDataList = response.rows;
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
        shopCity: null,
        shopName: null,
        shopId: null,
        income: null,
        goodsOriginalPrice: null,
        packagingFee: null,
        customerDeliveryFee: null,
        pay: null,
        merchantActivityExpenditure: null,
        publicContributions: null,
        otherExpenses: null,
        turnover: null,
        customerActualPayment: null,
        validOrder: null,
        paidAveragePrice: null,
        activitySubsidy: null,
        subsidyPlatformActivities: null,
        platformServiceFee: null,
        exposedPeopleNum: null,
        enterShopPeopleNum: null,
        shopConversionRate: null,
        orderConversionRate: null,
        exposeNewCustomers: null,
        enterShopNewCustomers: null,
        enterShopNewCustomersRate: null,
        newOrdersConversionRate: null,
        exposeRegularCustomers: null,
        regularCustomers: null,
        regularCustomersConversionRate: null,
        regularOrdersConversionRate: null,
        ordersPeopleNum: null,
        orderNewCustomers: null,
        orderRegularCustomer: null,
        cancelOrder: null,
        cancellationOrders: null,
        cancellationRate: null,
        shopScore: null,
        peakHoursScore: null,
        highQualityRateScore: null,
        effectiveActivityAbundanceScore: null,
        nonAcceptanceScore: null,
        negativeFeedbackScore: null,
        onlineContactResponseScore: null,
        merchantScore: null,
        averageDailyPeakRecent30days: null,
        highQualityCommodityRate: null,
        abundanceEffectiveActivities: null,
        recent30daysNonReceivingRate: null,
        recent30daysNegativeResponseRate: null,
        past7daysDailyAverageResponseRate: null,
        merchantRate: null,
        menuRichnessScore: null,
        decorationAbundanceScore: null,
        serviceFunctionRichnessScore: null,
        menuRichness: null,
        abundanceDecoration: null,
        abundanceServiceFunctions: null,
        deliveryPunctualityRate: null,
        basicOperatingHoursScore: null,
        basicOperatingHours: null,
        deliveryPunctualityRateScore: null
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
      this.title = "添加美团门店数据";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getMtData(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改美团门店数据";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateMtData(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMtData(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除美团门店数据编号为"' + ids + '"的数据项？').then(function() {
        return delMtData(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "美团门店数据导入";
      this.upload.open = true;
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('platform/mtData/export', {
        ...this.queryParams
      }, `mtData_${new Date().getTime()}.xlsx`)
    },
    /** 下载模板操作 */
    importTemplate() {
      this.download('platform/mtData/importTemplate', {
      }, `mtShopData_template_${new Date().getTime()}.xlsx`)
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
