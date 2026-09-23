create database BDAula01;
show databases;

USE bdAula01;

CREATE TABLE PESSOA(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    sexo VARCHAR(1) NOT NULL,
    idioma VARCHAR(10) NOT NULL
);

SHOW TABLES;
DESC PESSOA;

INSERT INTO PESSOA (nome,sexo,idioma)
VALUES ("Ricardo", "M", "Português"),
		("Rafael", "M", "Português"),
        ("Antony", "M", "Francês"),
        ("Joe", "M", "Espanhol"),
        ("Mary", "F", "Inglês");
        
SELECT * FROM PESSOA;





