package com.sagar.reactdigitaldealsbackend.serviceimpl;

import com.sagar.reactdigitaldealsbackend.model.Product;
import com.sagar.reactdigitaldealsbackend.repository.ProductRepo;
import com.sagar.reactdigitaldealsbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Override
    public void addProduct(Product product) {
        productRepo.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        productRepo.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product getProductById(int id) {
        return productRepo.findById(id).get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
}
