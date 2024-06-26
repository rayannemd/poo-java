package avfinal;

import java.util.Scanner;

import avfinal.service.FabricaMecanica;
import avfinal.service.Mecanica;

public class JogoDasPalavras {
    
	static Scanner sc = new Scanner(System.in);;
	static String palavraDigitada;    
	static String dificuldade;
	static Mecanica jogo;
	
	public static void main(String[] args) {

        System.out.println("|=================================================================|");
        System.out.println("|  /\\_/\\                                                   /\\_/\\  |");
        System.out.println("| ( o.o )                                                 ( o.o ) |");
        System.out.println("|-----------------------------------------------------------------|");
        System.out.println("|         BEM-VINDO AO JOGO DAS PALAVRAS EMBARALHADAS             |");
        System.out.println("|-----------------------------------------------------------------|");
        System.out.println("|  /\\_/\\                                                   /\\_/\\  |");
        System.out.println("| ( o.o )                                                 ( o.o ) |");
        System.out.println("|=================================================================|");
        
		inicio();

		while (!palavraDigitada.equals("q")) {
			String[] result = jogo.jogando(palavraDigitada);

			System.out.println(result[0]);
			System.out.println(result[1]);

			if (result[2].equals("q")) {
				palavraDigitada = "q";
				continue;
			}

			if (result[2].equals("s")) {
				inicio();
				continue;
			}

			System.out.println(result[2]);
			palavraDigitada = sc.nextLine();
		}

		if (palavraDigitada.equals("q")) {
			sair();
		}
	}

	private static void inicio() {
		dificuldade = getDificuldade();  
		
		jogo = new FabricaMecanica(dificuldade).getMecanica();
		
		System.out.println("Descubra qual é a palavra abaixo: ");
		System.out.println(jogo.iniciaJogo(dificuldade));

		palavraDigitada = sc.nextLine();
	}

    private static void sair() {
        System.out.format("|=================================================================|%n");
        System.out.format("|  /\\_/\\                                                   /\\_/\\  |%n");
        System.out.format("| ( o.o )                                                 ( o.o ) |%n");
        System.out.format("|-----------------------------------------------------------------|%n");
        System.out.format("|                            Fim de Jogo                          |%n");
        System.out.format("|-----------------------------------------------------------------|%n");
        System.out.format("|  /\\_/\\                                                   /\\_/\\  |%n");
        System.out.format("| ( o.o )                                                 ( o.o ) |%n");
        System.out.format("|=================================================================|%n");
        System.out.format("\n");
		System.exit(0);
	}

	private static String getDificuldade() {
		String dificuldade;
		System.out.println("Escolha a dificuldade ou digite 'q' para sair: ");
		System.out.println("0 = fácil, 1 = Difícil");
		dificuldade = sc.nextLine();

		while (!dificuldade.equals("0") && !dificuldade.equals("1") && !dificuldade.equals("q")) {
			System.out.println("Erro! Input invalido. Digite uma das opções a seguir: ");
			System.out.println("0 = fácil, 1 = Difícil ou q = Sair");
			dificuldade = sc.nextLine();
		}

		if (dificuldade.equals("q")) {
			sair();
		} else if (dificuldade.equals("0")) {
			System.out.println("Dificuldade Fácil? Esperava um desafio maior!");
		} else if (dificuldade.equals("1")) {
			System.out.println("Dificuldade Difícil selecionada! Que comecem os jogos!");
		}

		return dificuldade;
	}
}