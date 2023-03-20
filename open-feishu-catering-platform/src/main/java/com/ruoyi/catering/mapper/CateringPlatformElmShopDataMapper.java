package com.ruoyi.catering.mapper;

import java.util.List;
import com.ruoyi.catering.domain.CateringPlatformElmShopData;

/**
 * 饿了么门店数据Mapper接口
 * 
 * @author liuxiaodong
 * @date 2023-03-16
 */
public interface CateringPlatformElmShopDataMapper 
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
     * 删除饿了么门店数据
     * 
     * @param id 饿了么门店数据主键
     * @return 结果
     */
    public int deleteCateringPlatformElmShopDataById(Long id);

    /**
     * 批量删除饿了么门店数据
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCateringPlatformElmShopDataByIds(Long[] ids);

    /**
     * 根据店铺查询饿了么店铺数据
     * @param elmShopData
     * @return
     */
    public CateringPlatformElmShopData selectElmShopDataByShopIDAndDate(CateringPlatformElmShopData elmShopData);
}
