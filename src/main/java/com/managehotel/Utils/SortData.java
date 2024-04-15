package com.managehotel.Utils;

import com.managehotel.DTO.ListFacilitiesDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service
public class SortData {

    public List<Object> dataSort(List<ListFacilitiesDTO> data){
        List<Object> newArray = new ArrayList<>();
        Map<String,Object> dataTitle = new HashMap<>();
        Map<String,List<Map<String,Object>>> storedData = new HashMap<>();
        for(ListFacilitiesDTO i : data){
            if(!storedData.containsKey(i.getFacilityType())){
                storedData.put(i.getFacilityType(),new ArrayList<>());
            }
            Map<String,Object> list = new HashMap<>();
            list.put("facilityId", i.getFacilityId());
            list.put("facilityImage", i.getFacilityImage());
            list.put("facilityName", i.getFacilityName());
            storedData.get(i.getFacilityType()).add(list);
        }
        for(Map.Entry<String, List<Map<String, Object>>> i : storedData.entrySet()){
            Map<String,Object> newObject = new HashMap<>();
            newObject.put("facilityType", i.getKey());
            newObject.put("list",i.getValue());
            newArray.add(newObject);
        }
        return newArray;
    }
}
