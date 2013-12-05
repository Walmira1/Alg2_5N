package com.senac.algoritmos;

import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

import com.senac.Listas.ListaEncadeada;
import com.senac.Listas.ListadeCelulas;

/**
 * 
 */
public class AvaliadorExpressao {

	public static double evaluate(String expressao)
			throws InvalidOperator, InvalidToken
	{
		return evaluate(expressao, Locale.US);
	}

	public static double evaluate(String expressao, Locale locale)
			throws InvalidOperator, InvalidToken
	{
		return evaluateRPN( convertInfixToPostfix(expressao, locale), locale );
	}
	
	/**
	 * 
	 * @param op
	 * @return
	 */
	private static int priority(char op) {
		switch (op) {
			case ')':
			case '(': return 3;
			case '*':
			case '/': return 2;
			case '+':
			case '-': return 1;
			default: return -1;
		}
	}
	
	/**
	 * 
	 * @param pilha
	 * @return
	 */
	private static boolean canStackOperator(Stack<Character> pilha)
	{
		return !(!pilha.isEmpty() && pilha.peek() != '(');
	}
	
	/**
	 * 
	 * @param lhs
	 * @param rhs
	 * @return
	 */
	private static boolean isLowerPriority(char lhs, char rhs)
	{
		return priority(lhs) < priority(rhs);
	}
	
	/**
	 * 
	 * @param expressao
	 * @return
	 * @throws InvalidOperator
	 * @throws InvalidToken 
	 */
	public static String convertInfixToPostfix(String expressao)
			throws InvalidOperator, InvalidToken
	{
		return convertInfixToPostfix(expressao, Locale.US);
	}
	
	/**
	 * 
	 * @param expressao
	 * @param locale
	 * @return
	 * @throws InvalidOperator
	 * @throws InvalidToken 
	 */
	public static String convertInfixToPostfix(String expressao, Locale locale)
			throws InvalidOperator, InvalidToken
	{
		ListaEncadeada listacolunas = new ListaEncadeada();
		ListadeCelulas lista = new ListadeCelulas();
		Stack<Character> pilha = new Stack<Character>(); 
		String postfix = "";
		Scanner sc = new Scanner(sanitize(expressao, locale));
		sc.useLocale(locale);
		
		while (sc.hasNext()) {
			if (sc.hasNextDouble()) {
				double d = sc.nextDouble();
				postfix += d + " ";
			} else {
				String next = sc.next();
				if (isOperator(next)) {
					postfix += handleOperator(next.charAt(0), pilha);
				} else {
					String nome = verifyName(next);
				    int i = Integer.parseInt(nome.substring(0,1)) - 1;
				  	int z = Integer.parseInt(nome.substring(1)) - 1;
				  	lista = listacolunas.get(i); 
				  	if (lista != null){
				  		System.out.println("celula "+ lista.get(z));
				  		double d = Double.parseDouble(lista.get(z)) ;
				  		postfix += d + " ";
				  	}
				  	else
					throw new InvalidToken(next);
				}
			}
		}
		
		while (!pilha.isEmpty())
			postfix += pilha.pop() + " ";

		return postfix;
	}

	private static boolean isOperator(String op)
	{
		switch (op.charAt(0))
		{
			case '(':
			case ')':
			case '+':
			case '-':
			case '*':
			case '/': return true;
			default: return false;
		}
	}
	
	private static String handleOperator(char op, Stack<Character> pilha)
	{
		String postfix = "";
		if (op == ')') {
			while (!canStackOperator(pilha))
				postfix += pilha.pop()  + " ";
			pilha.pop();
		} else if (op == '(') {
			pilha.push(op);
		} else {
			while (!canStackOperator(pilha) && isLowerPriority(op,pilha.peek()))
				postfix += pilha.pop()  + " ";
			pilha.push(op);
		}
		return postfix;
	}
	
	/**
	 * 
	 * @param expressao
	 * @return
	 */
	private static String sanitize(String expressao, Locale locale) {
		Scanner sc = new Scanner(expressao);
		sc.useLocale(locale);
		String result = "";
		String floatNumber = "[0-9]+(\\.[0-9]*)?";
		String operator    = "[\\*-/+=\\(\\)]";
		String cellCoord   = "[a-zA-Z][a-zA-z]*[0-9]+";
		String regex = floatNumber + "|" + operator + "|" + cellCoord;
		String token;
		while ( null != (token = sc.findInLine(regex)))
			result += token + " ";
		return result;
	}

	/**
	 * 
	 * @param expressao
	 * @return
	 * @throws InvalidOperator
	 * @throws InvalidToken 
	 */
	public static double evaluateRPN(String expressao)
			throws InvalidOperator, InvalidToken
	{
		return evaluateRPN(expressao, Locale.US);
	}
	
	/**
	 * 
	 * @param expressao
	 * @param locale
	 * @return
	 * @throws InvalidOperator
	 * @throws InvalidToken 
	 */
	public static double evaluateRPN(String expressao, Locale locale)
			throws InvalidOperator, InvalidToken
	{
		Stack<Double> pilha = new Stack<Double>();
		Scanner sc = new Scanner(sanitize(expressao, locale));
		sc.useLocale(locale);
				
		while (sc.hasNext()) {
			if (sc.hasNextDouble()) {
				pilha.push(sc.nextDouble());
			} else {
				String next = sc.next();
				String nome = null;
				if (isOperator(next)){
					pilha.push( executeOperation(pilha, next) );
				}
				else
					 throw new InvalidToken(next);
			}
		}
		
		return pilha.pop();
	}

	/**
	 * 
	 * @param pilha
	 * @param op
	 * @return
	 * @throws InvalidOperator
	 */
	private static Double executeOperation(Stack<Double> pilha, String op)
			throws InvalidOperator
	{
		Double rhs = pilha.pop();
		Double lhs = pilha.pop();
		switch (op.charAt(0)) {
			case '+': return lhs + rhs;
			case '-': return lhs - rhs;
			case '*': return lhs * rhs;
			case '/': return lhs / rhs;
		}
		throw new InvalidOperator();
		
	}

		
	
	public static String verifyName(String nome){
	    nome = nome.replaceFirst("A", "1");
	    nome = nome.replaceFirst("a", "1");
		nome = nome.replaceFirst("B", "2");
		nome = nome.replaceFirst("b", "2");
		nome = nome.replaceFirst("C", "3");
		nome = nome.replaceFirst("c", "3");
		nome = nome.replaceFirst("D", "4");
		nome = nome.replaceFirst("d", "4");
		nome = nome.replaceFirst("E", "5");
		nome = nome.replaceFirst("e", "5");
		nome = nome.replaceFirst("F", "6");
		nome = nome.replaceFirst("f", "6");
		nome = nome.replaceFirst("G", "7");
		nome = nome.replaceFirst("g", "7");
		nome = nome.replaceFirst("H", "8");
		nome = nome.replaceFirst("h", "8");
		System.out.println(nome);
		return nome;

   }
	
	
}
