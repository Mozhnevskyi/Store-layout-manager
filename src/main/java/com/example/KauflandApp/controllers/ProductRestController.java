package com.example.KauflandApp.controllers;

import com.example.KauflandApp.entities.Product;
import com.example.KauflandApp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class ProductRestController {
    private ProductService productService;
    private JsonMapper mapper;

    @Autowired
    public ProductRestController(ProductService productService, JsonMapper mapper) {
        this.productService = productService;
        this.mapper = mapper;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        List<Product> products = productService.findAllProducts();
        return products;
    }

    @GetMapping("/products/{productId}")
    public Product getProductById(@PathVariable int productId){
        Product product = productService.findProductById(productId);
        return product;
    }
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProductById(@PathVariable int productId){
        productService.deleteProductById(productId);
    }

    @PutMapping("/products/{productId}")
    public Product updateProduct(@PathVariable int productId,
                                 @RequestBody Product product) {

        product.setId(productId);
        return productService.updateProduct(product);
    }

    @PatchMapping("/products/{productId}")
    public Product patchProduct(@PathVariable int productId, @RequestBody Map<String, Object> patchPayload){
        Product tempProduct = productService.findProductById(productId);
        //id in payload is forbidden
        Product patchedProduct = mapper.updateValue(tempProduct,patchPayload);
        return productService.updateProduct(patchedProduct);
    }
}
