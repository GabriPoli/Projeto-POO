package MecanicasJogo;

import java.util.Scanner;

import AtributosCartas.*;

public class Jogo {

	private int acao1;
	private int acao2;
	
	public Jogo() {
		
	}
	
	public void exibirStatus(Jogadores jogador1, Jogadores jogador2) {
	    System.out.println("===== Status Atual =====");
	    System.out.println("Vida do Jogador 1: " + jogador1.getVidaJogador() + " | Mana do Jogador 1: " + jogador1.getManaJogador());
	    System.out.println("Vida do Jogador 2: " + jogador2.getVidaJogador() + " | Mana do Jogador 2: " + jogador2.getManaJogador());
	    System.out.println("========================");
	}
	
	public int executarTurno(Scanner input, Criatura criaturaAtacante, Criatura criaturaDefensora, int vidaDefensora, int manaJogador) {
        System.out.println("O que deseja fazer?");
        System.out.println("1-Duelo  2-Mostrar a carta");
        acao1 = input.nextInt();

        if (acao1 == 1) {
            System.out.println("Mana: " + manaJogador);
            System.out.println("1-Ataque  2-Habilidade especial");
            acao2 = input.nextInt();

            if (acao2 == 1) {
            	
            	 if (manaJogador < criaturaAtacante.getCustoMana()) {
                 	System.out.println("Mana insuficiente para o duelo!");
                 }
            	 else {
            		 criaturaAtacante.ataque(criaturaDefensora, vidaDefensora);
                     manaJogador -= criaturaAtacante.getCustoMana();
            	 }
            } else {
                //criaturaAtacante.habilidadeEspecial(manaJogador);
            }
        } else {
            criaturaAtacante.mostrarCriatura();
        }

        System.out.println("Fim do turno");
		return manaJogador < 10 ? manaJogador + 1 : manaJogador;
        }
	
}
