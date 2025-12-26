package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room-assignments")
public class RoomAssignmentController {

    @GetMapping("/health")
    public String healthCheck() {
        return "Room Assignment Controller is running";
    }
}
