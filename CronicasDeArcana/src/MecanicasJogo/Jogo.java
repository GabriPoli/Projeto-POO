package MecanicasJogo;
import Feiticos.*;
import java.util.ArrayList;
import java.util.Scanner;

import Criaturas.*;
import Cartas.Carta;
import Cartas.*
;public class Jogo {

	private int turno = 1;
	private boolean isJogador1 = true;
	private ArrayList<Carta> mao1;
	private ArrayList<Carta> mao2;
	private ArrayList<Carta> campoDeBatalha1;
	private ArrayList<Carta> campoDeBatalha2;
	
	Carta cerbero = new Cerbero();
	Carta fenix = new Fenix();
	Carta golem = new Golem();
	Carta minotauro = new Minotauro();
	Carta grifo = new Grifo();
	Carta yeti = new Yeti();
	Carta terremoto = new Terremoto();
	Carta curar = new Curar();
	
	public Jogo() {
		mao1 = new ArrayList<Carta>();
		mao1.add(cerbero);
		mao1.add(grifo);
		mao1.add(minotauro);
		mao1.add(terremoto);
		mao2 = new ArrayList<Carta>();
		mao2.add(fenix);
		mao2.add(golem);
		mao2.add(yeti);
		mao2.add(curar);
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
	        // Verifica se o campo de batalha do jogador 1 está vazio
	        if (campoDeBatalha1.size() == 0) {
	            comecoJogo(jogador1);
	            isJogador1 = true;
	        }

	        boolean escolhaInvalida = true;
	        while (escolhaInvalida) {
	            System.out.println(jogador1.getNomeJogador() + " o que deseja fazer?");
	            System.out.println("1 - Ataque");
	            int acao1 = escolha.nextInt();

	            if (acao1 == 1) {
	                atacar(jogador1, jogador2);

	                if (!jogador2.getCriatura().isVivo()) {
	                    campoDeBatalha2.remove(jogador2.getCriatura());
	                }

	                escolhaInvalida = false; // Sair do loop, pois a ação foi válida
	            } else {
	                System.out.println("Escolha inválida, tente novamente.");
	            }
	        }
	        isJogador1 = false; // Passa o turno para o próximo jogador
	    } else {
	        // Verifica se o campo de batalha do jogador 2 está vazio
	        if (campoDeBatalha2.size() == 0) {
	            comecoJogo(jogador2);
	            isJogador1 = false;
	        }

	        boolean escolhaInvalida = true;
	        while (escolhaInvalida) {
	            System.out.println(jogador2.getNomeJogador() + " o que deseja fazer?");
	            System.out.println("1 - Ataque");
	            int acao2 = escolha.nextInt();

	            if (acao2 == 1) {
	                atacar(jogador2, jogador1);

	                if (!jogador1.getCriatura().isVivo()) {
	                    campoDeBatalha1.remove(jogador1.getCriatura());
	                }

	                escolhaInvalida = false; // Sair do loop, pois a ação foi válida
	            } else {
	                System.out.println("Escolha inválida, tente novamente.");
	            }
	        }
	        isJogador1 = true; // Passa o turno para o próximo jogador
	    }

	    System.out.println("Fim do turno " + turno);
	    turno++;
	}


	public void atacar(Jogadores jogadorAtaque, Jogadores jogadorDefesa) {
	    Carta cartaAtacante = jogadorAtaque.getCriatura();
	    Carta cartaDefensora = jogadorDefesa.getCriatura();

	    // Enquanto a ação for inválida, o jogo continua pedindo uma escolha válida
	    while (true) {
	        // Se o atacante for um feitiço, ele só pode atacar criaturas
	        if (cartaAtacante instanceof Feitico) {
	            if (!(cartaDefensora instanceof Criatura)) {
	                System.out.println("Feitiços só podem atacar criaturas. Escolha outra ação.");
	                return; // Feitiço não pode atacar algo que não seja uma criatura
	            }
	        }

	        // Se o atacante for uma criatura, ela só pode atacar outra criatura
	        if (cartaAtacante instanceof Criatura) {
	            if (!(cartaDefensora instanceof Criatura)) {
	                System.out.println("Criaturas só podem atacar outras criaturas. Escolha outra ação.");
	                return; // Criatura não pode atacar feitiço ou outro tipo de carta
	            }
	        }

	        // Lógica de combate: caso o ataque seja válido (criatura vs. criatura ou feitiço vs. criatura)
	        if (cartaDefensora.getResistencia() < cartaAtacante.getPoder()) {
	            int dano = cartaAtacante.getPoder() - cartaDefensora.getResistencia();
	            int vidaAtual = jogadorDefesa.getVidaJogador() - dano;
	            cartaDefensora.setVivo(false);
	            jogadorDefesa.setVidaJogador(vidaAtual);
	            System.out.println(cartaAtacante.getNome() + " destruiu " + cartaDefensora.getNome());

	            // Se o ataque foi válido, removemos a carta do campo de batalha do defensor
	            if (cartaAtacante instanceof Feitico) {
	                // Remove o feitiço da mão do atacante, pois foi usado com sucesso
	                jogadorAtaque.getMao().remove(cartaAtacante);
	            }

	            break; // Saímos do loop, pois o ataque foi bem-sucedido
	        } else {
	            System.out.println(cartaDefensora.getNome() + " sobreviveu ao ataque de " + cartaAtacante.getNome());
	            break; // Saímos do loop, o combate foi processado
	        }
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
