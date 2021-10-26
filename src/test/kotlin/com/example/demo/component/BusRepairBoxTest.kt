package com.example.demo.component

import com.example.demo.base.BaseComponentTest
import com.example.demo.model.Bus
import com.example.demo.model.Truck
import com.example.demo.service.RepairBox
import com.example.demo.service.impl.BusRepairBox
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration(classes = [BusRepairBoxTest.TestConfig::class])
class BusRepairBoxTest : BaseComponentTest() {
    @TestConfiguration
    class TestConfig {
        @Bean
        fun busRepairBox() = BusRepairBox()
    }

    @Autowired
    lateinit var busRepairBox: RepairBox

    @Test
    fun `bus repair box should be possible to repair buses`() {
        val brokenBus = Bus()
        assertTrue(busRepairBox.tryRepair(brokenBus))
    }

    @Test
    fun `bus repair box should not be possible to repair something other than bus`() {
        val brokenTruck = Truck("TR1")
        assertFalse(busRepairBox.tryRepair(brokenTruck))
    }
}