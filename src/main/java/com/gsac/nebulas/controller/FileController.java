package com.gsac.nebulas.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gsac.nebulas.aop.Log;
import com.gsac.nebulas.config.Constant;
import com.gsac.nebulas.model.Banner;
import com.gsac.nebulas.service.BannerService;
import com.gsac.nebulas.utils.MessageResult;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * FastDFS文件系统操作(现已改为图床)
 *
 * @author YI
 * @date 2018-8-7 10:37:27
 */
@Api(description = "图片文件上传")
@RestController
@RequestMapping("/file")
public class FileController {


    @Autowired
    BannerService bannerService;

    /**
     * @param file 文件
     * @return
     */
    @ApiOperation(value = "图片文件上传")
    @Log(action = "uploadFile", modelName = "FileController", description = "图片文件上传")
    @PostMapping("/uploadFile")
    public MessageResult uploadFile(@RequestParam("file") MultipartFile file,
                                    @ApiParam(value = "图片分类类型为：BANNER，DESIGNPIC（作品图片，必须标记作品人），NEWPIC（新闻图片），ADPIC（广告图片）") @RequestParam(value = "图片类型") String picType,
                                    @ApiParam(value = "设计者标记（名称）") @RequestParam(value = "designer", required = false) String designer,
                                    @ApiParam(value = "注意图片文件分类必传！0:banner,1:单个作品，2：作品集") @RequestParam(value = "type") Integer type) {
        MessageResult messageResult = new MessageResult();
        if (file.isEmpty()) {
            return MessageResult.errorMsg("请选择要上传的文件！");
        }
        if (null == type) {
            return MessageResult.errorMsg("请选择要上传的文件分类！");
        }
        if (null != picType) {
            if (!picType.equals(Constant.DESIGNPIC) || !picType.equals(Constant.ADPIC) || !picType.equals(Constant.NEWPIC) || !picType.equals(Constant.BANNER)) {
                messageResult.setCount(Constant.GenericNumber.NUMBER_ZERO);
                messageResult.setCode(Constant.FAILED);
                messageResult.setMsg("上传的图片分类类型不正确");
                return messageResult;
            }
        } else {
            messageResult.setCount(Constant.GenericNumber.NUMBER_ZERO);
            messageResult.setCode(Constant.FAILED);
            messageResult.setMsg("上传的文件类别不能为空");
            return messageResult;
        }
        return bannerService.savePicture(file, picType, designer, type);
    }

    @ApiOperation(value = "图片文件分页获取上线状态的数据")
    @Log(action = "getAllFileByPage", modelName = "FileController", description = "图片文件分页获取")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex",value = "第几页",dataType = "int",paramType = "query"),
            @ApiImplicitParam(name = "pageSize",value = "每页几条数据",dataType = "int",paramType = "query")
    })
    @GetMapping("/getAllFileByPage ")
    public MessageResult getAllFileByPage(@RequestParam(name ="pageIndex" ,defaultValue = "1",required = false) Integer pageIndex,
                                          @RequestParam(name ="pageSize" ,defaultValue = "10",required = false) Integer pageSize,
                                          @ApiParam(value = "设计者标记（名称）") @RequestParam(value = "designer", required = false) String designer,
                                 @ApiParam(value = "注意图片文件分类必传！0:banner,1:单个作品，2：作品集") @RequestParam(value = "type") Integer type) {
        return bannerService.findPicture(pageIndex,pageSize,designer, type);
    }

    @ApiOperation(value = "修改图片文件")
    @Log(action = "updateFile", modelName = "FileController", description = "修改图片文件")
    @PostMapping("/updateFile ")
    public MessageResult updateFile(@ApiParam(value = "id必传，只修改nameRemark与status")@RequestBody Banner banner) {
        return bannerService.updatePicture(banner);
    }

    @ApiOperation(value = "删除图片文件（以集合形式，单个也放集合里面传参）")
    @Log(action = "deleteFile", modelName = "FileController", description = "删除图片文件")
    @PostMapping("/deleteFile ")
    public MessageResult deleteFile(@ApiParam(value = "id必传,按list传参")@RequestParam List<Long> ids) {
        MessageResult messageResult = MessageResult.ok();
        boolean b = bannerService.removeByIds(ids);
        if(b){
            messageResult.setMsg("删除成功");
            messageResult.setCount(ids.size());
            messageResult.setCode(Constant.SUCCESS);
        }else{
            messageResult = MessageResult.errorMsg("删除失败");
        }
        return messageResult;
    }


    @ApiOperation(value = "分页获取所有状态图片信息")
    @Log(action = "getAllFileByPage", modelName = "FileController", description = "获取所有图片信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex",value = "第几页",dataType = "int",paramType = "query"),
            @ApiImplicitParam(name = "pageSize",value = "每页几条数据",dataType = "int",paramType = "query")
    })
    @GetMapping("/getAllFileByPages ")
    public MessageResult getAllFilesByPage(@RequestParam(name ="pageIndex" ,defaultValue = "1",required = false) Integer pageIndex,
                                          @RequestParam(name ="pageSize" ,defaultValue = "10",required = false) Integer pageSize){
        MessageResult messageResult = MessageResult.ok();
        QueryWrapper<Banner> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time");
        IPage<Banner> iPage = bannerService.page(new Page<>(pageIndex,pageSize),queryWrapper);
        messageResult.setResult(iPage);
        return messageResult;
    }

    @ApiOperation(value = "获取单个图片信息")
    @Log(action = "getOneFile", modelName = "FileController", description = "获取单个图片信息")
    @GetMapping("/getOneFile ")
    public MessageResult getOneFile(@RequestParam("id") Long id){
        MessageResult messageResult = MessageResult.ok();
        Banner banner = bannerService.getById(id);
        if(null == banner){
            messageResult = MessageResult.errorMsg("没有数据");
        }else{
            messageResult.setResult(banner);
        }
        return messageResult;
    }
}
