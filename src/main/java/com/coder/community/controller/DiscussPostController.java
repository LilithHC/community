package com.coder.community.controller;

import com.coder.community.entity.DiscussPost;
import com.coder.community.entity.User;
import com.coder.community.service.DiscussPostService;
import com.coder.community.service.UserService;
import com.coder.community.util.CommunityUtil;
import com.coder.community.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/discuss")
public class DiscussPostController {
    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @Autowired
    private HostHolder hostHolder;

    @RequestMapping(path="/add", method = RequestMethod.POST)
    @ResponseBody
    public String addDiscussPost(String title, String content){
        User user = hostHolder.getUser();
        if(user == null){
            return CommunityUtil.getJSONString(403, "你还没有登录！");
        }

        System.out.println(user.getId());
        DiscussPost post = new DiscussPost();
        post.setUserId(user.getId());
        System.out.println(post.getUserId());
        post.setTitle(title);
        System.out.println(post.getTitle());
        post.setContent(content);
        System.out.println(post.getContent());
        post.setCreateTime(new Date());
        discussPostService.addDiscussPost(post);

        //报错的情况，将来统一处理
        return CommunityUtil.getJSONString(0,"发布成功！");
    }

    @RequestMapping(path = "/detail/{discussPostId}", method = RequestMethod.GET)
    public String getDiscussPost(@PathVariable("discussPostId") int discussPostId, Model model){
        //帖子
        DiscussPost post = discussPostService.findDiscussPostById(discussPostId);
        model.addAttribute("post", post);
        //作者
        User user = userService.findUserById(post.getUserId());
        model.addAttribute("user",user);

        return "/site/discuss-detail";
    }

}
