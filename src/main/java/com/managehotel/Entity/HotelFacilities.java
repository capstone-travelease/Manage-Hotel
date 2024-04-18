package com.managehotel.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "hotel_facilities")
public class HotelFacilities {
    private Integer id_hotel;
    private Integer id_facility;

    @Id
    private Integer hotel_facilities_id;

    public HotelFacilities() {
    }

    public HotelFacilities(Integer id_hotel, Integer id_facility, Integer hotel_facilities_id) {
        this.id_hotel = id_hotel;
        this.id_facility = id_facility;
        this.hotel_facilities_id = hotel_facilities_id;
    }

    public Integer getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(Integer id_hotel) {
        this.id_hotel = id_hotel;
    }

    public Integer getId_facility() {
        return id_facility;
    }

    public void setId_facility(Integer id_facility) {
        this.id_facility = id_facility;
    }

    public Integer getHotel_facilities_id() {
        return hotel_facilities_id;
    }

    public void setHotel_facilities_id(Integer hotel_facilities_id) {
        this.hotel_facilities_id = hotel_facilities_id;
    }

    @Override
    public String toString() {
        return "HotelFacilities{" +
                "id_hotel=" + id_hotel +
                ", id_facility=" + id_facility +
                ", hotel_facilities_id=" + hotel_facilities_id +
                '}';
    }
}
