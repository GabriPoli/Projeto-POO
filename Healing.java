package spells;

import cartas.Carta;
import cartas.Criatura;
import cartas.Feiticos;

public class Healing  extends Feiticos {
    public Healing() {
        super(2, 6, "Healing", "Uma força divina surgiu e lhe concedeu 2 de vida");
    }

    public void heal(Criatura criatura){
        criatura.aumentarResistencia(2);

        }



}

