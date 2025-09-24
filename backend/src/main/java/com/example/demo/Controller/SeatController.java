package com.example.demo.controller;

import com.example.demo.entity.Seat;
import com.example.demo.entity.Employee;
import com.example.demo.repository.SeatRepository;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //REST API Controller 將值轉json給前端
@RequestMapping("/api/seats")
public class SeatController {

    @Autowired
    private SeatRepository seatRepository;// 自動注入SeatRepository實例，可直接呼叫seatRepository存取資料庫

    @Autowired
    private EmployeeRepository employeeRepository;

    // 查詢可用座位 Hibernate自動生成等同於sql SELECT * FROM seat_chart WHERE IS_TAKEN = 0;語句
    @GetMapping("/available")
    public List<Seat> getAvailableSeats() {
        return seatRepository.findByIsTakenFalse();
    }

    @GetMapping("/all")
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    @PostMapping("/assign")
    public Seat assignSeat(@RequestParam Integer empId, @RequestParam Integer seatId) {
        // 找新座位
        Seat newSeat = seatRepository.findById(seatId)
                .orElseThrow(() -> new RuntimeException("Seat not found"));

        if (newSeat.getIsTaken()) {
            throw new RuntimeException("Seat already taken");
        }

        // 找員工
        Employee emp = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // 如果員工原本有座位，釋放舊座位
        if (emp.getFloorSeatSeq() != null) {
            Seat oldSeat = seatRepository.findById(emp.getFloorSeatSeq())
                    .orElse(null);
            if (oldSeat != null) {
                oldSeat.setIsTaken(false);
                seatRepository.save(oldSeat);
            }
        }

        // 更新新座位
        newSeat.setIsTaken(true);
        seatRepository.save(newSeat);

        // 更新員工資料
        emp.setFloorSeatSeq(seatId);
        employeeRepository.save(emp);

        return newSeat;
    }
}