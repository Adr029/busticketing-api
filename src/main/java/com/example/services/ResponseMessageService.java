package com.example.services;

import com.example.dto.RequestDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResponseMessageService {
    public ResponseEntity<?> createMessage(String message, HttpStatus status) {
        RequestDetails requestDetails = new RequestDetails();
        requestDetails.setMessage(message);
        return ResponseEntity
                .status(status)
                .body(requestDetails);
    }
}
