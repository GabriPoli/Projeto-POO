package Encantamentos;
import Cartas.*;
import MecanicasJogo.Jogadores;

public class Mana extends Encantamento {
	public Mana() {
        super(2, 1, 0, "De repente, mais mana!", "Você agora tem 1 de mana a mais");
    }

     public void ganharVida(Jogadores jogador) {

        jogador.aumentarVida(5);


     }

}

