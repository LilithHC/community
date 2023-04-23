package com.coder.community;

import com.coder.community.util.SensitiveFilter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = CommunityApplication.class)
@SpringBootTest
public class SensitiveTests {
    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Test
    public void testSensitiveFilter(){
        String text="赌";
        text = sensitiveFilter.fileter(text);
        System.out.println(text);
    }
}
