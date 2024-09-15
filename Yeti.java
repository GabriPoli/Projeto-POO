package AtributosCartas;
import java.util.Scanner;
import MecanicasJogo.Jogadores;

public class Yeti extends Criatura{

	public Yeti() {
		
		super(5, 2, 3, 3,"Yeti", "Sempre frio e preparado para congelar seus oponentes!");
	}
	
	public void habilidadeCongelar(Jogadores jogador, Criatura congelada) {
		
		System.out.println("Uso de Habilidade Especial!!!");
		int poderOriginal = congelada.poder;
		
		for(int turnos = 0; turnos < 1; turnos++) {
			Scanner input = new Scanner(System.in);
	        System.out.println("Yeti agora vai congelar uma criatura do oponente, informe qual: ");
	        congelada.nome = input.next();
	        
	        congelada.poder = 0;
			jogador.gastaMana(3);
		}
		
		congelada.poder = poderOriginal;
	}
	
}
