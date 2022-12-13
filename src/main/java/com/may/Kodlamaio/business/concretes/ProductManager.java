package com.may.Kodlamaio.business.concretes;

import com.may.Kodlamaio.business.abstracts.ProductService;
import com.may.Kodlamaio.core.utilities.result.DataResult;
import com.may.Kodlamaio.core.utilities.result.Result;
import com.may.Kodlamaio.core.utilities.result.SuccessResult;
import com.may.Kodlamaio.core.utilities.result.SuccsessDataResult;
import com.may.Kodlamaio.dataAccess.abstracts.ProductDao;
import com.may.Kodlamaio.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccsessDataResult("başarılı işlem",this.productDao.findAll());
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC,"productName");
        return new SuccsessDataResult("başarılı işlem",productDao.findAll(sort));
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return new SuccsessDataResult(this.productDao.findAll(pageable).getContent());

    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("ürün eklendi");
    }

    @Override
    public SuccsessDataResult getByProductName(String productName) {
        return new SuccsessDataResult("başarılı işlem",this.productDao.getByProductName(productName));
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        return new SuccsessDataResult("başarılı işlem",this.productDao.getByProductNameAndCategory(productName,categoryId));
    }

    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccsessDataResult("başarılı işlem",this.productDao.getByCategoryIn(categories));
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccsessDataResult("başarılı işlem",this.productDao.getByProductNameOrCategory(productName,categoryId));
    }

    @Override
    public DataResult<List<Product>> getByProductNameContaining(String productName) {
        return new SuccsessDataResult("başarılı işlem",this.productDao.getByProductNameContaining(productName));
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccsessDataResult("başarılı işlem",this.productDao.getByProductNameStartsWith(productName));
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String product_Name, int category_Id) {
        return new SuccsessDataResult("başarılı işlem",this.productDao.getByNameAndCategory(product_Name,category_Id));
    }
}
