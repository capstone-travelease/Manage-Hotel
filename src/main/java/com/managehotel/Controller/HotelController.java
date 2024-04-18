package com.managehotel.Controller;


import com.managehotel.DTO.*;
import com.managehotel.Service.HotelService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/partner/api")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/hotels")
    public ResponeHotelDTO listHotel(@RequestParam("userId") Integer userId, HttpServletResponse response){
        return new ResponeHotelDTO(response.getStatus(),hotelService.getListHotel(userId),"OK");
    }


    @GetMapping("/hotels/detail")
    public ResponeDetailedHotelDTO getDetailedHotels(@RequestParam("hotelId") Integer hotelId,HttpServletResponse response){
        return new ResponeDetailedHotelDTO(response.getStatus(),hotelService.getdetailedHotel(hotelId),"OK");
    }
    @GetMapping("/facilites")
    public ResponeFacilitiesDTO listFacilities(HttpServletResponse response){
        return new ResponeFacilitiesDTO(response.getStatus(),hotelService.getListFacilties(),"OK");
    }

    @PostMapping("/hotels")
    public ResponeDTO addNewHotel(@RequestBody @Valid HotelRequestDTO hotels, HttpServletResponse response){
        Integer codeStatus = hotelService.addNewHotel(hotels);
        if (codeStatus == 500){
            response.setStatus(codeStatus);
            return new ResponeDTO(codeStatus,null,"");
        }
        return new ResponeDTO(200,codeStatus,"OK");
    }

    @PostMapping("/hotels/image")
    public ResponeDTO uploadHotelImages(@RequestParam("image") List<MultipartFile> image,@RequestParam("hotelId") Integer hotelId,HttpServletResponse response) throws IOException {
        boolean ischeckError = hotelService.uploadImageToFile(image,hotelId);
        return new ResponeDTO(200,null,"OK");
    }


    @PutMapping("/hotels")
    public ResponeDTO updateHotel(@RequestParam("hotelId") Integer hotelId, @RequestBody @Valid HotelUpdateDTO hotel ,HttpServletResponse response){
        Integer httpCode = hotelService.updateHotel(hotel, hotelId);
        if(httpCode == HttpServletResponse.SC_INTERNAL_SERVER_ERROR){
            response.setStatus(httpCode);
            return new ResponeDTO(response.getStatus(),null,"Internal Server Error");
        }
        return new ResponeDTO(response.getStatus(),null,"OK");
    }


    @DeleteMapping("/hotels")
    public ResponeDTO disableHotel(@RequestBody @Valid DisableHotelDTO hotel){
        boolean isCheckError = hotelService.disableHotel(hotel.getHotelId(),hotel.getStatus());
        return new ResponeDTO(200,null,"OK");
    }
}
