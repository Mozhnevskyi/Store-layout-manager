package com.example.KauflandApp.services;

import com.example.KauflandApp.entities.Product;
import com.example.KauflandApp.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findProductById(int productId) {
        Optional<Product> product = productRepository.findById(productId);
        return product.orElse(null);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        product.setId(0);
        return productRepository.save(product);
    }

    public void deleteProductById(int productId) {
        productRepository.deleteById(productId);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }
}
