# Project Show how to use DAO pattern

 CSVProductDAO save data to csv file.

 DBProductDAO save data to database.

Modify the code only in the Main.java file depending on whether you want to save the data to a database or a CSV file.

Choose which DAO class you want to use and remove the other:

        private static IProductDAO productDAO;

        // Save data to csv file
        productDAO = new CSVProductDAO();

        // Save data to db
        productDAO = new DBProductDAO();

### Commands to create db and product table.

#### Create database:
CREATE database productdb;

#### Create product table:
CREATE TABLE product (id BIGINT PRIMARY KEY, name TEXT, pieces INT);

#### Check config.properties.example.txt file and create config.properties file with your own db username and password.

    db.url=jdbc:mariadb://localhost/productdb

    db.username=<username>

    db.password=<password>