package com.gsac.nebulas.dao;

import com.gsac.nebulas.model.Presentation;
import com.gsac.nebulas.model.PresentationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PresentationMapper {
    long countByExample(PresentationExample example);

    int deleteByExample(PresentationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Presentation record);

    int insertSelective(Presentation record);

    List<Presentation> selectByExampleWithBLOBs(PresentationExample example);

    List<Presentation> selectByExample(PresentationExample example);

    Presentation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Presentation record, @Param("example") PresentationExample example);

    int updateByExampleWithBLOBs(@Param("record") Presentation record, @Param("example") PresentationExample example);

    int updateByExample(@Param("record") Presentation record, @Param("example") PresentationExample example);

    int updateByPrimaryKeySelective(Presentation record);

    int updateByPrimaryKeyWithBLOBs(Presentation record);

    int updateByPrimaryKey(Presentation record);
}