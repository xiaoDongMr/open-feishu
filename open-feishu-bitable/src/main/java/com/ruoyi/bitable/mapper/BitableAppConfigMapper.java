package com.ruoyi.bitable.mapper;

import java.util.List;
import com.ruoyi.bitable.domain.BitableAppConfig;

/**
 * 多维格应用配置Mapper接口
 * 
 * @author 刘晓东
 * @date 2023-02-21
 */
public interface BitableAppConfigMapper 
{
    /**
     * 查询多维格应用配置
     * 
     * @param id 多维格应用配置主键
     * @return 多维格应用配置
     */
    public BitableAppConfig selectBitableAppConfigById(String id);

    public BitableAppConfig selectBitableAppConfigByAppId(String appId);

    /**
     * 查询多维格应用配置列表
     * 
     * @param bitableAppConfig 多维格应用配置
     * @return 多维格应用配置集合
     */
    public List<BitableAppConfig> selectBitableAppConfigList(BitableAppConfig bitableAppConfig);

    /**
     * 新增多维格应用配置
     * 
     * @param bitableAppConfig 多维格应用配置
     * @return 结果
     */
    public int insertBitableAppConfig(BitableAppConfig bitableAppConfig);

    /**
     * 修改多维格应用配置
     * 
     * @param bitableAppConfig 多维格应用配置
     * @return 结果
     */
    public int updateBitableAppConfig(BitableAppConfig bitableAppConfig);

    /**
     * 删除多维格应用配置
     * 
     * @param id 多维格应用配置主键
     * @return 结果
     */
    public int deleteBitableAppConfigById(String id);

    /**
     * 批量删除多维格应用配置
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBitableAppConfigByIds(String[] ids);
}
