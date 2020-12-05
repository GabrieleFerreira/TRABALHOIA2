


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BuscaLargura {
    
    private Queue<No> fronteira = new LinkedList<No>();
    private ArrayList<No> removidosFronteira = new ArrayList<>();
    static ArrayList<No> caminho = new ArrayList<>();
    static int numerodeNos=0;
    //private  int limite = 7;

    public static void setNumerodeNos(int numerodeNos) {
        BuscaLargura.numerodeNos = numerodeNos;
    }

    public BuscaLargura() {

    }

    public  boolean Busca(No noInicial, int profundidade) {
       
        ArrayList<No> noArray = new ArrayList<>();

        //No noInicial = new No(estadoInicial, 0, -1);
        //inserir no inicial na fronteira

        fronteira.add(noInicial);

        No noBusca;

        while (!fronteira.isEmpty()) {

            //remove o no da fronteira
            noBusca = fronteira.poll();
            numerodeNos++;

            removidosFronteira.add(noBusca);
            //testa se o no removido é objetivo, retorna e sai do loop
            if (noBusca.getEstado().Objetivo(noBusca.getEstado().getMatriz())) {
                    System.out.println("\nAchei: \n");
                    ImprimeCaminho(noBusca);
                    return true;
                }
            //criar um array list que recebe os nós' removidos da fronteira, 
            //e o atributo pai dos sucessores que forem gerados desse no que foi removido, sera o indice desse no no array list
            
            
           
                
                //gera sucessores e depois insere na fronteira
             
                if(noBusca.getProfundidade()<profundidade)
            fronteira.addAll(noBusca.GeraSucessores(removidosFronteira.size() - 1));
                System.out.println("Procurando solução profundidade: "+noBusca.getProfundidade());
                
            

        }
        
        return false;
    }
    
    public void ImprimeCaminho(No no){ 
        if (no.getPai()==-1) {
            System.out.println("Pai: " + no.getPai());
            no.getEstado().ImprimirEstado();
            caminho.add(no);
            return ;
            
        }else{
            ImprimeCaminho(removidosFronteira.get(no.getPai()));
        }
        System.out.println("Pai: " + no.getPai());
        caminho.add(no);
            no.getEstado().ImprimirEstado();
     return;
    }

    public Queue<No> getFronteira() {
        return fronteira;
    }

    public void setFronteira(Queue<No> fronteira) {
        this.fronteira = fronteira;
    }

    public ArrayList<No> getRemovidosFronteira() {
        return removidosFronteira;
    }

    public void setRemovidosFronteira(ArrayList<No> removidosFronteira) {
        this.removidosFronteira = removidosFronteira;
    }

}
