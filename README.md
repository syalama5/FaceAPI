<h1 align="center">Face API</h1>
<h2 align="center">About The Application</h2>
The Azure Face service provides AI algorithms that detect, recognize, and analyze human faces in images.

###  Overview
The Azure Face service provides AI algorithms that detect, recognize, and analyze human faces in images. Facial recognition software is important in many different scenarios, such as identity verification, touchless access control, and face blurring for privacy.<br />
[Additional Resource]https://docs.microsoft.com/en-us/azure/cognitive-services/face/overview 

### Face Detection and Attributes
Detect human faces in an image, return face rectangles, and optionally with faceIds, landmarks, and attributes.
Optional parameters include faceId, landmarks, and attributes. Attributes include age, gender, headPose, smile, facialHair, glasses, emotion, hair, makeup, occlusion, accessories, blur, exposure, noise, mask, and qualityForRecognition. Some of the results returned for specific attributes may not be highly accurate.
[Additional resources]https://westus.dev.cognitive.microsoft.com/docs/services/563879b61984550e40cbbe8d/operations/563879b61984550f30395236
https://docs.microsoft.com/en-us/azure/cognitive-services/face/concepts/face-detection

### Face Recognition
Verification is one-to-one matching that takes two faces and returns whether they are the same face, and identification is one-to-many matching that takes a single face as input and returns a set of matching candidates. Face recognition is important in implementing the identity verification scenario, which enterprises and apps can use to verify that a (remote) user is who they claim to be.
[Additional resources] https://docs.microsoft.com/en-us/azure/cognitive-services/face/concepts/face-recognition

### Architecture:
![Architecture](images/![img_1.png]) <br/>


## How to use API
- Command line (example: curl -X 'GET' \
  'http://137.184.143.79:8080/computer-vision-api/analyzeImageWithPath?imagePath=<imagepath>')
- Swagger Interface <details><summary>Click to expand!</summary> ![swagger page](images/img.png) </details>


## Application Swagger link
[Face API Swagger link](http://159.89.52.132:8080/face-api/swagger-ui/index.html#/face-api-controller/analyzeOCRWithPath)
<details>
  <summary>Click to expand!</summary>

![swagger page](images/swaggerr)

</details>

## Run Application Locally
Clone the project
```bash
  git clone https://github.com/syalama5/FaceAPI
```
Go to the project directory
```bash
  cd FaceAPI
```
Start the server

```bash
  ./gradlew bootRun
```
## Application Tech Stack
- JAVA
- Spring Boot
- Gradle

## Troubleshooting & FAQ
- If Java is Not installed on system </br>
  [Install Java](https://www.java.com/en/download/help/download_options.html) <br />

## Authors

- [@syalama5](https://github.com/syalama5)
## Support
For support, email syalama5@uncc.edu
