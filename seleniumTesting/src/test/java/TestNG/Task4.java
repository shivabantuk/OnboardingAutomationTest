package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Task4 {

    @Test
    public void testcase1() {
        Assert.assertTrue(true);
        System.out.println("testcase1");
    }
    @Test
    public void testcase2() {
        Assert.assertTrue(false);
        System.out.println("testcase2");
    }
    int i =0;
    @Test(retryAnalyzer = retry.class)
    public void testcase3() {
        if(i<3){
            i++;
            Assert.assertTrue(false);
            System.out.println("failed testcase3");
        } else {
            System.out.println("testcase3");
        }
    }
}
