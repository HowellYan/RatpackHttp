package cn.com.ratpack.settings.Ratpack;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Created by Howell on 12/12/16.
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({StartRatpackConfiguration.class})
public @interface StartRatpack {

}
