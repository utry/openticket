package com.utry.openticket.service;

/**
 * @Description : 自定义列的文本类型service
 * @author : LVDING
 * @version : 1.0
 * @date : 2018/07/26
 */

import com.utry.openticket.dao.IFieldTypeDAO;
import com.utry.openticket.model.FieldTypeDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FieldTypeService {

    @Autowired
    private IFieldTypeDAO fieldTypeDAO;

    /**
     *
     * 功能描述 : 获得选择类型名称
     *
     * @param :
     * @return : List<FieldTypeDO> 选择类型List
     * @auther : LVDING
     * @date : 2018-07-26
     */
    public List<FieldTypeDO> getFieldTypeList(){
        List<FieldTypeDO> list = fieldTypeDAO.getFieldTypeList();
        return list;
    }

}
