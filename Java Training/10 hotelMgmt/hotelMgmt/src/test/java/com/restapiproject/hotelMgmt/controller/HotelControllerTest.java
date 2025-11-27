package com.restapiproject.hotelMgmt.controller;
 
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
 
import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.Mockito.times;
import java.util.*;
import org.mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
 

import com.restapiproject.hotelMgmt.dto.HotelDto;
import com.restapiproject.hotelMgmt.model.Hotel;
import com.restapiproject.hotelMgmt.service.HotelService;

 
public class HotelControllerTest {
 
    private MockMvc mockMvc;
 
    @Mock
    private HotelService hotelService;
 
    @InjectMocks
    private HotelController hotelController;
 
    private Hotel hotel1;
    private Hotel hotel2;
 
    private ObjectMapper objectMapper = new ObjectMapper();
 
    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(hotelController).build();
       
        // standalone setup -> do not want to load spring context , only wire only the controller and its dependencies 
        hotel1 = new Hotel(1L, "Hotel A", "Address A", 10, 5, new BigDecimal("100.0"));
        hotel2 = new Hotel(2L, "Hotel B", "Address B", 20, 10, new BigDecimal("200.0"));
    }
 
    @Test
    void testGetAllHotels() throws Exception {
        when(hotelService.getAllHotels()).thenReturn(Arrays.asList(hotel1, hotel2));
        mockMvc.perform(get("/api/hotels"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.length()").value(2))
               .andExpect(jsonPath("$[0].name").value("Hotel A"))
               .andExpect(jsonPath("$[1].name").value("Hotel B"));
        verify(hotelService,times(1)).getAllHotels();
    }
 
    @Test
    void testGetHotelById() throws Exception {
        when(hotelService.getHotelById(1L)).thenReturn(hotel1);
        mockMvc.perform(get("/api/hotels/1"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.name").value("Hotel A"))
               .andExpect(jsonPath("$.address").value("Address A"));
    }
 
    @Test
    void testCreateHotel() throws Exception {
        HotelDto dto = new HotelDto();
        dto.setName("Hotel C");
        dto.setAddress("Address C");
        dto.setTotal_rooms(30);
        dto.setAvailable_rooms(20);
        dto.setPrice_per_night(new BigDecimal("300.0"));
 
        Hotel created = new Hotel(3L, "Hotel C", "Address C", 30, 20, new BigDecimal("300.0"));
        when(hotelService.createHotel(any(Hotel.class))).thenReturn(created);

        mockMvc.perform(post("/api/hotels")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
               .andExpect(status().isCreated())
               .andExpect(header().string("Location", "/api/hotels/3"))
               .andExpect(jsonPath("$.id").value(3))
               .andExpect(jsonPath("$.name").value("Hotel C"));
    }
 
    @Test
    void testUpdateHotel() throws Exception {
        HotelDto dto = new HotelDto();
        dto.setName("Hotel Updated");
        dto.setAddress("New Address");
        dto.setTotal_rooms(15);
        dto.setAvailable_rooms(7);

        dto.setPrice_per_night(new BigDecimal("150.0"));
        Hotel updated = new Hotel(1L, "Hotel Updated", "New Address", 15, 7, new BigDecimal("150.0"));
        when(hotelService.updateHotel(eq(1L), any(Hotel.class))).thenReturn(updated);
        mockMvc.perform(put("/api/hotels/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.name").value("Hotel Updated"))
               .andExpect(jsonPath("$.address").value("New Address"));
    }
 
    @Test

    void testDeleteHotel() throws Exception {
        mockMvc.perform(delete("/api/hotels/1"))
               .andExpect(status().isNoContent());
    }
 
    @Test
    void testSearchHotelByName() throws Exception {
        when(hotelService.searchHotelByName("Hotel A")).thenReturn(List.of(hotel1));
        mockMvc.perform(get("/api/hotels/search").param("name", "Hotel A"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.length()").value(1))
               .andExpect(jsonPath("$[0].name").value("Hotel A"));
    }

}

 