package com.example.controller;

import com.example.model.AvailableTrip;
import com.example.model.ReservedTrip;
import com.example.services.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    //! TEST METHODS
    @GetMapping("/test")
    public List<AvailableTrip> displayAll() {
        return testService.displayAllTest();
    }


    @GetMapping("/testreserve")
    public List<ReservedTrip> displayAllReserved() {
        return testService.displayAllTestReserved();
    }


}
