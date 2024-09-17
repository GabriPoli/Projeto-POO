package spells;

import cartas.Carta;
import cartas.Criatura;
import cartas.Feiticos;

public class ExoriIco extends Feiticos {


    public ExoriIco() {
        super(3, 5, "Exori Ico", "Um forte terremoto é gerado e causa dano a um inimigo.");
    }

     public void exoriIco(Criatura criatura){

            criatura.receberFeitico(3);

        }


}
