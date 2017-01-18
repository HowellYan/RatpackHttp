package cn.com.ratpack.RestfulModel.util;

/**
 * Created by Howell on 18/1/17.
 */

public enum CommonCode {
    Logout_msg("999999", "请重新登陆！"),
    UserWrong_msg("999996", "用户不存在！"),
    LoginWrong_msg("999995", "用户、密码不匹配！"),
    ContentType_msg("999998", "Please modify requested that ContentType is 'application/json' type！"),
    Configuration_msg("999997", "Restful Configuration Have Wrong！！"),
    Success_msg("000000", "Success");

    private String code;
    private String msg;

    CommonCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
