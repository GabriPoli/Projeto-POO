package MecanicasJogo;

import java.util.ArrayList;
import java.util.Scanner;

import Criaturas.*;
import Cartas.Carta;

public class Jogo {

	private int turno = 1;
	private boolean isJogador1 = true;
	private ArrayList<Carta> mao1;
	private ArrayList<Carta> mao2;
	private ArrayList<Carta> campoDeBatalha1;
	private ArrayList<Carta> campoDeBatalha2;
	
	Cerbero cerbero = new Cerbero();
	Fenix fenix = new Fenix();
	Golem golem = new Golem();
	Minotauro minotauro = new Minotauro();
	Grifo grifo = new Grifo();
	Yeti yeti = new Yeti();
	
	public Jogo() {
		mao1 = new ArrayList<Carta>();
		mao1.add(cerbero);
		mao1.add(grifo);
		mao1.add(minotauro);
		
		mao2 = new ArrayList<Carta>();
		mao2.add(fenix);
		mao2.add(golem);
		mao2.add(yeti);
	}
	
	public void cartasDoCampo(Jogadores campo, Carta criaturaParaCampo) {

		if (isJogador1) {
			mao1.remove(criaturaParaCampo);
			campoDeBatalha1 = new ArrayList<Carta>();
			campoDeBatalha1.add(criaturaParaCampo);
			System.out.println("Campo de batalha de " + campo.getNomeJogador());

			for (int i = 0; i < campoDeBatalha1.size(); i++) {
				System.out.println((i + 1) + " - " + campoDeBatalha1.get(i).getNome());
			}
		} else {
			mao2.remove(criaturaParaCampo);
			campoDeBatalha2 = new ArrayList<Carta>();
			campoDeBatalha2.add(criaturaParaCampo);
			System.out.println("Campo de batalha de " + campo.getNomeJogador());

			for (int i = 0; i < campoDeBatalha2.size(); i++) {
				System.out.println((i + 1) + " - " + campoDeBatalha2.get(i).getNome());
			}
		}

	}

	public void cartasDaMao(Jogadores maoJogador) {

		if (isJogador1) {
			mao1 = maoJogador.getMao();
			System.out.println("Mão de " + maoJogador.getNomeJogador());

			for (int i = 0; i < mao1.size(); i++) {
				System.out.println((i + 1) + " - " + mao1.get(i).getNome());
			}
		} else {
			mao2 = maoJogador.getMao();
			System.out.println("Mão de " + maoJogador.getNomeJogador());
			
			for (int i = 0; i < mao2.size(); i++) {
				System.out.println((i + 1) + " - " + mao2.get(i).getNome());
			}
		}

	}

	public void comecoJogo(Jogadores jogador) {

		Scanner escolhaJogador = new Scanner(System.in);

		if(isJogador1) {
			cartasDaMao(jogador);
			System.out.println(jogador.getNomeJogador() + ", digite o nome da criatura que deseja usar: ");
			int criatura1 = escolhaJogador.nextInt();
			Carta criaturaJogador1 = mao1.get(criatura1 - 1);
			jogador.setCriatura(criaturaJogador1);
			cartasDoCampo(jogador, jogador.getCriatura());

			isJogador1 = false;
		}
		else {
			cartasDaMao(jogador);
			System.out.println(jogador.getNomeJogador() + ", digite o nome da criatura que deseja usar: ");
			int criatura2 = escolhaJogador.nextInt();
			Carta criaturaJogador2 = mao2.get(criatura2 - 1);
			jogador.setCriatura(criaturaJogador2);
			cartasDoCampo(jogador, jogador.getCriatura());
			
			isJogador1 = true;
		}
		
	}

	public void exibirStatus(Jogadores jogador1, Jogadores jogador2) {
		System.out.println("===== Status Atual =====");
		System.out.println("Vida do Jogador 1: " + jogador1.getVidaJogador());
		System.out.println("Vida do Jogador 2: " + jogador2.getVidaJogador());
		System.out.println("========================");
	}

	public void executarTurno(Jogadores jogador1, Jogadores jogador2) {

		System.out.println("Turno " + turno);

		Scanner escolha = new Scanner(System.in);
		
		if (isJogador1) {
			
			if(campoDeBatalha1.size() == 0) {
				comecoJogo(jogador1);
				isJogador1 = true;
				
				System.out.println(jogador1.getNomeJogador() + " o que deseja fazer?");
				System.out.println("1-Ataque");
				int acao1;
				acao1 = escolha.nextInt();
				
				if(acao1 == 1) {
					isJogador1 = false;
					atacar(jogador1, jogador2);
					
					if(jogador2.getCriatura().isVivo() == false) {
						System.out.println(jogador1.getCriatura().getNome()+" destruiu "+jogador2.getCriatura().getNome());
						campoDeBatalha2.remove(jogador2.getCriatura());
					}
				}
			}
			else {
				cartasDoCampo(jogador1, jogador1.getCriatura());
				System.out.println(jogador1.getNomeJogador() + " o que deseja fazer?");
				System.out.println("1-Ataque");
				int acao1;
				acao1 = escolha.nextInt();
				
				if(acao1 == 1) {
					isJogador1 = false;
					atacar(jogador1, jogador2);
					
					if(jogador2.getCriatura().isVivo() == false) {
						System.out.println(jogador1.getCriatura().getNome()+" destruiu "+jogador2.getCriatura().getNome());
						campoDeBatalha2.remove(jogador2.getCriatura());
					}
				}
			}
		} 
		
		else {
			
			if(campoDeBatalha2.size() == 0) {
				comecoJogo(jogador2);
				isJogador1 = false;
				
				System.out.println(jogador2.getNomeJogador() + " o que deseja fazer?");
				System.out.println("1-Ataque");
				int acao1;
				acao1 = escolha.nextInt();
				
				if(acao1 == 1) {
					isJogador1 = true;
					atacar(jogador2, jogador1);
					
					if(jogador1.getCriatura().isVivo() == false) {
						System.out.println(jogador2.getCriatura().getNome()+" destruiu "+jogador1.getCriatura().getNome());
						campoDeBatalha1.remove(jogador1.getCriatura());
					}
				}
			}
			else {
				cartasDoCampo(jogador2, jogador2.getCriatura());
				System.out.println(jogador2.getNomeJogador() + " o que deseja fazer?");
				System.out.println("1-Ataque");
				int acao1;
				acao1 = escolha.nextInt();
				
				if(acao1 == 1) {
					isJogador1 = true;
					atacar(jogador2, jogador1);
					
					if(jogador1.getCriatura().isVivo() == false) {
						System.out.println(jogador2.getCriatura().getNome()+" destruiu "+jogador1.getCriatura().getNome());
						campoDeBatalha1.remove(jogador1.getCriatura());
					}
				}
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

	public ArrayList<Carta> getListaCriaturas1() {
		return mao1;
	}

	public ArrayList<Carta> getListaCriaturas2() {
		return mao2;
	}

	// Novo
	public ArrayList<Carta> getCampoDeBatalha1() {
		return campoDeBatalha1;
	}

	public void setCampoDeBatalha1(ArrayList<Carta> campoDeBatalha1) {
		this.campoDeBatalha1 = campoDeBatalha1;
	}

	public ArrayList<Carta> getCampoDeBatalha2() {
		return campoDeBatalha2;
	}

	public void setCampoDeBatalha2(ArrayList<Carta> campoDeBatalha2) {
		this.campoDeBatalha2 = campoDeBatalha2;
	}

	// public void cartasDisponiveis(Jogadores maoJogador1, Jogadores maoJogador2) {

	// ArrayList<Criatura> listaCriaturas1 = new ArrayList<Criatura>();
	// listaCriaturas1.add(maoJogador1.getCriatura().getNome());

	// ArrayList<Criatura> listaCriaturas2 = maoJogador2.getCriaturasLista();

	// }

}
