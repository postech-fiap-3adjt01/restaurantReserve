package com.fiap.restaurante.entities;

import com.fiap.restaurante.external.persistance.entites.Comentario;
import org.apache.coyote.BadRequestException;

import java.text.DateFormat;
import java.util.List;
import java.util.Locale;

public class UsuarioEntity {
    private String email;
    private String nome;
    private List<String> reservas;
    private List<Comentario> comentarios;

    public UsuarioEntity(String nome, String email) throws BadRequestException {
        if(!EmailValidation.validate(email)) {
            throw new BadRequestException("O email utilizado não é válido");
        }
        this.nome = nome;
        this.email = email;
    }

}
