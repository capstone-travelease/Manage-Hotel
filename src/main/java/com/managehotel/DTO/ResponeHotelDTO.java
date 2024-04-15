package com.managehotel.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class ResponeHotelDTO  {
    private Integer code;
    private List<ListHotelDTO> list;
    private String message;
}
