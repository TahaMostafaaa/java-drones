# java-drones
Java Drones using Spring boot

Pull Dependencies and Run
```cmd
mvn  install
mvn spring-boot:run
```



1. POST Register Drone
    ```http://localhost:8090/api/drone```

2. PUT Load Medication in Drone
    ```http://localhost:8090/api/v1/drones/DRONE-1```

3. GET Available Drones
    ```http://localhost:8090/api/v1/drones/available-drones```

4. GET Drone or Get Drone battery
    ```http://localhost:8090/api/v1/drones/DRONE-1```
    
5. GET All Medications
    ```http://localhost:8090/api/medications/medication-items```

  
