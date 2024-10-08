package Feiticos;
import Cartas.*;
public class Terremoto extends Feitico {


    public Terremoto() {
        super(3, 5, 0, "Terremoto", "Um forte terremoto é gerado e causa dano a um inimigo.");
    }

     public void usarFeitico(Criatura criatura){

            criatura.receberFeitico(this.poder);

        }


}