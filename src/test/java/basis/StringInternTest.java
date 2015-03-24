package basis;

import org.junit.Test;

/**
 * Created by Hank on 2015/3/23.
 *
 * 基于jdk8测试
 *
 * java7之前String常量放在持久带，java7及以后版本String常量放在
 */
public class StringInternTest {
    @Test
    public void testInternFunc(){
        String s1 = "Hello,Intern";
        s1.intern();
        String s2 = "Hello,Intern";
        s2.intern();

        assert(s1 == s2);
    }

    @Test
    public void testNormal(){
        String s1 = "Hello,String";
        String s2 = "Hello,String";

        assert (s1 == s2);
    }
}
