package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

	// método para receber e atualizar um cliente no banco de dados
	public void update(Aluno aluno) throws Exception {

		// abrindo conexão com o banco de dados
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();

		// escrevendo um comando em linguagem SQL para atualizar um cliente no banco de
		// dados
		PreparedStatement statement = connection
				.prepareStatement("update aluno set nome=?, matricula=?, cpf=?	where idaluno=?");
		statement.setString(1, aluno.getNome());
		statement.setString(2, aluno.getMatricula());
		statement.setString(3, aluno.getCpf());
	

	statement.setInt(4,aluno.getIdAluno());statement.execute();

	// fechando a conexão
	connection.close();

	}

	// método para receber e excluir um cliente no banco de dados
	public void delete(Aluno aluno) throws Exception {

		// abrindo conexão com o banco de dados
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();

		// escrevendo um comando em linguagem SQL
		// para excluir um cliente no banco de dados
		PreparedStatement statement = connection.prepareStatement("delete from aluno where idaluno=?");
		statement.setInt(1, aluno.getIdAluno());
		statement.execute();
		connection.close();
	}

	// método para consultar todos os clientes cadastrados no banco de dados
	public List<Aluno> findAll() throws Exception {
		
		//abrinco conexão com o banco de dados
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();
		
		//escrevendo um comando em linguagem SQL para consultar
		//todos os alunos
		PreparedStatement statement = connection.prepareStatement ("select * from aluno");
		ResultSet resultSet = statement.executeQuery();
		
		//declarando uma listagem de alunos
		List<Aluno> lista = new ArrayList<Aluno>();
		
		//percorrendo cada registro obtido do banco de dados
		while(resultSet.next()) {
			
			Aluno aluno = new Aluno();			
			
			//capturando os campos do banco de dados
			aluno.setIdAluno(resultSet.getInt("idaluno"));
			aluno.setNome(resultSet.getString("nome"));			
			aluno.setMatricula(resultSet.getString("matricula"));
			aluno.setCpf(resultSet.getString("cpf"));
			
			//adicionar cada objeto cliente dentro da lista
			lista.add(aluno);
		}
		
		//fechando conexão
		connection.close();
		return lista; //retornando a listagem de alunos
	
		}
		
}