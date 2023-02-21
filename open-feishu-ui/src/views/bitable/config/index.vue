<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="app_token" prop="appToken" label-width="88px">
        <el-input
          v-model="queryParams.appToken"
          placeholder="请输入URL中app_token"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="table_id" prop="tableId">
        <el-input
          v-model="queryParams.tableId"
          placeholder="请输入URL中table_id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="view_id" prop="viewId">
        <el-input
          v-model="queryParams.viewId"
          placeholder="请输入URL中view_id"
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
          v-hasPermi="['bitable:config:add']"
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
          v-hasPermi="['bitable:config:edit']"
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
          v-hasPermi="['bitable:config:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['bitable:config:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="configList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="应用配置id" align="center" prop="id" />
      <el-table-column label="飞书appID" align="center" prop="appId" />
      <el-table-column label="飞书secret" align="center" prop="appSecret" />
      <el-table-column label="应用类型0:ISV 1:企业自建应用" align="center" prop="appType" />
      <el-table-column label="URL中app_token" align="center" prop="appToken" />
      <el-table-column label="URL中table_id" align="center" prop="tableId" />
      <el-table-column label="URL中view_id" align="center" prop="viewId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['bitable:config:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['bitable:config:remove']"
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

    <!-- 添加或修改多维格应用配置对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="550px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="飞书appID" prop="appId">
          <el-input v-model="form.appId" placeholder="请输入飞书appID" />
        </el-form-item>
        <el-form-item label="飞书secret" prop="appSecret">
          <el-input v-model="form.appSecret" placeholder="请输入飞书secret" />
        </el-form-item>
        <el-form-item label="app_token" prop="appToken">
          <el-input v-model="form.appToken" placeholder="请输入URL中app_token">
            <template slot="append">
              <el-button type="primary" @click="handleShowApptoken">
                参数说明
                <i class="el-icon-question el-icon--right"></i>
              </el-button>
            </template>
          </el-input>
        </el-form-item>
        <el-form-item label="table_id" prop="tableId">
          <el-input v-model="form.tableId" placeholder="请输入URL中table_id">
            <template slot="append">
              <el-button type="primary" @click="handleShowOpenTableId">
                参数说明
                <i class="el-icon-question el-icon--right"></i>
              </el-button>
            </template>
          </el-input>
        </el-form-item>
        <el-form-item label="view_id" prop="viewId">
          <el-input v-model="form.viewId" placeholder="请输入URL中view_id">
            <template slot="append">
              <el-button type="primary" @click="handleShowOpenViewId">
                参数说明
                <i class="el-icon-question el-icon--right"></i>
              </el-button>
            </template>
          </el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <el-dialog title="参数说明app_token" :visible.sync="openAppToken" append-to-body destroy-on-close class="scrollbar">
      <div class="block">
        <img src="@/assets/images/apptokendesc.png">
      </div>
    </el-dialog>
    <el-dialog title="参数说明table_id" :visible.sync="openTableId" append-to-body destroy-on-close class="scrollbar">
      <div class="block">
        <img src="@/assets/images/tableIddesc.png">
      </div>
    </el-dialog>
    <el-dialog title="参数说明view_id" :visible.sync="openViewId" append-to-body destroy-on-close class="scrollbar">
      <div class="block">
        <img src="@/assets/images/viewIddesc.png">
      </div>
    </el-dialog>

  </div>
</template>

<script>
import { listConfig, getConfig, delConfig, addConfig, updateConfig } from "@/api/bitable/config";

export default {
  name: "Config",
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
      // 是否显示AppToken表达式弹出层
      openAppToken: false,
      // 是否显示tableId表达式弹出层
      openTableId: false,
      // 是否显示viewId表达式弹出层
      openViewId: false,
      // 总条数
      total: 0,
      // 多维格应用配置表格数据
      configList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        appId: null,
        appSecret: null,
        appType: null,
        appToken: null,
        tableId: null,
        viewId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        appId: [
          { required: true, message: "飞书appID不能为空", trigger: "blur" }
        ],
        appSecret: [
          { required: true, message: "飞书secret不能为空", trigger: "blur" }
        ],
        appType: [
          { required: true, message: "应用类型0:ISV 1:企业自建应用不能为空", trigger: "change" }
        ],
        appToken: [
          { required: true, message: "URL中app_token不能为空", trigger: "blur" }
        ],
        tableId: [
          { required: true, message: "URL中table_id不能为空", trigger: "blur" }
        ],
        viewId: [
          { required: true, message: "URL中view_id不能为空", trigger: "blur" }
        ],
        createBy: [
          { required: true, message: "创建者不能为空", trigger: "blur" }
        ],
        createTime: [
          { required: true, message: "创建时间不能为空", trigger: "blur" }
        ],
        updateBy: [
          { required: true, message: "更新者不能为空", trigger: "blur" }
        ],
        updateTime: [
          { required: true, message: "更新时间不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询多维格应用配置列表 */
    getList() {
      this.loading = true;
      listConfig(this.queryParams).then(response => {
        this.configList = response.rows;
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
        appId: null,
        appSecret: null,
        appType: null,
        appToken: null,
        tableId: null,
        viewId: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null
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
      this.title = "添加多维格应用配置";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getConfig(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改多维格应用配置";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateConfig(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addConfig(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除多维格应用配置编号为"' + ids + '"的数据项？').then(function() {
        return delConfig(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('bitable/config/export', {
        ...this.queryParams
      }, `config_${new Date().getTime()}.xlsx`)
    },
    handleShowApptoken(){
      this.openAppToken = true;
    },
    handleShowOpenTableId(){
      this.openTableId = true;
    },
    handleShowOpenViewId(){
      this.openViewId = true;
    }
  }
};
</script>
