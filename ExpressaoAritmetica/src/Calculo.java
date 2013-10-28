
import static java.lang.System.*;

import java.util.Scanner;

public class Calculo {
	public static void main(String[] args) {
		Pilha p1 = new Pilha(10);
		PilhaString p2 = new PilhaString(10);
		int prioridadeAnt = -1;
		int prioridade = 0;
		String sinal;
		String sinalAnt = " ";
		String[] rpnm = new String[100];
		double num = 0;
		int indice = -1;
		boolean fimCalculo = false;
		while (fimCalculo == false) {
			System.out.println("digite uma operação numerica ou fim para terminar");
			String line = teclado.nextLine();
			Scanner sc = new Scanner(line);
			try {
				while (sc.hasNext()) {
					if (sc.hasNextInt()) {
						indice++;
						rpnm[indice] = sc.next();
					} else {
						sinal = sc.next();
						prioridade = prioridade(sinal);
						if ((prioridade >= prioridadeAnt || prioridade == 0)
								&& prioridade < 4) {
							p2.insert(sinal);
							prioridadeAnt = prioridade;
						} else {
							if (prioridade == 4) {
								sinal = p2.exclusao();
								prioridade = prioridade(sinal);
								while (prioridade > 0) {
									indice++;
									rpnm[indice] = sinal;
									sinal = p2.exclusao();
									prioridade = prioridade(sinal);
								}
								sinal = " ";
							} else {
								if ((prioridade < prioridadeAnt)) {
									sinalAnt = sinal;
									prioridadeAnt = prioridade;
									sinal = p2.exclusao();
									prioridade = prioridade(sinal);
									while (prioridadeAnt < prioridade) {
										if (prioridade != 4 && prioridade != 0) {
											indice++;
											rpnm[indice] = sinal;
											sinal = p2.exclusao();
											if (sinal == " ")
												prioridade = -1;
											else
												prioridade = prioridade(sinal);
										}
									}
									if (prioridade > -1)
										p2.insert(sinal);
									p2.insert(sinalAnt);
									sinal = sinalAnt;
									prioridade = prioridade(sinal);
								}
							}

						}
					}

					prioridadeAnt = prioridade;
				}
				if (prioridade == 5){
					fimCalculo = true;}
				else {
				sinal = p2.exclusao();
				while (sinal != " ") {
					if (sinal != ")") {
						indice++;
						rpnm[indice] = sinal;
					}
					sinal = p2.exclusao();
				}
				for (int i = 0; i < indice + 1; i++) {
					sinal = rpnm[i];
					if (sinal.charAt(0) == '+' || sinal.charAt(0) == '-'
							|| sinal.charAt(0) == '*' || sinal.charAt(0) == '/') {
						p1.insert(avalia(sinal, p1));
					} else {
						num = Double.parseDouble(sinal);
						p1.insert(num);
					}
				}
				num = p1.exclusao();
				System.out.println("resultado = " + num);
				}
			} catch (Exception e) {
				err.println(e.getMessage());
			}
		}
		System.out.println("fim");
	}

	private static double avalia(String op, Pilha p) throws Exception {
		double rhs = p.exclusao();
		double lhs = p.exclusao();
		switch (op) {
		case "+":
			return lhs + rhs;
		case "-":
			return lhs - rhs;
		case "*":
			return lhs * rhs;
		case "/":
			return lhs / rhs;

		}
		throw new Exception("operador invalido para exclusão");
	}

	private static Scanner teclado = new Scanner(System.in);

	private static int prioridade(String sinal) throws Exception {
		switch (sinal) {
		case "(":
			return 0;
		case "+":
			return 1;
		case "-":
			return 1;
		case "*":
			return 2;
		case "/":
			return 3;
		case ")":
			return 4;
		default:
			return 5;
		}

	}

}
