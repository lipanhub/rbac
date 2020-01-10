package com.scau.ssm.service;

import com.scau.ssm.domain.Orders;

import java.util.List;

public interface IOrdersService {
    public List<Orders> findAll(Integer page,Integer pageSize) throws Exception;

    public Orders findById(String id) throws Exception;
}
