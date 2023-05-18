package org.example.dao;
import org.example.model.Product;
public interface IProductDAO {
    boolean createProduct(Product product);
    Product readProduct(Long id);
    Product[] readProductList();
    Product updateProduct(Product product);
    boolean delete(Long id);
}
