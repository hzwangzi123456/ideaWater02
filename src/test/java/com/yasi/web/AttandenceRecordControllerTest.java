package com.yasi.web;

import com.common.util.CheckUtil;
import com.common.util.DateUtil;
import com.yasi.bo.AttandenceRecordBo;
import com.yasi.vo.AttandenceRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * @author wangzi
 * @date 17/12/30 上午2:24.
 */
public class AttandenceRecordControllerTest {

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(locations = {"classpath:spring-mvc.xml", "classpath:spring-mybatis.xml"})
    public static class testClass01 {

        @Autowired
        ApplicationContext applicationContext;

        @Test
        public void test01() {
            AttandenceRecordController attandenceRecordController = applicationContext.getBean(AttandenceRecordController.class);
            AttandenceRecordBo attandenceRecordBo = attandenceRecordController.getAttandenceRecordBo();
            AttandenceRecord attandenceRecord = new AttandenceRecord();
            attandenceRecord.setWorkNumber("1");
            List<AttandenceRecord> attandenceRecordList = attandenceRecordBo.findAttandenceRecordByPojo(attandenceRecord);
            System.out.println("--------------------------------------------------------");
            for (AttandenceRecord attandenceRecord1 : attandenceRecordList) {
                CheckUtil.Look(attandenceRecord1);
            }
            attandenceRecordController.findAttandenceRecordByPojo();
        }

        @Test
        public void insertAttandenceRecordByPojoTest() {
            AttandenceRecordController attandenceRecordController = applicationContext.getBean(AttandenceRecordController.class);
            AttandenceRecordBo attandenceRecordBo = attandenceRecordController.getAttandenceRecordBo();
            String dateStr = "2017-09-01";
            for (int i = 0; i < 200; i++) {
                dateStr = DateUtil.getDateStringFromStrDayAdd(DateUtil.y_m_dFormat, dateStr, 1);
                System.out.println(dateStr);
                Date date = DateUtil.getDateFromStr(DateUtil.y_m_dFormat, dateStr);
                String week = DateUtil.weekFormat.format(date).substring(2);
                System.out.println(week);

                AttandenceRecord attandenceRecord = new AttandenceRecord();
                attandenceRecord.setWorkNumber("3");
                if (week.equals("日") || week.equals("六")) {
                    attandenceRecord.setState(3);
                } else {
                    attandenceRecord.setState(1);
                }
                attandenceRecord.setDate(dateStr);
                attandenceRecord.setDay(week);
                String time = "";
                String hour = (int) (Math.random() * 23) + "";
                if (hour.length() == 1) {
                    hour = "0" + hour;
                }
                String minute = (int) (Math.random() * 59) + "";
                if (minute.length() == 1) {
                    minute = "0" + minute;
                }
                String second = (int) (Math.random() * 59) + "";
                if (second.length() == 1) {
                    second = "0" + second;
                }
                time += hour + ":" + minute + ":" + second;
                attandenceRecord.setTime(time);

                //根据毫秒数的来取缺勤天
                long temp = new Date().getTime();
                //如果被8整除作为缺勤
                if(temp % 8 == 0 && week.equals("日") == false && week.equals("六") == false) {
                    attandenceRecord.setState(2);
                    attandenceRecord.setTime(null);
                }
                attandenceRecordBo.insertAttandenceRecord(attandenceRecord);
            }
        }


    }
}
