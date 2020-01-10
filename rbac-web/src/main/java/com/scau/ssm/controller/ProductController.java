package com.scau.ssm.controller;

import com.scau.ssm.service.IProductService;
import com.scau.ssm.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RolesAllowed("ADMIN")
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();

        List<Product> products = productService.findAll();

        System.out.println(products.size());

        mv.addObject("productList",products);
        mv.setViewName("product-list");

        return mv;
    }

    @RequestMapping("/add.do")
    public String addOne(Product product) throws Exception {


        System.out.println(product.getCityName());

        productService.addOne(product);

        return "redirect:findAll.do";
    }


}
