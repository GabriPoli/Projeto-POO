package AtributosCartas;

public class FabricaDeCartas {

	public Criatura criarCarta(String tipo) {
		switch(tipo) {
			case "Minotauro":
				return new Criatura(7, 3, 4, "Minotauro", "Ele vaga e acaba com qualquer um que pise no seu labirinto!");
			case "Hidra":
				return new Criatura(4, 2, 3, "Hidra", "Seu veneno esmagador avaba com seu inimigos apenas com o hálito!");
			case "Cerbero":
				return new Criatura(8, 4, 5, "Cérbero", "O guardião do submundo, que não permite que ninguem escape do inferno!");
			case "Fenix":	
				return new Criatura(3, 1, 6, "Fênix", "Das suas próprias cinzas renasce e levanda voo rumo a novos desafios!");
			case "Yeti":
				return new Criatura(5, 2, 3, "Yeti", "");
			case "Grifo":
				return new Criatura(5, 2, 2, "Grifo", "");
			default:
				throw new IllegalArgumentException("Carta não encontrada: " + tipo);
		}
		
	}
	
	public Habilidades criarHabilidade(String tipo) {
		switch(tipo) {
			case "Furia":
				return new Habilidades(2, +1, -2,"Fúria", "+1 de poder, porém -2 de resistência(2 turnos)!");
			case "Dreno":
				return new Habilidades(3, +5, -5,"Dreno", "-5 de vida do oponente e +5 de vida para você(intantaneo)!");
			case "Fortificacao":
				return new Habilidades(2, +2, -1,"Fortificação", "-1 de poder, porém +2 de resistência(2 turnos)!");
			default:
				throw new IllegalArgumentException("Carta não encontrada: " + tipo);
		}
		
	}
	
	
}
