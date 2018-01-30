package com.yasi.web;

import com.yasi.bo.YascmfTcplogsBo;
import com.yasi.vo.YascmfTcplogs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

/**
 * Created by ziwang on 17/10/16.
 */

public class YascmfTcplogsControllerTest {

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(locations = {"classpath:spring-mvc.xml", "classpath:spring-mybatis.xml"})
    public static class testClass01 {

        @Autowired
        private ApplicationContext context;

        @Test
        public void test01() {
            YascmfTcplogsController yascmfTcplogsController = context.getBean(YascmfTcplogsController.class);
            YascmfTcplogsBo yascmfTcplogsBo = yascmfTcplogsController.getYascmfTcplogsBo();
            List<YascmfTcplogs> list = yascmfTcplogsBo.findYascmfTcplogsByPojo(null);
            for(int i = 0;i < list.size();i ++) {
                int n = list.get(i).getState();
                if(n == 0) {
                    System.out.println(list.get(i).getLog());
                }
            }
        }

        @Test
        public void test02() {
            Integer i = Integer.valueOf(1);
            Integer j = Integer.valueOf(2);
            if(i.equals(j)) {
                System.out.println("相同");
            }
            else {
                System.out.println("不相同");
            }
        }

        @Test
        public void test03() {
            System.out.println(100 * 365);
        }
    }
}
