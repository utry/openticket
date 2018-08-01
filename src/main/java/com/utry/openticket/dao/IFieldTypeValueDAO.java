package com.utry.openticket.dao;

/**
 * @Description : 非文本框自定义列的选择值表DAO
 * @author : LVDING
 * @version : 1.0
 * @date : 2018/07/26
 */

import com.utry.openticket.model.FieldTypeValueDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IFieldTypeValueDAO {

    /**
     *
     * 功能描述 : 保存非文本框自定义属性的选择值并返回影响行数
     *
     * @param : List<FieldTypeValueDO> 非文本框自定义属性的选择值List
     * @return : int 影响行数
     * @auther : LVDING
     * @date : 2018-07-26
     */
    int saveFieldTypeValue(List<FieldTypeValueDO> fieldTypeValuelist);

    /**
     *
     * 功能描述 : 查询指定自定义列的选择值
     *
     * @param : fieldId 指定列id
     * @return : List<String> 选择值
     * @auther : LVDING
     * @date : 2018-07-31
     */
    List<String> getFieldTypeValue(int fieldId);

}
