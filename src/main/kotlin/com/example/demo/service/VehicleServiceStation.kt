package com.example.demo.service

import com.example.demo.model.Repairable

interface VehicleServiceStation {
    fun repair(vehicle: Repairable) : Boolean
}