package com.example.productdatabase; // Remplace par le nom exact de ton package si différent

public class Product {
    private int _id;
    private String _productname;
    private int _sku;

    // Constructeurs
    public Product() {
    }

    public Product(int id, String productname, int sku) {
        this._id = id;
        this._productname = productname;
        this._sku = sku;
    }

    public Product(String productname, int sku) {
        this._productname = productname;
        this._sku = sku;
    }

    // Getters et Setters
    public void setID(int id) {
        this._id = id;
    }

    public int getID() {
        return this._id;
    }

    public void setProductName(String productname) {
        this._productname = productname;
    }

    public String getProductName() {
        return this._productname;
    }

    public void setSku(int sku) {
        this._sku = sku;
    }

    public int getSku() {
        return this._sku;
    }
}