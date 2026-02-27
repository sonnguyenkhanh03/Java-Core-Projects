package com.safemove.backend.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Survey_Request")
public class SurveyRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "service_id", nullable = false)
    private MoveService service;

    @Column(name = "pickup_address", nullable = false)
    private String pickupAddress;

    @Column(name = "destination_address", nullable = false)
    private String destinationAddress;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "num_staff", nullable = false)
    private Integer numStaff;

    @Column(name = "estimated_price")
    private BigDecimal estimatedPrice;

    @Column(name = "estimated_distance_km")
    private Integer estimatedDistanceKm;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "created_date", insertable = false, updatable = false)
    private LocalDateTime createdDate;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public MoveService getService() { return service; }
    public void setService(MoveService service) { this.service = service; }
    public String getPickupAddress() { return pickupAddress; }
    public void setPickupAddress(String pickupAddress) { this.pickupAddress = pickupAddress; }
    public String getDestinationAddress() { return destinationAddress; }
    public void setDestinationAddress(String destinationAddress) { this.destinationAddress = destinationAddress; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public Integer getNumStaff() { return numStaff; }
    public void setNumStaff(Integer numStaff) { this.numStaff = numStaff; }
    public BigDecimal getEstimatedPrice() { return estimatedPrice; }
    public void setEstimatedPrice(BigDecimal estimatedPrice) { this.estimatedPrice = estimatedPrice; }
    public Integer getEstimatedDistanceKm() { return estimatedDistanceKm; }
    public void setEstimatedDistanceKm(Integer estimatedDistanceKm) { this.estimatedDistanceKm = estimatedDistanceKm; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getCreatedDate() { return createdDate; }
}
