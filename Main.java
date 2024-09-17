package jogoCartas;

import mecanicasjogo.Jogo;
import players.Jogadores;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int acao1;
        Jogo jogo = new Jogo();
        Jogadores jogador1 = new Jogadores("Freitas", 20, 10);
        Jogadores jogador2 = new Jogadores("Leal", 20, 10);


        //Escolher os encantamentos
        jogo.escolherEncantamentoJogador1(jogador1);
        jogo.escolherEncantamentoJogador2(jogador2);

        jogo.comecoJogo(jogador1, jogador2);

        while (jogador1.getVidaJogador() > 0 && jogador2.getVidaJogador() > 0) {
            Scanner input = new Scanner(System.in);
            System.out.println(jogador1.getNomeJogador() + " o que deseja fazer?");
            System.out.println("1-Ataque");
            acao1 = input.nextInt();

            jogo.executarTurno(acao1, jogador1, jogador2);
            jogo.exibirStatus(jogador1, jogador2);
        }

        System.out.println("Fim de Jogo!!!");
    }
}
