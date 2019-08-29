package com.gsac.nebulas.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("contact")
@ApiModel(value="contact对象", description="公司联系表")
public class Contact implements Serializable {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "办公地址")
    private String address;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "qq账号")
    private String qq;

    @ApiModelProperty(value = "微信账号")
    private String wx;

    @ApiModelProperty(value = "版权所有者，公司名称")
    private String ownership;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

}