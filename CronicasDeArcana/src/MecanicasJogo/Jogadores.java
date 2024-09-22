package MecanicasJogo;

import java.util.ArrayList;

import Criaturas.*;
import Cartas.Carta;
public class Jogadores {

	private String nomeJogador;
	private int vidaJogador;
	private int manaJogador;
	private Carta criatura;
	//Novo
	private ArrayList<Carta> mao;
	private ArrayList<Carta> campoDeBatalha;
	
	public Jogadores(String nome, int vida, int mana, ArrayList<Carta> mao, ArrayList<Carta> campoDeBatalha) {
    	
    	this.nomeJogador = nome;
    	this.vidaJogador = vida;
    	this.manaJogador = mana;
    	this.mao = mao;
    	//Novo
    	this.campoDeBatalha = campoDeBatalha;
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

	public Carta getCriatura() {
		return criatura;
	}

	public void setCriatura(Carta criatura) {
		this.criatura = criatura;
	}

	public ArrayList<Carta> getMao() {
		return mao;
	}

	public void setMao(ArrayList<Carta> mao) {
		this.mao = mao;
	}

	
	//Novo
	public ArrayList<Carta> getCampoDeBatalha() {
		return campoDeBatalha;
	}

	public void setCampoDeBatalha(ArrayList<Carta> campoDeBatalha) {
		this.campoDeBatalha = campoDeBatalha;
	}
	
	
	
	
}
