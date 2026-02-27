package com.safemove.backend.controller;

import com.safemove.backend.entity.MoveService;
import com.safemove.backend.entity.VehicleType;
import com.safemove.backend.repository.MoveServiceRepository;
import com.safemove.backend.repository.VehicleTypeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/master")
public class MasterDataController {
    private final VehicleTypeRepository vehicleTypeRepository;
    private final MoveServiceRepository moveServiceRepository;

    public MasterDataController(VehicleTypeRepository vehicleTypeRepository,
                                MoveServiceRepository moveServiceRepository) {
        this.vehicleTypeRepository = vehicleTypeRepository;
        this.moveServiceRepository = moveServiceRepository;
    }

    @GetMapping("/vehicle-types")
    public List<VehicleType> getVehicleTypes() {
        return vehicleTypeRepository.findAll();
    }

    @GetMapping("/services")
    public List<MoveService> getServices() {
        return moveServiceRepository.findAll();
    }
}
