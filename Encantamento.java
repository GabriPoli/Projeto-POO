package enchantments;


public class Encantamento implements Encantamentos {

    private int poder;
    private String nome;
    private String descricao;

    public Encantamento(int poder, String nome, String descricao) {

        this.poder = poder;
        this.nome = nome;
        this.descricao = descricao;


    }


    @Override
    public int getPoder() {
        return poder;
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




