package com.mncm.daoimpl;

import com.api.common.enums.EntityStatus;
import com.api.common.services.objectify.OfyService;
import com.api.common.utils.ObjUtil;
import com.api.common.utils.Preconditions;
import com.api.common.utils.RandomUtil;
import com.mncm.dao.OrderDao;
import com.api.common.entity.OM.Order;
import com.api.common.model.OM.OrderModel;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by sonudhakar on 28/10/17.
 */
@Slf4j
public class OrderDaoImpl extends OfyService implements OrderDao{

    @Override
    public Order get(String id) throws Exception{
        return get(Order.class,id);
    }

    @Override
    public Order getByCountry(String country) throws Exception{
        if (country == null)
            return null;

        //TODO it can be cached
        return ofy().load().type(Order.class).filter("country", country).first().now();
    }

    @Override
    public Order getByPostCode(String postcode) throws Exception{
        if (postcode == null)
            return null;

        //TODO it can be cached
        return ofy().load().type(Order.class).filter("postcode", postcode).first().now();
    }

    @Override
    public Order getByTransactionId(String transactionId) throws Exception{
        if (transactionId == null)
            return null;

        //TODO it can be cached
        return ofy().load().type(Order.class).filter("transactionId", transactionId).first().now();
    }

    @Override
    public Order createOrder(OrderModel orderModel) throws Exception{

        Preconditions.checkArgument(orderModel == null,"order payload is not valid");

        Order order = new Order(orderModel);
        order.setStatus(EntityStatus.ACTIVE);

        if(orderModel.getId() != null){
            order.setId(orderModel.getId());
        }else{
            order.setId(RandomUtil.generateSecureRandomString(32,RandomUtil.RandomModeType.ALPHANUMERIC));
        }

        return saveOrder(order);
    }

    @Override
    public Order saveOrder(Order order) throws Exception{
        if(order == null)
            return null;

        return save(order) != null ? order : null;
    }

    @Override
    public Order deleteOrder(String orderId) throws Exception{

        if(ObjUtil.isNullOrEmpty(orderId))
            return null;

        Order order = get(orderId);

        return delete(order) ? order : null;
    }

}
