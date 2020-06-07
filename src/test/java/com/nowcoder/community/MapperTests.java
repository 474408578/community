package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.LoginTicketMapper;
import com.nowcoder.community.dao.MessageMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.LoginTicket;
import com.nowcoder.community.entity.Message;
import com.nowcoder.community.entity.User;
import com.nowcoder.community.service.DiscussPostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private LoginTicketMapper loginTicketMapper;

    @Autowired
    private MessageMapper messageMapper;

    @Test
    public void testSelectUser() {
        User user = userMapper.selectById(1);
        System.out.println(user);

        user = userMapper.selectByName("liubei");
        System.out.println(user);

        user = userMapper.selectByEmail("1638392300@qq.com");
        System.out.println(user);
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void updateUser() {
        int rows = userMapper.updateStatus(2, 1);
        System.out.println(rows);

        rows = userMapper.updateHeader(150, "http://www.nowcoder.com/102.png");
        System.out.println(rows);

        rows = userMapper.updatePassword(150, "hello");
        System.out.println(rows);
    }

    @Test
    public void testSelectPosts() {
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(1, 0, 10);
        for (DiscussPost discussPost : list) {
            System.out.println(discussPost);
        }

        int rows = discussPostMapper.selectDiscussPostRows(1);
        System.out.println(rows);
    }

    @Test
    public void testLoginTicket() {
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(10);
        loginTicket.setTicket("abc");
        loginTicket.setStatus(0);
        // 10分钟到期
        loginTicket.setExpired(new Date(System.currentTimeMillis() + 1000 * 60 *10));
        loginTicketMapper.insertLoginTicket(loginTicket);
    }

    @Test
    public void testSelectLoginTicket() {
        LoginTicket loginTicket = loginTicketMapper.selectByTicket("abc");
        System.out.println(loginTicket);

        loginTicketMapper.updateStatus("abc", 1);
        loginTicket = loginTicketMapper.selectByTicket("abc");
        System.out.println(loginTicket);
    }

    @Test
    public void testInsertDiscussPost() {
        DiscussPost discussPost = new DiscussPost();
        discussPost.setUserId(15);
        discussPost.setTitle("我的Linux学习之路");
        discussPost.setContent("Linux基础学习");
        discussPost.setCommentCount(0);
        discussPost.setCreateTime(new Date(System.currentTimeMillis()));
        discussPost.setStatus(0);
        discussPost.setType(0);

        discussPostMapper.insertDiscussPost(discussPost);

    }

    @Test
    public void testSelectDiscussPostById() {
        DiscussPost discussPost = discussPostMapper.selectDiscussPostById(10);
        System.out.println(discussPost);
    }

    @Test
    public void testSelectLetters() {
        List<Message> list = messageMapper.selectConversations(9, 0, 2);
        System.out.println("对话：");
        for (Message message : list) {
            System.out.println(message);
        }

        int count = messageMapper.selectConversationCount(9);
        System.out.println("总对话数量：" + count);

        list = messageMapper.selectLetters("9_15", 0, 2);
        System.out.println("conversation私信：");
        for (Message message : list) {
            System.out.println(message);
        }

        count = messageMapper.selectLetterCount("9_15");
        System.out.println("conversation私信总数：" + count);

        count = messageMapper.selectLetterUnreadCount(9, "9_15");
        System.out.println("userId、conversationId未读消息数" + count);

    }

}
