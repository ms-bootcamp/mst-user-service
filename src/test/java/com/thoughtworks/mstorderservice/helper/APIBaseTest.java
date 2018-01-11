package com.thoughtworks.mstorderservice.helper;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public abstract class APIBaseTest extends BaseTest {

    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @BeforeEach
    public void baseBefore() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
}
