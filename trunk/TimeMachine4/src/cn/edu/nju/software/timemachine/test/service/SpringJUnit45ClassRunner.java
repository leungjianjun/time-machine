package cn.edu.nju.software.timemachine.test.service;

import org.apache.commons.logging.Log;  
import org.apache.commons.logging.LogFactory;  
import org.junit.runners.model.InitializationError;  
import org.junit.runners.BlockJUnit4ClassRunner;  
  
import org.springframework.test.context.TestContextManager;

public class SpringJUnit45ClassRunner extends BlockJUnit4ClassRunner {  
	  
    private static final Log logger = LogFactory.getLog(SpringJUnit45ClassRunner.class);  
  
    private final TestContextManager testContextManager;  
  
    public SpringJUnit45ClassRunner(Class<?> clazz) throws InitializationError {  
        super(clazz);  
        if (logger.isDebugEnabled()) {  
            logger.debug("SpringJUnit45ClassRunner constructor called with [" + clazz + "].");  
        }  
        this.testContextManager = createTestContextManager(clazz);  
    }  
  
    protected Object createTest() throws Exception {  
        Object testInstance = super.createTest();  
        getTestContextManager().prepareTestInstance(testInstance);  
        return testInstance;  
    }  
  
    protected TestContextManager createTestContextManager(Class<?> clazz) {  
        return new TestContextManager(clazz);  
    }  
  
    protected final TestContextManager getTestContextManager() {  
        return this.testContextManager;  
    }  
  
}  
