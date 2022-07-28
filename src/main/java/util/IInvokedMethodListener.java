package util;

import com.aventstack.extentreports.Status;
import org.testng.IInvokedMethod;
import org.testng.ITestResult;
import reportgenerator.ExtentFactory;

/**
 * IInvokedMethod Listener performs some tasks before and after the Methods execute.
 * We generally use this class for setting up configurations or clean up
 * IInvokedMethod Listener invokes before and after every test method available in the test code. It contains
 * two methods:
 * (a) beforeInvocation(): This method invokes before every method
 * (b) afterInvocation(): This method is invoked after every method.
 */
public class IInvokedMethodListener implements org.testng.IInvokedMethodListener {

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult){
        ExtentFactory.getInstance().getExtent()
                .log(Status.INFO, "Before Invocation of: "+
                        method.getTestMethod().getMethodName() + "of Class" + testResult.getTestClass());
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult){
        ExtentFactory.getInstance().getExtent()
                .log(Status.INFO, "After Invocation of: "+
                        method.getTestMethod().getMethodName() + "of Class" + testResult.getTestClass());
    }
}
