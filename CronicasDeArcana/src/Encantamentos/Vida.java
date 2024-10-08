package Encantamentos;
import Cartas.*;
import MecanicasJogo.Jogadores;
public class Vida extends Encantamento {
	public Vida() {
        super(5, 4, 0, "Vida", "Você agora tem 5 de vida a mais");
    }

     public void ganharVida(Jogadores jogador) {

        jogador.aumentarVida(5);


     }

}

