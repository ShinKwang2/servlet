import org.junit.jupiter.api.Test;

import java.util.StringTokenizer;

public class example {

    @Test
    void test() throws Exception {
        //given
        String testString = "/WEB-INF/views/members.jsp";

        //when
        String[] result = testString.split("/");

        //then
        int lastIndex = result.length - 1;
        String s = result[lastIndex];
        System.out.println("s = " + s);

        String[] result2 = s.split("[.]");
        String s1 = result2[0];
        System.out.println("s1 = " + s1);


    }
}
