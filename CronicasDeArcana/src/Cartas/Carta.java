package Cartas;

public class Carta {

	protected int resistencia;
    protected int poder;
    protected int mana;
    protected boolean vivo;
    private String nome;
    private String descricao;


    public Carta(int poder, int mana, int resistencia, String nome, String descricao) {

        this.poder = poder;
        this.resistencia = resistencia;
        this.mana = mana;
        this.nome = nome;
        this.descricao = descricao;

    }

    public int getPoder() {
        return poder;
    }
    
    public int getMana() {
        return mana;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getResistencia() {
        return resistencia;
    }
    
    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }
   
    
	
}
