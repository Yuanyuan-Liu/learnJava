package com.licf.demo.service;

import com.licf.demo.model.request.BlackRequest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlackServiceTest {
    @Autowired
    private BlackService blackService;

    @Test
    public void list() {
        BlackRequest[] blackRequests = {new BlackRequest()};
        blackRequests[0].setUniqueId("111");
        blackRequests[0].setAppId("222");
        blackRequests[0].setIp("333");
        List<Map<String,Object>> list = (List<Map<String,Object>>)blackService.list(blackRequests);
        Assert.assertThat(list.size(), is(1));
    }
}