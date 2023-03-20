package com.ruoyi.catering.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.catering.mapper.CateringPlatformElmShopDataMapper;
import com.ruoyi.catering.domain.CateringPlatformElmShopData;
import com.ruoyi.catering.service.ICateringPlatformElmShopDataService;

import javax.validation.Validator;

/**
 * 饿了么门店数据Service业务层处理
 * 
 * @author liuxiaodong
 * @date 2023-03-16
 */
@Service
public class CateringPlatformElmShopDataServiceImpl implements ICateringPlatformElmShopDataService 
{
    private static final Logger log = LoggerFactory.getLogger(CateringPlatformElmShopDataServiceImpl.class);

    @Autowired
    private CateringPlatformElmShopDataMapper cateringPlatformElmShopDataMapper;
    @Autowired
    protected Validator validator;

    /**
     * 查询饿了么门店数据
     * 
     * @param id 饿了么门店数据主键
     * @return 饿了么门店数据
     */
    @Override
    public CateringPlatformElmShopData selectCateringPlatformElmShopDataById(Long id)
    {
        return cateringPlatformElmShopDataMapper.selectCateringPlatformElmShopDataById(id);
    }

    /**
     * 查询饿了么门店数据列表
     * 
     * @param cateringPlatformElmShopData 饿了么门店数据
     * @return 饿了么门店数据
     */
    @Override
    public List<CateringPlatformElmShopData> selectCateringPlatformElmShopDataList(CateringPlatformElmShopData cateringPlatformElmShopData)
    {
        return cateringPlatformElmShopDataMapper.selectCateringPlatformElmShopDataList(cateringPlatformElmShopData);
    }

    /**
     * 新增饿了么门店数据
     * 
     * @param cateringPlatformElmShopData 饿了么门店数据
     * @return 结果
     */
    @Override
    public int insertCateringPlatformElmShopData(CateringPlatformElmShopData cateringPlatformElmShopData)
    {
        return cateringPlatformElmShopDataMapper.insertCateringPlatformElmShopData(cateringPlatformElmShopData);
    }

    /**
     * 修改饿了么门店数据
     * 
     * @param cateringPlatformElmShopData 饿了么门店数据
     * @return 结果
     */
    @Override
    public int updateCateringPlatformElmShopData(CateringPlatformElmShopData cateringPlatformElmShopData)
    {
        return cateringPlatformElmShopDataMapper.updateCateringPlatformElmShopData(cateringPlatformElmShopData);
    }

    /**
     * 批量删除饿了么门店数据
     * 
     * @param ids 需要删除的饿了么门店数据主键
     * @return 结果
     */
    @Override
    public int deleteCateringPlatformElmShopDataByIds(Long[] ids)
    {
        return cateringPlatformElmShopDataMapper.deleteCateringPlatformElmShopDataByIds(ids);
    }

    /**
     * 删除饿了么门店数据信息
     * 
     * @param id 饿了么门店数据主键
     * @return 结果
     */
    @Override
    public int deleteCateringPlatformElmShopDataById(Long id)
    {
        return cateringPlatformElmShopDataMapper.deleteCateringPlatformElmShopDataById(id);
    }

    @Override
    public String importPlatformElmShopData(List<CateringPlatformElmShopData> elmShopDataList, Boolean isUpdateSupport, String operName) {

        if (StringUtils.isNull(elmShopDataList) || elmShopDataList.size() == 0)
        {
            throw new ServiceException("导入数据不能为空！");
        }

        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (CateringPlatformElmShopData elmShopData : elmShopDataList)
        {
            try
            {
                CateringPlatformElmShopData esd = cateringPlatformElmShopDataMapper.selectElmShopDataByShopIDAndDate(elmShopData);
                if (StringUtils.isNull(esd))
                {
                    BeanValidators.validateWithException(validator, elmShopData);
                    /*esd.setCreateBy(operName);*/
                    this.insertCateringPlatformElmShopData(elmShopData);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、店铺 " + elmShopData.getDate().toString() + elmShopData.getShopName() + " 导入成功");
                } else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, elmShopData);
                    /*esd.setUpdateBy(operName);*/
                    this.updateCateringPlatformElmShopData(elmShopData);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、店铺 " + elmShopData.getDate().toString() + elmShopData.getShopName() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、店铺 " + elmShopData.getDate().toString() + elmShopData.getShopName() + " 已存在");
                }

            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、店铺 " + elmShopData.getDate().toString() + elmShopData.getShopName() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }

        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

}
