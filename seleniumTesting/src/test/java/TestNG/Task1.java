package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Task1 {

    @Test
    public void add(){
         int a = Math.addExact(2,3);
        Assert.assertEquals(a,5);
    }







}
