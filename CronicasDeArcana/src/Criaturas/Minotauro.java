package Criaturas;
import Cartas.Criatura;
import MecanicasJogo.Jogadores;

public class Minotauro extends Criatura{

	public Minotauro() {
		
		super(7, 2, 6, "Minotauro", "Ele vaga e acaba com qualquer um que pise no seu labirinto.");
	}
	
	public void habilidadeFuria(Jogadores jogador) {
		
		System.out.println("Uso de Habilidade Especial!!!");
		for(int turnos = 0; turnos < 2; turnos++) {
			
			poder = poder + 1;
			resistencia = resistencia - 2;
			System.out.println("Minotauro agora possui o poder de " + getPoder() + " e a resistencia de " + getResistencia());
			jogador.gastaMana(2);
		}
	}
	
}
