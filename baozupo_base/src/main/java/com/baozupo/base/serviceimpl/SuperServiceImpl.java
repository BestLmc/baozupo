package com.baozupo.base.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baozupo.base.mapper.SuperMapper;
import com.baozupo.base.service.SuperService;


public class SuperServiceImpl<M extends SuperMapper<T>, T> extends ServiceImpl<M, T> implements SuperService<T> {

}
