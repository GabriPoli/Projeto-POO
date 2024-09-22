package Criaturas;
import Cartas.Criatura;
import MecanicasJogo.Jogadores;


public class Fenix extends Criatura{

	public Fenix() {

		super(3, 3, 6,"Fênix", "Das suas próprias cinzas renasce e levanda voo rumo a novos desafios!");
	}
	
	public void habilidadeCura(Jogadores jogador) {
		
		jogador.ganhaVida(3);
		System.out.println("Uso de Habilidade Especial!!!");
		System.out.println("A Fenix curou 3 de vida do seu mestre.");
		jogador.gastaMana(3);
	}
	
}
