package Criaturas;
import Cartas.Criatura;
import MecanicasJogo.Jogadores;


public class Golem extends Criatura{

	public Golem() {
		
		super(3, 4, 8, "Golem", "Sua defesa é sua essência, mas a defesa pode ser o melhor ataque!");
	}
	
	public void habilidadeTrocaDeModo(Jogadores jogador) {
		
		System.out.println("Uso de Habilidade Especial!!!");
		this.poder = this.resistencia;
		this.resistencia = 3;
		System.out.println("Golem agora entrou em modo de ataque.");
		jogador.gastaMana(4);
	}
	
}