package com.thoughtworks.mstorderservice.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.thoughtworks.mstorderservice.Repository.AddressRepository;
import com.thoughtworks.mstorderservice.entity.Address;
import com.thoughtworks.mstorderservice.helper.APIBaseTest;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

class AddressControllerTest extends APIBaseTest {

    @Autowired
    AddressRepository addressRepository;

    @Test
    void should_get_addresses_when_query_by_user_id() throws Exception {
        String userId = "user-id";
        String address1 = "address-1";
        String address2 = "address-2";
        addressRepository.save(Address.builder().userId(userId).address(address1).build());
        addressRepository.save(Address.builder().userId(userId).address(address2).build());

        mockMvc.perform(get("/api/addresses/" + userId)
            .contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.size()", Is.is(2)))
            .andExpect(jsonPath("$[0].user_id", Is.is(userId)))
            .andExpect(jsonPath("$[0].address", Is.is(address1)))
            .andExpect(jsonPath("$[1].user_id", Is.is(userId)))
            .andExpect(jsonPath("$[1].address", Is.is(address2)));
    }
}