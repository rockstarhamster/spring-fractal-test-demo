package com.example.demo.controller

import com.example.demo.exception.RepairException
import com.example.demo.model.Truck
import com.example.demo.service.VehicleServiceStation
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/trucks")
class VehicleServiceStationController(
    private val vehicleServiceStation: VehicleServiceStation
) {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun repairTruck(@RequestBody truck: Truck) {
        if (!vehicleServiceStation.repair(truck)) throw RepairException()
    }

}