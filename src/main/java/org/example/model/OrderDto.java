package org.example.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderDto {

    private Integer id;
    private LocalDate date;
    private boolean purchase;
    private BigDecimal sharePrice;
    private BigDecimal shareQuantity;
    private Integer indexFundId;

    public OrderDto(Integer id, LocalDate date, boolean purchase, BigDecimal sharePrice, BigDecimal shareQuantity, Integer indexFundId) {
        this.id = id;
        this.date = date;
        this.purchase = purchase;
        this.sharePrice = sharePrice;
        this.shareQuantity = shareQuantity;
        this.indexFundId = indexFundId;
    }

    public OrderDto(LocalDate date, boolean purchase, BigDecimal sharePrice, BigDecimal shareQuantity) {
        this(null, date, purchase, sharePrice, shareQuantity, null);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getIndexFundId() {
        return indexFundId;
    }

    public void setIndexFundId(Integer indexFundId) {
        this.indexFundId = indexFundId;
    }
}
