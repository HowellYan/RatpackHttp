package cn.com.ratpack.dbModel;

import lombok.Data;
import lombok.ToString;

/**
 * Created by samland on 17/1/3.
 */
@Data
@ToString(callSuper = true)
public class T_info_user {
    private String id;
    private String name;
    private String tel;
    private String email;
    private String creat_at;
    private String update_at;
    private String pid;
    private String post;
    private long effect;
    private long type;
    private String password;
}
