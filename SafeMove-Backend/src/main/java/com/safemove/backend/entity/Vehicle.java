package com.safemove.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private Integer id;

    @Column(name = "plate_number", nullable = false, unique = true)
    private String plateNumber;

    @ManyToOne(optional = false)
    @JoinColumn(name = "vehicle_type_id", nullable = false)
    private VehicleType vehicleType;

    @ManyToOne(optional = false)
    @JoinColumn(name = "leader_staff_id", nullable = false)
    private Staff leaderStaff;

    @Column(name = "status", nullable = false)
    private String status;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getPlateNumber() { return plateNumber; }
    public void setPlateNumber(String plateNumber) { this.plateNumber = plateNumber; }
    public VehicleType getVehicleType() { return vehicleType; }
    public void setVehicleType(VehicleType vehicleType) { this.vehicleType = vehicleType; }
    public Staff getLeaderStaff() { return leaderStaff; }
    public void setLeaderStaff(Staff leaderStaff) { this.leaderStaff = leaderStaff; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
