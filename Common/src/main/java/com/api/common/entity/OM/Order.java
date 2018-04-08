package com.api.common.entity.OM;

import com.api.common.entity.AbstractBaseEntity;
import com.api.common.enums.EntityStatus;
import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Unindex;
import com.api.common.model.contact.ContactMethodModel;
import com.api.common.model.OM.OrderModel;
import com.api.common.model.IM.ProductModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by sonudhakar on 28/10/17.
 */
@Data
@NoArgsConstructor
@Cache
@Entity
@EqualsAndHashCode(callSuper = true)
public class Order extends AbstractBaseEntity{

    private static final long serialVersionUID = 1712149888615129334L;

    @Index
    private List<ContactMethodModel> linkedContactMethods;

    @Unindex
    private String addressModel;

    @Unindex
    private List<ProductModel> linkedProducts;

    @Unindex
    private String region;

    @Index
    private String country;

    @Index
    private String postcode;

    @Unindex
    private String paymentMethodId;

    @Index
    private String transactionId;

    @Unindex
    private EntityStatus status;

    public Order(OrderModel orderModel){
        this.id = orderModel.getId();
        this.linkedContactMethods = orderModel.getLinkedContactMethods();
        this.addressModel = orderModel.getAddressModel();
        this.linkedProducts = orderModel.getLinkedProducts();
        this.region = orderModel.getRegion();
        this.country = orderModel.getCountry();
        this.postcode = orderModel.getPostcode();
        this.paymentMethodId = orderModel.getPaymentMethodId();
        this.transactionId = orderModel.getTransactionId();
    }
}
