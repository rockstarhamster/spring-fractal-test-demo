package com.example.demo.component

import com.example.demo.base.BaseComponentTest
import com.example.demo.model.Bus
import com.example.demo.model.Truck
import com.example.demo.service.RepairBox
import com.example.demo.service.impl.TruckRepairBox
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration(classes = [TruckRepairBoxTest.TestConfig::class])
class TruckRepairBoxTest : BaseComponentTest() {
    @TestConfiguration
    class TestConfig {
        @Bean
        fun truckRepairBox() = TruckRepairBox()
    }

    @Autowired
    lateinit var truckRepairBox: RepairBox

    @Test
    fun `truck repair box should be possible to repair trucks`() {
        val brokenTruck = Truck("TR1")
        Assertions.assertTrue(truckRepairBox.tryRepair(brokenTruck))
    }

    @Test
    fun `truck repair box should not be possible to repair something other than truck`() {
        val brokenBus = Bus()
        Assertions.assertFalse(truckRepairBox.tryRepair(brokenBus))
    }
}