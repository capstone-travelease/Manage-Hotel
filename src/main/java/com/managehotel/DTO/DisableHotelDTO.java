package com.managehotel.DTO;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DisableHotelDTO {

    @NotNull
    private Integer hotelId;
    @NotNull
    private Integer status;
}
