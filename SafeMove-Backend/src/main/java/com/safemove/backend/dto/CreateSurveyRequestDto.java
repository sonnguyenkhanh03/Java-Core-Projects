package com.safemove.backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class CreateSurveyRequestDto {
    @NotNull
    private Integer customerId;
    @NotNull
    private Integer serviceId;
    @NotBlank
    private String pickupAddress;
    @NotBlank
    private String destinationAddress;
    @NotNull
    private LocalDate startDate;
    @NotNull
    @Min(1)
    private Integer numStaff;
    @NotNull
    @Min(1)
    private Integer estimatedDistanceKm;

    public Integer getCustomerId() { return customerId; }
    public void setCustomerId(Integer customerId) { this.customerId = customerId; }
    public Integer getServiceId() { return serviceId; }
    public void setServiceId(Integer serviceId) { this.serviceId = serviceId; }
    public String getPickupAddress() { return pickupAddress; }
    public void setPickupAddress(String pickupAddress) { this.pickupAddress = pickupAddress; }
    public String getDestinationAddress() { return destinationAddress; }
    public void setDestinationAddress(String destinationAddress) { this.destinationAddress = destinationAddress; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public Integer getNumStaff() { return numStaff; }
    public void setNumStaff(Integer numStaff) { this.numStaff = numStaff; }
    public Integer getEstimatedDistanceKm() { return estimatedDistanceKm; }
    public void setEstimatedDistanceKm(Integer estimatedDistanceKm) { this.estimatedDistanceKm = estimatedDistanceKm; }
}
