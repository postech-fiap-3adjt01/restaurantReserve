//package com.fiap.restaurante.entities;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fiap.restaurante.controllers.RestauranteController;
//import com.fiap.restaurante.service.RestauranteService;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
// 
//import static org.hamcrest.Matchers.not;
//import static org.hamcrest.Matchers.empty;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//public class test2ee {
//
//  AutoCloseable openMocks;
//
//  private MockMvc mockMvc;
//  @Mock
//  private RestauranteService restauranteService;
//
//  public static String asJsonString(final Object object) throws JsonProcessingException {
//    return new ObjectMapper().writeValueAsString(object);
//  }
//
//  @BeforeEach
//  void setup() {
////    openMocks = MockitoAnnotations.openMocks(this);
////    RestauranteController restauranteController = new RestauranteController(restauranteService);
////    mockMvc = MockMvcBuilders.standaloneSetup(restauranteController)
////            .addFilter((request, response, chain) -> {
////            response.setCharacterEncoding("UTF-8");
////            chain.doFilter(request, response);
////            })
////            .build();
//  }
//
//  @AfterEach
//  void tearDown() throws Exception {
//    openMocks.close();
//  }
//  @Test
//  void testCOntroles() throws Exception {
//    mockMvc.perform(post("restaurante")
//                    .param("page", "0")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(asJsonString(new Object())))
//                    .andDo(print())
//                    .andExpect(status().isCreated())
//                    .andExpect(content().string("Bla"))
//                    .andExpect(jsonPath("$.content", not(empty())))
//                    .andExpect(jsonPath("$.totalPages").value(1));
//  }
//}
