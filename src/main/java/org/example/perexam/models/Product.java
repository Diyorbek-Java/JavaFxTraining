package org.example.perexam.models;

public class Product {

    static Integer staticId = 0;
    private Integer id;

    private String name;

    private Integer stock;


    public Product(String name, Integer stock) {
        id = staticId++;
        this.name = name;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
