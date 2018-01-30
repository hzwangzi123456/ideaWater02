package com.yasi.web;

import com.yasi.bo.impl.YascmfDatasBoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ziwang on 17/10/14.
 */

public class YascmfDatasControllerTest {

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(locations = {"classpath:spring-mvc.xml", "classpath:spring-mybatis.xml"})
    public static class testClass01 {

        @Autowired
        ApplicationContext applicationContext;

        @Test
        public void TestfindYascmfDatasByPojo() throws Exception {
//            YascmfDatasController yascmfDatasController = applicationContext.getBean(YascmfDatasController.class);
//            YascmfDatasBo yascmfDatasBo = yascmfDatasController.getYascmfDatasBo();
//            List<YascmfDatas> list = yascmfDatasBo.findYascmfDatasByTime("D01","2017-04-19 00:00:00","2017-04-27 23:59:59");
//            for(int i = 0;i < list.size();i ++) {
//                CheckUtil.Look(list.get(i));
//            }

            YascmfDatasBoImpl yascmfDatasBo = applicationContext.getBean(YascmfDatasBoImpl.class);
        }
    }
}
