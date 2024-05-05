CREATE TABLE restaurante (
    id UUID PRIMARY KEY,
    nome VARCHAR(255),
    localizacao VARCHAR(255),
    cozinha VARCHAR(100),
    horario VARCHAR(100),
    capacidade INTEGER
);