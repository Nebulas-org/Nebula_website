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
@TableName("banner")
@ApiModel(value="Banner对象", description="Banner表")
public class Banner implements Serializable {

    @ApiModelProperty(value = "banner id")
    private Long id;

    @ApiModelProperty(value = "0 下线，1 上线")
    private Integer status;

    @ApiModelProperty(value ="图片url")
    private String imgPath;

    @ApiModelProperty(value ="0:banner,1:单个作品，2：作品集")
    private Integer type;

    @ApiModelProperty(value = "banner为0；其他标记作品,用设计者的名字或代号作为标记")
    private String nameRemark;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField( fill = FieldFill.INSERT)
    private LocalDateTime createTime;




}