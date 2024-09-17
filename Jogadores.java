package MecanicasJogo;

import java.util.ArrayList;

import AtributosCartas.Criatura;
public class Jogadores {

	private String nomeJogador;
	private int vidaJogador;
	private int manaJogador;
	private Criatura criatura;
	private ArrayList<Criatura> mao;
	
	public Jogadores(String nome, int vida, int mana, ArrayList<Criatura> mao) {
    	
    	this.nomeJogador = nome;
    	this.vidaJogador = vida;
    	this.manaJogador = mana;
    	this.mao = mao;
    }
	
	public void gastaMana(int manaGasta) {
		manaJogador = manaJogador - manaGasta;
	}
	
	public void perdeVida(int dano) {
		vidaJogador = vidaJogador - dano;
	}
	
	public void ganhaVida(int cura) {
		vidaJogador = vidaJogador + cura;
	}
	
	public int getVidaJogador() {
		return vidaJogador;
	}
	public int getManaJogador() {
		return manaJogador;
	}

	public String getNomeJogador() {
		return nomeJogador;
	}

	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}

	public void setVidaJogador(int vidaJogador) {
		this.vidaJogador = vidaJogador;
	}

	public void setManaJogador(int manaJogador) {
		this.manaJogador = manaJogador;
	}

	public Criatura getCriatura() {
		return criatura;
	}

	public void setCriatura(Criatura criatura) {
		this.criatura = criatura;
	}

	public ArrayList<Criatura> getMao() {
		return mao;
	}

	public void setMao(ArrayList<Criatura> mao) {
		this.mao = mao;
	}
	
	
}
