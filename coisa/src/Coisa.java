package coisa.src;

import java.util.Scanner;

/**
 * Oferece uma interface para o usuario em linha de comando. 
 * 
 * @author Daniel Coura
 *
 */
public class Coisa {
	
	/**
	 * Classe principal do programa.
	 * 
	 * @param args os argumentos passados ao invocar o programa
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Aluno aluno = new Aluno();
		
		int sair = 0;
		while (sair == 0) {
			System.out.print("> ");
			executaComando(sc.nextLine().split(" "), aluno);
		}
		sc.close();
	}
	
	/**
	 * Converte uma String em uma array de inteiros. Os elementos
	 * da String devem estar separados por ponto e virgula (;). 
	 * Ex: "1;2;43;5"
	 * 
	 * @param valor a String a ser convertida 
	 * @return um array de inteiros obtidos atraves da String passada
	 */
	private static int[] toIntArray(String valor) {
		String[] values = valor.split(";");
		int[] newValues = new int[values.length];
		for (int i = 0; i < values.length; i++) {
			newValues[i] = Integer.parseInt(values[i]);
		}
		return newValues;
	}
	
	/**
	 * Executa comandos passados pelo usuario.
	 * 
	 * @param comando o comando e os argumentos passados
	 * @param aluno o objeto aluno que sera manipulado
	 */
	public static void executaComando(String[] comando, Aluno aluno) {
		if (comando[0].equals("CADASTRA_LAB")) {
			if (comando.length == 2) {
				aluno.cadastraLaboratorio(comando[1]);
			} else if (comando.length == 3 ) {
				aluno.cadastraLaboratorio(comando[1], Integer.parseInt(comando[2]));
			} else {
				Exceptions.numeroArgumentos(comando[0], comando.length - 1, 1, 2);
			}
		} else if (comando[0].equals("CONSOME_ESPACO")) {
			if (comando.length == 3) {
				aluno.consomeEspaco(comando[1], Integer.parseInt(comando[2]));
			} else {
				Exceptions.numeroArgumentos(comando[0], comando.length - 1, 2, 2);
			}
		} else if (comando[0].equals("LIBERA_ESPACO")) {
			if (comando.length == 3) {
				aluno.liberaEspaco(comando[1], Integer.parseInt(comando[2]));
			} else {
				Exceptions.numeroArgumentos(comando[0], comando.length - 1, 2, 2);
			}
		} else if (comando[0].equals("ATINGIU_COTA")) {
			if (comando.length == 2) {
				System.out.println(aluno.atingiuCota(comando[1]));
			} else {
				Exceptions.numeroArgumentos(comando[0], comando.length - 1, 1, 1);
			}
		} else if (comando[0].equals("STRING_LAB")) {
			if (comando.length == 2) {
				System.out.println(aluno.laboratorioToString(comando[1]));
			} else {
				Exceptions.numeroArgumentos(comando[0], comando.length - 1, 1, 1);
			}
		} else if (comando[0].equals("LISTA_LAB")) {
			if (comando.length == 1) {
				System.out.print(aluno.listaLab());
			} else {
				Exceptions.numeroArgumentos(comando[0], comando.length - 1, 0, 0);
			}
		} else if (comando[0].equals("CADASTRA_DISCIPLINA")) {
			if (comando.length == 2) {
				aluno.cadastraDisciplina(comando[1]);
			} else if (comando.length == 3) {
				aluno.cadastraDisciplina(comando[1], Integer.parseInt(comando[2]));
			} else if (comando.length == 4) {
				aluno.cadastraDisciplina(comando[1], Integer.parseInt(comando[2]), toIntArray(comando[3]));
			}
			else {
				Exceptions.numeroArgumentos(comando[0], comando.length - 1, 1, 3);
			}
		} else if (comando[0].equals("CADASTRA_HORAS")) {
			if (comando.length == 3) {
				aluno.cadastraHoras(comando[1], Integer.parseInt(comando[2]));
			} else {
				Exceptions.numeroArgumentos(comando[0], comando.length - 1, 2, 2);
			}
		} else if (comando[0].equals("CADASTRA_NOTA")) {
			if (comando.length == 4) {
				aluno.cadastraNota(comando[1], Integer.parseInt(comando[2]), Double.parseDouble(comando[3]));
			} else {
				Exceptions.numeroArgumentos(comando[0], comando.length - 1, 3, 3);
			}
		} else if (comando[0].equals("APROVADO")) {
			if (comando.length == 2){
				System.out.println(aluno.aprovado(comando[1]));
			} else {
				Exceptions.numeroArgumentos(comando[0], comando.length - 1, 1, 1);
			}
		} else if (comando[0].equals("LISTA_DISCIPLINA")) {
			if (comando.length == 1) {
				System.out.print(aluno.listaDisciplina());
			} else {
				Exceptions.numeroArgumentos(comando[0], comando.length - 1, 0, 0);
			} 
		} else if (comando[0].equals("STRING_DISCIPLINA")) {
			if (comando.length == 2) {
				System.out.println(aluno.disciplinaToString(comando[1]));
			} else {
				Exceptions.numeroArgumentos(comando[0], comando.length - 1, 1, 1);
			}
		} else if (comando[0].equals("CADASTRA_CANTINA")) {
			if (comando.length == 2) {
				aluno.cadastraCantina(comando[1]);
			} else {
				Exceptions.numeroArgumentos(comando[0], comando.length - 1, 1, 1);
			}
		} else if (comando[0].equals("CADASTRA_LANCHE")) {
			if (comando.length == 4) {
				aluno.cadastraLanche(comando[1], Integer.parseInt(comando[2]), Integer.parseInt(comando[3]));
			} else if (comando.length == 5) {
				aluno.cadastraLanche(comando[1], Integer.parseInt(comando[2]), Integer.parseInt(comando[3]), comando[4]);
			} else {
				Exceptions.numeroArgumentos(comando[0], comando.length - 1, 3, 4);
			}
		} else if (comando[0].equals("LISTA_DETALHES")) {
			if (comando.length == 2) {
				System.out.println(aluno.listarDetalhes(comando[1]));
			} else {
				Exceptions.numeroArgumentos(comando[0], comando.length - 1, 1, 1);
			}
		} else if (comando[0].equals("PAGA_CONTA")) {
			if (comando.length == 3) {
				aluno.pagarConta(comando[1], Integer.parseInt(comando[2]));
			} else {
				Exceptions.numeroArgumentos(comando[0], comando.length - 1, 2, 2);
			} 
		} else if (comando[0].equals("LISTA_CANTINA")) {
			if (comando.length == 1) {
				System.out.print(aluno.listaCantina());
			} else {
				Exceptions.numeroArgumentos(comando[0], comando.length - 1, 0, 0);
			}
		} else if (comando[0].equals("STRING_CANTINA")) {
			if (comando.length == 2) {
				System.out.println(aluno.cantinaToString(comando[1]));
			} else {
				Exceptions.numeroArgumentos(comando[0], comando.length -1 , 1, 1);
			}
		} else if (comando[0].equals("SAUDE_MENTAL")) {
			if (comando.length == 2) {
				aluno.defineSaudeMental(comando[1]);
			} else {
				Exceptions.numeroArgumentos(comando[0], comando.length - 1, 1, 1);
			}
		} else if (comando[0].equals("SAUDE_FISICA")) {
			if (comando.length == 2) {
				aluno.defineSaudeFisica(comando[1]);
			} else {
				Exceptions.numeroArgumentos(comando[0], comando.length - 1, 1, 1);
			}
		} else if (comando[0].equals("SAUDE_GERAL")) {
			if (comando.length == 1) {
				System.out.println(aluno.geral());
			} else {
				Exceptions.numeroArgumentos(comando[0], comando.length - 1, 0, 0);
			}
		} else {
			System.out.println("Comando não encontrado");
		}
	}	
}