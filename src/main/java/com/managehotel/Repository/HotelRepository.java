package com.managehotel.Repository;

import com.managehotel.DTO.DetailHotelDTO;
import com.managehotel.DTO.ListFacilitiesDTO;
import com.managehotel.DTO.ListHotelDTO;
import com.managehotel.Entity.Hotels;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotels, Integer> {

    @Query("SELECT new com.managehotel.DTO.ListHotelDTO(h.hotel_id, h.hotel_name, h.hotel_contact_number, h.hotel_address,s.status_id,s.status_name)\n" +
            "FROM Hotels h\n" +
            "INNER JOIN ApproveStatus s ON s.status_id = h.approve_status\n" +
            "INNER JOIN Users u ON u.user_id = h.owner_id\n" +
            "WHERE u.user_id = ?1")
    List<ListHotelDTO> getListHotel(Integer userId);

    @Query("Select new com.managehotel.DTO.DetailHotelDTO(h.hotel_id, h.hotel_name, h.hotel_address, h.hotel_city, h.hotel_country, h.hotel_contact_number, \n" +
            "\th.hotel_description, h.hotel_email, h.check_in_time, h.check_out_time) from Hotels h Where h.hotel_id = ?1")
    DetailHotelDTO getDetailedHotel(Integer hotelId);

    @Query("SELECT a.file_url\n" +
            "\tFROM Hotels h\n" +
            "INNER JOIN HotelAttachment ha ON ha.hotel_id = h.hotel_id\n" +
            "INNER JOIN Attachment a ON a.attachment_id = ha.attachment_id\n" +
            "WHERE h.hotel_id = ?1")
    List<String> getUrlPath(Integer hotelId);


    @Query("select hf.id_facility from HotelFacilities hf\n" +
            "where hf.id_hotel = ?1")
    List<Integer> listHotelFacilites(Integer hotelId);

    @Query("SELECT new com.managehotel.DTO.ListFacilitiesDTO(f.facility_id,f.facility_name,ft.facility_type_name,f.facility_image) FROM Facilities f\n" +
            "inner join FacilityType ft on ft.facility_type_id = f.facility_type\n" +
            "ORDER BY f.facility_id ASC ")
    List<ListFacilitiesDTO> getListFacilities();


    @Query(value = "INSERT INTO public.hotels(\n" +
            "hotel_name, hotel_address, hotel_city, hotel_country, hotel_contact_number, hotel_email, hotel_description, check_in_time, approve_status, check_out_time, owner_id)\n" +
            "VALUES ( ?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11) RETURNING hotel_id",nativeQuery = true)
    Integer insertHotel(String hotelName, String hotelAddress,String hotelCity ,String hotelCountry, String hotelContactNumber, String hotelEmail, String hotelDescription, String checkInTime,  Integer status, String checkOutTime, Integer userId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM public.hotel_facilities hf\n" +
            "\tWHERE hf.id_hotel = ?1;",nativeQuery = true)
    void removeFacilities(Integer hotelId);


    @Transactional
    @Modifying
    @Query(value = "UPDATE public.hotels\n" +
            "\tSET hotel_name=?2, hotel_address=?3, hotel_city=?4, hotel_country=?5, hotel_contact_number=?6, hotel_email=?7, hotel_description=?8, check_in_time=?9, check_out_time=?10\n" +
            "\tWHERE hotel_id = ?1",nativeQuery = true)
    void  updateHotel(Integer hotelId, String hotelName, String hotelAddress, String hotelCity, String hotelCountry, String hotelPhone, String hotelEmail, String hotelDescription, String checkInTime, String checkOutTime);


    @Transactional
    @Modifying
    @Query(value = "INSERT INTO public.policies(\n" +
            "\t hotel_id, cancellation_policy, check_in_policy, check_out_policy)\n" +
            "\tVALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    void insertPolicies(Integer hotelId, String cancel,String checkIn , String checkOut);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO public.hotel_facilities(\n" +
            "\tid_hotel, id_facility)\n" +
            "\tVALUES (?1, ?2);",nativeQuery = true)
    void insertHotelFacilities(Integer hotelId, Integer facilityId);

    @Query(value = "INSERT INTO public.attachment(\n" +
            "\t upload_at, file_url)\n" +
            "\tVALUES (?1, ?2) returning attachment_id",nativeQuery = true)
    Integer insertImage(Date uploadAt, String fileUrl);

    @Query(value = "DELETE FROM public.hotel_attachment\n" +
            "\tWHERE hotel_id = ?1 returning attachment_id",nativeQuery = true)
    Integer removeHotelAttacment(Integer hotelId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM public.attachment\n" +
            "\tWHERE attachment_id = ?1",nativeQuery = true)
    void removeAttacment(Integer attachmentId);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO public.hotel_attachment(\n" +
            "\tattachment_id, hotel_id)\n" +
            "\tVALUES (?2, ?1);",nativeQuery = true)
    void addHotelImage(Integer hotelId, Integer attachmentId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE public.hotels\n" +
            "\tSET  approve_status=?2\n" +
            "\tWHERE hotels.hotel_id = ?1",nativeQuery = true)
    void disableHotel(Integer hotelId,Integer status);
}
