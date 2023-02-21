package com.ruoyi.bitable.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.bitable.domain.BitableAppConfig;
import com.ruoyi.bitable.service.IBitableAppConfigService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 多维格应用配置Controller
 * 
 * @author 刘晓东
 * @date 2023-02-21
 */
@RestController
@RequestMapping("/bitable/config")
public class BitableAppConfigController extends BaseController
{
    @Autowired
    private IBitableAppConfigService bitableAppConfigService;

    /**
     * 查询多维格应用配置列表
     */
    @PreAuthorize("@ss.hasPermi('bitable:config:list')")
    @GetMapping("/list")
    public TableDataInfo list(BitableAppConfig bitableAppConfig)
    {
        startPage();
        List<BitableAppConfig> list = bitableAppConfigService.selectBitableAppConfigList(bitableAppConfig);
        return getDataTable(list);
    }

    /**
     * 导出多维格应用配置列表
     */
    @PreAuthorize("@ss.hasPermi('bitable:config:export')")
    @Log(title = "多维格应用配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BitableAppConfig bitableAppConfig)
    {
        List<BitableAppConfig> list = bitableAppConfigService.selectBitableAppConfigList(bitableAppConfig);
        ExcelUtil<BitableAppConfig> util = new ExcelUtil<BitableAppConfig>(BitableAppConfig.class);
        util.exportExcel(response, list, "多维格应用配置数据");
    }

    /**
     * 获取多维格应用配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('bitable:config:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(bitableAppConfigService.selectBitableAppConfigById(id));
    }

    /**
     * 新增多维格应用配置
     */
    @PreAuthorize("@ss.hasPermi('bitable:config:add')")
    @Log(title = "多维格应用配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BitableAppConfig bitableAppConfig)
    {
        return toAjax(bitableAppConfigService.insertBitableAppConfig(bitableAppConfig));
    }

    /**
     * 修改多维格应用配置
     */
    @PreAuthorize("@ss.hasPermi('bitable:config:edit')")
    @Log(title = "多维格应用配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BitableAppConfig bitableAppConfig)
    {
        return toAjax(bitableAppConfigService.updateBitableAppConfig(bitableAppConfig));
    }

    /**
     * 删除多维格应用配置
     */
    @PreAuthorize("@ss.hasPermi('bitable:config:remove')")
    @Log(title = "多维格应用配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(bitableAppConfigService.deleteBitableAppConfigByIds(ids));
    }
}
