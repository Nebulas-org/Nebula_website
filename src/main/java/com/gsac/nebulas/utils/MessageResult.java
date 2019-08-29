package com.gsac.nebulas.utils;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 统一返回数据格式
 * @author YI
 * @date 2018-8-22 11:25:56
 */
@Data
public class MessageResult<T> {
    private int code = 200;
    private String msg = "数据读取成功!";
    private int count;
    private T result;
    private Map<String, List<T>> map;

    public MessageResult() {
        super();
    }

    public MessageResult(int code, String msg, int count, T result) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.result = result;
    }

    public static MessageResult ok() {
        return new MessageResult();
    }

    public static MessageResult ok(Object result) {
        MessageResult rs = new MessageResult();
        rs.setResult(result);
        return rs;
    }

    public static MessageResult errorMsg(String msg) {
        return new MessageResult(-1, msg, 0, null);
    }

    public static MessageResult errorMap(Object data) {
        return new MessageResult(-1, "ERROR:出错啦，么么哒！！！", 0, data);
    }

    public static MessageResult errorTokenMsg(String msg) {
        return new MessageResult(-1, msg, 0, null);
    }


    @Override
    public String toString() {
        return "MessageResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + result +
                '}';
    }
}
