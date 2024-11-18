package MecanicasJogo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import Erros.*;
import Feiticos.*;
import Criaturas.*;
import Cartas.*;

public class Jogo {

	private Jogadores jogador;
	private int turno = 1;
	private boolean isJogador1 = true;
	private ArrayList<Carta> mao1;
	private ArrayList<Carta> mao2;
	private ArrayList<Carta> campoDeBatalha1;
	private ArrayList<Carta> campoDeBatalha2;
	private Random random = new Random();
	private Carta cartaJogador1;
	private Carta cartaJogador2;
	public int jogarDeNovo = 1;

	public Jogo() {
		mao1 = new ArrayList<Carta>();
		mao2 = new ArrayList<Carta>();
	}

	Cemiterio cemiterio = new Cemiterio();
	
	public void definirCartasDaMao(Jogadores jogador) {
		
		Deck deck = new Deck(); 
		
		if (isJogador1) {
			for (int i = 0; i < 5; i++) {
				jogador.setMaoAleatoriaDeck1(mao1, deck);
			}
			isJogador1 = false;
		} 
		else {
			for (int i = 0; i < 5; i++) {
				jogador.setMaoAleatoriaDeck2(mao2, deck);
			}
			isJogador1 = true;
		}

	}

	public void cartasDaMao(Jogadores maoJogador) {

		if (maoJogador != null && !maoJogador.isEmpty()) {
			
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
		
		else {
	        System.out.println("A mão de " + jogador.getNomeJogador() + " está vazia.");
	    }
	}
	
	public void cartasDoCampo(Jogadores campo, Carta cartaParaCampo) {

		if (isJogador1) {
			mao1.remove(cartaParaCampo);
			campoDeBatalha1 = new ArrayList<Carta>();
			campoDeBatalha1.add(cartaParaCampo);
			System.out.println("Campo de batalha de " + campo.getNomeJogador());

			for (int i = 0; i < campoDeBatalha1.size(); i++) {
				System.out.println((i + 1) + " - " + campoDeBatalha1.get(i).getNome());
			}
		} else {
			mao2.remove(cartaParaCampo);
			campoDeBatalha2 = new ArrayList<Carta>();
			campoDeBatalha2.add(cartaParaCampo);
			System.out.println("Campo de batalha de " + campo.getNomeJogador());

			for (int i = 0; i < campoDeBatalha2.size(); i++) {
				System.out.println((i + 1) + " - " + campoDeBatalha2.get(i).getNome());
			}
		}

	}

	public Carta comecoJogo(Jogadores jogador) throws IndiceForaDoLimiteException, ManaInsuficienteException {

	    Scanner escolhaJogador = new Scanner(System.in);
	    int novaMana;

	    if (isJogador1) {
	        cartasDaMao(jogador);
	        System.out.println(jogador.getNomeJogador() + ", digite o número da carta que deseja usar: ");
	        int criatura1 = escolhaJogador.nextInt();

	        if ((criatura1 >= 1) && (criatura1 <= 5)) {
	            cartaJogador1 = mao1.get(criatura1 - 1);

	            if (jogador.jogavel(cartaJogador1)) {
	                jogador.setCarta(cartaJogador1);
	                cartasDoCampo(jogador, jogador.getCarta());

	                novaMana = jogador.getManaJogador() - cartaJogador1.getMana();
	                jogador.setManaJogador(novaMana);

	                isJogador1 = false;
	                
	                
	                return cartaJogador1;
	            }

	        } else {
	            throw new IndiceForaDoLimiteException();
	        }

	    } else {
	        cartasDaMao(jogador);
	        System.out.println(jogador.getNomeJogador() + ", digite o número da carta que deseja usar: ");
	        int criatura2 = escolhaJogador.nextInt();

	        if ((criatura2 >= 1) && (criatura2 <= 5)) {
	            cartaJogador2 = mao2.get(criatura2 - 1);

	            if (jogador.jogavel(cartaJogador2)) {
	                jogador.setCarta(cartaJogador2);
	                cartasDoCampo(jogador, jogador.getCarta());

	                novaMana = jogador.getManaJogador() - cartaJogador2.getMana();
	                jogador.setManaJogador(novaMana);

	                isJogador1 = true;
	                
	                
	                return cartaJogador2;
	            }

	        } else {
	            throw new IndiceForaDoLimiteException();
	        }
	    }
	    
	    
	    return null;
	}



	public void exibirStatus(Jogadores jogador1, Jogadores jogador2) {
		System.out.println("===== Status Atual =====");
		System.out.println("Vida do Jogador 1: " + jogador1.getVidaJogador());
		System.out.println("Mana do Jogador 1: " + jogador1.getManaJogador());
		System.out.println("------------------------");
		System.out.println("Vida do Jogador 2: " + jogador2.getVidaJogador());
		System.out.println("Mana do Jogador 2: " + jogador2.getManaJogador());
		System.out.println("========================");
		
		//Novo
		jogador1.setManaJogador(jogador1.getManaJogador() + 1);
		jogador2.setManaJogador(jogador2.getManaJogador() + 1);
	}

	public void executarTurno(Jogadores jogador1, Jogadores jogador2) throws IndiceForaDoLimiteException {

	    System.out.println("Turno " + turno);
	    Scanner escolha = new Scanner(System.in);

	    if (isJogador1) {
	        if (campoDeBatalha1.size() == 0) {
	            try {
	                comecoJogo(jogador1);
	                
	                isJogador1 = true;
	                
	                // Se for Criatura
	                if(this.getCartaJogador1() instanceof Criatura) {
	                	
	                	System.out.println(jogador1.getNomeJogador() + " o que deseja fazer?");
		                System.out.println("1-Ataque");
		                System.out.println("2-Habilidade Especial");
		                int acao1 = escolha.nextInt();
		                
		                if (acao1 == 1) {
		                    isJogador1 = false;
		                    atacar(jogador1, jogador2);

		                    if (!jogador2.getCarta().isVivo()) {
		                        System.out.println(jogador1.getCarta().getNome() + " destruiu " + jogador2.getCarta().getNome());
		                        campoDeBatalha2.remove(jogador2.getCarta());
		                        jogador2.cartaProCemiterio2(jogador2.getCarta(), cemiterio);
		                    }
		                }
		                
		                if(acao1 == 2) {
		                	isJogador1 = false;
		                	Criatura criatura = (Criatura)this.getCartaJogador1();
		                    criatura.usarHabilidade(jogador1, jogador2);
		                	
		                	
		                	
		                }
	                	
	                }
	                 // FIM
	                
	                //Se for Feitiço
	                if(this.getCartaJogador1() instanceof Feitico) {
	                	System.out.println(jogador1.getNomeJogador() + " o que deseja fazer?");
	                	System.out.println("1-Ataque com Feitiço");
		                int acao1 = escolha.nextInt();
		                
		                if(acao1 == 1) {
		                    
		                	isJogador1 = false;
		                    
		                	try {
		                		
		                		atacarComFeitico(jogador1, jogador2);
		                		
		                		if(!jogador2.getCarta().isVivo()) {
		                			System.out.println(jogador1.getCarta().getNome() + " destruiu " + jogador2.getCarta().getNome());
		                            campoDeBatalha2.remove(jogador2.getCarta());
		                            campoDeBatalha1.remove(jogador1.getCarta());
		                			
		                		}
		                	} catch (FeiticoVsFeiticoException e) {
		                        System.out.println(e.getMessage());
		                        System.exit(0);
		                	}
		                		
		                }
	               }
	                //FIM
	                
	                //Se For Encantamento
	                
	                if(this.getCartaJogador1() instanceof Encantamento) {
	                	System.out.println(jogador1.getNomeJogador() + " o que deseja fazer?");
		                System.out.println("1-Usar Encantamento");
		                int acao1 = escolha.nextInt();
	                	
	                }
	                //FIM
	                
	                
	            } catch (ManaInsuficienteException e) {
	                System.out.println(e.getMessage());
	                System.exit(0);
	            }
	        
	        } else {
	            cartasDoCampo(jogador1, jogador1.getCarta());
	            
	            // Se for Criatura
	            if(this.getCartaJogador1() instanceof Criatura) {
                	
                	System.out.println(jogador1.getNomeJogador() + " o que deseja fazer?");
	                System.out.println("1-Ataque");
	                System.out.println("2-Habilidade Especial");
	                int acao1 = escolha.nextInt();
	                
	                if (acao1 == 1) {
	                    isJogador1 = false;
	                    atacar(jogador1, jogador2);

	                    if (!jogador2.getCarta().isVivo()) {
	                        System.out.println(jogador1.getCarta().getNome() + " destruiu " + jogador2.getCarta().getNome());
	                        campoDeBatalha2.remove(jogador2.getCarta());
	                        jogador2.cartaProCemiterio2(jogador2.getCarta(), cemiterio);
	                    }
	                }
                	
                }// FIM
	            
	            // Se for feitiço
	            if(this.getCartaJogador1() instanceof Feitico) {
                	System.out.println(jogador1.getNomeJogador() + " o que deseja fazer?");
                	System.out.println("1-Ataque com Feitiço");
	                int acao1 = escolha.nextInt();
	                
	                if(acao1 == 1) {
	                    
	                	isJogador1 = false;
	                    
	                	try {
	                		
	                		atacarComFeitico(jogador1, jogador2);
	                		
	                		if(!jogador2.getCarta().isVivo()) {
	                			System.out.println(jogador1.getCarta().getNome() + " destruiu " + jogador2.getCarta().getNome());
	                            campoDeBatalha2.remove(jogador2.getCarta());
	                            campoDeBatalha1.remove(jogador1.getCarta());
	                			
	                		}
	                	} catch (FeiticoVsFeiticoException e) {
	                        System.out.println(e.getMessage());
	                        System.exit(0);
	                	}
	                		
	                }
               } // FIM
	            
	            //Se for com Encantamento
	            if(this.getCartaJogador1() instanceof Encantamento) {
                	System.out.println(jogador1.getNomeJogador() + " o que deseja fazer?");
	                System.out.println("1-Usar Encantamento");
	                int acao1 = escolha.nextInt();
                	
                }
	            
	        }   
	        
	        //SEGUNDO JOGADOR!!
	    } else {
	        if (campoDeBatalha2.size() == 0) {
	            try {
	                comecoJogo(jogador2);
	                isJogador1 = false;

	                System.out.println(jogador2.getNomeJogador() + " o que deseja fazer?");
	                System.out.println("1-Ataque");
	                System.out.println("2-Ataque com Feitiço");
	                int acao1 = escolha.nextInt();

	                if (acao1 == 1) {
	                    isJogador1 = true;
	                    atacar(jogador2, jogador1);

	                    if (!jogador1.getCarta().isVivo()) {
	                        System.out.println(jogador2.getCarta().getNome() + " destruiu " + jogador1.getCarta().getNome());
	                        campoDeBatalha1.remove(jogador1.getCarta());
	                        jogador1.cartaProCemiterio2(jogador1.getCarta(), cemiterio);
	                    }
	                } else if (acao1 == 2) {
	                    isJogador1 = false;
	                    try {
	                        atacarComFeitico(jogador2, jogador1);

	                        if (!jogador1.getCarta().isVivo()) {
	                            System.out.println(jogador2.getCarta().getNome() + " destruiu " + jogador1.getCarta().getNome());
	                            campoDeBatalha1.remove(jogador1.getCarta());
	                            campoDeBatalha2.remove(jogador2.getCarta());
	                        }
	                    } catch (FeiticoVsFeiticoException e) {
	                        System.out.println(e.getMessage());
	                        System.exit(0);
	                    }
	                }
	            } catch (ManaInsuficienteException e) {
	                System.out.println(e.getMessage());
	                System.exit(0);
	            }
	        } else {
	            cartasDoCampo(jogador2, jogador2.getCarta());
	            System.out.println(jogador2.getNomeJogador() + " o que deseja fazer?");
	            System.out.println("1-Ataque");
	            System.out.println("2-Ataque com Feitiço");
	            int acao1 = escolha.nextInt();

	            if (acao1 == 1) {
	                isJogador1 = true;
	                atacar(jogador2, jogador1);

	                if (!jogador1.getCarta().isVivo()) {
	                    System.out.println(jogador2.getCarta().getNome() + " destruiu " + jogador1.getCarta().getNome());
	                    campoDeBatalha1.remove(jogador1.getCarta());
	                }
	            } else if (acao1 == 2) {
	                isJogador1 = false;
	                try {
	                    atacarComFeitico(jogador2, jogador1);

	                    if (!jogador1.getCarta().isVivo()) {
	                        System.out.println(jogador2.getCarta().getNome() + " destruiu " + jogador1.getCarta().getNome());
	                        campoDeBatalha1.remove(jogador1.getCarta());
	                        campoDeBatalha2.remove(jogador2.getCarta());
	                    }
	                } catch (FeiticoVsFeiticoException e) {
	                    System.out.println(e.getMessage());
	                    System.exit(0);
	                }
	            }
	        }
	    }

	    System.out.println("Fim do turno " + turno);
	    turno++;
	}


	public void atacarComFeitico(Jogadores jogadorAtaque, Jogadores jogadorDefesa) throws FeiticoVsFeiticoException {
        if ((jogadorDefesa.getCarta() instanceof Feitico && jogadorAtaque.getCarta() instanceof Feitico)) {

            throw new FeiticoVsFeiticoException();


        } else {

            if (jogadorDefesa.getCarta().getResistencia() < jogadorAtaque.getCarta().getPoder()) {
                int dano = jogadorAtaque.getCarta().getPoder() - jogadorDefesa.getCarta().getResistencia();
                int vidaAtual = jogadorDefesa.getVidaJogador() - dano;
                jogadorDefesa.getCarta().setVivo(false);
                jogadorDefesa.setVidaJogador(vidaAtual);
            }
        }
    }
	
	public void atacar(Jogadores jogadorAtaque, Jogadores jogadorDefesa) {

        int poderAtaque = jogadorAtaque.getCarta().getPoder();
        int resistenciaDefesa = jogadorDefesa.getCarta().getResistencia();
        System.out.println("Poder de ataque: " + poderAtaque);
        System.out.println("Resistência inicial do jogadorDefesa: " + resistenciaDefesa);

        if (resistenciaDefesa < poderAtaque) {

            int dano = poderAtaque - resistenciaDefesa;
            int vidaAtual = jogadorDefesa.getVidaJogador() - dano;
            jogadorDefesa.getCarta().setVivo(false);
            jogadorDefesa.setVidaJogador(vidaAtual);

            resistenciaDefesa = resistenciaDefesa - poderAtaque;
            jogadorDefesa.getCarta().setResistencia(resistenciaDefesa);


        } else {
            int vidaAtual = jogadorDefesa.getVidaJogador();
            jogadorDefesa.getCarta().setVivo(true);
            jogadorDefesa.setVidaJogador(vidaAtual);

            resistenciaDefesa = resistenciaDefesa - poderAtaque;
            jogadorDefesa.getCarta().setResistencia(resistenciaDefesa);
            System.out.println("Nova resistência após o ataque: " + resistenciaDefesa);
        }
    }	
	//Novo
	public void desejaJogarDeNovo() {
		Scanner escolha = new Scanner(System.in);
		
		System.out.println("Desejam jogar outra partida?");
		System.out.println("1-Sim");
		System.out.println("2-Não");
		jogarDeNovo = escolha.nextInt();
		
		jogarDeNovo = this.getJogarDeNovo();
		
	}
	
	//Novo
	public void reiniciaPartida(Jogadores jogador1, Jogadores jogador2) {
		getListaCartas1().clear();
		getListaCartas2().clear();
		getCampoDeBatalha1().clear();
		getCampoDeBatalha2().clear();
		
		jogador1.setVidaJogador(20);
		jogador2.setVidaJogador(20);
		jogador1.setManaJogador(10);
		jogador2.setManaJogador(10);
		
		turno = 1;
	}

	public ArrayList<Carta> getListaCartas1() {
		return mao1;
	}

	public ArrayList<Carta> getListaCartas2() {
		return mao2;
	}

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

	public Jogadores getJogador() {
		return jogador;
	}

	public boolean getjogadorAtivo() {
		return isJogador1;
	}

	public int getJogarDeNovo() {
		return jogarDeNovo;
	}
	

	public Carta getCartaJogador1() {
		return cartaJogador1;
	}


	public Carta getCartaJogador2() {
		return cartaJogador2;
	}
	// public void cartasDisponiveis(Jogadores maoJogador1, Jogadores maoJogador2) {

	// ArrayList<Criatura> listaCriaturas1 = new ArrayList<Criatura>();
	// listaCriaturas1.add(maoJogador1.getCriatura().getNome());

	// ArrayList<Criatura> listaCriaturas2 = maoJogador2.getCriaturasLista();

	// }

}