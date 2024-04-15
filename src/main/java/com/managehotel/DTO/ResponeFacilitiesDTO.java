package com.managehotel.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
public class ResponeFacilitiesDTO {
   private Integer code;
   private List<Object> list;
   private String message;

}
