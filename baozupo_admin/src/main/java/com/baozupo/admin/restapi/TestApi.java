package com.baozupo.admin.restapi;

import com.baozupo.biz.service.TestService;
import com.baozupo.common.domain.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: t_admin
 * @Author bestlmc
 * @Date 2021/6/22 13:00
 */
@RestController
@RequestMapping("/test")
@Api(value = "测试接口", tags = {"测试接口"})
public class TestApi {
    @Resource
    TestService testService;

    @ApiOperation(value = "getTestbeen", notes = "测试getTestbeen")
    @PostMapping("/getTestbeen")
    public CommonResult getTestbeen(){

        System.out.println(">>>>>开户成功>>>>>>>>");

        return testService.getTestbeen();
    }



}
