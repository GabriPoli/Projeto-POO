package MecanicasJogo;

import java.util.ArrayList;
import java.util.Scanner;

import AtributosCartas.*;

public class Jogo {

	private int turno = 1;
	private boolean isJogador1 = true;
	private ArrayList<Criatura> listaCriaturas1;
	private ArrayList<Criatura> listaCriaturas2;
	
	public Jogo() {

	}
	
	public void cartasDaMao(Jogadores maoJogador) {
		
		Cerbero cerbero = new Cerbero();
        Fenix fenix = new Fenix();
        Golem golem = new Golem();
		Minotauro minotauro = new Minotauro();
		Grifo grifo = new Grifo();
		Yeti yeti = new Yeti();
        
		if(isJogador1) {
			listaCriaturas1 = maoJogador.getMao();
			System.out.println("Mão de " + maoJogador.getNomeJogador());
			listaCriaturas1 = new ArrayList<Criatura>();
			listaCriaturas1.add(cerbero);
			listaCriaturas1.add(grifo);
			listaCriaturas1.add(minotauro);
			
			for(int i = 0; i < listaCriaturas1.size(); i++) {
				System.out.println((i + 1) + " - " + listaCriaturas1.get(i).getNome());
			}
		}
		else {
			listaCriaturas2 = maoJogador.getMao();
			System.out.println("Mão de " + maoJogador.getNomeJogador());
			listaCriaturas2 = new ArrayList<Criatura>();
			listaCriaturas2.add(fenix);
			listaCriaturas2.add(golem);
			listaCriaturas2.add(yeti);
			
			for(int i = 0; i < listaCriaturas2.size(); i++) {
				System.out.println((i + 1) + " - " + listaCriaturas2.get(i).getNome());
			}
		}
		
	}
	
	public void comecoJogo(Jogadores jogador1, Jogadores jogador2) {

		Scanner escolhaJogador1 = new Scanner(System.in);
		
		cartasDaMao(jogador1);
		System.out.println(jogador1.getNomeJogador() +", digite o nome da criatura que deseja usar: ");
		int criatura1 = escolhaJogador1.nextInt();
		Criatura criaturaJogador1 = listaCriaturas1.get(criatura1 - 1);
		jogador1.setCriatura(criaturaJogador1);
		
		isJogador1 = false;
				
		Scanner escolhaJogador2 = new Scanner(System.in);
		
		cartasDaMao(jogador2);
		System.out.println(jogador2.getNomeJogador() +", digite o nome da criatura que deseja usar: ");
		int criatura2 = escolhaJogador2.nextInt();
		Criatura criaturaJogador2 = listaCriaturas2.get(criatura2 - 1);
		jogador2.setCriatura(criaturaJogador2);
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
				cartasDaMao(jogador1);
				atacar(jogador1, jogador2);
				isJogador1 = false;
			}
			else {
				cartasDaMao(jogador2);
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

	public ArrayList<Criatura> getListaCriaturas1() {
		return listaCriaturas1;
	}

	public ArrayList<Criatura> getListaCriaturas2() {
		return listaCriaturas2;
	}
	
	

	//public void cartasDisponiveis(Jogadores maoJogador1, Jogadores maoJogador2) {

		//ArrayList<Criatura> listaCriaturas1 = new ArrayList<Criatura>();
		//listaCriaturas1.add(maoJogador1.getCriatura().getNome());

		//ArrayList<Criatura> listaCriaturas2 = maoJogador2.getCriaturasLista();

	//}

}
