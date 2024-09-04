package AtributosCartas;

//import java.lang.reflect.Constructor;

public class Criatura{

    protected int poder;
    protected int resistencia;
    protected int custoMana;
    private String nome;
    private String descricao;
    
    public Criatura(int poder, int custoMana, int resistencia, String nome, String descricao) {
    	
    	this.poder = poder;
    	this.custoMana = custoMana;
    	this.resistencia = resistencia;
    	this.nome = nome;
    	this.descricao = descricao;
    }
    
    //Métodos específicos da classe
    
    public void ataque(Criatura defensor) {
    	if(getPoder() > defensor.getResistencia()) {
    		System.out.println(getNome() + " destruiu " + defensor.getNome());
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
    
    public void furia() {
		poder = poder + 1;
		resistencia = resistencia - 2;
		System.out.println("Novo poder:" + getPoder() + " Nova resistencia:" + getResistencia());
	}
    
    public void fortificar() {
		resistencia = resistencia + 2;
		poder = poder - 1;
		System.out.println("Novo poder:" + getPoder() + " Nova resistencia:" + getResistencia());
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
}
