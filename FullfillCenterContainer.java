package com.company;
import java.util.*;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Map;

public class FullfillCenterContainer {
    Map<String, FulfillmentCenter> warehousesMap;

    public FullfillCenterContainer() {
        this.warehousesMap = new HashMap<>();
    }

    void addCenter(String name, double capacity) {
        FulfillmentCenter warehouse = new FulfillmentCenter(name, capacity);
        this.warehousesMap.put(name, warehouse);
    }

    void removeCenter(String warehouseName) {
            this.warehousesMap.remove(warehouseName);
    }

    List isEmpty()
    {
        List<FulfillmentCenter> emptyList = new LinkedList<>();
        for(String key: warehousesMap.keySet()) {
            if(warehousesMap.get(key).productList.isEmpty())
            {
                emptyList.add(warehousesMap.get(key));
            }
            else continue;
        }
        return emptyList;
    }

    void summary()
    {
        System.out.println("Kontener zawiera:");
        for(String key: warehousesMap.keySet()) {
            double percentTemp = (warehousesMap.get(key).actualAmount/warehousesMap.get(key).capacity)*100;
            System.out.println(warehousesMap.get(key).warehouseName + ": " + percentTemp + "%");
        }
    }

}
