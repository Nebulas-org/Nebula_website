package com.gsac.nebulas.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 
 */
@Data
public class UserVo implements Serializable {


    private String userToken;

    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 1 为管理员  2 为编辑
     */
    private Byte type;

    private String email;

    /**
     * 1 为有效 2 为禁用
     */
    private Byte status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


    @Override
    public String toString() {
        return "UserVo{" +
                "userToken='" + userToken + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}