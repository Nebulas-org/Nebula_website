package com.gsac.nebulas.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleWithBLOBs extends Article implements Serializable {

    @ApiModelProperty(value = "文章")
    @Size(min = 10,max = 4000,message ="文章最小10字，最多4000字")
    @NotBlank(message = "内容不能为空")
    private String news_content;

    @ApiModelProperty(value = "文章图片视频url")
    private String pathImage;

}