/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jd.jaffee.gmm.utils;

import com.jd.jaffee.gmm.domain.Restaurant;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jaffee
 */
public class RestaurantUtil {

    private static final String KEY = "Restaurant";

    public static List<Restaurant> getRestaurantList() {
        List<Restaurant> restaurantList = null;
        String restauantStr = PropertiesUtil.getProperty(KEY);
        if (!StringUtil.isBlank(restauantStr)) {
            String[] restauants = restauantStr.split("_");
            if (restauants != null && restauants.length > 0) {
                restaurantList = new ArrayList<Restaurant>();
                for (String restauant : restauants) {
                    if (!StringUtil.isBlank(restauant)) {
                        String[] values = restauant.split("\\*");
                        if (values != null && values.length == 2) {
                            Restaurant restaurant = new Restaurant();
                            restaurant.setId(Integer.parseInt(values[0]));
                            restaurant.setName(values[1]);
                            restaurantList.add(restaurant);
                        }
                    }
                }
            }
        }
        return restaurantList;
    }

    public static String[] getRestaurantNames(){
        String[] restaurantNames = null;
        String restauantStr = PropertiesUtil.getProperty(KEY);
        if (!StringUtil.isBlank(restauantStr)) {
            String[] restauants = restauantStr.split("_");
            if (restauants != null && restauants.length > 0) {
                restaurantNames = new String[restauants.length];
                for (int index = 0; index < restauants.length; index++) {
                    String restauant = restauants[index];
                    if (!StringUtil.isBlank(restauant)) {
                        String[] values = restauant.split("\\*");
                        if (values != null && values.length == 2) {
                            restaurantNames[index] = values[1];
                        }
                    }
                }
            }
        }
        return restaurantNames;
    }

}
