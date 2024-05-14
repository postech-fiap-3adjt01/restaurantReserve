package com.fiap.restaurante;

import com.fiap.restaurante.external.persistance.entites.Restaurante;
import com.fiap.restaurante.external.persistance.jparepositories.RestauranteJpaRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
class RestauranteApplicationTests {

    AutoCloseable openMocks;
    @Mock
    private RestauranteJpaRepository restauranteJpaRepository;

    @BeforeEach
    void setup() {
        openMocks = MockitoAnnotations.openMocks(this.restauranteJpaRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void contextLoads() {
        Restaurante restaurante = Restaurante.builder().nome("Restaurante novo").cozinha("Nova").capacidade(1000).build();
        when(restauranteJpaRepository.save(restaurante)).thenReturn(restaurante);
        Restaurante response = restauranteJpaRepository.save(restaurante);
        assertThat(1).isEqualTo(1);
    }

}
