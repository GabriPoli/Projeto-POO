package players;

public class Jogador1 {
    private String nome;
    private int vida;
    private int mana;

    public Jogador1(String nome, int vida, int mana) {

        this.nome = nome;
        this.vida = vida;
        this.mana = mana;


    }

    public int getMana() {
        return mana;
    }


    public String getNome() {

        return nome;
    }

    public int getVida() {

        return vida;
    }

    public void aumentarVida(int quantidade) {

        this.vida += quantidade;

    }
}
