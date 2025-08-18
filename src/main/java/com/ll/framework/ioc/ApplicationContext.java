package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestFacadePostService;
import com.ll.domain.testPost.testPost.service.TestPostService;

public class ApplicationContext {
    private TestPostService tempTestPostService;
    private TestPostRepository testPostRepository;
    private TestFacadePostService TestFacadePostService;
    public ApplicationContext() {
        this.testPostRepository = new TestPostRepository();
        this.tempTestPostService = new TestPostService(testPostRepository);
        this.TestFacadePostService = new TestFacadePostService(tempTestPostService, testPostRepository);
    }

    public <T> T genBean(String beanName) {
        if (beanName.equals("testPostService")) {
            TestPostRepository repo = genBean("testPostRepository");
            return (T) tempTestPostService;
        }
        else if( beanName.equals("testPostRepository")) {
            return (T) testPostRepository;
        }

        else if ( beanName.equals("testFacadePostService")){
            return (T) TestFacadePostService;
        }
        return null;
    }
}