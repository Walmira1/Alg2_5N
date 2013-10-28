
import static java.lang.System.*;

import java.util.LinkedList;


public class PilhaString {
	private String[] dados;
	

	private int topo;

	public PilhaString(int tamanho) {
		this.topo = 0;
		this.dados = new String[tamanho];
	}

	public void insert(String x) throws Exception {
		if (this.cheia())
			throw new Exception("pilha cheia");
		this.dados[topo] = x;
		topo++;

	}

	public String consulta() throws Exception {
		if (this.vazia())
			return " ";
		return dados[topo - 1];

	}
	// vai retirar o topo da pilha 
	public String exclusao() throws Exception{
		if (this.vazia())
			return " ";
		String res = this.consulta();
		topo--;
		return res;
		
	}

	public boolean vazia() {
		return topo == 0;
	}

	public boolean cheia() {
		return topo == dados.length;
	}

	
}

