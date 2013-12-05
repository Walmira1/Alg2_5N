package com.senac.Listas;

//import Nodo;

public class ListadeCelulas {
			
	private Nodo primeiro;
	private Nodo ultimo;
	int tamanho;

	
	public ListadeCelulas() {
		primeiro = null; 
		ultimo = null;
		tamanho = 0;
	}

	public void add(String informacao)
	{
		Nodo novo = new Nodo();
		novo.setInformacao(informacao);
								
		if (primeiro == null)
		{
			primeiro = novo;
			ultimo = novo;
		}
		else
		{
			ultimo.setProximo(novo);
			ultimo = novo;
		}
		tamanho++;
	}
	
	public String get(int posicao)
	{
		Nodo aux = primeiro;
		for (int i = 0; i < posicao; i++)
		{
			aux = aux.getProximo();
			
			if (aux == null)
				return "  ";
		}
		
		return aux.getInformacao();
	}
	
	public void remove(int posicao)
	{
		if (posicao == 0)
		{
			primeiro = primeiro.getProximo();
		}
		else
		{
			Nodo aux;
			int contPosicao = 1;
			
			for (aux = primeiro; aux != null; aux = aux.getProximo())
			{
				if (contPosicao == posicao)
				{
					aux.setProximo(aux.getProximo().getProximo());
				}
				else
					contPosicao++;
			}
		}
	}
	public void change(int posicao,String informacao)
	{
			Nodo aux = primeiro;  
			for (int i = 0; i < posicao; i++)
			{
				aux = aux.getProximo();
			
			}
			
			if (aux != null )
				aux.setInformacao(informacao);
			
	}	
	public int size()
	{
		return this.tamanho;
	}
}
