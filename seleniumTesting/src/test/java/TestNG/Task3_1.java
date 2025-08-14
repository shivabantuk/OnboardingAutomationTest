package TestNG;

import org.testng.annotations.Test;

public class Task3_1 {

    @Test(groups = {"smoke", "functional", "regression"})
    public void testcase1(){
        System.out.println("testcase1");
    }
    @Test(groups = {"smoke",  "regression"})
    public void testcase2(){
        System.out.println("testcase2");
    }
    @Test(groups = {"smoke", "functional"})
    public void testcase3(){
        System.out.println("testcase3");
    }
    @Test(groups = {"functional", "regression"})
    public void testcase4(){
        System.out.println("testcase4");
    }
    @Test(groups = {"smoke"})
    public void testcase5(){
        System.out.println("testcase5");
    }
    @Test(groups = {"regression"})
    public void testcase6(){
        System.out.println("testcase6");
    }
    @Test(groups = {"functional"})
    public void testcase7(){
        System.out.println("testcase7");
    }
}
