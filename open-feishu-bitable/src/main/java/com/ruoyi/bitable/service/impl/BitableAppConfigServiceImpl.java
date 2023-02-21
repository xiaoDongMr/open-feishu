package com.ruoyi.bitable.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bitable.mapper.BitableAppConfigMapper;
import com.ruoyi.bitable.domain.BitableAppConfig;
import com.ruoyi.bitable.service.IBitableAppConfigService;

/**
 * 多维格应用配置Service业务层处理
 * 
 * @author 刘晓东
 * @date 2023-02-21
 */
@Service
public class BitableAppConfigServiceImpl implements IBitableAppConfigService 
{
    @Autowired
    private BitableAppConfigMapper bitableAppConfigMapper;

    /**
     * 查询多维格应用配置
     * 
     * @param id 多维格应用配置主键
     * @return 多维格应用配置
     */
    @Override
    public BitableAppConfig selectBitableAppConfigById(String id)
    {
        return bitableAppConfigMapper.selectBitableAppConfigById(id);
    }

    /**
     * 查询多维格应用配置列表
     * 
     * @param bitableAppConfig 多维格应用配置
     * @return 多维格应用配置
     */
    @Override
    public List<BitableAppConfig> selectBitableAppConfigList(BitableAppConfig bitableAppConfig)
    {
        return bitableAppConfigMapper.selectBitableAppConfigList(bitableAppConfig);
    }

    /**
     * 新增多维格应用配置
     * 
     * @param bitableAppConfig 多维格应用配置
     * @return 结果
     */
    @Override
    public int insertBitableAppConfig(BitableAppConfig bitableAppConfig)
    {
        bitableAppConfig.setCreateTime(DateUtils.getNowDate());
        return bitableAppConfigMapper.insertBitableAppConfig(bitableAppConfig);
    }

    /**
     * 修改多维格应用配置
     * 
     * @param bitableAppConfig 多维格应用配置
     * @return 结果
     */
    @Override
    public int updateBitableAppConfig(BitableAppConfig bitableAppConfig)
    {
        bitableAppConfig.setUpdateTime(DateUtils.getNowDate());
        return bitableAppConfigMapper.updateBitableAppConfig(bitableAppConfig);
    }

    /**
     * 批量删除多维格应用配置
     * 
     * @param ids 需要删除的多维格应用配置主键
     * @return 结果
     */
    @Override
    public int deleteBitableAppConfigByIds(String[] ids)
    {
        return bitableAppConfigMapper.deleteBitableAppConfigByIds(ids);
    }

    /**
     * 删除多维格应用配置信息
     * 
     * @param id 多维格应用配置主键
     * @return 结果
     */
    @Override
    public int deleteBitableAppConfigById(String id)
    {
        return bitableAppConfigMapper.deleteBitableAppConfigById(id);
    }
}
