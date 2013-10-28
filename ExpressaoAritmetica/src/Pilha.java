
public class Pilha {
	private double[] dados;
	private int topo;

	public Pilha(int tamanho) {
		this.topo = 0;
		this.dados = new double[tamanho];
	}

	public void insert(double x) throws Exception {
		if (this.cheia())
			throw new Exception("pilha cheia");
		this.dados[topo] = x;
		topo++;
			}

	public double consulta() throws Exception {
		if (this.vazia())
			throw new Exception("pilha vazia");
		return dados[topo - 1];

	}
	// vai retirar o topo da pilha 
	public double exclusao() throws Exception{
		if (this.vazia())
			throw new Exception("pilha vazia");
		double res = this.consulta();
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
