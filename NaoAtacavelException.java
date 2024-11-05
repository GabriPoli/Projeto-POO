package Erros;

public class NaoAtacavelException extends Exception{
	public NaoAtacavelException() {
        super("Carta não atacável.");
    }
}
