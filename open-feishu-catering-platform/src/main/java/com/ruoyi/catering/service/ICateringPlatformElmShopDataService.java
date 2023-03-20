package com.ruoyi.catering.service;

import java.util.List;
import com.ruoyi.catering.domain.CateringPlatformElmShopData;
import com.ruoyi.common.core.domain.entity.SysUser;

/**
 * 饿了么门店数据Service接口
 * 
 * @author liuxiaodong
 * @date 2023-03-16
 */
public interface ICateringPlatformElmShopDataService 
{
    /**
     * 查询饿了么门店数据
     * 
     * @param id 饿了么门店数据主键
     * @return 饿了么门店数据
     */
    public CateringPlatformElmShopData selectCateringPlatformElmShopDataById(Long id);

    /**
     * 查询饿了么门店数据列表
     * 
     * @param cateringPlatformElmShopData 饿了么门店数据
     * @return 饿了么门店数据集合
     */
    public List<CateringPlatformElmShopData> selectCateringPlatformElmShopDataList(CateringPlatformElmShopData cateringPlatformElmShopData);

    /**
     * 新增饿了么门店数据
     * 
     * @param cateringPlatformElmShopData 饿了么门店数据
     * @return 结果
     */
    public int insertCateringPlatformElmShopData(CateringPlatformElmShopData cateringPlatformElmShopData);

    /**
     * 修改饿了么门店数据
     * 
     * @param cateringPlatformElmShopData 饿了么门店数据
     * @return 结果
     */
    public int updateCateringPlatformElmShopData(CateringPlatformElmShopData cateringPlatformElmShopData);

    /**
     * 批量删除饿了么门店数据
     * 
     * @param ids 需要删除的饿了么门店数据主键集合
     * @return 结果
     */
    public int deleteCateringPlatformElmShopDataByIds(Long[] ids);

    /**
     * 删除饿了么门店数据信息
     * 
     * @param id 饿了么门店数据主键
     * @return 结果
     */
    public int deleteCateringPlatformElmShopDataById(Long id);

    /**
     * 导入饿了么门店数据
     *
     * @param elmShopDataList 饿了么数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importPlatformElmShopData(List<CateringPlatformElmShopData> elmShopDataList, Boolean isUpdateSupport, String operName);
}
