package Criaturas;

import java.util.Scanner;

import Cartas.Criatura;
import MecanicasJogo.Jogadores;

public class Grifo extends Criatura {

	public Grifo() {

		super(5, 2, 2, "Grifo", "Poderosa criatura alada que peregrina por toda Arcadia!");
	}

	public void habilidade(Jogadores jogador, Criatura congelada) {
		
		System.out.println("Uso de Habilidade Especial!!!");
		for(int turnos = 0; turnos < 1; turnos++) {
			
		}
	
	}
}