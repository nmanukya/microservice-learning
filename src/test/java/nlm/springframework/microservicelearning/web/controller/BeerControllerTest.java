package nlm.springframework.microservicelearning.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import nlm.springframework.microservicelearning.web.model.BeerDto;
import nlm.springframework.microservicelearning.web.model.BeerStyleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;


import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static java.util.UUID.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(BeerController.class)
class BeerControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws  Exception{
        BeerDto beerDto=getValidBeerDto();
        String beerDtoJson= objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws  Exception{
        BeerDto beerDto=getValidBeerDto();
        String beerDtoJson= objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(put("/api/v1/beer/"+UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isNoContent());
    }
    BeerDto getValidBeerDto(){
        return BeerDto.builder()
                .beerName("Leffe")
                .beerStyle(BeerStyleEnum.LAGER)
                .price(new BigDecimal("3.01"))
                .upc(123123123123L)
                .build();
    }
}