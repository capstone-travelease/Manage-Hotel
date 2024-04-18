package com.managehotel.Service;


import com.managehotel.DTO.*;
import com.managehotel.Entity.Hotels;
import com.managehotel.Repository.HotelRepository;
import com.managehotel.Utils.SortData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    private final SortData sortData;

    // folder path
    private final String FOLDER_PATH = "/images/";
    @Autowired
    public HotelService(HotelRepository hotelRepository, SortData sortData) {
        this.hotelRepository = hotelRepository;
        this.sortData = sortData;
    }

    public DetailHotelDTO getdetailedHotel(Integer hotelId){
        DetailHotelDTO hotelData = hotelRepository.getDetailedHotel(hotelId);
        List<String> hotelImage = hotelRepository.getUrlPath(hotelId);
        List<Integer> hotelFacilites = hotelRepository.listHotelFacilites(hotelId);
        hotelData.setHotelImage(hotelImage);
        hotelData.setHotelFacility(hotelFacilites);
        return hotelData;
    }
    public List<ListHotelDTO> getListHotel(Integer userId){
          List<ListHotelDTO> hotelData = hotelRepository.getListHotel(userId);
          for (ListHotelDTO i : hotelData){
              List<String> img = hotelRepository.getUrlPath(i.getHotelId());
              i.setUrlPath(img);
          }
          return hotelData;
    }

    public Integer updateHotelImage(List<MultipartFile> image, Integer hotelId){
        try {
            Integer attachmentId = hotelRepository.removeHotelAttacment(hotelId);
            hotelRepository.removeAttacment(attachmentId);
            uploadImageToFile(image,hotelId);
            return 200;
        }catch (Exception ex){
            System.err.println(ex);
            return 500;
        }

    }

    public Integer updateHotel(HotelUpdateDTO hotel, Integer hotelId){
        System.out.println(hotelId);
        try {
            hotelRepository.updateHotel(
                    hotelId,
                    hotel.getHotelName(),
                    hotel.getHotelAddress(),
                    hotel.getHotelCity(),
                    hotel.getHotelCounty(),
                    hotel.getHotelContactNumber(),
                    hotel.getHotelEmail(),
                    hotel.getHotelDescription(),
                    hotel.getCheckInTime(),
                    hotel.getCheckOutTime()
            );
            hotelRepository.removeFacilities(hotelId);
            boolean checkIsErrorUpdateFacility = addHotelFacilities(hotel.getFacilities(),hotelId);
            if(!checkIsErrorUpdateFacility){
                return 500;
            }
            return 200;
        }catch (Exception ex){
            System.out.println(ex);
            return 500;
        }
    }
    public List<Object> getListFacilties(){
        List<ListFacilitiesDTO> facilityData = hotelRepository.getListFacilities();
        List<Object> storedData =  sortData.dataSort(facilityData);
        return storedData;
    }


    public Integer addNewHotel(HotelRequestDTO hotels){
        try {
            Integer newHotelId = hotelRepository.insertHotel(
                    hotels.getHotelName(),
                    hotels.getHotelAddress(),
                    hotels.getHotelCity(),
                    hotels.getHotelCounty(),
                    hotels.getHotelContactNumber(),
                    hotels.getHotelEmail(),
                    hotels.getHotelDescription(),
                    hotels.getCheckInTime(),
                    2,
                    hotels.getCheckOutTime(),
                    hotels.getUserId());
            boolean isCheckErrorPolicy = addNewHotelPolicy(hotels.getCancellationPolicy(),hotels.getCheckInPolicy(),hotels.getCheckOutPolicy(),newHotelId);
            boolean isCheckErrorFacility = addHotelFacilities(hotels.getFacilities(),newHotelId);
            if(!isCheckErrorPolicy || !isCheckErrorFacility){
                return 500;
            }
            return newHotelId;
        }catch (Exception ex){
            System.err.println(ex);
            return 500;
        }
    }

    private boolean addNewHotelPolicy(String cancel, String checkInPolicy, String checkOutPolicy, Integer newHotelId){
          try {
               hotelRepository.insertPolicies(newHotelId,cancel,checkInPolicy,checkOutPolicy);
               return true;
          }catch (Exception ex){
                 return false;
          }
    }
    
    private boolean addHotelFacilities(List<Integer> facilitiesId, Integer newHotelId){
        try {
           for(Integer i : facilitiesId){
                   hotelRepository.insertHotelFacilities(newHotelId, i);
           }
           return true;
        } catch (Exception exception){
            System.err.println(exception);
            return false;
        }
    }


    // the function is used to upload in local system
    public boolean uploadImageToFile(List<MultipartFile> image, Integer hotelId)  {
        try {
            for (MultipartFile i: image) {
                String fileUrl = FOLDER_PATH+i.getOriginalFilename();
                // tranfer from data of api to folder
                i.transferTo(new File(fileUrl));
                String imageUrl = "/hotel_images/" + i.getOriginalFilename();
                Integer attachmentId = hotelRepository.insertImage(new Date(),imageUrl);
                boolean isCheckErrImage = insertImage(attachmentId,hotelId);
            }
            // the path of folder has existed in local
            return true;
        }catch (Exception ex){
            System.err.println(ex);
            return false;
        }

    }

    private boolean insertImage(Integer attachmentId, Integer hotelId){
          try {
            hotelRepository.addHotelImage(hotelId,attachmentId);
            return true;
          }catch (Exception ex){
              System.err.println(ex);
              return false;
          }
    }
    public boolean disableHotel(Integer hotelId, Integer status){
        try {
           hotelRepository.disableHotel(hotelId,status);
           return true;
        }catch (Exception exception){
           System.err.println(exception);
           return false;
        }
    }

}
