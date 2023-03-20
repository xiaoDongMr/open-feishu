package com.ruoyi.catering.service;

import java.util.List;

import com.ruoyi.catering.domain.CateringPlatformElmShopData;
import com.ruoyi.catering.domain.CateringPlatformMtShopData;

/**
 * 美团门店数据Service接口
 * 
 * @author liuxiaodong
 * @date 2023-03-16
 */
public interface ICateringPlatformMtShopDataService 
{
    /**
     * 查询美团门店数据
     * 
     * @param id 美团门店数据主键
     * @return 美团门店数据
     */
    public CateringPlatformMtShopData selectCateringPlatformMtShopDataById(Long id);

    /**
     * 查询美团门店数据列表
     * 
     * @param cateringPlatformMtShopData 美团门店数据
     * @return 美团门店数据集合
     */
    public List<CateringPlatformMtShopData> selectCateringPlatformMtShopDataList(CateringPlatformMtShopData cateringPlatformMtShopData);

    /**
     * 新增美团门店数据
     * 
     * @param cateringPlatformMtShopData 美团门店数据
     * @return 结果
     */
    public int insertCateringPlatformMtShopData(CateringPlatformMtShopData cateringPlatformMtShopData);

    /**
     * 修改美团门店数据
     * 
     * @param cateringPlatformMtShopData 美团门店数据
     * @return 结果
     */
    public int updateCateringPlatformMtShopData(CateringPlatformMtShopData cateringPlatformMtShopData);

    /**
     * 批量删除美团门店数据
     * 
     * @param ids 需要删除的美团门店数据主键集合
     * @return 结果
     */
    public int deleteCateringPlatformMtShopDataByIds(Long[] ids);

    /**
     * 删除美团门店数据信息
     * 
     * @param id 美团门店数据主键
     * @return 结果
     */
    public int deleteCateringPlatformMtShopDataById(Long id);


    /**
     * 导入美图门店数据
     *
     * @param elmShopDataList 美团数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importPlatformMtShopData(List<CateringPlatformMtShopData> elmShopDataList, Boolean isUpdateSupport, String operName);
}
