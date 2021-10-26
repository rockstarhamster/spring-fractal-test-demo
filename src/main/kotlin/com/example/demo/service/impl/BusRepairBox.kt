package com.example.demo.service.impl

import com.example.demo.model.Bus
import com.example.demo.model.Repairable
import com.example.demo.service.RepairBox
import org.springframework.stereotype.Service

@Service
class BusRepairBox : RepairBox {
    override fun tryRepair(vehicle: Repairable): Boolean {
        return vehicle is Bus
    }
}