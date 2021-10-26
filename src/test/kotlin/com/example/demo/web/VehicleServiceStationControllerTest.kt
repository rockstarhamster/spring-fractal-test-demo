package com.example.demo.web

import com.example.demo.base.BaseMvcTest
import com.example.demo.controller.VehicleServiceStationController
import com.example.demo.model.Truck
import com.example.demo.service.VehicleServiceStation
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(VehicleServiceStationController::class)
class VehicleServiceStationControllerTest : BaseMvcTest() {

    @MockkBean
    lateinit var station: VehicleServiceStation

    @Test
    fun `request with truck produce OK`() {
        every { station.repair(any()) } returns true
        val truck = Truck("TR1")
        mockMvc.perform(post("/trucks")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(truck))
        ).andExpect(status().isOk)
    }
    
}