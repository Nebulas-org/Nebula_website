package com.gsac.nebulas.model;

import lombok.Builder;

import java.time.LocalDateTime;

/**
 * 图床
 * @author YI
 * @date 2019-1-11 09:26:29
 */
@lombok.Data
@Builder
public class Sm {

    private Integer code;
    private LocalDateTime data;
    private String msg;
    private String path;
}