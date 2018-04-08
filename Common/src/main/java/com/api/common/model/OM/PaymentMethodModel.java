package com.api.common.model.OM;

import com.api.common.entity.AbstractBaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Created by sonudhakar on 23/09/17.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PaymentMethodModel extends AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = 8103509625951224949L;

    @JsonProperty("id")
    private String id;

    @JsonProperty("paymentMode")
    private String paymentMode;

    @JsonProperty("status")
    private String status;

    @JsonProperty("basePrice")
    private float basePrice;

    @JsonProperty("CGST")
    private float CGST;

    @JsonProperty("SGST")
    private float SGST;

    @JsonProperty("amount")
    private float amount;

    @JsonProperty("transactionId")
    private Boolean transactionId;
}
