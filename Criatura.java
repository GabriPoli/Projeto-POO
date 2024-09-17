package cartas;

public class Criatura extends Carta {
    public Criatura(int poder, int resistencia, int mana, String nome, String descricao) {
        super(poder, mana, resistencia, nome, descricao);

    }

    public void aumentarResistencia(int quantidade){

        this.resistencia += quantidade;
    }

    public void receberFeitico(int quantidade){
        this.mana -= quantidade;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }


}
