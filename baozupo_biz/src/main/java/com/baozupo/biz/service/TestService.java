package com.baozupo.biz.service;

import com.baozupo.base.service.SuperService;
import com.baozupo.biz.domain.entity.TestBeen;
import com.baozupo.common.domain.CommonResult;

public interface TestService extends SuperService<TestBeen> {

    // 获取测试信息
    public CommonResult getTestbeen();
}
