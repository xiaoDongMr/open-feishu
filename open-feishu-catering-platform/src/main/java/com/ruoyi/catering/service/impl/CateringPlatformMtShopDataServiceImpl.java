package com.ruoyi.catering.service.impl;

import java.util.List;

import com.ruoyi.catering.domain.CateringPlatformElmShopData;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.catering.mapper.CateringPlatformMtShopDataMapper;
import com.ruoyi.catering.domain.CateringPlatformMtShopData;
import com.ruoyi.catering.service.ICateringPlatformMtShopDataService;

import javax.validation.Validator;

/**
 * 美团门店数据Service业务层处理
 * 
 * @author liuxiaodong
 * @date 2023-03-16
 */
@Service
public class CateringPlatformMtShopDataServiceImpl implements ICateringPlatformMtShopDataService 
{
    private static final Logger log = LoggerFactory.getLogger(CateringPlatformMtShopDataServiceImpl.class);

    @Autowired
    private CateringPlatformMtShopDataMapper cateringPlatformMtShopDataMapper;
    @Autowired
    protected Validator validator;

    /**
     * 查询美团门店数据
     * 
     * @param id 美团门店数据主键
     * @return 美团门店数据
     */
    @Override
    public CateringPlatformMtShopData selectCateringPlatformMtShopDataById(Long id)
    {
        return cateringPlatformMtShopDataMapper.selectCateringPlatformMtShopDataById(id);
    }

    /**
     * 查询美团门店数据列表
     * 
     * @param cateringPlatformMtShopData 美团门店数据
     * @return 美团门店数据
     */
    @Override
    public List<CateringPlatformMtShopData> selectCateringPlatformMtShopDataList(CateringPlatformMtShopData cateringPlatformMtShopData)
    {
        return cateringPlatformMtShopDataMapper.selectCateringPlatformMtShopDataList(cateringPlatformMtShopData);
    }

    /**
     * 新增美团门店数据
     * 
     * @param cateringPlatformMtShopData 美团门店数据
     * @return 结果
     */
    @Override
    public int insertCateringPlatformMtShopData(CateringPlatformMtShopData cateringPlatformMtShopData)
    {
        return cateringPlatformMtShopDataMapper.insertCateringPlatformMtShopData(cateringPlatformMtShopData);
    }

    /**
     * 修改美团门店数据
     * 
     * @param cateringPlatformMtShopData 美团门店数据
     * @return 结果
     */
    @Override
    public int updateCateringPlatformMtShopData(CateringPlatformMtShopData cateringPlatformMtShopData)
    {
        return cateringPlatformMtShopDataMapper.updateCateringPlatformMtShopData(cateringPlatformMtShopData);
    }

    /**
     * 批量删除美团门店数据
     * 
     * @param ids 需要删除的美团门店数据主键
     * @return 结果
     */
    @Override
    public int deleteCateringPlatformMtShopDataByIds(Long[] ids)
    {
        return cateringPlatformMtShopDataMapper.deleteCateringPlatformMtShopDataByIds(ids);
    }

    /**
     * 删除美团门店数据信息
     * 
     * @param id 美团门店数据主键
     * @return 结果
     */
    @Override
    public int deleteCateringPlatformMtShopDataById(Long id)
    {
        return cateringPlatformMtShopDataMapper.deleteCateringPlatformMtShopDataById(id);
    }

    @Override
    public String importPlatformMtShopData(List<CateringPlatformMtShopData> mtShopDataList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(mtShopDataList) || mtShopDataList.size() == 0)
        {
            throw new ServiceException("导入数据不能为空！");
        }

        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (CateringPlatformMtShopData mtShopData : mtShopDataList) {
            try
            {
                CateringPlatformMtShopData msd = cateringPlatformMtShopDataMapper.selectMtShopDataByShopIDAndDate(mtShopData);
                if (StringUtils.isNull(msd))
                {
                    BeanValidators.validateWithException(validator, mtShopData);
                    /*esd.setCreateBy(operName);*/
                    this.insertCateringPlatformMtShopData(mtShopData);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、店铺 " + mtShopData.getDate().toString() + mtShopData.getShopName() + " 导入成功");
                } else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, mtShopData);
                    /*esd.setUpdateBy(operName);*/
                    this.updateCateringPlatformMtShopData(mtShopData);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、店铺 " + mtShopData.getDate().toString() + mtShopData.getShopName() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、店铺 " + mtShopData.getDate().toString() + mtShopData.getShopName() + " 已存在");
                }

            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、店铺 " + mtShopData.getDate().toString() + mtShopData.getShopName() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }

        return successMsg.toString();
    }
}
