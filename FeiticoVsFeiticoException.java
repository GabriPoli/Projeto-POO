package Erros;

public class FeiticoVsFeiticoException extends Exception {
	public FeiticoVsFeiticoException() {
		super("Feitiços não podem atacar entre si!");
	}

}
