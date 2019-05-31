package com.epam.pihnastyi.task4.service.impl;

import com.epam.pihnastyi.task4.dao.ProductDAO;
import com.epam.pihnastyi.task4.entity.Product;
import com.epam.pihnastyi.task4.service.ProductService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDAO productDAO;

    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<Product> showAllProduct() {
        return productDAO.getAllProducts();
    }

    @Override
    public Product getElementById(int productId) {
        int sizeShopElement = productDAO.getAllProducts().size();
        if (productId > 0 && productId <= sizeShopElement) {
            return productDAO.getElementById(productId);
        }
        return null;
    }

    @Override
    public void addAllProducts(List<Product> products) {
        productDAO.addAllProducts(products);
    }

    @Override
    public void serializeProduct() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("products"))) {
            oos.writeObject(showAllProduct());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deserializeProduct() {
        List<Product> productsShop = new ArrayList<>();
        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("products"))) {
            try {
                productsShop = (List<Product>) oos.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println("No file to deserialize. Fill default shop data");
        }
        addAllProducts(productsShop);
    }

    @Override
    public void addProduct(Product product) {
        productDAO.addProduct(product);

    }
}
