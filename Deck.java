package MecanicasJogo;

import java.util.ArrayList;
import Cartas.*;
import Criaturas.*;
import CriaturasDeck2.*;
import Encantamentos.*;
import Feiticos.*;

public class Deck {

	private ArrayList<Carta> deck1;
	private ArrayList<Carta> deck2;
	
	public Deck() {
        deck1 = new ArrayList<>();  
        deck2 = new ArrayList<>();  

        setDeck1(deck1);
        setDeck2(deck2);
    }
	
	public ArrayList<Carta> getDeck1() {
		return deck1;
	}
	public void setDeck1(ArrayList<Carta> deck1) {
		Carta carta1 = new Cerbero();
		Carta carta2 = new Cerbero();
		Carta carta3 = new Grifo();
		Carta carta4 = new Grifo();
		Carta carta5 = new Hidra();
		Carta carta6 = new Hidra();
		Carta carta7 = new Minotauro();
		Carta carta8 = new Minotauro();
		Carta carta9 = new Terremoto();
		Carta carta10 = new Terremoto();
		Carta carta11 = new Basilisco();
		Carta carta12 = new Basilisco();
		Carta carta13 = new Sereia();
		Carta carta14 = new Sereia();
		
		deck1.add(carta1);
		deck1.add(carta2);
		deck1.add(carta3);
		deck1.add(carta4);
		deck1.add(carta5);
		deck1.add(carta6);
		deck1.add(carta7);
		deck1.add(carta8);
		deck1.add(carta9);
		deck1.add(carta10);
		deck1.add(carta11);
		deck1.add(carta12);
		deck1.add(carta13);
		deck1.add(carta14);
		
	}
	public ArrayList<Carta> getDeck2() {
		return deck2;
	}
	public void setDeck2(ArrayList<Carta> deck2) {
		Carta carta1 = new Boitata();
		Carta carta2 = new Boitata();
		Carta carta3 = new Caipora();
		Carta carta4 = new Caipora();
		Carta carta5 = new Cuca();
		Carta carta6 = new Cuca();
		Carta carta7 = new Lobisomem();
		Carta carta8 = new Lobisomem();
		Carta carta9 = new BolaDeFogo();
		Carta carta10 = new BolaDeFogo();
		Carta carta11 = new MulaSemCabeca();
		Carta carta12 = new MulaSemCabeca();
		Carta carta13 = new Saci();
		Carta carta14 = new Saci();
		
		deck2.add(carta1);
		deck2.add(carta2);
		deck2.add(carta3);
		deck2.add(carta4);
		deck2.add(carta5);
		deck2.add(carta6);
		deck2.add(carta7);
		deck2.add(carta8);
		deck2.add(carta9);
		deck2.add(carta10);
		deck2.add(carta11);
		deck2.add(carta12);
		deck2.add(carta13);
		deck2.add(carta14);
	}
	
	
	
}
