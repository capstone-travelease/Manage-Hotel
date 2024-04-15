package com.managehotel.DTO;


import lombok.Data;

import java.util.List;

@Data
public class ListHotelDTO {
    private Integer hotelId;
    private String hotelName;
    private String hotelPhone;
    private String hotelAddress;
    private Integer statusId;
    private String statusName;

    public List<String> getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(List<String> urlPath) {
        this.urlPath = urlPath;
    }

    private List<String> urlPath;

    public ListHotelDTO() {
    }

    public ListHotelDTO(Integer hotelId, String hotelName, String hotelPhone, String hotelAddress, Integer statusId, String statusName) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelPhone = hotelPhone;
        this.hotelAddress = hotelAddress;
        this.statusId = statusId;
        this.statusName = statusName;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelPhone() {
        return hotelPhone;
    }

    public void setHotelPhone(String hotelPhone) {
        this.hotelPhone = hotelPhone;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }




    @Override
    public String toString() {
        return "ListHotelDTO{" +
                "hotelId=" + hotelId +
                ", hotelName='" + hotelName + '\'' +
                ", hotelPhone='" + hotelPhone + '\'' +
                ", hotelAddress='" + hotelAddress + '\'' +
                ", statusId=" + statusId +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}
