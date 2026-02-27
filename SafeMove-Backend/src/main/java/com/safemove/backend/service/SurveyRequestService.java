package com.safemove.backend.service;

import com.safemove.backend.dto.CreateSurveyRequestDto;
import com.safemove.backend.entity.*;
import com.safemove.backend.repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Service
public class SurveyRequestService {
    private final SurveyRequestRepository surveyRequestRepository;
    private final CustomerRepository customerRepository;
    private final MoveServiceRepository moveServiceRepository;
    private final PriceTableRepository priceTableRepository;

    public SurveyRequestService(SurveyRequestRepository surveyRequestRepository,
                                CustomerRepository customerRepository,
                                MoveServiceRepository moveServiceRepository,
                                PriceTableRepository priceTableRepository) {
        this.surveyRequestRepository = surveyRequestRepository;
        this.customerRepository = customerRepository;
        this.moveServiceRepository = moveServiceRepository;
        this.priceTableRepository = priceTableRepository;
    }

    public SurveyRequest create(CreateSurveyRequestDto dto) {
        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));

        MoveService service = moveServiceRepository.findById(dto.getServiceId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Service not found"));

        PriceTable priceTable = priceTableRepository
                .findFirstByServiceIdAndMinDistanceKmLessThanEqualAndMaxDistanceKmGreaterThanEqual(
                        service.getId(), dto.getEstimatedDistanceKm(), dto.getEstimatedDistanceKm())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "No pricing range found for this distance"));

        BigDecimal estimatedPrice = service.getBasePrice()
                .add(priceTable.getPricePerKm().multiply(BigDecimal.valueOf(dto.getEstimatedDistanceKm())));

        SurveyRequest request = new SurveyRequest();
        request.setCustomer(customer);
        request.setService(service);
        request.setPickupAddress(dto.getPickupAddress());
        request.setDestinationAddress(dto.getDestinationAddress());
        request.setStartDate(dto.getStartDate());
        request.setNumStaff(dto.getNumStaff());
        request.setEstimatedDistanceKm(dto.getEstimatedDistanceKm());
        request.setEstimatedPrice(estimatedPrice);
        request.setStatus("PENDING");

        return surveyRequestRepository.save(request);
    }
}
