package com.example.demo.entity;

import jakarta.persistence.*;//JPA（Java Persistence API）套件,定義ORM(Object-Relational Mapping)的規則

@Entity
@Table(name = "EmployeeData")//資料表名稱
public class Employee {

    @Id //主鍵
    @GeneratedValue(strategy = GenerationType.IDENTITY) //主鍵是否自動生成
    @Column(name = "EMP_ID") //對應的資料表column
    private Integer empId;

    @Column(name = "NAME")
    private String empName;

    @Column(name = "EMAIL")
    private String empEmail;

    @Column(name = "FLOOR_SEAT_SEQ")
    private Integer floorSeatSeq; // 外鍵 (對應 SeatChart table)

    // Getter / Setter
    public Integer getEmpId() { return empId; }
    public void setEmpId(Integer empId) { this.empId = empId; }

    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }

    public String getEmpEmail() { return empEmail; }
    public void setEmpEmail(String empEmail) { this.empEmail = empEmail; }

    public Integer getFloorSeatSeq() { return floorSeatSeq; }
    public void setFloorSeatSeq(Integer floorSeatSeq) { this.floorSeatSeq = floorSeatSeq; }
}