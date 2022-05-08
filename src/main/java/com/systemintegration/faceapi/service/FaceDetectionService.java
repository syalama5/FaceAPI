package com.systemintegration.faceapi.service;

import com.microsoft.azure.cognitiveservices.vision.faceapi.FaceAPI;
import com.microsoft.azure.cognitiveservices.vision.faceapi.FaceAPIManager;
import com.microsoft.azure.cognitiveservices.vision.faceapi.models.AzureRegions;
import com.microsoft.azure.cognitiveservices.vision.faceapi.models.DetectedFace;
import com.microsoft.azure.cognitiveservices.vision.faceapi.models.FaceAttributeType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class FaceDetectionService {

    @Value("${subscriptionKey}")
    private String subscriptionKey;
    @Value("${computervision.endpoint}")
    private String endpoint;

    final AzureRegions REGION = AzureRegions.EASTUS;

    public ResponseEntity faceDetection(String imagePath, MultipartFile imageFile){

        FaceAPI faceAPI = Authenticate(subscriptionKey, endpoint);

        return  analyzeRemoteImage(faceAPI,imagePath,imageFile);

    }

    public FaceAPI Authenticate(String subscriptionKey, String endpoint){
        return FaceAPIManager.authenticate(REGION, subscriptionKey).withAzureRegion(REGION);
    }

    public ResponseEntity analyzeRemoteImage(FaceAPI faceAPI, String imagePath, MultipartFile imageFile) {

        List<FaceAttributeType> faceAttributes = new ArrayList<>();
        faceAttributes.add(FaceAttributeType.AGE);
        faceAttributes.add(FaceAttributeType.GENDER);
        faceAttributes.add(FaceAttributeType.HEAD_POSE);
        faceAttributes.add(FaceAttributeType.HAIR);
        faceAttributes.add(FaceAttributeType.FACIAL_HAIR);
        faceAttributes.add(FaceAttributeType.SMILE);
        List<DetectedFace> detectedFaces = faceAPI.faces().detectWithUrl().withUrl(imagePath).withReturnFaceAttributes(faceAttributes).execute();

        return ResponseEntity.ok(detectedFaces);
    }

}
