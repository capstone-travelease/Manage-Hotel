package com.managehotel.Entity;


import jakarta.persistence.*;


@Entity
@Table
public class Hotels {
    @Id
    @SequenceGenerator(
            name = "hotels_hotel_id_seq",
            sequenceName = "hotels_hotel_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "hotels_hotel_id_seq"
    )
    private Integer hotel_id;
    private String hotel_name;
    private String hotel_address;
    private String hotel_city;
    private String hotel_country;
    private String hotel_contact_number;
    private String hotel_email;
    private String hotel_description;
    private Double star_rating;
    private String check_in_time;
    private String check_out_time;
    private Integer approve_status;
    private Integer owner_id;

    public Hotels() {
    }

    public Hotels(Integer hotel_id, String hotel_name, String hotel_address, String hotel_city, String hotel_country, String hotel_contact_number, String hotel_email, String hotel_description, Double star_rating, String check_in_time, String check_out_time, Integer approve_status, Integer owner_id) {
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.hotel_address = hotel_address;
        this.hotel_city = hotel_city;
        this.hotel_country = hotel_country;
        this.hotel_contact_number = hotel_contact_number;
        this.hotel_email = hotel_email;
        this.hotel_description = hotel_description;
        this.star_rating = star_rating;
        this.check_in_time = check_in_time;
        this.check_out_time = check_out_time;
        this.approve_status = approve_status;
        this.owner_id = owner_id;
    }

    public Integer getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Integer hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_address() {
        return hotel_address;
    }

    public void setHotel_address(String hotel_address) {
        this.hotel_address = hotel_address;
    }

    public String getHotel_city() {
        return hotel_city;
    }

    public void setHotel_city(String hotel_city) {
        this.hotel_city = hotel_city;
    }

    public String getHotel_country() {
        return hotel_country;
    }

    public void setHotel_country(String hotel_country) {
        this.hotel_country = hotel_country;
    }

    public String getHotel_contact_number() {
        return hotel_contact_number;
    }

    public void setHotel_contact_number(String hotel_contact_number) {
        this.hotel_contact_number = hotel_contact_number;
    }

    public String getHotel_email() {
        return hotel_email;
    }

    public void setHotel_email(String hotel_email) {
        this.hotel_email = hotel_email;
    }

    public String getHotel_description() {
        return hotel_description;
    }

    public void setHotel_description(String hotel_description) {
        this.hotel_description = hotel_description;
    }

    public Double getStar_rating() {
        return star_rating;
    }

    public void setStar_rating(Double star_rating) {
        this.star_rating = star_rating;
    }

    public String getCheck_in_time() {
        return check_in_time;
    }

    public void setCheck_in_time(String check_in_time) {
        this.check_in_time = check_in_time;
    }

    public String getCheck_out_time() {
        return check_out_time;
    }

    public void setCheck_out_time(String check_out_time) {
        this.check_out_time = check_out_time;
    }

    public Integer getApprove_status() {
        return approve_status;
    }

    public void setApprove_status(Integer approve_status) {
        this.approve_status = approve_status;
    }

    public Integer getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }

    @Override
    public String toString() {
        return "Hotels{" +
                "hotel_id=" + hotel_id +
                ", hotel_name='" + hotel_name + '\'' +
                ", hotel_address='" + hotel_address + '\'' +
                ", hotel_city='" + hotel_city + '\'' +
                ", hotel_country='" + hotel_country + '\'' +
                ", hotel_contact_number='" + hotel_contact_number + '\'' +
                ", hotel_email='" + hotel_email + '\'' +
                ", hotel_description='" + hotel_description + '\'' +
                ", star_rating=" + star_rating +
                ", check_in_time=" + check_in_time +
                ", check_out_time=" + check_out_time +
                ", approve_status=" + approve_status +
                ", owner_id=" + owner_id +
                '}';
    }
}
