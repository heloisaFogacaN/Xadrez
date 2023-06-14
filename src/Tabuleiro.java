import java.util.ArrayList;
import java.util.function.Predicate;

public class Tabuleiro {
    private ArrayList<Posicao> posicoes= new ArrayList<>();

    public Tabuleiro(){
        for (int i = 0 ; i < 64 ; i++){
            posicoes.add(new Posicao());
            if(i >= 8 && i <= 15){
                posicoes.get(i).setPeca(new Peao("Preto"));
            }
            if(i >= 48 && i <= 55){
                posicoes.get(i).setPeca(new Peao("Branco"));
            } if(i==0 || i==7){
                posicoes.get(0).setPeca(new Torre("Preto"));
            } if(i==0 || i==7){
                posicoes.get(0).setPeca(new Torre("Branco"));
            } if(i==0 || i==7){
                posicoes.get(0).setPeca(new Cavalo("Preto"));
            } if(i==0 || i==7){
                posicoes.get(0).setPeca(new Cavalo("Branco"));
            } if(i==0 || i==7){
                posicoes.get(0).setPeca(new Bispo("Preto"));
            } if(i==0 || i==7){
                posicoes.get(0).setPeca(new Bispo("Branco"));
            } if(i==0 || i==7){
                posicoes.get(0).setPeca(new Rainha("Preto"));
            } if(i==0 || i==7) {
                posicoes.get(0).setPeca(new Rainha("Branco"));
            } if(i==0 || i==7){
                posicoes.get(0).setPeca(new Rei("Preto"));
            } if(i==0 || i==7){
                posicoes.get(0).setPeca(new Rei("Branco"));
            }

        }
    }

    public ArrayList<Posicao> getPosicoes() {
        return posicoes;
    }

    public void removerPeca(Posicao posicao){
    }
}
