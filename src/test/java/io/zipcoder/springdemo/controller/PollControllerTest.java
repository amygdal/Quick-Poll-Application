package io.zipcoder.springdemo.controller;

import io.zipcoder.springdemo.services.PollService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.OverrideAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author leon on 4/2/18.
 */
@RunWith(SpringRunner.class)
@OverrideAutoConfiguration(enabled = true)
@WebMvcTest(PollController.class)
public class PollControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PollService pollService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.pollService = mock(PollService.class);Assert.assertNotNull(pollService);
    }


    @Test
    public void test() throws Exception {
        given(this.pollService.getPolls()).willReturn(null);
        mvc.perform(get("/polls").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().string("ok"));
        verify(pollService, times(1)).getPolls();
    }

}

