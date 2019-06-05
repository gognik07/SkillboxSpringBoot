package main;

import main.model.Business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Storage {
    private static int currentId = 1;
    private static HashMap<Integer, Business> businesses = new HashMap<Integer, Business>();

    public static List<Business> getAllBusinesses() {
        ArrayList<Business> businessesList = new ArrayList<Business>();
        businessesList.addAll(businesses.values());
        return businessesList;
    }

    public static int addBusiness(Business business) {
        int id = currentId++;
        business.setId(id);
        businesses.put(id, business);
        return id;
    }

    public static Business getBusiness(int businessId) {
        if (businesses.containsKey(businessId)) {
            return businesses.get(businessId);
        }
        return null;
    }
}
