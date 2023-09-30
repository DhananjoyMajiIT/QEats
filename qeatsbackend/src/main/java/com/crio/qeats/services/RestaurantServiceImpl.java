
/*
 *
 * * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package com.crio.qeats.services;

import com.crio.qeats.dto.Restaurant;
import com.crio.qeats.exchanges.GetRestaurantsRequest;
import com.crio.qeats.exchanges.GetRestaurantsResponse;
import com.crio.qeats.repositoryservices.RestaurantRepositoryService;
import lombok.extern.log4j.Log4j2;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Log4j2
public class RestaurantServiceImpl implements RestaurantService {

  private final Double peakhoursServingRadiusInKms = 3.0;
  private final Double normalhoursServingRadiusInKms = 5.0;
  
  @Autowired
  private RestaurantRepositoryService restaurantRepositoryService;


  // TODO: CRIO_TASK_MODULE_RESTAURANTSAPI - Implement findAllRestaurantsCloseby.
  // Check RestaurantService.java file for the interface contract.
  @Override
  public GetRestaurantsResponse findAllRestaurantsCloseBy(
      GetRestaurantsRequest getRestaurantsRequest, LocalTime currentTime) {
    List<Restaurant> listOfrest;
    int hour = currentTime.getHour();
    int minit = currentTime.getMinute();

    if ((hour >= 8 && hour <= 9) || (hour == 10 && minit == 0) || (hour == 13)
        || (hour == 14 && minit == 0) || (hour >= 19 && hour <= 20) || (hour == 21 && minit == 0)) {
      listOfrest =
          restaurantRepositoryService.findAllRestaurantsCloseBy(getRestaurantsRequest.getLatitude(),
              getRestaurantsRequest.getLongitude(), currentTime, peakhoursServingRadiusInKms);
    } else {
      listOfrest =
          restaurantRepositoryService.findAllRestaurantsCloseBy(getRestaurantsRequest.getLatitude(),
              getRestaurantsRequest.getLongitude(), currentTime, normalhoursServingRadiusInKms);
    }
    GetRestaurantsResponse responcerest=new GetRestaurantsResponse(listOfrest);
    return responcerest;
  }


}

