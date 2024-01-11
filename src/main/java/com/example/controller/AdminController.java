package com.example.controller;

import com.example.model.AvailableTrip;
import com.example.model.ReservedTrip;
import com.example.services.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {

    private final AdminService adminService;


    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @GetMapping("/admin/login")
    public void adminLogin(
            @RequestParam String username,
            @RequestParam String password
    ) {
        adminService.validateAdminCredentials(username, password);
    }

    @GetMapping("/admin/logout")
    public void adminLogout() {
        adminService.logOut();
    }

    @GetMapping("/admin/displaytrips")
    public List<AvailableTrip> displayAll() {
        return adminService.displayAllTrips();
    }


    @GetMapping("/admin/displayreservations")
    public List<ReservedTrip> displayAllReserved() {
        return adminService.displayAllReservations();
    }


}
