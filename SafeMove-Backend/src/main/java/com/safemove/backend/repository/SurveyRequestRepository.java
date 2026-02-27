package com.safemove.backend.repository;

import com.safemove.backend.entity.SurveyRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRequestRepository extends JpaRepository<SurveyRequest, Integer> {
}
