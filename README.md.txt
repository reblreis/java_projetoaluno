# Projeto Java JDBC - CRUD Alunos

Este é um projeto Java local que visa demonstrar a realização de conexão com banco de dados PostGreSQL e as operações de CRUD (cadastro, consulta, edição e exclusão) para uma tabela de alunos.

## Pré-requisitos

Antes de executar este projeto, é necessário ter o seguinte software instalado:

- Java JDK 11
- Eclipse IDE

## Como executar o projeto

1. Clone este repositório em sua máquina local.
2. Abra o projeto no Eclipse
3. Adicione a biblioteca .JAR contendo o driver do PostGreSQL
4. Crie um banco de dados no PostGreSQL com o nome 'bd_java_projetoaluno' e execute o script abaixo:

```sql
CREATE TABLE aluno (
  idaluno SERIAL PRIMARY KEY,
  nome VARCHAR(150),
  matricula VARCHAR(15),
  cpf VARCHAR(11)
);