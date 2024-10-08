package Cartas;

//import java.lang.reflect.Constructor;

public class Criatura extends Carta{

    protected int poder;
    protected int resistencia;
    protected int custoManaHabilidade;
    protected String nome;
    private String descricao;
    private boolean vivo;
    
    public Criatura(int poder, int custoManaHabilidade, int resistencia, String nome, String descricao) {
    	
    	super(poder, custoManaHabilidade, resistencia, nome, descricao);
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
    }
    
    public int danoRecebido(Criatura defensora) {
    	return this.poder - defensora.resistencia;
	}
    
    public void receberFeitico(int quantidade) {
    	
    	this.resistencia -= quantidade;
    }
    
    public void receberCura(int quantidade) {
    	
    	this.resistencia += quantidade;
    }
 
}
