package com.api.common.model.OM;

import com.api.common.entity.AbstractBaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.api.common.model.contact.ContactMethodModel;
import com.api.common.model.IM.ProductModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sonudhakar on 23/09/17.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderModel  extends AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = 8103509625951224949L;

    @JsonProperty("id")
    private String id;

    @JsonProperty("linkedContactMethods")
    private List<ContactMethodModel> linkedContactMethods;

    @JsonProperty("addressModel")
    private String addressModel;

    @JsonProperty("linkedProducts")
    private List<ProductModel> linkedProducts;

    @JsonProperty("paymentMethod")
    private String region;

    @JsonProperty("country")
    private String country;

    @JsonProperty("postcode")
    private String postcode;

    @JsonProperty("paymentMethodId")
    private String paymentMethodId;

    @JsonProperty("transactionId")
    private String transactionId;
}
