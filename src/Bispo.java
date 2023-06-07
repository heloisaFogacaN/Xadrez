import java.util.ArrayList;

public class Bispo extends Peca{
    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        Posicao posicaoAtual= this.getPosicao();
        int posicaoNoTabuleiro = tabuleiro.getPosicoes().indexOf(posicaoAtual);
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();
        for(int i = (posicaoNoTabuleiro %8 == 0 ? 64 : posicaoNoTabuleiro+7); i < tabuleiro.getPosicoes().size(); i+=7){
            possiveisMovimentos.add(tabuleiro.getPosicoes().get(i));
            if(i % 8 || i+1 % 8 ==0)
        }
        for(int i = ((posicaoNoTabuleiro + 1) %8 == 0 ? -1 : posicaoNoTabuleiro-7); i >= 0; i-=7){
            possiveisMovimentos.add(tabuleiro.getPosicoes().get(i));
        }
        for(int i = ((posicaoNoTabuleiro + 1) %8 == 0 ? 64 : posicaoNoTabuleiro+7); i < tabuleiro.getPosicoes().size(); i+=9){
            possiveisMovimentos.add(tabuleiro.getPosicoes().get(i));
        }
        for(int i = ((posicaoNoTabuleiro + 1) %8 == 0 ? -1 : posicaoNoTabuleiro+7); i >= 0; i-=9){
            possiveisMovimentos.add(tabuleiro.getPosicoes().get(i));
        }

//        for(Posicao posicao: tabuleiro.getPosicoes()){
//            int contador=tabuleiro.getPosicoes().indexOf(posicao);
//            if((contador-posicaoNoTabuleiro) % 7 ==0){
//                possiveisMovimentos.add(posicao);
//            } else if((contador-posicaoNoTabuleiro) % 9 ==0){
//                possiveisMovimentos.add(posicao);
//            }
//            if(){
//
//            }
//        }
        return possiveisMovimentos;
    }
}
