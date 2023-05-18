package org.example;

import org.example.dao.CSVProductDAO;
import org.example.dao.DBProductDAO;
import org.example.dao.IProductDAO;
import org.example.model.Product;

import java.util.Scanner;

public class Main {
    private static IProductDAO productDAO;
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // Writes data to csv file
        productDAO = new CSVProductDAO();

        // Writes data to db
        //productDAO = new DBProductDAO();

        String input = "";
        while(!input.equalsIgnoreCase("e")) {
            printInstructions();
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("a")) {
                boolean added = addProduct();
                if (added) {
                    System.out.println("Product added successfully!");
                } else {
                    System.out.println("Something went wrong!");
                }
            } else if (input.equalsIgnoreCase("r")) {
                readShoppingList();
            }
        }
        System.out.println("Exit!");

    }
    private static boolean addProduct() {
        Product product = new Product();
        System.out.println("Write product name:");
        String name = scanner.nextLine();
        System.out.println("Write number of product:");
        int pieces = scanner.nextInt();
        product.setName(name);
        product.setPieces(pieces);
        return productDAO.createProduct(product);
    }

    private static void readShoppingList() {
        Product[] shoppingList = productDAO.readProductList();
        for (Product p : shoppingList)
            p.printProduct();
    }
    private static void printInstructions() {
        System.out.println("A: Add product.");
        System.out.println("R: Read shoppinglist.");
        System.out.println("E: Exit.");
        System.out.print("Select: ");
    }

}