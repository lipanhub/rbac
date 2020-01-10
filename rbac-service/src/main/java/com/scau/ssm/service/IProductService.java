package com.scau.ssm.service;

import com.scau.ssm.domain.Product;

import java.util.List;

public interface IProductService {

    public List<Product> findAll() throws Exception;

    public void addOne(Product product) throws Exception;
}
