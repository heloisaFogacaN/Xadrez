import java.util.ArrayList;

public class Torre extends Peca{

    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        Posicao posicaoAtual= this.getPosicao();
        int posicaoNoTabuleiro = tabuleiro.getPosicoes().indexOf(posicaoAtual);
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();

        for(int i = posicaoNoTabuleiro + 8; i< tabuleiro.getPosicoes().size(); i+=8){
            if(verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos)){
                break;
            }
        }
        for(int i = posicaoNoTabuleiro - 8; i >= 0; i-= 8){
            if(verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos)){
                break;
            }
        }
        for(int i = (validaExtremidade(posicaoNoTabuleiro+1) ? 64 : posicaoNoTabuleiro +1) ; i< tabuleiro.getPosicoes().size() ; i++) {
            if( verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos) || validaExtremidade(i +1) ){
                break;
            }
        }
        for(int i = (validaExtremidade(posicaoNoTabuleiro+1) ? -1 : posicaoNoTabuleiro -1) ; i>=0 ; i--) {
            if(verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos)  || validaExtremidade(i) ){
                break;
            }
        }
        return possiveisMovimentos;
    }


}
