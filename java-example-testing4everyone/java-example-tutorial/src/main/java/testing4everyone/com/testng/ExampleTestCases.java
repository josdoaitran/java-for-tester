package testing4everyone.com.testng;

import org.testng.annotations.Test;

public class ExampleTestCases {

    @Test
    public void testCase(){
        String runner =  System.getProperty("testPlatformRun");
        System.out.println(runner);

        String check =  System.getProperty("checkParam");
        System.out.println(check);
        if (!runner.isEmpty()){
            System.setProperty("checkParam", "abcadsdsad");
            System.out.println(System.getProperty("checkParam"));
        }
    }
}
