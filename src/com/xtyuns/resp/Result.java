package com.xtyuns.resp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Result {
    private Integer code;
    private Object data;
    private String msg;

    private Result(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static Result success(Object data) {
        return new Result(200, data, "");
    }

    public static Result error(String msg) {
        return new Result(-1, null, msg);
    }

    public static Result error(Integer code, String msg) {
        return new Result(code, null, msg);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        ObjectMapper om = new ObjectMapper();
        Integer jCode = this.code;
        String jStr = "";
        String jMsg = this.msg;
        try {
            jStr = om.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            String error = e.toString();
            int split = error.indexOf(':');
            int begin = error.substring(0, split).lastIndexOf('.');
            jCode = 500;
            jStr = null;
            jMsg = error.substring(begin + 1);
        }
        if (jStr != null && jStr.startsWith("\""))
            // 如果 data 是字符串那么将中间的双引号转义为单引号
            jStr = jStr.replaceAll("(?<!^)\"(?!$)", "'");
        if (jMsg != null)
            // 将 msg 字符串中间的双引号转义为单引号
            jMsg = jMsg.replaceAll("\"", "'");
        return "{" +
                "\"code\": " + jCode +
                ", \"data\": " + jStr +
                ", \"msg\": \"" + jMsg + '"' +
                '}';
    }
}
