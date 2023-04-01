package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entities.Aluno;
import factories.ConnectionFactory;

public class AlunoRepository {

	// método para receber e cadastrar um cliente no banco de dados
	public void create(Aluno aluno) throws Exception {

		// abrindo conexão com o banco de dados
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();

		// escrevendo um comando em linguagem SQL
		// para inserir um cliente no banco de dados
		PreparedStatement statement = connection
				.prepareStatement("insert into aluno(nome, matricula, cpf) values(?,?,?)");

		statement.setString(1, aluno.getNome());
		statement.setString(2, aluno.getMatricula());
		statement.setString(3, aluno.getCpf());
		statement.execute();

		// fechando a conexão
		connection.close();
	}
}