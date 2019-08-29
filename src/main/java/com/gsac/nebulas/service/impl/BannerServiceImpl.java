package com.gsac.nebulas.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gsac.nebulas.config.Constant;
import com.gsac.nebulas.controller.FileController;
import com.gsac.nebulas.dao.BannerMapper;
import com.gsac.nebulas.model.Banner;
import com.gsac.nebulas.model.BannerExample;
import com.gsac.nebulas.model.Sm;
import com.gsac.nebulas.service.BannerService;
import com.gsac.nebulas.utils.MessageResult;
import com.gsac.nebulas.utils.SmUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 网站首页
 *
 * @author wlm
 * @date 2019-8-29 14:36:27
 */
@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner>  implements BannerService {
    private static Logger logger = LoggerFactory.getLogger(FileController.class);
    @Resource
    BannerMapper bannerMapper;

    @Override
    public MessageResult savePicture(MultipartFile file, String picType, String designer, Integer type) {
        MessageResult messageResult = new MessageResult();
        Banner banner = new Banner();
        try {
            Sm sm = SmUtil.savePic(file, picType);
            if (sm.getCode().equals(Constant.SUCCESS)) {
                banner.setImgPath(sm.getPath());
                banner.setStatus(Constant.GenericNumber.NUMBER_ONE);
                banner.setCreateTime(LocalDateTime.now());
                banner.setType(type);
                if (picType.equals(Constant.DESIGNPIC)) {
                    banner.setNameRemark(designer);
                }
                this.saveSelective(banner);
                messageResult.setResult(sm.getPath());
                messageResult.setCount(Constant.GenericNumber.NUMBER_ONE);
            }
            messageResult.setCode(sm.getCode());
            messageResult.setMsg(sm.getMsg());
        } catch (Exception e) {
            logger.error(Constant.UPLOADFAILED, e);
            messageResult = MessageResult.errorMsg(Constant.UPLOADFAILED + e.getMessage());
        }
        return messageResult;
    }

    @Override
    public MessageResult findPicture(Integer pageIndex,Integer pageSize,String designer, Integer type) {
        MessageResult messageResult = MessageResult.ok();
        QueryWrapper<Banner> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Banner::getStatus, Constant.GenericNumber.NUMBER_ONE);
        if (type == Constant.GenericNumber.NUMBER_ZERO || type == Constant.GenericNumber.NUMBER_ONE) {
            queryWrapper.lambda().eq(Banner::getType, type);
            if (null != designer) {
                queryWrapper.lambda().eq(Banner::getNameRemark, designer);
            }
            queryWrapper.orderByDesc("create_time");
            IPage<Banner> iPage = this.page(new Page<>(pageIndex,pageSize),queryWrapper);
            messageResult.setCode(Constant.SUCCESS);
            if(iPage.getRecords().size()>0){
                messageResult.setCount(iPage.getRecords().size());
            }else{
                messageResult.setCount(0);
            }
            messageResult.setMsg("成功！");
            messageResult.setResult(iPage);
        }
        if (type == Constant.GenericNumber.NUMBER_TWO) {
            queryWrapper.lambda().eq(Banner::getType, type);
            if (null != designer) {
                queryWrapper.lambda().eq(Banner::getNameRemark, designer);
            }
            queryWrapper.orderByDesc("create_time");
            IPage<Banner> iPage = this.page(new Page<>(pageIndex,pageSize),queryWrapper);
            if (null == designer && iPage.getRecords().size() > 0) {
                Map<String, List<Banner>> collect = iPage.getRecords().stream().collect(Collectors.groupingBy(Banner::getNameRemark));
                messageResult.setMap(collect);
                messageResult.setResult(iPage);
                messageResult.setCount((int)iPage.getTotal());
            } else {
                messageResult.setResult(iPage);
            }
            messageResult.setCode(Constant.SUCCESS);
            messageResult.setMsg("成功！");
        }
        return messageResult;
    }

    @Override
    public MessageResult updatePicture(Banner banner) {
        MessageResult messageResult = MessageResult.ok();
        QueryWrapper<Banner> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Banner::getId, banner.getId());
        Banner one = this.getOne(queryWrapper);
        if (null == one) {
            messageResult = MessageResult.errorMsg("没有数据");
        } else {
            if (null != banner.getNameRemark() && !one.equals(banner.getNameRemark())) {
                one.setNameRemark(banner.getNameRemark());
            }
            if (null != banner.getStatus() && !one.getStatus().equals(banner.getStatus())) {
                one.setStatus(banner.getStatus());
            }
            messageResult.setResult(one);
            messageResult.setCode(Constant.SUCCESS);
            messageResult.setCount(Constant.GenericNumber.NUMBER_ONE);
            messageResult.setMsg("成功！");
        }
        return messageResult;
    }

    @Override
    public Banner saveSelective(Banner banner) {
        banner.setId(IdWorker.getId());
        this.baseMapper.insert(banner);
        return banner;
    }

    @Override
    public List<Banner> selectByExampleWithBLOBs(BannerExample example) {
        return bannerMapper.selectByExampleWithBLOBs(example);
    }
}
