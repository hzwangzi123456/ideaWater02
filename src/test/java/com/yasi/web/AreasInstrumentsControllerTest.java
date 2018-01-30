package com.yasi.web;

import com.common.util.CheckUtil;
import com.yasi.bo.AreasInstrumentsBo;
import com.yasi.vo.AreasInstruments;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author wangzi
 * @date 17/10/28 上午4:42.
 */
public class AreasInstrumentsControllerTest {
    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(locations = {"classpath:spring-mvc.xml", "classpath:spring-mybatis.xml"})
    public static class testClass01 {

        @Autowired
        ApplicationContext applicationContext;

        @Test
        public void test01() {
            AreasInstrumentsController areasInstrumentsController = applicationContext.getBean(AreasInstrumentsController.class);
            AreasInstrumentsBo areasInstrumentsBo = areasInstrumentsController.getAreasInstrumentsBo();
            AreasInstruments areasInstruments = new AreasInstruments();
            areasInstruments.setPrefix("B");
            List<AreasInstruments> arr = areasInstrumentsBo.findAreasInstrumentsByPojo(areasInstruments);
            for(int i = 0;i < arr.size();i ++) {
                CheckUtil.Look(arr.get(i));
            }
        }
    }
}
