package com.may.Kodlamaio.api.controllers;

import com.may.Kodlamaio.business.abstracts.ProductService;
import com.may.Kodlamaio.core.utilities.result.DataResult;
import com.may.Kodlamaio.core.utilities.result.Result;
import com.may.Kodlamaio.core.utilities.result.SuccsessDataResult;

import com.may.Kodlamaio.entities.concretes.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll(){
        return new SuccsessDataResult("başarılı işlem",this.productService.getAll());
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        this.productService.add(product);
        return new Result(true,"başarıyla eklendi");
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName){
        return this.productService.getByProductName(productName);
    }

    @GetMapping("/getallpage")
    public DataResult<List<Product>> getAll(int pageNo, int pageSize){
        return this.productService.getAll(pageNo,pageSize);
    }

    @GetMapping("/getAllSorted")
    public DataResult<List<Product>> getAllSorted(){
        return this.productService.getAllSorted();
    }




}
