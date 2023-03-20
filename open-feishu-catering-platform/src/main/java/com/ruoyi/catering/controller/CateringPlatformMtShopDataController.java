package com.ruoyi.catering.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.catering.domain.CateringPlatformElmShopData;
import com.ruoyi.common.core.domain.entity.SysUser;
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
import com.ruoyi.catering.domain.CateringPlatformMtShopData;
import com.ruoyi.catering.service.ICateringPlatformMtShopDataService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 美团门店数据Controller
 * 
 * @author liuxiaodong
 * @date 2023-03-16
 */
@RestController
@RequestMapping("/platform/mtData")
public class CateringPlatformMtShopDataController extends BaseController
{
    @Autowired
    private ICateringPlatformMtShopDataService cateringPlatformMtShopDataService;

    /**
     * 查询美团门店数据列表
     */
    @PreAuthorize("@ss.hasPermi('platform:mtData:list')")
    @GetMapping("/list")
    public TableDataInfo list(CateringPlatformMtShopData cateringPlatformMtShopData)
    {
        startPage();
        List<CateringPlatformMtShopData> list = cateringPlatformMtShopDataService.selectCateringPlatformMtShopDataList(cateringPlatformMtShopData);
        return getDataTable(list);
    }

    /**
     * 导出美团门店数据列表
     */
    @PreAuthorize("@ss.hasPermi('platform:mtData:export')")
    @Log(title = "美团门店数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CateringPlatformMtShopData cateringPlatformMtShopData)
    {
        List<CateringPlatformMtShopData> list = cateringPlatformMtShopDataService.selectCateringPlatformMtShopDataList(cateringPlatformMtShopData);
        ExcelUtil<CateringPlatformMtShopData> util = new ExcelUtil<CateringPlatformMtShopData>(CateringPlatformMtShopData.class);
        util.exportExcel(response, list, "美团门店数据数据");
    }

    @Log(title = "美团门店数据导入", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('platform:mtData:export')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<CateringPlatformMtShopData> util = new ExcelUtil<CateringPlatformMtShopData>(CateringPlatformMtShopData.class);
        List<CateringPlatformMtShopData> userList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = cateringPlatformMtShopDataService.importPlatformMtShopData(userList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<CateringPlatformMtShopData> util = new ExcelUtil<CateringPlatformMtShopData>(CateringPlatformMtShopData.class);
        util.importTemplateExcel(response, "美团门店数据");
    }

    /**
     * 获取美团门店数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('platform:mtData:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(cateringPlatformMtShopDataService.selectCateringPlatformMtShopDataById(id));
    }

    /**
     * 新增美团门店数据
     */
    @PreAuthorize("@ss.hasPermi('platform:mtData:add')")
    @Log(title = "美团门店数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CateringPlatformMtShopData cateringPlatformMtShopData)
    {
        return toAjax(cateringPlatformMtShopDataService.insertCateringPlatformMtShopData(cateringPlatformMtShopData));
    }

    /**
     * 修改美团门店数据
     */
    @PreAuthorize("@ss.hasPermi('platform:mtData:edit')")
    @Log(title = "美团门店数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CateringPlatformMtShopData cateringPlatformMtShopData)
    {
        return toAjax(cateringPlatformMtShopDataService.updateCateringPlatformMtShopData(cateringPlatformMtShopData));
    }

    /**
     * 删除美团门店数据
     */
    @PreAuthorize("@ss.hasPermi('platform:mtData:remove')")
    @Log(title = "美团门店数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cateringPlatformMtShopDataService.deleteCateringPlatformMtShopDataByIds(ids));
    }
}
