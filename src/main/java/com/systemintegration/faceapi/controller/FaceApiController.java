package com.systemintegration.faceapi.controller;

import com.systemintegration.faceapi.service.FaceDetectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FaceApiController {

    private FaceDetectionService faceDetectionService;

    public FaceApiController(FaceDetectionService faceDetectionService) {
        this.faceDetectionService = faceDetectionService;
    }

    @GetMapping("/faceDetection")
    public ResponseEntity analyzeOCRWithPath(String imagePath) {
        return faceDetectionService.faceDetection(imagePath, null);
    }
}
