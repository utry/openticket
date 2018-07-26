package com.utry.openticket.dao;

/**
 * @Description : 自定义列的文本类型表DAO
 * @author : LVDING
 * @version : 1.0
 * @date : 2018/07/26
 */

import com.utry.openticket.model.FieldTypeDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IFieldTypeDAO {

    /**
     *
     * 功能描述 : 获得选择类型名称
     *
     * @param :
     * @return : List<FieldTypeDO> 选择类型List
     * @auther : LVDING
     * @date : 2018-07-26
     */
    List<FieldTypeDO> getFieldTypeList();

}
