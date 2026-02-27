package com.safemove.backend.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Price_Table")
public class PriceTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_id")
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "service_id", nullable = false)
    private MoveService service;

    @Column(name = "min_distance_km", nullable = false)
    private Integer minDistanceKm;

    @Column(name = "max_distance_km", nullable = false)
    private Integer maxDistanceKm;

    @Column(name = "price_per_km", nullable = false)
    private BigDecimal pricePerKm;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public MoveService getService() { return service; }
    public void setService(MoveService service) { this.service = service; }
    public Integer getMinDistanceKm() { return minDistanceKm; }
    public void setMinDistanceKm(Integer minDistanceKm) { this.minDistanceKm = minDistanceKm; }
    public Integer getMaxDistanceKm() { return maxDistanceKm; }
    public void setMaxDistanceKm(Integer maxDistanceKm) { this.maxDistanceKm = maxDistanceKm; }
    public BigDecimal getPricePerKm() { return pricePerKm; }
    public void setPricePerKm(BigDecimal pricePerKm) { this.pricePerKm = pricePerKm; }
}
