package com.managehotel.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ListFacilitiesDTO {
    private Integer facilityId;
    private String facilityName;
    private String facilityType;
    private String facilityImage;

}
