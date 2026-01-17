package com.inditex.pricesapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureMockMvc
class PriceControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    private static final String URL = "/api/prices";

    private MockHttpServletRequestBuilder getRequestBuilder(String date, String productId, String brandId) {
        return get(URL)
                .param("date", date)
                .param("productId", productId)
                .param("brandId", brandId);
    }

    @Test
    void shouldReturn404WhenPriceNotFound() throws Exception {
        mockMvc
                .perform(getRequestBuilder("2000-06-14T10:00:00","99999","0"))
                .andExpect(status().isNotFound());
    }

    @Test
    void test1_2020_06_14_10_00_returnsPriceList1() throws Exception {
        mockMvc.perform(getRequestBuilder("2020-06-14T10:00:00","35455","1"))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.value").value(35.50));
    }

    // java
    @Test
    void test2_2020_06_14_16_00_returnsPriceList2() throws Exception {
        mockMvc.perform(getRequestBuilder("2020-06-14T16:00:00","35455","1"))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.value").value(25.45));
    }

    @Test
    void test3_2020_06_14_21_00_returnsPriceList1() throws Exception {
        mockMvc.perform(getRequestBuilder("2020-06-14T21:00:00", "35455", "1"))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.value").value(35.50));
    }

    @Test
    void test4_2020_06_15_10_00_returnsPriceList3() throws Exception {
        mockMvc.perform(
                        get("/api/prices")
                                .param("date", "2020-06-15T10:00:00")
                                .param("productId", "35455")
                                .param("brandId", "1"))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(jsonPath("$.value").value(30.50));
    }

    @Test
    void test5_2020_06_16_21_00_returnsPriceList4() throws Exception {
        mockMvc.perform(getRequestBuilder("2020-06-16T21:00:00", "35455", "1"))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.id").value(4))
                .andExpect(jsonPath("$.value").value(38.95));
    }

}