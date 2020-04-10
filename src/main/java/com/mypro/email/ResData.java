package com.mypro.email;

/**
 * @author jayMamba
 * @date 2020/4/8
 * @time 9:29
 * @desc
 */
public class ResData {
    private int code;

    private String message;

    private Object data;

    public static ResData success(Object data) {
        ResData resData = new ResData();
        resData.setCode(200);
        resData.setMessage("success");
        resData.setData(data);
        return resData;
    }

    public static ResData failed(String message) {
        ResData resData = new ResData();
        resData.setCode(500);
        resData.setMessage(message);
        return resData;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
