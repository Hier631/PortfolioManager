package org.example.model;

import org.apache.cayenne.Cayenne;
import org.example.model.auto._Order;

public class Order extends _Order {

    private static final long serialVersionUID = 1L;

    public int getId() {
        return Cayenne.intPKForObject(this);
    }

    public OrderDto toDto()
    {
        return new OrderDto(this.getId(), this.getDate(), this.isPurchase(), this.getSharePrice(), this.getShareQuantity(), this.getIndexFund().getId());
    }

    public void copyDataFromDto(OrderDto orderDto) {
        this.setDate(orderDto.getDate());
        this.setPurchase(orderDto.isPurchase());
        this.setSharePrice(orderDto.getSharePrice());
        this.setShareQuantity(orderDto.getShareQuantity());
    }
}
