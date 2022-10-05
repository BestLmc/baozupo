package com.baozupo.biz.service.impl;

import com.baozupo.base.serviceimpl.SuperServiceImpl;
import com.baozupo.biz.domain.entity.TestBeen;
import com.baozupo.biz.mapper.TestMapper;
import com.baozupo.biz.service.TestService;
import com.baozupo.common.domain.CommonResult;
import org.springframework.stereotype.Service;


/**
 * @Description: 测试实现类
 * @Author bestlmc
 * @Date 2021/6/22 13:19
 */
@Service
public class TestServiceImpl extends SuperServiceImpl<TestMapper, TestBeen> implements TestService {
    @Override
    public CommonResult getTestbeen() {
        CommonResult result = new CommonResult();
        result.setCode(0);
        result.setMessage("successfully");
        result.setData("hello world!");

        return result;
    }

}
