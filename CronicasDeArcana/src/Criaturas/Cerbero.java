package Criaturas;
import Cartas.Criatura;
import MecanicasJogo.Jogadores;

public class Cerbero extends Criatura{

	public Cerbero() {

		super(8, 3, 5, "Cérbero", "O guardião do submundo, que não permite que ninguem escape do inferno!");
	}
	
	public void habilidadeDrenagem(Jogadores jogador1, Jogadores jogador2) {
		
		jogador2.perdeVida(2);
		jogador1.ganhaVida(2);
		System.out.println("Uso de Habilidade Especial!!!");
		System.out.println("O Cérbero drenou 2 de vida do oponente e recuperou 2 de vida do seu mestre.");
		jogador1.gastaMana(3);
	}
	
}