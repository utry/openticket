package com.utry.openticket.service;

import com.utry.openticket.dao.IFieldTypeValueDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : LVDING
 * @version : 1.0
 * @Description : 非文本框自定义列的选择值service
 * @date : 2018-07-31
 */

@Service
public class FieldTypeValueService {

    @Autowired
    private IFieldTypeValueDAO fieldTypeValueDAO;

    /**
     *
     * 功能描述 : 查询指定自定义列的选择值
     *
     * @param : fieldId 指定列id
     * @return : List<String> 选择值
     * @auther : LVDING
     * @date : 2018-07-31
     */
    public List<String>  getFieldTypeValue(int fieldId){
        return fieldTypeValueDAO.getFieldTypeValue(fieldId);
    }
}
