package com.drones.drones.task.dtos;

import com.drones.drones.task.constants.enums.Model;
import com.drones.drones.task.constants.enums.State;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DroneDTO {

    @JsonProperty
    @NotBlank(message = "Serial Number is mandatory")
    private String serialNumber;

    @JsonProperty
    private Model model;

    @JsonProperty
    @Range(min=1, max=500, message = "Weight must be in the range of 1 to 500")
    private int weightLimit;

    @JsonProperty
    @Range(min=0, max=100, message = "Battery Capacity must be in the range of 0 to 100")
    private int batteryCapacity;

    @JsonProperty
    private State state;

    // @JsonInclude(Include.NON_EMPTY)
    @JsonInclude(Include.NON_NULL)
    private List<MedicationDTO> medications;

}
