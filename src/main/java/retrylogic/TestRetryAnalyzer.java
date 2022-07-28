package retrylogic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestRetryAnalyzer implements IRetryAnalyzer {
    /**
     * Returns true if the test method has to be retried, false otherwise.
     *
     * @param result The result of the test method that just ran.
     * @return true if the test method has to be retried, false otherwise.
     */

    int counter = 1;
    int retryMaxLimit = 4;
    @Override
    public boolean retry(ITestResult result) {
        if(counter<retryMaxLimit){
            counter++;
            return true;
        }
        return false;
    }
}
