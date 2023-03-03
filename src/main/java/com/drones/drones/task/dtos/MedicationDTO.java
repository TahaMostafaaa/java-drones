package com.drones.drones.task.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicationDTO {

    @JsonProperty
    @NotBlank(message = "Name is mandatory")
    private String name;

    @JsonProperty
    private int weight;

    @JsonProperty
    @Pattern( regexp = "^[a-zA-Z0-9_.-]*$", message="Code can only contain letters, numbers, '-', '_'")
    private String code;

    @JsonProperty
    @NotBlank(message = "Image is mandatory")
    private String image;

    @JsonInclude(Include.NON_NULL)
    private DroneDTO drone;

}
