package com.examples.crazy.simpleboard.controller;

import com.examples.crazy.simpleboard.service.BoardService;
import com.examples.crazy.simpleboard.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BoardController.class)
public class BoardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // `MainController`가 의존하고 있는 `Service`를 `Mock`으로 설정
    @MockBean
    private BoardService boardService;
    @MockBean
    private CategoryService categoryService;
    @MockBean
    private EnableJpaAuditing enableJpaAuditing;
    @MockBean
    private JpaMetamodelMappingContext jpaMetamodelMappingContext;

    @Test
    public void boardList() throws Exception {
        mockMvc.perform(get("/boards"))
                .andDo(print())
                .andExpect(status().isOk());
    }

//    @Test
//    public void boardDetail() throws
}