## Aula 07 - Dia 23.09.2026
Na aula de hoje vai ser visto com java swing + banco de dados. 

--- 
## Java Swing + Banco de dados
Vai ser usado o `My SQL`, no final *o projeto final extencionista vai ser em `SQL Server`.*

Utilizando o `Command Line`: 
- **show databases;**: para mostrar o banco na máquina

> usando mysql workbench para criação do banco p/melhor facilidade de salvamento.

---
## Criando BD
Foi criado um banco de dados `pessoa` e depois outro bd chamado `ESCOLA`.Os códigos de sql desenvolvidos estão ([CÓDIGO](https://github.com/yasminComputing/LaboratorioDesenvolvimentoDeSoftware/tree/main/Comando_Aula_23.09-Desenvolvido%20em%20Aula)).

--- 
## Conectando o java swing com banco de dado

- **Foi criado um pacote *conexa* juntamente com a clase `Conexao` e depois realizado  um import de um arquivo *jar* para realizar a conexão. Por úliimo criado pacote *principal*junto com a classe `Principal` onde chama a classe `Conexao` (c.getConexao()).**


- O pacote *beans* é utilizado para mapear as tabelas do banco de dados, ou seja, as classes terão como atributos as colunas da tabelas. 

> Essa conexão está sendo usado o `criação_do_BancoAula01`

- **DAO = Data Access Object ou Objeto de Acesso aos Dados,este pacote, teremos as classes responsáveis por persistir os dados (inserção, edição, exclusão e pesquisa) da aplicação nas tabelas.Resumindo, é ela que executará os códigos SQL no banco.**

Por úliimo foi realizado o método que inserir dados da classe principal para o banco de daodos. 

