package com.mncm.endpoints.api;

import com.mncm.model.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by sonudhakar on 03/09/17.
 */
@Slf4j
@Path("v1/order")
@Consumes(MediaType.APPLICATION_JSON)
public class OrderEndPoint {

    @Path("/create")
    @POST
    public Response createOrder(){
        ApiResponse apiResponse = new ApiResponse();
        try{

        }catch(Exception e){
            log.error(e.getMessage(),e);
        }
        apiResponse.setOk(true);
        return Response.ok(apiResponse).build();
    }
}
