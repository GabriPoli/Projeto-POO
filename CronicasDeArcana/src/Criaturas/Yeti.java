package Criaturas;
import java.util.Scanner;

import Cartas.Criatura;
import MecanicasJogo.Jogadores;

public class Yeti extends Criatura{

	public Yeti() {
		
		super(5, 3, 6, "Yeti", "Sempre frio e preparado para congelar seus oponentes!");
	}
	
	/*public void habilidadeCongelar(Jogadores jogador, Criatura congelada) {
		
		System.out.println("Uso de Habilidade Especial!!!");
		int poderOriginal = congelada.getPoder();
		
		for(int turnos = 0; turnos < 1; turnos++) {
		
			Scanner input = new Scanner(System.in);
	        System.out.println("Yeti agora vai congelar uma criatura do oponente, informe qual: ");
	        String nomeCongelada = congelada.getNome();
	        nomeCongelada = input.next();
	        
	        congelada.getPoder() = 0;
			jogador.gastaMana(3);
		}
		
		congelada.poder = poderOriginal;
	}*/
	
}