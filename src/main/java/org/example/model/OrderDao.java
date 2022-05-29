package org.example.model;

import org.apache.cayenne.Cayenne;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.query.ObjectSelect;
import org.example.utils.CayenneUtil;

import java.util.ArrayList;
import java.util.List;

public class OrderDao implements Dao<OrderDto, Integer> {

    private final ObjectContext context;

    public OrderDao(ObjectContext context) {
        this.context = context;
    }

    @Override
    public OrderDto getById(Integer id) {
        OrderDto orderDto = null;

        if (id != null) {
            Order order = Cayenne.objectForPK(context, Order.class, id);

            if (order != null) {
                orderDto = order.toDto();
            }
        }

        return orderDto;
    }

    @Override
    public void deleteById(Integer id) {
        if (id != null) {

            Order order = Cayenne.objectForPK(context, Order.class, id);

            if (order != null) {
                context.deleteObject(order);
                context.commitChanges();
            }
        }
    }

    @Override
    public List<OrderDto> getAll() {
        List<OrderDto> orderDtoList = null;

        List<Order> orders = ObjectSelect
                .query(Order.class)
                .select(context);

        if (orders != null && !orders.isEmpty()) {

            orderDtoList = new ArrayList<>();

            for (Order order : orders) {
                orderDtoList.add(order.toDto());
            }
        }

        return orderDtoList;
    }

    @Override
    public void save(OrderDto orderDto) {
        if (orderDto != null && orderDto.getIndexFundId() != null) {

            IndexFund indexFund = Cayenne.objectForPK(context, IndexFund.class, orderDto.getIndexFundId());

            if (indexFund != null) {
                Order order = context.newObject(Order.class);
                order.copyDataFromDto(orderDto);
                order.setIndexFund(indexFund);
                context.commitChanges();
            }
        }
    }

    @Override
    public void update(OrderDto orderDto) {
        if (orderDto != null && orderDto.getId() != null) {

            Order order = Cayenne.objectForPK(context, Order.class, orderDto.getId());
            order.copyDataFromDto(orderDto);

            if (orderDto.getIndexFundId() != null) {
                order.setIndexFund(Cayenne.objectForPK(context, IndexFund.class, orderDto.getIndexFundId()));
            }

            context.commitChanges();
        }
    }

    @Override
    public void delete(OrderDto orderDto) {
        if (orderDto != null && orderDto.getId() != null) {

            Order order = Cayenne.objectForPK(context, Order.class, orderDto.getId());

            if (order != null) {
                context.deleteObject(order);
                context.commitChanges();
            }
        }
    }
}
