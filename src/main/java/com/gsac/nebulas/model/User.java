package com.gsac.nebulas.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user")
@ApiModel(value="User对象", description="用户表")
public class User implements Serializable {

    @ApiModelProperty(value = "用户id")
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "头像path")
    private String avatar;

    @ApiModelProperty(value = "1 为有效 2 为禁用")
    private Integer status;

    @ApiModelProperty(value = "1 为管理员  2 为编辑")
    private Integer type;

    @ApiModelProperty(value = "电话号码")
    private Long mobile;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField( fill = FieldFill.INSERT)
    private LocalDateTime createTime;


}