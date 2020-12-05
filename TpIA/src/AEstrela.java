
import java.util.ArrayList;
import java.util.PriorityQueue;

public class AEstrela {
    private PriorityQueue<No> fronteira = new PriorityQueue<>();
    private ArrayList<No> noRemovido = new ArrayList<>();
    static ArrayList<No> Caminho = new ArrayList<>();
    static int numerodeNos=0;

    public static void setNumerodeNos(int numerodeNos) {
        AEstrela.numerodeNos = numerodeNos;
    }
    private  int limite = 2;
    

    public AEstrela() {    
    }
    
    public boolean Busca(No noInicial, int limit) {
        limite=limit;
    

        fronteira.add(noInicial);

        No noBusca;

        while (!fronteira.isEmpty()) {

            //remove o no da fronteira
            noBusca = fronteira.poll();
            numerodeNos++;

            noRemovido.add(noBusca);
            //testa se o no removido é objetivo, retorna e sai do loop
            if (noBusca.getEstado().Objetivo(noBusca.getEstado().getMatriz())) {
                    System.out.println("\nAchei: \n");
                    ImprimeCaminho(noBusca);
                    return true;
                }
            //criar um array list que recebe os nós' removidos da fronteira, 
            //e o atributo pai dos sucessores que forem gerados desse no que foi removido, sera o indice desse no no array list       
            
            //gera sucessores e depois insere na fronteira
                           
                //gera sucessores e depois insere na fronteira
                
                fronteira.addAll(noBusca.GeraSucessores(noRemovido.size() - 1));
            

        }
        return false;
    }
    
    public void ImprimeCaminho(No no){ 
        
        if (no.getPai()!=-1){
            ImprimeCaminho(noRemovido.get(no.getPai()));
        }
        System.out.println("Pai: " + no.getPai());
            no.getEstado().ImprimirEstado();
            Caminho.add(no);
    }

    public PriorityQueue<No> getFronteira() {
        return fronteira;
    }

    public void setFronteira(PriorityQueue<No> fronteira) {
        this.fronteira = fronteira;
    }

    public ArrayList<No> getNoRemovido() {
        return noRemovido;
    }

    public void setNoRemovido(ArrayList<No> noRemovido) {
        this.noRemovido = noRemovido;
    }
    
}
