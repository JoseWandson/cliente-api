CREATE TABLE usuario
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    senha VARCHAR(150) NOT NULL,
    UNIQUE (email)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;
    
INSERT INTO usuario (
nome, email, senha) VALUES (
'Administrador', 'admin@hotmail.com', '$2a$10$ixInHI/Th6SC6Xi/XWa52OX2N1BDqjENwqChqVXq01TRDUB4XRNsa');
