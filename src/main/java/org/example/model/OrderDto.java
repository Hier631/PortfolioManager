package org.example.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderDto {

    private int id;
    private LocalDate date;
    private boolean purchase;
    private BigDecimal sharePrice;
    private BigDecimal shareQuantity;
    private int indexFundId;

    public OrderDto(int id, LocalDate date, boolean purchase, BigDecimal sharePrice, BigDecimal shareQuantity, int indexFundId) {
        this.id = id;
        this.date = date;
        this.purchase = purchase;
        this.sharePrice = sharePrice;
        this.shareQuantity = shareQuantity;
        this.indexFundId = indexFundId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isPurchase() {
        return purchase;
    }

    public void setPurchase(boolean purchase) {
        this.purchase = purchase;
    }

    public BigDecimal getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(BigDecimal sharePrice) {
        this.sharePrice = sharePrice;
    }

    public BigDecimal getShareQuantity() {
        return shareQuantity;
    }

    public void setShareQuantity(BigDecimal shareQuantity) {
        this.shareQuantity = shareQuantity;
    }

    public int getIndexFundId() {
        return indexFundId;
    }

    public void setIndexFundId(int indexFundId) {
        this.indexFundId = indexFundId;
    }
}
