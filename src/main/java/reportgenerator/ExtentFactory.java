package reportgenerator;

import com.aventstack.extentreports.ExtentTest;

public class ExtentFactory {

    private ExtentFactory(){

    }

    private static ExtentFactory extentFactoryInstance=null;

    synchronized public static ExtentFactory getInstance(){
        if(extentFactoryInstance==null){
            extentFactoryInstance=new ExtentFactory();
        }
        return extentFactoryInstance;
    }

    ThreadLocal<ExtentTest> extentTestThreadLocal=new ThreadLocal<ExtentTest>();

    public ExtentTest getExtent(){
        return extentTestThreadLocal.get();
    }

    public void setExtentTestThreadLocal(ExtentTest extentTestObject){
        extentTestThreadLocal.set(extentTestObject);
    }

    public void removeExtentObject(){
        extentTestThreadLocal.remove();
    }
}
