package com.ruoyi.catering.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

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
import com.ruoyi.catering.domain.CateringPlatformElmShopData;
import com.ruoyi.catering.service.ICateringPlatformElmShopDataService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 饿了么门店数据Controller
 * 
 * @author liuxiaodong
 * @date 2023-03-16
 */
@RestController
@RequestMapping("/platform/elmData")
public class CateringPlatformElmShopDataController extends BaseController
{
    @Autowired
    private ICateringPlatformElmShopDataService cateringPlatformElmShopDataService;

    /**
     * 查询饿了么门店数据列表
     */
    @PreAuthorize("@ss.hasPermi('platform:elmData:list')")
    @GetMapping("/list")
    public TableDataInfo list(CateringPlatformElmShopData cateringPlatformElmShopData)
    {
        startPage();
        List<CateringPlatformElmShopData> list = cateringPlatformElmShopDataService.selectCateringPlatformElmShopDataList(cateringPlatformElmShopData);
        return getDataTable(list);
    }

    /**
     * 导出饿了么门店数据列表
     */
    @PreAuthorize("@ss.hasPermi('platform:elmData:export')")
    @Log(title = "饿了么门店数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CateringPlatformElmShopData cateringPlatformElmShopData)
    {
        List<CateringPlatformElmShopData> list = cateringPlatformElmShopDataService.selectCateringPlatformElmShopDataList(cateringPlatformElmShopData);
        ExcelUtil<CateringPlatformElmShopData> util = new ExcelUtil<CateringPlatformElmShopData>(CateringPlatformElmShopData.class);
        util.exportExcel(response, list, "饿了么门店数据数据");
    }


    @Log(title = "饿了么门店数据导入", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('platform:elmData:export')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<CateringPlatformElmShopData> util = new ExcelUtil<CateringPlatformElmShopData>(CateringPlatformElmShopData.class);
        List<CateringPlatformElmShopData> userList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = cateringPlatformElmShopDataService.importPlatformElmShopData(userList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<CateringPlatformElmShopData> util = new ExcelUtil<CateringPlatformElmShopData>(CateringPlatformElmShopData.class);
        util.importTemplateExcel(response, "饿了么门店数据");
    }


    /**
     * 获取饿了么门店数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('platform:elmData:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(cateringPlatformElmShopDataService.selectCateringPlatformElmShopDataById(id));
    }

    /**
     * 新增饿了么门店数据
     */
    @PreAuthorize("@ss.hasPermi('platform:elmData:add')")
    @Log(title = "饿了么门店数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CateringPlatformElmShopData cateringPlatformElmShopData)
    {
        return toAjax(cateringPlatformElmShopDataService.insertCateringPlatformElmShopData(cateringPlatformElmShopData));
    }

    /**
     * 修改饿了么门店数据
     */
    @PreAuthorize("@ss.hasPermi('platform:elmData:edit')")
    @Log(title = "饿了么门店数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CateringPlatformElmShopData cateringPlatformElmShopData)
    {
        return toAjax(cateringPlatformElmShopDataService.updateCateringPlatformElmShopData(cateringPlatformElmShopData));
    }

    /**
     * 删除饿了么门店数据
     */
    @PreAuthorize("@ss.hasPermi('platform:elmData:remove')")
    @Log(title = "饿了么门店数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cateringPlatformElmShopDataService.deleteCateringPlatformElmShopDataByIds(ids));
    }
}
