package com.example.demo.e2e

import com.example.demo.base.BaseE2ETest
import com.example.demo.model.Truck
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


class VehicleServiceStationE2ETest : BaseE2ETest() {
    @Test
    fun `vehicle station can repair truck`() {
        val truck = Truck("TR1")
        mockMvc.perform(post("/trucks")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(truck))
        ).andExpect(status().isOk)
    }
}