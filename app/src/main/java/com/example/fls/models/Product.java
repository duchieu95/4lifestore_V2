package com.example.fls.models;

/**
 * Created by HieuHo on 3/1/2017.
 */

public class Product {
    public int IdProduct;
    public String NameProduct;
    public int PriceProduct;
    public String ImageProduct;
    public String ProductCode;
    public int IdSale;
    public String Content;
    public int TypesOfItems;
    public String IdFavorite;
    public int NumberProduct;
    public String Date;
    public Product(int PriceProduct,String Name){
        this.PriceProduct = PriceProduct;
        this.NameProduct = Name;

    }

    public int getIdProduct() {
        return IdProduct;
    }

    public void setIdProduct(int idProduct) {
        IdProduct = idProduct;
    }

    public String getNameProduct() {
        return NameProduct;
    }

    public void setNameProduct(String nameProduct) {
        NameProduct = nameProduct;
    }

    public int getPriceProduct() {
        return PriceProduct;
    }

    public void setPriceProduct(int priceProduct) {
        PriceProduct = priceProduct;
    }

    public String getImageProduct() {
        return ImageProduct;
    }

    public void setImageProduct(String imageProduct) {
        ImageProduct = imageProduct;
    }

    public String getProductCode() {
        return ProductCode;
    }

    public void setProductCode(String productCode) {
        ProductCode = productCode;
    }

    public int getIdSale() {
        return IdSale;
    }

    public void setIdSale(int idSale) {
        IdSale = idSale;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public int getTypesOfItems() {
        return TypesOfItems;
    }

    public void setTypesOfItems(int typesOfItems) {
        TypesOfItems = typesOfItems;
    }

    public String getIdFavorite() {
        return IdFavorite;
    }

    public void setIdFavorite(String idFavorite) {
        IdFavorite = idFavorite;
    }

    public int getNumberProduct() {
        return NumberProduct;
    }

    public void setNumberProduct(int numberProduct) {
        NumberProduct = numberProduct;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

}
