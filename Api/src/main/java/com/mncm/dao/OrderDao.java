package com.mncm.dao;

import com.api.common.entity.OM.Order;
import com.api.common.model.OM.OrderModel;

/**
 * Created by sonudhakar on 28/10/17.
 */
public interface OrderDao {

    public Order get(String id) throws Exception;

    public Order getByCountry(String country) throws Exception;

    public Order getByPostCode(String postcode) throws Exception;

    public Order getByTransactionId(String transactionId) throws Exception;

    public Order createOrder(OrderModel orderModel) throws Exception;

    public Order saveOrder(Order order) throws Exception;

    public Order deleteOrder(String orderId) throws Exception;
}
