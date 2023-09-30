/*
 *
 *  * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package com.crio.qeats.exchanges;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice.This;

// TODO: CRIO_TASK_MODULE_RESTAURANTSAPI
//  Implement GetRestaurantsRequest.
//  Complete the class such that it is able to deserialize the incoming query params from
//  REST API clients.
//  For instance, if a REST client calls API
//  /qeats/v1/restaurants?latitude=28.4900591&longitude=77.536386&searchFor=tamil,
//  this class should be able to deserialize lat/long and optional searchFor from that.
@Data
@AllArgsConstructor
public class GetRestaurantsRequest {
   
    @NotNull
    @Min (value = -90)
    @Max (value = 90)
    private double latitude;
    @NotNull
    @Min (value = -180)
    @Max (value = 180)
    private double longitude;

    // public GetRestaurantsRequest(double d, double e) {
    //   this.longitude=d;
    //   this.latitude=e;
    // }
    public void setLongitude(Double longitude) {
      this.longitude = longitude;
    }
    
    public void setLatitude(Double latitude) {
      this.latitude = latitude;
    }
    
    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
      return latitude;
    }

}

