package spells;

public class Feiticos implements Feitico {

    private int poder;
    private int mana;
    private String nome;
    private String descricao;

    public Feiticos(int poder, int mana, String nome, String descricao) {

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
        System.out.println(nome);
        return nome;
    }

    @Override
    public String getDescricao() {
        System.out.println(descricao);
        return descricao;
    }
}
