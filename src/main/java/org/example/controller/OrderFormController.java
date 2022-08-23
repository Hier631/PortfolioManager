package org.example.controller;

import org.apache.cayenne.ObjectContext;
import org.example.model.Dao;
import org.example.model.OrderDao;
import org.example.model.OrderDto;
import org.example.view.OrderFormView;

public class OrderFormController {

    private Integer orderId;
    private OrderFormView view;
    private Dao<OrderDto, Integer> dao;

    public OrderFormView getView() {
        return view;
    }

    public OrderFormController(ObjectContext context, OrderFormView view, Integer orderId) {
        this.dao = new OrderDao(context);
        this.view = view;
        this.orderId = orderId;

        initView();
    }

    public OrderFormController(ObjectContext context, OrderFormView view) {
        this(context, view, null);
    }

    private void initView() {

    }
}
