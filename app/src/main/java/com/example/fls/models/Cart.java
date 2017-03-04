package com.example.fls.models;

/**
 * Created by HieuHo on 3/4/2017.
 */

public class Cart {
    public int IdCard;
    public int IdProduct;
    public String ProductName;
    public String ProductImage;
    public int PriceProduct;
    public int NumberProduct;
    public int TotalCash;
    public int IdUser;

    public Cart(String ProductName,int NumberProduct,int TotalCash){
            this.ProductName = ProductName;
            this.NumberProduct = NumberProduct;
            this.TotalCash = TotalCash;
    }

    public int getIdCard() {
        return IdCard;
    }

    public void setIdCard(int idCard) {
        IdCard = idCard;
    }

    public int getIdProduct() {
        return IdProduct;
    }

    public void setIdProduct(int idProduct) {
        IdProduct = idProduct;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductImage() {
        return ProductImage;
    }

    public void setProductImage(String productImage) {
        ProductImage = productImage;
    }

    public int getPriceProduct() {
        return PriceProduct;
    }

    public void setPriceProduct(int priceProduct) {
        PriceProduct = priceProduct;
    }

    public int getNumberProduct() {
        return NumberProduct;
    }

    public void setNumberProduct(int numberProduct) {
        NumberProduct = numberProduct;
    }

    public int getTotalCash() {
        return TotalCash;
    }

    public void setTotalCash(int totalCash) {
        TotalCash = totalCash;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int idUser) {
        IdUser = idUser;
    }
}
