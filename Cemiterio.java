package MecanicasJogo;

import java.util.ArrayList;
import Cartas.*;
import Criaturas.*;
import CriaturasDeck2.*;
import Encantamentos.*;
import Feiticos.*;

public class Cemiterio {

	private ArrayList<Carta> cemiterio1;
	private ArrayList<Carta> cemiterio2;
	
	public Cemiterio() {
		cemiterio1 = new ArrayList<>();  
		cemiterio2 = new ArrayList<>();  
	}
	
	public ArrayList<Carta> getCemiterio1() {
		return cemiterio1;
	}

	public ArrayList<Carta> getCemiterio2() {
		return cemiterio2;
	}
	
	
}
