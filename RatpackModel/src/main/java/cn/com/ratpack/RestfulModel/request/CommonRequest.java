package cn.com.ratpack.RestfulModel.request;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@ToString(callSuper = true)
public class CommonRequest implements Serializable {
    private static final long serialVersionUID = -449603975016674678L;
    /**
     * 发起流水号
     */
    @NotNull(message = "keep值不能为空")
    private String keep;
}
