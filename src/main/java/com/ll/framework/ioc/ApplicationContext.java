package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {
    private final Map<String, Object> beans = new HashMap<>();

    public ApplicationContext() {

        TestPostRepository testPostRepository = new TestPostRepository();

    }
}
