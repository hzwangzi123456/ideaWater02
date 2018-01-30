package com.common.util;

import org.junit.Test;

/**
 * @author wangzi
 * @date 17/11/30 上午2:06.
 */
public class TestStringUtil {

    @Test
    public void TeststrAIsBiggerThanstrB(){
        boolean result = StringUtil.strAIsBiggerThanstrB("a","a");
        System.out.println(result);
    }

    @Test
    public void TeststrAIsSamllerThanstrB() {
        boolean result = StringUtil.strAIsSmallerThanstrB("b","c");
        System.out.println(result);
    }

}
