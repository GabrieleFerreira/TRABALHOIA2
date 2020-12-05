
import java.util.ArrayList;



public class NoBuscaGulosa implements Comparable<NoBuscaGulosa>{

    private Estado  estado;
    private int     profundidade;
    private int     pai;
    private int     heuristica;

    public NoBuscaGulosa(Estado estado, int profundidade, int pai) {
        this.estado = estado;
        this.profundidade = profundidade;
        this.pai = pai;
        FuncaoHeuristicaPecas();
    }

    public NoBuscaGulosa() {
    }

    
  
    public ArrayList<NoBuscaGulosa> GeraSucessores(int indexPai) {
        ArrayList<NoBuscaGulosa> sucessores = new ArrayList<>();
        Estado direita;
        Estado esquerda;
        Estado cima;
        Estado baixo;

        
        direita = this.estado.GeraSucessor('d'); 
        if (direita != null) {
            NoBuscaGulosa noSucessor1 = new NoBuscaGulosa(direita, this.profundidade+1, indexPai);
            sucessores.add(noSucessor1);
            
        }

        
        esquerda = this.estado.GeraSucessor('e');
        if (esquerda != null) {
            NoBuscaGulosa noSucessor2 = new NoBuscaGulosa(esquerda, this.profundidade+1, indexPai);
            sucessores.add(noSucessor2);
            
        }

       
        cima = this.estado.GeraSucessor('c');
        if (cima != null) {
            NoBuscaGulosa noSucessor3 = new NoBuscaGulosa(cima, this.profundidade+1, indexPai);
            sucessores.add(noSucessor3);
            
        }

        
        baixo = this.estado.GeraSucessor('b');
        if (baixo != null) {
            NoBuscaGulosa noSucessor4 = new NoBuscaGulosa(baixo, this.profundidade+1, indexPai);
            sucessores.add(noSucessor4);
            
        }
        
        return (ArrayList<NoBuscaGulosa>) sucessores;
    }
    
    
    private void FuncaoHeuristicaPecas(){
        heuristica = 0;
        int matrizObjetivo[][] = {{1, 2, 3}, 
                                  {4, 5, 6}, 
                                  {7, 8, 0}};
        for(int i=0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                if (matrizObjetivo[i][j] != this.estado.getMatriz()[i][j]) {
                    heuristica++;
                }
            }
            
        }
        //return heuristica;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(int profundidade) {
        this.profundidade = profundidade;
    }

    public int getPai() {
        return pai;
    }

    public void setPai(int pai) {
        this.pai = pai;
    }

    public int getHeuristica() {
        return heuristica;
    }

    public void setHeuristica(int heuristica) {
        this.heuristica = heuristica;
    }


    @Override
      public int compareTo(NoBuscaGulosa NoBuscaGulosa) {
        if (this.heuristica > NoBuscaGulosa.heuristica) {
            return 1;
        }else if(this.heuristica < NoBuscaGulosa.heuristica){
            return -1;
        }else{
            return 0;
        }
    }

   

}
   

