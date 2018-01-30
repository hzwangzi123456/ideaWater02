package com.yasi.web;

import com.common.util.CheckUtil;
import com.yasi.bo.AreasInstrumentsBo;
import com.yasi.bo.AuthorityAreasBo;
import com.yasi.vo.AreasInstruments;
import com.yasi.vo.AuthorityAreas;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author wangzi
 * @date 17/10/28 下午3:22.
 */
public class AuthorityAreasControllerTest {
    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(locations = {"classpath:spring-mvc.xml", "classpath:spring-mybatis.xml"})
    public static class testClass01 {

        @Autowired
        ApplicationContext applicationContext;

        @Test
        public void test01() {
            AuthorityAreasController authorityAreasController = applicationContext.getBean(AuthorityAreasController.class);
            AuthorityAreasBo authorityAreasBo = authorityAreasController.getAuthorityAreasBo();
            AuthorityAreas authorityAreas = new AuthorityAreas();
            authorityAreas.setUsername("admin");
            List<AuthorityAreas> arr = authorityAreasBo.findAuthorityAreasByPojo(authorityAreas);
//            for(int i = 0;i < arr.size();i ++) {
//                CheckUtil.Look(arr.get(i));
//            }

            AreasInstrumentsController areasInstrumentsController = applicationContext.getBean(AreasInstrumentsController.class);
            AreasInstrumentsBo areasInstrumentsBo = areasInstrumentsController.getAreasInstrumentsBo();
            for(int i = 0;i < arr.size();i ++) {
                AreasInstruments areasInstruments = new AreasInstruments();
                areasInstruments.setPrefix(arr.get(i).getPrefix());
                List<AreasInstruments> arr02 = areasInstrumentsBo.findAreasInstrumentsByPojo(areasInstruments);
                for(int j = 0;j < arr02.size();j ++) {
                    CheckUtil.Look(arr02.get(j));
                }
            }
        }
    }
}
