package com.gsac.nebulas.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置扫描接口路径
 *
 * @author YI
 * @date 2018-8-22 18:19:45
 */
@Configuration
@MapperScan(basePackages = {"com.gsac.nebulas.dao"})
public class Constant {
    /**
     * redis key
     */
    public static final String USER_REDIS_SESSION = "user_redis_session";

    /**
     * sm图床上传地址
     */
    public static final String SM_URL = "https://sm.ms/api/upload";

    /**
     * redis token超时时间（ms）
     */
    public static final int REDIS_TIMEOUT = 1000 * 60 * 30;
    /**
     * win路径
     */
    public static final String WINPATH = "d:\\picture";

    /**
     * win路径分隔符
     */
    public static final String WINLEVEL = "\\";
    /**
     * linux路径
     */
    public static final String LINUXPATH = "/picture";

    /**
     * linux路径分隔符
     */
    public static final String LINUXLEVEL = "/";
    /**
     * 成功
     */
    public static final int SUCCESS = 200;
    /**
     * 失败
     */
    public static final int FAILED = 400;
    /**
     * 上传成功
     */
    public static final String SUCCESSUPLOAD = "上传成功!";
    /**
     * 上传成功
     */
    public static final String UPLOADFAILED = "上传失败!";
    /**
     * 文件已存在
     */
    public static final String FILEREADY= "文件已存在!";
    /**
     * 图片类型:新闻
     */
    public static final String NEWPIC = "NEWPIC";
    /**
     * 图片类型:作品
     */
    public static final String DESIGNPIC = "DESIGNPIC";

    /**
     * 图片类型:banner
     */
    public static final String BANNER = "BANNER";

    /**
     * 图片类型:广告
     */
    public static final String ADPIC = "ADPIC";
    /**
     * windows
     * 系統表示
     */
    public static final String WINDOWS = "win";

    /**
     * 通用数字
     */
    public static class GenericNumber {
        public static final int NUMBER_ZERO = 0;
        public static final int NUMBER_ONE = 1;
        public static final int NUMBER_TWO = 2;
        public static final int NUMBER_THREE = 3;
        public static final int NUMBER_FOUR = 4;
        public static final int NUMBER_FIVE = 5;
        public static final int NUMBER_SIX = 6;
        public static final int NUMBER_SEVEN = 7;
        public static final int NUMBER_EIGHT = 8;
        public static final int NUMBER_NINE = 9;
        public static final int NUMBER_TEN = 10;
        public static final int NUMBER_TWENTY = 20;
        public static final int NUMBER_THIRTY = 30;
        public static final int NUMBER_TWO_HUNDRED = 200;
        public static final int NUMBER_TWO_HUNDRED_AND_ONE = 201;
        public static final int NUMBER_FOUR_HUNDRED_AND_THREE = 403;
    }
}
