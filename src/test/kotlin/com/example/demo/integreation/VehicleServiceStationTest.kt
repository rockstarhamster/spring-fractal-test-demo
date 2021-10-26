package com.example.demo.integreation

import com.example.demo.base.BaseIntegrationTest
import com.example.demo.component.BusRepairBoxTest
import com.example.demo.component.ShovelRepairBoxTest
import com.example.demo.component.TruckRepairBoxTest
import com.example.demo.model.Repairable
import com.example.demo.model.Truck
import com.example.demo.service.RepairBox
import com.example.demo.service.VehicleServiceStation
import com.example.demo.service.impl.VehicleServiceStationImpl
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration(
    classes = [
        BusRepairBoxTest.TestConfig::class,
        TruckRepairBoxTest.TestConfig::class,
        ShovelRepairBoxTest.TestConfig::class,
        VehicleServiceStationTest.TestConfig::class
    ]
)
class VehicleServiceStationTest : BaseIntegrationTest() {
    @TestConfiguration
    class TestConfig {
        @Bean
        fun vehicleServiceStation(repairBoxes: List<RepairBox>) = VehicleServiceStationImpl(repairBoxes)
    }

    @Autowired
    lateinit var vehicleServiceStation: VehicleServiceStation

    @Test
    fun `vehicle station should be possible to repair known vehicle`() {
        val brokenTruck = Truck("TR1")
        assertTrue(vehicleServiceStation.repair(brokenTruck))
    }

    @Test
    fun `vehicle station should be possible to repair unknown vehicle`() {
        val unknownVehicle = UnknownVehicle()
        assertFalse(vehicleServiceStation.repair(unknownVehicle))
    }

    private inner class UnknownVehicle : Repairable {
        override fun excludeEngine(): Any {
            TODO("Not yet implemented")
        }

        override fun excludeSuspension(): Any {
            TODO("Not yet implemented")
        }
    }
}