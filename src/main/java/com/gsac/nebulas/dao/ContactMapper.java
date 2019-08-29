package com.gsac.nebulas.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gsac.nebulas.model.Contact;
import com.gsac.nebulas.model.ContactExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContactMapper extends BaseMapper<Contact> {
    long countByExample(ContactExample example);

    int deleteByExample(ContactExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Contact record);

    int insertSelective(Contact record);

    List<Contact> selectByExample(ContactExample example);

    Contact selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Contact record, @Param("example") ContactExample example);

    int updateByExample(@Param("record") Contact record, @Param("example") ContactExample example);

    int updateByPrimaryKeySelective(Contact record);

    int updateByPrimaryKey(Contact record);
}