package AtributosCartas;

//import java.lang.reflect.Constructor;

public class Criatura{

    protected int poder;
    protected int resistencia;
    protected int custoMana;
    protected int custoManaHabilidade;
    private String nome;
    private String descricao;
    private boolean vivo;
    
    public Criatura(int poder, int custoMana, int resistencia, int custoManaHabilidade, String nome, String descricao) {
    	
    	this.poder = poder;
    	this.custoMana = custoMana;
    	this.custoManaHabilidade = custoManaHabilidade;
    	this.resistencia = resistencia;
    	this.nome = nome;
    	this.descricao = descricao;
    	this.vivo = true;
    }
    
    //Métodos específicos da classe
    
    public void ataque(Criatura defensor, int danoVida) {
    	if(getPoder() > defensor.getResistencia()) {
    		System.out.println(getNome() + " destruiu " + defensor.getNome());
    		danoVida = danoVida - (getPoder() - defensor.getResistencia());
    		defensor.setVivo(false);
    	}
    	else {
    		System.out.println(getNome() + " não destruiu " + defensor.getNome());
    	}
    }
    
    public void mostrarCriatura() {
    	System.out.println("Nome: " + getNome());
    	System.out.println("Descrição: " + getDescricao());
    	System.out.println("Poder: " + getPoder());
    	System.out.println("resistencia: "+ getResistencia());
    	System.out.println("Custo de mana do ataque: " + getCustoMana());
    }
    
    public int danoRecebido(Criatura defensora) {
    	return this.poder - defensora.resistencia;
	}
    
    // Getters
	public int getPoder() {
		return poder;
	}

	public int getResistencia() {
		return resistencia;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getCustoMana() {
		return custoMana;
	}
	
	public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }
}
