package Feiticos;

import Cartas.Criatura;

import Cartas.Feitico;
public class BolaDeFogo extends Feitico{
	public BolaDeFogo() {
        super(4, 5, 0, "Bola de Fogo", "Um Meteoro invade a órbita do planeta e atinge o campo de batalha.");
    }

     public void usarFeitico(Criatura criatura){

            criatura.receberFeitico(this.poder);

        }

}

