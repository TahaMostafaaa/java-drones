# java-drones
Java Drones using Spring boot

Duration: 3 days

Pull Dependencies and Run
```cmd
mvn  install
mvn spring-boot:run
```



1. POST Register Drone
    ```http://localhost:8090/api/drone```

2. PUT Load Medication in Drone
    ```http://localhost:8090/api/v1/drones/load-medication/DRONE-1```

3. GET Available Drones
    ```http://localhost:8090/api/v1/drones/available-drones```

4. GET Drone or Get Drone battery
    ```http://localhost:8090/api/v1/drones/DRONE-1```
    
5. GET All Medications
    ```http://localhost:8090/api/medications/medication-items```
    
    
# Swagger URL
    ```http://localhost:8090/swagger-ui/index.html#/```
    
<img width="1440" alt="Screenshot 2023-03-03 at 10 26 36 PM" src="https://user-images.githubusercontent.com/12519065/222823090-71afd540-f666-46c5-a43c-b71821aa2f00.png">


# Screen Shots with output and json format data



<img width="1440" alt="Screenshot 2023-03-03 at 8 11 08 PM" src="https://user-images.githubusercontent.com/12519065/222796190-145f1e5d-936e-42c7-a9b1-2a8b5688e68e.png">
<img width="1440" alt="Screenshot 2023-03-03 at 8 10 43 PM" src="https://user-images.githubusercontent.com/12519065/222796192-53a1f5af-c613-4885-9d33-84766b59f212.png">
<img width="1440" alt="Screenshot 2023-03-03 at 8 08 15 PM" src="https://user-images.githubusercontent.com/12519065/222796198-fcca8614-a4c9-48c2-abf3-e99d6d532e48.png">
<img width="1440" alt="Screenshot 2023-03-03 at 8 11 49 PM" src="https://user-images.githubusercontent.com/12519065/222796181-9885da1e-33f0-4265-9cd2-f0dda641b7a9.png">

