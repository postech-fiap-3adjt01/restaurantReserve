package com.fiap.restaurante.entities;

import java.util.List;

import org.apache.coyote.BadRequestException;

import com.fiap.restaurante.external.persistance.entites.Comentario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioEntity {
    private String email;
    private String nome;
    private List<String> reservas;
    private List<Comentario> comentarios;

    public UsuarioEntity(String nome, String email) throws BadRequestException {
        if(Boolean.FALSE.equals(EmailValidation.validate(email))) {
            throw new BadRequestException("O email utilizado não é válido");
        }
        this.nome = nome;
        this.email = email;
    }

}
