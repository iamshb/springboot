package com.s2.springboot.controller;

import com.s2.springboot.service.AsyncService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest
public class AsyncControllerTest {
    private MockMvc mvc;

    @InjectMocks
    AsyncController controller;

    @Mock
    private AsyncService asyncService;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders
                .standaloneSetup(controller)
//                .addInterceptors()
//                .setControllerAdvice()
//                .addFilters()
                .build();
    }

    @Test
    public void callable() throws Exception {
        mvc.perform(get("/async/callable"))
//            .accept(MediaType.APPLICATION_JSON))
            .andDo((s) -> {
//                System.out.println("# response: " + s.getAsyncResult());
                assertTrue(s.getResponse().getStatus() == HttpStatus.OK.value());
                assertTrue(s.getAsyncResult().equals("hello callable."));
            });
    }

    @Test
    public void deferred() throws Exception {
        given(asyncService.simpleLFAsync()).willReturn(new AsyncResult<>("deferred"));

        MockHttpServletResponse response = mvc.perform(get("/async/deferred")).andDo(r -> {
            assertTrue(r.getAsyncResult().equals("deferred"));
        }).andReturn().getResponse();
    }

    @Test
    public void sync() throws Exception {
        MockHttpServletResponse response = mvc.perform(get("/async/sync")).andReturn().getResponse();

        assertTrue(response.getStatus() == HttpStatus.OK.value());
        assertTrue(response.getContentAsString().equals("sync"));

    }
}