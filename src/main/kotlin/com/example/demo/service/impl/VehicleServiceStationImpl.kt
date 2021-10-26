package com.example.demo.service.impl

import com.example.demo.model.Repairable
import com.example.demo.service.RepairBox
import com.example.demo.service.VehicleServiceStation
import org.springframework.stereotype.Service

@Service
class VehicleServiceStationImpl(
    private val repairBoxes : List<RepairBox>
) : VehicleServiceStation {
    override fun repair(vehicle: Repairable): Boolean {
        return repairBoxes.asSequence()
            .map { repairBox -> repairBox.tryRepair(vehicle) }
            .any { repairResult -> repairResult }
    }
}