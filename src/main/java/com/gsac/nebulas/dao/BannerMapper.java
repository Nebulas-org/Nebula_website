package com.gsac.nebulas.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gsac.nebulas.model.Banner;
import com.gsac.nebulas.model.BannerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BannerMapper  extends BaseMapper<Banner> {
    long countByExample(BannerExample example);

    int deleteByExample(BannerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Banner record);

    int insertSelective(Banner record);

    List<Banner> selectByExampleWithBLOBs(BannerExample example);

    List<Banner> selectByExample(BannerExample example);

    Banner selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Banner record, @Param("example") BannerExample example);

    int updateByExampleWithBLOBs(@Param("record") Banner record, @Param("example") BannerExample example);

    int updateByExample(@Param("record") Banner record, @Param("example") BannerExample example);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKeyWithBLOBs(Banner record);

    int updateByPrimaryKey(Banner record);
}