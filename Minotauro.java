package AtributosCartas;
import MecanicasJogo.Jogadores;

public class Minotauro extends Criatura{

	public Minotauro() {
		
		super(7, 3, 6, 2, "Minotauro", "Ele vaga e acaba com qualquer um que pise no seu labirinto.");
	}
	
	public void habilidadeFuria(Jogadores jogador) {
		
		poder = poder + 1;
		resistencia = resistencia - 2;
		System.out.println("Uso de Habilidade Especial!!!");
		System.out.println("Minotauro agora possui o poder de " + getPoder() + " e a resistencia de " + getResistencia());
		jogador.gastaMana(2);
	}
	
}
