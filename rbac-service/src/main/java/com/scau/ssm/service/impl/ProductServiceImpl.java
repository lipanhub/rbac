package com.scau.ssm.service.impl;

import com.scau.ssm.service.IProductService;
import com.scau.ssm.dao.IProductDao;
import com.scau.ssm.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void addOne(Product product) throws Exception {
        productDao.add(product);
    }
}
