package com.example.demo.service

import com.example.demo.model.Repairable

interface RepairBox {
    fun tryRepair(vehicle: Repairable) : Boolean
}