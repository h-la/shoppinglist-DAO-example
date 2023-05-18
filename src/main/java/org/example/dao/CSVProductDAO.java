package org.example.dao;

import org.example.model.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CSVProductDAO implements IProductDAO {

    private static String fileName = "shopping_list.csv";

    public CSVProductDAO() {
    }

    @Override
    public boolean createProduct(Product product) {
        product.setId(new Random().nextLong(100000));
        try(PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            writer.println(csvFormat(product));
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public Product readProduct(Long id) {
        return null;
    }
    @Override
    public Product[] readProductList() {
        ArrayList<Product> productList = new ArrayList<>();
        try (Scanner fileReader = new Scanner(Paths.get(fileName))) {
            while (fileReader.hasNextLine()) {
                String row = fileReader.nextLine();
                productList.add(csvToProduct(row));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        Product[] returnArray = new Product[productList.size()];
        return productList.toArray(returnArray);
    }
    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    private Product csvToProduct(String csvText) {
        String[] data = csvText.split(";");
        if (data.length < 3) {
            return null;
        }
        long id = Long.parseLong(data[0]);
        String name = data[1];
        int pieces = Integer.parseInt(data[2]);
        return new Product(id, name, pieces);
    }
    private String csvFormat(Product product) {
        return product.getId() + ";" + product.getName() + ";" + product.getPieces();
    }
}
