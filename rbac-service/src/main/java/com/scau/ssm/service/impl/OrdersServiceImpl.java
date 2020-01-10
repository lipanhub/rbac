package com.scau.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.scau.ssm.dao.IOrdersDao;
import com.scau.ssm.domain.Orders;
import com.scau.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public List<Orders> findAll(Integer page,Integer pageSize) throws Exception {

        PageHelper.startPage(page,pageSize);

        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String id) throws Exception {
        return ordersDao.findById(id);
    }
}
