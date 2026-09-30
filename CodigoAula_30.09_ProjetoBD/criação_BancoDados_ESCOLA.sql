CREATE DATABASE ESCOLA;

USE ESCOLA;

CREATE TABLE ALUNOS(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50),
    idade INT,
    curso VARCHAR(50)
);

INSERT INTO ALUNOS (nome,idade,curso)
VALUES  ('João',20,'Matemática'),
		('Maria',22,'História'),
		('Pedro',21,'Ciência da Computação'),
		('Ana',19,'Biologia'),
        ('Carlos',23,'Economia');
        
CREATE TABLE PROFESSORES(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50),
    idade INT,
    disciplina VARCHAR(50)
);


INSERT INTO PROFESSORES (nome,idade,disciplina)
VALUES ('Ricardo',41,'Laboratório de Desenvolvimento de Software');

INSERT INTO PROFESSORES (nome,idade,disciplina)
VALUES ('Luiz',45,'Matemática Discreta');
INSERT INTO PROFESSORES (nome,idade,disciplina)
VALUES ('Augusto',50,'História');

CREATE TABLE MATRICULAS(
	id INT AUTO_INCREMENT PRIMARY KEY,
    id_aluno INT,
    id_professor int,
    data_matricula DATE,
	FOREIGN KEY (id_aluno) REFERENCES alunos(id),
    FOREIGN KEY (id_professor) REFERENCES professores(id)
);
INSERT INTO MATRICULAS(id_aluno, id_professor, data_matricula)
VALUES      (1, 2, '2023-01-15'), 
            (2, 3, '2023-02-20'),
            (3, 1, '2023-03-10'),
            (4, 3, '2023-04-05'), 
            (5, 2, '2023-05-12');
            
            select *
            from alunos;
            


