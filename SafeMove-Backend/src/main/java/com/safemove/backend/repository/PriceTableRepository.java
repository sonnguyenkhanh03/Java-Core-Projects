package com.safemove.backend.repository;

import com.safemove.backend.entity.PriceTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PriceTableRepository extends JpaRepository<PriceTable, Integer> {
    Optional<PriceTable> findFirstByServiceIdAndMinDistanceKmLessThanEqualAndMaxDistanceKmGreaterThanEqual(
            Integer serviceId, Integer minDistanceKm, Integer maxDistanceKm);
}
