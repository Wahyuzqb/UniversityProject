package com.pojo;

import java.util.List;

public class MyJson {
    private Integer code = 0;
    private String msg = "";
    private Integer count = 1000;
    private List<Transfers> data;

    @Override
    public String toString() {
        return "{" +
                "'code':'" + code +
                "', 'msg':'" + msg +
                "', 'count':'" + count +
                "', 'data':'" + data +
                "'}";
    }

    public MyJson() {
    }

    public MyJson(Integer code, String msg, Integer count, List<Transfers> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Transfers> getData() {
        return data;
    }

    public void setData(List<Transfers> data) {
        this.data = data;
    }
}
