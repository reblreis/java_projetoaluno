package controllers;

import java.util.List;
import java.util.Scanner;

import entities.Aluno;
import repositories.AlunoRepository;

public class AlunoController {

	public void cadastrarAluno() {
		System.out.println("\n*** CADASTRO DE ALUNOS ***\n");

		Scanner scanner = new Scanner(System.in);
		Aluno aluno = new Aluno();

		System.out.print("NOME DO ALUNO....: ");
		aluno.setNome(scanner.nextLine());
		System.out.print("MATRICULA........: ");
		aluno.setMatricula(scanner.nextLine());
		System.out.print("CPF..............: ");
		aluno.setCpf(scanner.nextLine());

		AlunoRepository alunoRepository = new AlunoRepository();

		try {
			alunoRepository.create(aluno);
			System.out.println("\nALUNO CADASTRADO COM SUCESSO!");
		} catch (Exception e) {
			System.out.println("\nFALHA AO CADASTRAR ALUNO!");
			e.printStackTrace(); // imprimir log do erro
		}
	}

	public void atualizarAluno() {
		System.out.println("\n*** ATUALIZAÇÃO DE ALUNOS ***\n");

		Scanner scanner = new Scanner(System.in);
		Aluno aluno = new Aluno();

		System.out.print("ID DO ALUNO......: ");
		aluno.setIdAluno(Integer.parseInt(scanner.nextLine()));
		System.out.print("NOME.............: ");
		aluno.setNome(scanner.nextLine());
		System.out.print("MATRICULA........: ");
		aluno.setMatricula(scanner.nextLine());
		System.out.print("CPF..............: ");
		aluno.setCpf(scanner.nextLine());

		AlunoRepository alunoRepository = new AlunoRepository();

		try {
			alunoRepository.update(aluno);
			System.out.println("\nALUNO ATUALIZADO COM SUCESSO!");
		} catch (Exception e) {
			System.out.println("\nFALHA AO ATUALIZAR ALUNO!");
			e.printStackTrace(); // imprimir log do erro
		}
	}

	public void excluirAluno() {
		System.out.println("\n*** EXCLUSÃO DE ALUNOS ***\n");

		Scanner scanner = new Scanner(System.in);
		Aluno aluno = new Aluno();

		System.out.print("ID DO ALUNO......: ");
		aluno.setIdAluno(Integer.parseInt(scanner.nextLine()));

		AlunoRepository alunoRepository = new AlunoRepository();

		try {
			alunoRepository.delete(aluno);
			System.out.println("\nALUNO EXCLUÍDO COM SUCESSO!");
		} catch (Exception e) {
			System.out.println("\nFALHA AO EXCLUIR ALUNO!");
			e.printStackTrace(); // imprimir log do erro
		}
	}

	public void consultarAlunos() {
		
		System.out.println("\n*** CONSULTA DE ALUNOS ***\n");

		AlunoRepository alunoRepository = new AlunoRepository();

		try {

			List<Aluno> lista = alunoRepository.findAll();
			for (Aluno aluno : lista) { // foreach

				System.out.println("ID DO ALUNO.....: " + aluno.getIdAluno());
				System.out.println("NOME............: " + aluno.getNome());
				System.out.println("MATRICULA.......: " + aluno.getMatricula());
				System.out.println("CPF.............: " + aluno.getCpf());
				System.out.println("...");
			}
		} catch (Exception e) {
			System.out.println("\nFALHA AO CONSULTAR ALUNOS!");
			e.printStackTrace(); // imprimir log do erro
		}
	}
}