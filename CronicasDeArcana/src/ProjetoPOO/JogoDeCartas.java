package ProjetoPOO;

import java.util.ArrayList;
import java.util.Scanner;

import Cartas.Criatura;
import MecanicasJogo.Jogadores;
import MecanicasJogo.Jogo;

public class JogoDeCartas {
	
    public static void main(String[] args) {
    	
    	Jogo jogo = new Jogo();
    	
    	Jogadores jogador1 = new Jogadores("Freitas", 20, 10, jogo.getListaCriaturas1(), jogo.getCampoDeBatalha1());
    	Jogadores jogador2 = new Jogadores("Leal", 20, 10, jogo.getListaCriaturas2(), jogo.getCampoDeBatalha2());

        jogo.comecoJogo(jogador1);
        jogo.comecoJogo(jogador2);
     
        while(jogador1.getVidaJogador() > 0 && jogador2.getVidaJogador() > 0) {
  
        	jogo.executarTurno(jogador1, jogador2);
        	jogo.exibirStatus(jogador1, jogador2);
        }
        
        System.out.println("Fim de Jogo!!!");
        

        
        
        
        
        
        
        
        
        //ArrayList<Criatura> listaCriaturas = jogador1.getCriaturasLista();
        //Selecione qual carta vc quer usar para atacar seu baitola
       //for (Criatura criatura : listaCriaturas) {
		//0 - criatura.getNome();
    	   
    	   //criatura.getNome();
       //}
       
       //criaturas.get(0);
       
    }
    
   
}
