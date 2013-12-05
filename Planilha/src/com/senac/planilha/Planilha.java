package com.senac.planilha;

import com.senac.Listas.*;

import java.util.Scanner;

import com.senac.algoritmos.AvaliadorExpressao;
import com.senac.algoritmos.InvalidOperator;
import com.senac.algoritmos.InvalidToken;

public class Planilha {

	/**
	 * @param args
	 * @throws InvalidOperator
	 * @throws InvalidToken
	 */

	public static void main(String[] args) throws InvalidOperator, InvalidToken {
		
		String nome;
		String formula;
		double result = 0;
		ListaEncadeada listacolunas = new ListaEncadeada();
		ListadeCelulas lista = new ListadeCelulas();
		Scanner sc1 = new Scanner(System.in);
		listacolunas =  buildPlanilha();
		writeScreem(listacolunas);
		while (true) {
			Celula celula = new Celula();
			System.out.println();
			System.out.println("Digite a celula: ");
		//	nome = new Scanner(System.in).next();
			Scanner sa = new Scanner(System.in);
			nome = sa.nextLine();
			if (nome.equalsIgnoreCase("fim")) {
				System.out.println("Fim do Programa");
				break;
			}
			celula.setnome(nome);
	        nome = verifyName(nome);
			nome = nome.substring(0, 1);
			
			int i = Integer.parseInt(nome) - 1;
					
			nome = celula.getnome();
			nome = nome.substring(1);
			int z = Integer.parseInt(nome) - 1;
			lista = listacolunas.get(i); 
			if (lista != null){
			   formula = lista.get(z);
			   }
			else
			   formula = "  "	;
			celula.setformula(formula);
			System.out.println(celula.getnome() + " Formula = " + celula.getformula());
			System.out.println("Insira a nova Formula: ");
			Scanner sc = new Scanner(System.in);
			
				formula = sc.nextLine();
				celula.setformula(formula);
				lista.change(z, celula.getformula());
	/*	  		lista.adicionaQualquerPosicao(0,celula.getformula());
				if (formula.equalsIgnoreCase("fim")) {
					System.out.println("Fim do Programa");
					break;
				
				}
				String postfix = AvaliadorExpressao
						.convertInfixToPostfix(formula);
				result = AvaliadorExpressao.evaluateRPN(postfix);
				System.out.println(celula.getnome() + '\n');
				System.out.println(celula.getnome() + ":" + result + '\n');
				
	*/
				
         
			}
		}
	   public static ListaEncadeada buildPlanilha(){
		   ListaEncadeada listacoluna = new ListaEncadeada();
		   for (int i = 0; i < 5 ; i ++){
			  switch (i) {
				case 0: ListadeCelulas listaA = new  ListadeCelulas();
				        listaA.add("5");
				        listaA.add("10");
				        listaA.add("15");
				        listacoluna.add(listaA);
				        				        
				case 1: ListadeCelulas listaB = new  ListadeCelulas();
						listaB.add("2");
						listaB.add("3");
						listaB.add("4");
						listacoluna.add(listaB);	
				case 2: ListadeCelulas listaC = new  ListadeCelulas();
				        listaC.add("(A1+A2)*(B1+B2)");
				    	listacoluna.add(listaC);
		//		case 3: ListadeCelulas listaD = new  ListadeCelulas();
			//	default: ListadeCelulas listaF = new  ListadeCelulas();
			   }
			  
		   }
		   return listacoluna;		   
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
	   static void writeScreem(ListaEncadeada listaencadeada) throws InvalidOperator, InvalidToken{
		   double result = 0;
		   String [] letras = {"A", "B", "C", "D", "E", "F", "G"};
		   String formula = " ";
	//	   String nome = " ";
		   int z = 0;
		   ListadeCelulas listacelulas = new ListadeCelulas();
		   for (int i = 0; i < listaencadeada.size(); i++){
			   listacelulas = listaencadeada.get(i);
			   System.out.println();
			    System.out.println(letras[i]);
			   for (int j = 0; j < listacelulas.size(); j++){
				    
				    z = j + 1;
				   System.out.print(letras[i] +""+z+":" + "  ");
				//   nome = ""+j;
				//   nome = letras[j].concat(nome);
				   formula = listacelulas.get(j);
				   
				   
				   result = resolveformula(formula);
				   System.out.print(""+ result);
				   }
		   }
		
	   }
	   public static double resolveformula(String formula) throws InvalidOperator, InvalidToken{
		   double result = 0;
		   Celula celula = new Celula();
		   celula.setformula(formula);
		   if (formula.equalsIgnoreCase("fim")) {
				System.out.println("Fim do Programa");
		    			
			}
			String postfix = AvaliadorExpressao
					.convertInfixToPostfix(formula);
			result = AvaliadorExpressao.evaluateRPN(postfix);
	//		System.out.println(celula.getnome() + '\n');
	//		System.out.println(celula.getnome() + ":" + result + '\n');
            return result;
	       
	   }     
	
	}
	
	
	
	


