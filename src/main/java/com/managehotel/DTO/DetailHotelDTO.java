package com.managehotel.DTO;


import lombok.Data;

import java.util.List;

@Data
public class DetailHotelDTO {

    private Integer hotelId;
    private String hotelName;
    private String hotelAddress;
    private String hotelCity;
    private String hotelCountry;
    private String hotelNumber;
    private String hotelDescription;
    private String hotelEmail;
    private String hotelCheckIn;
    private String hotelCheckOut;
    private List<String> hotelImage;

    public List<String> getHotelImage() {
        return hotelImage;
    }

    public void setHotelImage(List<String> hotelImage) {
        this.hotelImage = hotelImage;
    }

    public List<Integer> getHotelFacility() {
        return hotelFacility;
    }

    public void setHotelFacility(List<Integer> hotelFacility) {
        this.hotelFacility = hotelFacility;
    }

    private List<Integer> hotelFacility;

    public DetailHotelDTO(Integer hotelId, String hotelName, String hotelAddress, String hotelCity, String hotelCountry, String hotelNumber, String hotelDescription, String hotelEmail, String hotelCheckIn, String hotelCheckOut) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.hotelCity = hotelCity;
        this.hotelCountry = hotelCountry;
        this.hotelNumber = hotelNumber;
        this.hotelDescription = hotelDescription;
        this.hotelEmail = hotelEmail;
        this.hotelCheckIn = hotelCheckIn;
        this.hotelCheckOut = hotelCheckOut;
    }

    @Override
    public String toString() {
        return "DetailHotelDTO{" +
                "hotelId=" + hotelId +
                ", hotelName='" + hotelName + '\'' +
                ", hotelAddress='" + hotelAddress + '\'' +
                ", hotelCity='" + hotelCity + '\'' +
                ", hotelCountry='" + hotelCountry + '\'' +
                ", hotelNumber='" + hotelNumber + '\'' +
                ", hotelDescription='" + hotelDescription + '\'' +
                ", hotelEmail='" + hotelEmail + '\'' +
                ", hotelCheckIn=" + hotelCheckIn +
                ", hotelCheckOut=" + hotelCheckOut +
                '}';
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

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelCity() {
        return hotelCity;
    }

    public void setHotelCity(String hotelCity) {
        this.hotelCity = hotelCity;
    }

    public String getHotelCountry() {
        return hotelCountry;
    }

    public void setHotelCountry(String hotelCountry) {
        this.hotelCountry = hotelCountry;
    }

    public String getHotelNumber() {
        return hotelNumber;
    }

    public void setHotelNumber(String hotelNumber) {
        this.hotelNumber = hotelNumber;
    }

    public String getHotelDescription() {
        return hotelDescription;
    }

    public void setHotelDescription(String hotelDescription) {
        this.hotelDescription = hotelDescription;
    }

    public String getHotelEmail() {
        return hotelEmail;
    }

    public void setHotelEmail(String hotelEmail) {
        this.hotelEmail = hotelEmail;
    }

    public String getHotelCheckIn() {
        return hotelCheckIn;
    }

    public void setHotelCheckIn(String hotelCheckIn) {
        this.hotelCheckIn = hotelCheckIn;
    }

    public String getHotelCheckOut() {
        return hotelCheckOut;
    }

    public void setHotelCheckOut(String hotelCheckOut) {
        this.hotelCheckOut = hotelCheckOut;
    }

    public DetailHotelDTO() {
    }
}
