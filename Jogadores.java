package MecanicasJogo;

public class Jogadores {

	private String nomeJogador;
	private int vidaJogador;
	private int manaJogador;
	
	public Jogadores(String nome, int vida, int mana) {
    	
    	this.nomeJogador = nome;
    	this.vidaJogador = vida;
    	this.manaJogador = mana;
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
	
	
}
