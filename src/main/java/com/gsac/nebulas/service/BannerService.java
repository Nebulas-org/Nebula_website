package com.gsac.nebulas.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gsac.nebulas.model.Banner;
import com.gsac.nebulas.model.BannerExample;
import com.gsac.nebulas.utils.MessageResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 首页图片
 * @author YI
 * @date 2018-8-29 14:35:32
 */
public interface BannerService extends IService<Banner> {
    /**
     * 保存图片文件
     * @param file
     * @param picType
     * @param designer
     * @param type
     * @return
     */

    MessageResult savePicture(MultipartFile file,String picType,String designer,Integer type);


    /**
     * 根据条件获取数据
     * @param designer
     * @param type
     * @param pageIndex
     * @param pageSize
     * @return
     */
    MessageResult findPicture(Integer pageIndex,Integer pageSize,String designer,Integer type);
    /**
     * 根据条件修改数据
     * @param banner
     * @return
     */
    MessageResult updatePicture(Banner banner);

    /**
     * 保存banner图片地址
     * @param record
     * @return
     */
    Banner saveSelective(Banner record);

    /**
     * 按条件查询
     * @param example 条件
     * @return
     */
    List<Banner> selectByExampleWithBLOBs(BannerExample example);
}
