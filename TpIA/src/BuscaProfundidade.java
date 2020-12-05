/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.ArrayList;
import java.util.Stack;
import jdk.nashorn.internal.ir.BreakNode;

public class BuscaProfundidade {

    private Stack<No>     fronteira = new Stack<>();
    private ArrayList<No> removidosFronteira = new ArrayList<>();
    static ArrayList<No> caminho = new ArrayList<>();
    static int           NumerodeNos=0;

    public BuscaProfundidade() {

    }

    public static int getNumerodeNos() {
        return NumerodeNos;
    }

    public static void setNumerodeNos(int NumerodeNos) {
        BuscaProfundidade.NumerodeNos = NumerodeNos;
    }

    public boolean Busca(No noInicial, int limite) {

        ArrayList<No> noArray = new ArrayList<>();

        //No noInicial = new No(estadoInicial, 0, -1);
        //inserir no inicial na fronteira

        fronteira.push(noInicial);

        No noBusca;

        while (!fronteira.isEmpty()) {
            NumerodeNos++;
            //remove o no da fronteira
            noBusca = fronteira.pop();

            removidosFronteira.add(noBusca);
             System.out.println("Procurando solução profundidade: "+noBusca.getProfundidade());
            //testa se o no removido é objetivo, retorna e sai do loop
            if (noBusca.getEstado().Objetivo(noBusca.getEstado().getMatriz())) {
                    System.out.println("\nAchei: \n");
                    ImprimeCaminho(noBusca);
                    return true;
                }
            //criar um array list que recebe os nós' removidos da fronteira, 
            //e o atributo pai dos sucessores que forem gerados desse no que foi removido, sera o indice desse no no array list
            
            
            if (noBusca.getProfundidade() < limite) {
                
                //gera sucessores e depois insere na fronteira
                fronteira.addAll(noBusca.GeraSucessores(removidosFronteira.size() - 1));
                /*noArray.addAll(noBusca.GeraSucessores(removidosFronteira.size() - 1));
                int i = 0;
                while (i<noArray.size()) {                    
                    fronteira.add(noArray.get(i));
                    noArray.remove(i);
                    i++;
                }*/
                
            }

        }
        return false;
    }
    
    public void ImprimeCaminho(No no){ 
        
       /* if (no.getPai()==-1) {
            System.out.println("Pai: " + no.getPai());
            no.getEstado().ImprimirEstado();
            return;
            
        }else{
            ImprimeCaminho(removidosFronteira.get(no.getPai()));
        }*/
        
        if (no.getPai()!=-1){
            ImprimeCaminho(removidosFronteira.get(no.getPai()));
            caminho.add(no);
        }
        System.out.println("Pai: " + no.getPai());
            no.getEstado().ImprimirEstado();
        /*
        No noAux = removidosFronteira.get(no.getPai());;
                    
        System.out.println("#########################################\n"
                + "++++++++++++++++Caminho+++++++++++++++++\n"
                + "#########################################");
        System.out.println("Pai: " + no.getPai());
        no.getEstado().ImprimirEstado();
         
        while (noAux.getPai()>-1) {
            System.out.println("Pai: " + noAux.getPai());
            
            noAux.getEstado().ImprimirEstado();
            noAux = removidosFronteira.get(noAux.getPai());
        }
        System.out.println("Pai: " + noAux.getPai());
            
            noAux.getEstado().ImprimirEstado();*/
    }

    public Stack<No> getFronteira() {
        return fronteira;
    }

    public void setFronteira(Stack<No> fronteira) {
        this.fronteira = fronteira;
    }

    public ArrayList<No> getRemovidosFronteira() {
        return removidosFronteira;
    }

    public void setRemovidosFronteira(ArrayList<No> removidosFronteira) {
        this.removidosFronteira = removidosFronteira;
    }

}
