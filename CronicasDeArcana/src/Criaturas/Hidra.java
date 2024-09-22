package Criaturas;
import Cartas.Criatura;
import MecanicasJogo.Jogadores;

public class Hidra extends Criatura {

	public Hidra() {

		super(4, 1, 3,"Hidra", "Seu veneno esmagador avaba com seu inimigos apenas com o hálito!");
	}

	public void habilidadeFortificar(Jogadores jogador) {
		
		resistencia = resistencia + 2;
		poder = poder - 1;
		System.out.println("Uso de Habilidade Especial!!!");
		System.out.println("Hidra agora possui a resistgencia de " + getResistencia() + " e o poder de " + getPoder());
		jogador.gastaMana(1);
	}
}
