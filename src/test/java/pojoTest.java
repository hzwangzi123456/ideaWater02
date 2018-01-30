import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangzi
 * @date 17/12/30 下午2:06.
 */
public class pojoTest {

    @Test
    public void test01() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String week = sdf.format(new Date());
        System.out.println(week);
        System.out.println(week.length());
        System.out.println("a");
        System.out.println("\r\n");
        System.out.println("a");
    }

    @Test
    public void test02() {
        System.out.println(new Date().getTime());
    }
}
