package org.example.model;

public class Product {
    private Long id;
    private String name;
    private int pieces;
    public Product() {}
    public Product(Long id, String name, int pieces) {
        this.id = id;
        this.name = name;
        this.pieces = pieces;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getPieces() {
        return pieces;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPieces(int pieces) {
        this.pieces = pieces;
    }
}
