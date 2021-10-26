package com.example.demo.component

import com.example.demo.base.BaseComponentTest
import com.example.demo.model.Bus
import com.example.demo.model.Shovel
import com.example.demo.service.RepairBox
import com.example.demo.service.impl.ShovelRepairBox
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration
class ShovelRepairBoxTest : BaseComponentTest() {
    @TestConfiguration
    class TestConfig {
        @Bean
        fun shovelRepairBox() = ShovelRepairBox()
    }

    @Autowired
    lateinit var shovelRepairBox: RepairBox

    @Test
    fun `shovel repair box should be possible to repair shovels`() {
        val brokenShovel = Shovel()
        Assertions.assertTrue(shovelRepairBox.tryRepair(brokenShovel))
    }

    @Test
    fun `shovel repair box should not be possible to repair something other than shovels`() {
        val brokenBus = Bus()
        Assertions.assertFalse(shovelRepairBox.tryRepair(brokenBus))
    }
}