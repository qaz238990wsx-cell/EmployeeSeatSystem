package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SeatChart")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FLOOR_SEAT_SEQ")
    private Integer floorSeatSeq;

    @Column(name = "FLOOR_NO")
    private Integer floorNo;

    @Column(name = "SEAT_NO")
    private String seatNo;

    @Column(name = "IS_TAKEN")
    private Boolean isTaken;

    // Getter / Setter
    public Integer getFloorSeatSeq() { return floorSeatSeq; }
    public void setFloorSeatSeq(Integer floorSeatSeq) { this.floorSeatSeq = floorSeatSeq; }

    public Integer getFloorNo() { return floorNo; }
    public void setFloorNo(Integer floorNo) { this.floorNo = floorNo; }

    public String getSeatNo() { return seatNo; }
    public void setSeatNo(String seatNo) { this.seatNo = seatNo; }

    public Boolean getIsTaken() { return isTaken; }
    public void setIsTaken(Boolean isTaken) { this.isTaken = isTaken; }
}