# Project Show how to use DAO pattern

 CSVProductDAO save data to csv file.

 DBProductDAO save data to database.

Only change to code when changing data saving place is to change which dao class to use in code.

Choose which DAO class you want to use and remove other:

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

####
Check config.properties.example.txt file and create config.properties file with your own db username and password.

    db.username=<username>

    db.password=<password>