package com.songhee.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestApiControllerTest {

  @Autowired
  private TestApiController testApiController;

  private MockMvc mockMvc;

  @Test
  public void mockMvcTest_searchBlog() throws Exception {

    mockMvc = MockMvcBuilders.standaloneSetup(testApiController).build();
    mockMvc.perform(
        MockMvcRequestBuilders.get("/v1/test/search/blog").param("query", "5")
    ).andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  public void mockMvcTest_searchLast10() throws Exception {

    mockMvc = MockMvcBuilders.standaloneSetup(testApiController).build();
    mockMvc.perform(
        MockMvcRequestBuilders.get("/v1/test/search/last-10")
    ).andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk());
  }

}
