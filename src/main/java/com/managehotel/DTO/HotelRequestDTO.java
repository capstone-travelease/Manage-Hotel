package com.managehotel.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
public class HotelRequestDTO {
     @NotBlank
     @NotNull
     private  String hotelName;

     @NotBlank
     @NotNull
     private  String hotelAddress;

     @NotBlank
     @NotNull
     private String hotelCity;

     @NotBlank
     @NotNull
     private String hotelCounty;

     @NotBlank
     @NotBlank
     private String hotelContactNumber;

     @NotBlank
     @NotNull
     private  String hotelEmail;

     @NotBlank
     @NotNull
     private String hotelDescription;

     @NotNull
     private String checkInTime;

     @NotNull
     private String checkOutTime;

     @NotNull
     @NotBlank
     private String cancellationPolicy;

     @NotNull
     @NotBlank
     private String checkInPolicy;

     @NotNull
     @NotBlank
     private String checkOutPolicy;

     @NotNull
     private Integer userId;

     @NotNull
     @NotEmpty
     private List<Integer> facilities;

}
