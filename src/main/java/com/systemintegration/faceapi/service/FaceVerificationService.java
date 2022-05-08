package com.systemintegration.faceapi.service;

import com.microsoft.azure.cognitiveservices.vision.faceapi.FaceAPI;
import com.microsoft.azure.cognitiveservices.vision.faceapi.FaceAPIManager;
import com.microsoft.azure.cognitiveservices.vision.faceapi.models.AzureRegions;
import com.microsoft.azure.cognitiveservices.vision.faceapi.models.VerifyResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FaceVerificationService {

    @Value("${subscriptionKey}")
    private String subscriptionKey;
    @Value("${computervision.endpoint}")
    private String endpoint;

    final AzureRegions REGION = AzureRegions.EASTUS;

    public ResponseEntity faceDetection(String imagePath1, String imagePath2) {

        FaceAPI faceAPI = Authenticate(subscriptionKey, endpoint);

        return analyzeRemoteImage(faceAPI, imagePath1, imagePath2);

    }

    public FaceAPI Authenticate(String subscriptionKey, String endpoint) {
        return FaceAPIManager.authenticate(REGION, subscriptionKey).withAzureRegion(REGION);
    }

    public ResponseEntity analyzeRemoteImage(FaceAPI faceAPI, String imagePath1, String imagePath2) {

        UUID face1 = faceAPI.faces().detectWithUrl().withUrl(imagePath1).withReturnFaceId(true).execute().stream().findFirst().get().faceId();
        UUID face2 = faceAPI.faces().detectWithUrl().withUrl(imagePath1).withReturnFaceId(true).execute().stream().findFirst().get().faceId();
        VerifyResult verifyResult = faceAPI.faces().verifyFaceToFace(face1, face2);

        return ResponseEntity.ok(verifyResult);
    }
}