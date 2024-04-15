package com.managehotel.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor
public class ResponeDTO {
    private Integer code;
    private Integer hotelId;
    private String message;
}
