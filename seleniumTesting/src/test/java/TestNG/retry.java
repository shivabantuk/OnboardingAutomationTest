package TestNG;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retry implements IRetryAnalyzer {

    int count = 0;
    int maxCount = 3; // Maximum number of retries
    @Override
    public boolean retry(ITestResult result) {
        if(count<maxCount){
            count++;
            return true;
        }
        return false;
    }
}
