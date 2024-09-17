package cartas;

public class Carta implements Cartas{
    protected int resistencia;
    protected int poder;
    protected int mana;
    protected boolean vivo;
    private String nome;
    private String descricao;


    public Carta(int poder, int mana, int resistencia, String nome, String descricao) {

        this.poder = poder;
        this.mana = mana;
        this.nome = nome;
        this.descricao = descricao;

    }

    @Override
    public int getPoder() {
        return poder;
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    public int getResistencia() {
        return resistencia;
    }
    
}
