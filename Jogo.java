package mecanicasjogo;
import java.util.ArrayList;
import java.util.Scanner;

import cartas.Carta;
import criaturas.Cerbero;
import criaturas.Fenix;
import criaturas.Golem;
import players.Jogadores;
import cartas.Criatura;
import enchantments.*;

public class Jogo {

    private int turno = 1;
    private boolean isJogador1 = true;

    //Instanciando os Encantamentos
    Vida vida = new Vida();
    Mana mana = new Mana();

    //Instanciando as Criaturas
    Cerbero cerbero = new Cerbero();
    Fenix fenix = new Fenix();
    Golem golem = new Golem();

    //ArrayList para o Deck
    ArrayList<Criatura> deck = new ArrayList<Criatura>();


    public Jogo() {

    }

    //Método para o Jogador1 escolher o seu encantamento
    public void escolherEncantamentoJogador1(Jogadores jogador1) {
        System.out.println(jogador1.getNomeJogador() + " Escolha o seu encantamento:  ");
        System.out.println("1. Vida\n2. Mana");
        Scanner escolha = new Scanner(System.in);
        int decisao = escolha.nextInt();

        switch(decisao) {
            case 1:
                vida.ganharVida(jogador1);
                System.out.println("Você escolheu o encantamento: " + vida.getNome() + "  Seu novo HP: " + jogador1.getVidaJogador());
                break;
            case 2:
                mana.ganharMana(jogador1);
                System.out.println("Você escolheu o encantamento: " + mana.getNome() + "  Sua nova Mana: " + jogador1.getManaJogador());
                break;
        }
    }

    //Método para o Jogador2 escolher o seu encantamento
    public void escolherEncantamentoJogador2(Jogadores jogador2) {

        System.out.println(jogador2.getNomeJogador() + " Escolha o seu encantamento:  ");
        System.out.println("1. Vida\n2. Mana");
        Scanner escolha = new Scanner(System.in);
        int decisao = escolha.nextInt();

        switch(decisao) {
            case 1:
                vida.ganharVida(jogador2);
                System.out.println("Você escolheu o encantamento: " + vida.getNome() + "  Seu novo HP: " + jogador2.getVidaJogador());
                break;
            case 2:
                mana.ganharMana(jogador2);
                System.out.println("Você escolheu o encantamento: " + mana.getNome() + "  Sua nova Mana: " + jogador2.getManaJogador());
                break;
        }

    }

    public void comecoJogo(Jogadores jogador1, Jogadores jogador2) {

        Scanner input = new Scanner(System.in);
        System.out.println(jogador1.getCriatura() +", digite o nome da criatura que deseja usar: ");
        String nomeCriatura1 = input.next();
        nomeCriatura1 = jogador1.getCriatura().getNome();
        System.out.println(jogador2.getNomeJogador() +", digite o nome da criatura que deseja usar: ");
        String nomeCriatura2 = input.next();
        nomeCriatura2 = jogador2.getCriatura().getNome();
    }

    public void exibirStatus(Jogadores jogador1, Jogadores jogador2) {
        System.out.println("===== Status Atual =====");
        System.out.println("Vida do Jogador 1: " + jogador1.getVidaJogador());
        System.out.println("Vida do Jogador 2: " + jogador2.getVidaJogador());
        System.out.println("========================");
    }

    public void executarTurno(int acao1, Jogadores jogador1, Jogadores jogador2) {

        System.out.println("Turno " + turno);

        if (acao1 == 1) {

            if(isJogador1) {
                atacar(jogador1, jogador2);
                isJogador1 = false;
            }
            else {
                atacar(jogador2, jogador1);
                isJogador1 = true;
            }
        }

        System.out.println("Fim do truno " + turno);
        turno++;
    }

    public void atacar(Jogadores jogadorAtaque, Jogadores jogadorDefesa) {

        if (jogadorDefesa.getCriatura().getResistencia() < jogadorAtaque.getCriatura().getPoder()) {

            int dano = jogadorAtaque.getCriatura().getPoder() - jogadorDefesa.getCriatura().getResistencia();
            int vidaAtual = jogadorDefesa.getVidaJogador() - dano;
            jogadorDefesa.getCriatura().setVivo(false);
            jogadorDefesa.setVidaJogador(vidaAtual);
        } else {

            int vidaAtual = jogadorDefesa.getVidaJogador();
            jogadorDefesa.getCriatura().setVivo(true);
            jogadorDefesa.setVidaJogador(vidaAtual);
        }
    }

//public void cartasDisponiveis(Jogadores maoJogador1, Jogadores maoJogador2) {

//ArrayList<Criatura> listaCriaturas1 = new ArrayList<Criatura>();
//listaCriaturas1.add(maoJogador1.getCriatura().getNome());

//ArrayList<Criatura> listaCriaturas2 = maoJogador2.getCriaturasLista();

//}

}

