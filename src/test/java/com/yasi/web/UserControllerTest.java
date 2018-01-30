package com.yasi.web;

import com.common.util.CheckUtil;
import com.yasi.bo.UserBo;
import com.yasi.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by ziwang on 17/10/19.
 */
public class UserControllerTest {
    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(locations = {"classpath:spring-mvc.xml", "classpath:spring-mybatis.xml"})
    public static class testClass01 {

        @Autowired
        ApplicationContext applicationContext;

        @Test
        public void findUserByPojo() throws Exception {
            UserController userController = applicationContext.getBean(UserController.class);
            UserBo userBo = userController.getUserBo();
            List<User> list = userBo.findUserByPojo(null);
            for(int i = 0;i < list.size();i ++) {
                CheckUtil.Look(list.get(i));
            }
        }

        @Test
        public void findSessionByLogin() {
            UserController userController = applicationContext.getBean(UserController.class);
            userController.findSessionByLogin();
        }
    }
}
