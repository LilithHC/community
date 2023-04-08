package com.coder.community;

import com.coder.community.dao.DiscussPostMapper;
import com.coder.community.dao.UserMapper;
import com.coder.community.entity.DiscussPost;
import com.coder.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;

@ContextConfiguration(classes = CommunityApplication.class)
@SpringBootTest
public class MapperTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;

//    @Test
//    public void testSelectUser(){
//        User user = userMapper.selectById(101);
//        System.out.println(user);
//
//        user = userMapper.selectByName("liubei");
//        System.out.println(user);
//
//        user = userMapper.selectByEmail("nowcoder101@sina.com");
//        System.out.println(user);
//    }

//    @Test
//    public void testInsertUser(){
//        User user = new User();
//        user.setUsername("test");
//        user.setPassword("23456");
//        user.setSalt("abc");
//        user.setEmail("bb@13.com");
//        user.setHeaderUrl("http://www.nowcoder.com/101.png");
//        user.setCreateTime(new Date());
//
//        int rows = userMapper.insertUser(user);
//        System.out.println(rows);
//        System.out.println(user.getId());
//    }

    @Test
    public void testDiscussPost(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(101,0,2);
        for(DiscussPost post:list){
            System.out.println(post);
        }
       int rows = discussPostMapper.selectDiscussPostRows(101);
        System.out.println(rows);
    }
}
