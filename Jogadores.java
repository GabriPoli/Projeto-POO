package players;

import cartas.Criatura;
import enchantments.Vida;

import java.util.ArrayList;
import java.util.Scanner;

public class Jogadores {

    private String nomeJogador;
    private int vidaJogador;
    private int manaJogador;
    private Criatura criatura;
    private ArrayList<Criatura> criaturasLista;

    public Jogadores(String nome, int vida, int mana) {

        this.nomeJogador = nome;
        this.vidaJogador = vida;
        this.manaJogador = mana;
    }

    public void gastaMana(int manaGasta) {
        manaJogador = manaJogador - manaGasta;
    }

    public void perdeVida(int dano) {
        vidaJogador = vidaJogador - dano;
    }

    public void ganhaVida(int cura) {
        vidaJogador = vidaJogador + cura;
    }

    public int getVidaJogador() {
        return vidaJogador;
    }
    public int getManaJogador() {
        return manaJogador;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public void setVidaJogador(int vidaJogador) {
        this.vidaJogador = vidaJogador;
    }

    public void setManaJogador(int manaJogador) {
        this.manaJogador = manaJogador;
    }

    public Criatura getCriatura() {
        return criatura;
    }

    public void setCriatura(Criatura criatura) {
        this.criatura = criatura;
    }

    public ArrayList<Criatura> getCriaturasLista() {
        return criaturasLista;
    }

    public void setCriaturasLista(ArrayList<Criatura> criaturasLista) {
        this.criaturasLista = criaturasLista;
    }

    //Método Para o Encantamento
    public void aumentarVida(int quantidade) {
        vidaJogador = vidaJogador + quantidade;
    }

    public void aumentarMana(int quantidade) {
        manaJogador = manaJogador + quantidade;
    }
}
