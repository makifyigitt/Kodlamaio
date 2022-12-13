package com.may.Kodlamaio.dataAccess.abstracts;

import com.may.Kodlamaio.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {
    Product getByProductName(String productName);
    Product getByProductNameAndCategory(String productName, int categoryId);
    List<Product> getByCategoryIn(List<Integer> categories);
    List<Product> getByProductNameOrCategory(String productName, int categoryId);
    List<Product> getByProductNameContaining(String productName);
    List<Product> getByProductNameStartsWith(String productName);

    @Query("From Product where productName=:product_Name and category.categoryId=:category_Id")
    List<Product> getByNameAndCategory(String product_Name, int category_Id);

}
