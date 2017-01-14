package cn.com.ratpack.dbModel;

import lombok.Data;
import lombok.ToString;

/**
 * Created by Howell on 13/12/16.
 */
@Data
@ToString(callSuper = true)
public class UserModel {
    String u_id;
    String u_name;
    String u_pass;
    String u_phone;
}
