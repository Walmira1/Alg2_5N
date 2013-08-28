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
        System.out.print("Fazer com que um caminhão com tanque de combustível com capacidade para ");
        System.out.println ("6 unidades de combustível atravesse um [mapa] com 10 unidades de distância.");
        System.out.println ("REGRAS DO JOGO"); 
        System.out.print("");
        System.out.println("O jogador controla o caminhão através dos comandos: avancar(1), voltar(2), ");     
        System.out.println("carregar (3) e descarregar (4).- Cada vez que o caminhão move, ele gasta ");      
        System.out.println("uma unidade de combustível e anda uma unidade de distância. - Na posição ");    
        System.out.println("inicial do mapa existe um estoque infinito de combustível.- O jogador pode ");
        System.out.println("descarregar combustível do caminhão, que ficará depositado na posição do mapa ");
        System.out.println("onde o caminhão se encontra.- O jogador pode, a qualquer momento carregar uma ");
        System.out.println("unidade de combustível para o caminhão, desde que exista uma unidade de ");        
        System.out.println("combustível disponível na posição onde o mesmo se encontra.- O jogo acaba ");     
        System.out.println("quando o caminhão chegar na última posição do mapa (caso em que o jogador ");      
        System.out.println("ganha), ou quando o caminhão ficar sem combustível e não puder ser recarregado ");
        System.out.println("Vamos jogar??(sim ou não)");
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
	    System.out.println ("Entre com a sua opção 1- avança, 2 - voltar, 3 - descarregar, 4 - carregar  ");
	    //recebeOpcao = leitor.toString();
	    recebeOpcao = leitor.nextInt();
	    return recebeOpcao; 
	}
	public void printstatus(){
		capacidadeTanque = 6 - quantidadeTanque;
        System.out.println("Posição do mapa =  "+ posicao );
        System.out.println("Capacidade do tanque  =  " + capacidadeTanque);
        System.out.println("Quantidade de combustivel no tanque =  " + quantidadeTanque); 
        System.out.println("Quantidade de combustivel nesta posição =  " + mapa[posicao]);
	    
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
			System.out.println("Sem combustivel para avançar" );
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

