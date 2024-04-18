package com.managehotel.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponeDetailedHotelDTO {
    private Integer code;
    private DetailHotelDTO data;
    private String message;
}
