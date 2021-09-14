package dk.kea.webshop.service;

import dk.kea.webshop.model.Product;

import dk.kea.webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {



        @Autowired
        ProductRepository productRepository;

        public List<Product> getAll()
        {
            List<Product> products = new ArrayList<>();
            for (Product product:productRepository.findAll())
            {
                products.add(product);
            }
            return products;
        }

        public void createProduct(Product product)
        {
            productRepository.createProduct(product);
        }

        public void deleteProduct(int id)
        {
            productRepository.deleteProduct(id);
        }

        public Product findProductById(int id)
        {
            return productRepository.findProductById(id);
        }

        public void updateProduct(Product product)
        {
            productRepository.updateProduct(product);
        }
    }
