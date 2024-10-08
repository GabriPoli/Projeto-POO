package Feiticos;
import Cartas.*;
public class Curar extends Feitico {
	
	    public Curar() {
	        super(2, 6, 0, "Curar", "Uma força divina surgiu e lhe concedeu 2 de vida");
	    }

	    public void usarFeitico(Criatura criatura){
	        
	    	criatura.receberCura(this.poder);

	        }

}
