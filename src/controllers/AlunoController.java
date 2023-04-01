package controllers;

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

}
