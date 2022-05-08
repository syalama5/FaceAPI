package com.systemintegration.faceapi.controller;

import com.systemintegration.faceapi.service.FaceDetectionService;
import com.systemintegration.faceapi.service.FaceVerificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FaceApiController {

    private FaceDetectionService faceDetectionService;

    private FaceVerificationService faceVerificationService;

    public FaceApiController(FaceVerificationService faceVerificationService, FaceDetectionService faceDetectionService) {
        this.faceVerificationService = faceVerificationService;
        this.faceDetectionService = faceDetectionService;
    }

    @GetMapping("/faceDetection")
    public ResponseEntity analyzeOCRWithPath(String imagePath) {
        return faceDetectionService.faceDetection(imagePath, null);
    }

    @GetMapping("/faceVerification")
    public ResponseEntity analyzeOCRWithPath(String imagePath1, String imagePath2) {
        return faceVerificationService.faceDetection(imagePath1, imagePath2);
    }
}