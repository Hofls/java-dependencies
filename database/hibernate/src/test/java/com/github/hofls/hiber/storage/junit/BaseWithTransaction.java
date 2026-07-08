package com.github.hofls.hiber.storage.junit;

import org.springframework.transaction.annotation.Transactional;

@Transactional // automatically reverts changes after each test (test isolation)
public abstract class BaseWithTransaction extends BaseTest {

}
