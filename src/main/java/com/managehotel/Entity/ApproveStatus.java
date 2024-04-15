package com.managehotel.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "ApproveStatus")
@Table(name = "approve_status")
public class ApproveStatus {
    @Id
    private Integer status_id;
    private String status_name;


}
