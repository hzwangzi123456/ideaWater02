package com.yasi.bo.impl;

import com.yasi.bo.EmployeeBo;
import com.yasi.po.Employee;
import com.yasi.vo.EmployeeRecord;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author wangzi
 * @date 18/1/3 下午5:10.
 */
public class EmployeeBoImplTest {

    private ApplicationContext classPathXmlApplicationContext;

    @Before
    public void init(){
        String[] strings = {"classpath:spring-mvc.xml", "classpath:spring-mybatis.xml"};
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext(strings);
    }

    @Test
    public void test03() {
        EmployeeBo bean =  classPathXmlApplicationContext.getBean(EmployeeBo.class);
        List<Employee> employeeList = bean.findEmployeeByPojo(null);
        System.out.println(employeeList);
    }

    @Test
    public void testfindEmployeeRecordByVo() {
        EmployeeBo bean =  classPathXmlApplicationContext.getBean(EmployeeBo.class);
        List<EmployeeRecord> employeeRecordList = bean.findEmployeeRecordByVo(null);
        System.out.println(employeeRecordList);
    }

    @Test
    public void testinsertEmployeeRecordByVo() {

    }
}
