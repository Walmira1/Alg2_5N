import java.util.Scanner;
public class JogoCaminhao {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ModeloJogo obj = new ModeloJogo();
		obj.regras();
		obj.jogo();
	}

}
class ModeloJogo{
	private int posicao = 0;
    private int quantidadeTanque;
    private int capacidadeTanque; 
    private int mapa[] = { 999999999,0,0,0,0,0,0,0,0,0};
   
    
	public ModeloJogo(){
		
	}
	
	public void regras(){
        
        System.out.println ("OBJETIVO DO JOGO");
        System.out.print("");
        System.out.print("Fazer com que um caminh�o com tanque de combust�vel com capacidade para ");
        System.out.println ("6 unidades de combust�vel atravesse um [mapa] com 10 unidades de dist�ncia.");
        System.out.println ("REGRAS DO JOGO"); 
        System.out.print("");
        System.out.println("O jogador controla o caminh�o atrav�s dos comandos: avancar(1), voltar(2), ");     
        System.out.println("carregar (3) e descarregar (4).- Cada vez que o caminh�o move, ele gasta ");      
        System.out.println("uma unidade de combust�vel e anda uma unidade de dist�ncia. - Na posi��o ");    
        System.out.println("inicial do mapa existe um estoque infinito de combust�vel.- O jogador pode ");
        System.out.println("descarregar combust�vel do caminh�o, que ficar� depositado na posi��o do mapa ");
        System.out.println("onde o caminh�o se encontra.- O jogador pode, a qualquer momento carregar uma ");
        System.out.println("unidade de combust�vel para o caminh�o, desde que exista uma unidade de ");        
        System.out.println("combust�vel dispon�vel na posi��o onde o mesmo se encontra.- O jogo acaba ");     
        System.out.println("quando o caminh�o chegar na �ltima posi��o do mapa (caso em que o jogador ");      
        System.out.println("ganha), ou quando o caminh�o ficar sem combust�vel e n�o puder ser recarregado ");
        System.out.println("Vamos jogar??(sim ou n�o)");
        System.out.println("");
        
	}    
	public void jogo(){
		boolean k;
		k = true;
		int opcao;
		//opcao = getopcao();
		do{
		printstatus();
		opcao = getopcao();
		//System.out.println("opcao " + opcao);
		switch (opcao) {
		case 1:
			posicao = setavancar(posicao);
			break;
		case 2:
			posicao = voltar(posicao);
	    	break;
		case 3 :
			descarregar(posicao);
		    break;
		case 4 :
			carregar(posicao);
			break;
		default :
			System.out.println("Do you know to read??? entry with the right number please!" );
	    	break;
			
		}// fim switch	*/
		
		if (posicao == 99)
			k = false;
		}
		while(k);
	    	
	}
	public int getopcao(){	
		int recebeOpcao;
    	Scanner leitor = new Scanner(System.in);
    	System.out.println ("");
	    System.out.println ("Entre com a sua op��o 1- avan�a, 2 - voltar, 3 - descarregar, 4 - carregar  ");
	    //recebeOpcao = leitor.toString();
	    recebeOpcao = leitor.nextInt();
	    return recebeOpcao; 
	}
	public void printstatus(){
		capacidadeTanque = 6 - quantidadeTanque;
        System.out.println("Posi��o do mapa =  "+ posicao );
        System.out.println("Capacidade do tanque  =  " + capacidadeTanque);
        System.out.println("Quantidade de combustivel no tanque =  " + quantidadeTanque); 
        System.out.println("Quantidade de combustivel nesta posi��o =  " + mapa[posicao]);
	    
	}
	public void carregar(int posicao){
		posicao = this.posicao;
		if (mapa[posicao] < capacidadeTanque ){
            quantidadeTanque = quantidadeTanque + mapa[posicao];
            mapa[posicao] = 0;
            }
        else{
        	if (quantidadeTanque < 6){
              quantidadeTanque = quantidadeTanque + capacidadeTanque;
              mapa[posicao] = mapa[posicao] - capacidadeTanque;
              System.out.println("FULL");}
        	else 
        		System.out.println("looser you are full .... fuller and looser");	
            }
	}
	public void descarregar(int posicao){
		if (quantidadeTanque > 0) {	
    		capacidadeTanque ++;
            quantidadeTanque --;
            mapa[posicao] ++;  } 
		else {
			System.out.println("Looooseerrrrr" );
			System.out.println("Are you drunk??? empty, do anything smart please" );
		}
	}
	public int setavancar(int posicao){
		this.posicao = posicao;
		if (quantidadeTanque == 0){
			if (mapa[posicao] == 0 ){
				System.out.println("Looooseerrrrr" );
				System.out.println("Game Finish... the end" );
				posicao = 99;				
			   }
			System.out.println("Sem combustivel para avan�ar" );
		   }
		else{
		posicao++; 
        capacidadeTanque ++;
        quantidadeTanque --;
		}
		
        return posicao;
	}
	public int voltar(int posicao){
		this.posicao = posicao;
		if (posicao > 0) {
		posicao --; 
        capacidadeTanque ++;
        quantidadeTanque --;       
		}
		else System.out.println("losers run back... winners run in front" );
	return posicao;
	}
	
	
}

