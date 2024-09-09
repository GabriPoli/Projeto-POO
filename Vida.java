package enchantments;
import players.Jogador1;

public class Vida extends Encantamento {
    public Vida() {
        super(5, "Vida", "Seu reino agora tem 5 de vida a mais");
    }

     public void ganharVida(Jogador1 jogador) {

        jogador.aumentarVida(5);


     }

}



