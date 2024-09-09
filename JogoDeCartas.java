package ProjetoPOO;

import AtributosCartas.*;
import MecanicasJogo.*;
import java.util.Scanner;

public class JogoDeCartas {

	static String nomeCarta1;
    static String nomeCarta2;

    public static void main(String[] args) {
    	
    	Jogo jogo = new Jogo();
    	
    	Jogadores jogador1 = new Jogadores("P1", 20, 10);
    	Jogadores jogador2 = new Jogadores("P2", 20, 10);
    	
        Scanner input = new Scanner(System.in);
        System.out.println("Jogador 1, digite o nome da criatura que deseja usar: ");
        nomeCarta1 = input.next();
        System.out.println("Jogador 2, digite o nome da criatura que deseja usar: ");
        nomeCarta2 = input.next();

        FabricaDeCartas fabricaDeCarta = new FabricaDeCartas();

        Criatura criatura1 = fabricaDeCarta.criarCarta(nomeCarta1);
        Criatura criatura2 = fabricaDeCarta.criarCarta(nomeCarta2);

        while (jogador1.getVidaJogador() > 0 && jogador2.getVidaJogador() > 0) {

            if (criatura1.isVivo() || (jogador1.getManaJogador() > criatura1.getCustoMana())) {
                System.out.println("Turno do Jogador 1");
                int novaManaJogador1 = jogo.executarTurno(input, criatura1, criatura2, jogador2.getVidaJogador(), jogador1.getManaJogador());
                jogador1.setManaJogador(novaManaJogador1);                
                jogador2.setVidaJogador(jogador2.getVidaJogador() - criatura1.danoRecebido(criatura2));
                jogo.exibirStatus(jogador1, jogador2);
            } else {
                System.out.println("Jogador 1, digite o nome da nova criatura que deseja usar: ");
                nomeCarta1 = input.next();
                criatura1 = fabricaDeCarta.criarCarta(nomeCarta1);
            }

            if (jogador2.getVidaJogador() <= 0) {
                System.out.println("Jogador 1 venceu!");
                break;
            }

            if (criatura2.isVivo() && (jogador2.getManaJogador() > criatura2.getCustoMana())) {
                System.out.println("Turno do Jogador 2");
                int novaManaJogador2 = jogo.executarTurno(input, criatura2, criatura1, jogador1.getVidaJogador(), jogador2.getManaJogador());
                jogador2.setManaJogador(novaManaJogador2);                
                jogador1.setVidaJogador(jogador1.getVidaJogador() - criatura2.danoRecebido(criatura1));
                jogo.exibirStatus(jogador1, jogador2);
            } else {
                System.out.println("Jogador 2, digite o nome da nova criatura que deseja usar: ");
                nomeCarta2 = input.next();
                criatura2 = fabricaDeCarta.criarCarta(nomeCarta2);
            }

            if (jogador1.getVidaJogador() <= 0) {
                System.out.println("Jogador 2 venceu!");
                break;
            }
        }

        input.close();
    }
}
