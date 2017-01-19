package cn.com.ratpack.controller;


import cn.com.ratpack.config.SetupConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by Howell on 15/12/16.
 */
@Slf4j
public class LoginControllerTest extends SetupConfig {
    private MockMvc mockMvc;

    @Override
    public void init() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup().build();
    }

    /**
     * mockMvc 模拟请求Controller
     * @throws Exception
     */
    @Test
    public void loginController() throws Exception {
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<String, String>();
        multiValueMap.add("username", "15270878808");
        multiValueMap.add("loginpwd", "123");

        mockMvc.perform(
                post("/api/login")
                        .params(multiValueMap)
        ).andExpect(status().isOk()).andDo(print()).andReturn(); //执行请求

    }



}
