package com.safemove.backend.controller;

import com.safemove.backend.dto.CreateSurveyRequestDto;
import com.safemove.backend.entity.SurveyRequest;
import com.safemove.backend.repository.SurveyRequestRepository;
import com.safemove.backend.service.SurveyRequestService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/survey-requests")
public class SurveyRequestController {
    private final SurveyRequestRepository surveyRequestRepository;
    private final SurveyRequestService surveyRequestService;

    public SurveyRequestController(SurveyRequestRepository surveyRequestRepository,
                                   SurveyRequestService surveyRequestService) {
        this.surveyRequestRepository = surveyRequestRepository;
        this.surveyRequestService = surveyRequestService;
    }

    @GetMapping
    public List<SurveyRequest> getAll() {
        return surveyRequestRepository.findAll();
    }

    @PostMapping
    public SurveyRequest create(@Valid @RequestBody CreateSurveyRequestDto dto) {
        return surveyRequestService.create(dto);
    }
}
