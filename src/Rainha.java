import java.util.ArrayList;

public class Rainha extends Peca{


    public Rainha(String cor, Posicao posicao) {
        super(cor, posicao);
    }

    @Override
    public ArrayList<Posicao> possiveisMovimento(Tabuleiro tabuleiro) {
        Posicao posicaoAtual= this.getPosicao();
        int posicaoNoTabuleiro = tabuleiro.getPosicoes().indexOf(posicaoAtual);
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();

        for(int i = (validaExtremidade(posicaoNoTabuleiro) ? 64 : posicaoNoTabuleiro+7); i < tabuleiro.getPosicoes().size(); i+=7){
            possiveisMovimentos.add(tabuleiro.getPosicoes().get(i));
            if (verificaPeca(tabuleiro.getPosicoes().get(i),possiveisMovimentos)||validaExtremidade( i)) {
                break;
            }
        }
        //No for, na primeira vez que roda, ele ignora a terceira parte, na segunda ele ignora a primeira, e na terceira ele ignora a segunda
        for(int i = (validaExtremidade(posicaoNoTabuleiro+1)  ? -1 : posicaoNoTabuleiro-7); i >= 0; i-=7){
            possiveisMovimentos.add(tabuleiro.getPosicoes().get(i));
            //Esse "?" significa um if ternário, onde caso seja vdd ele irá retornar o que está antes dos dois pontos, e caso seja falso oq está depois
            if( validaExtremidade(i+1)  ||verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos)){
                break;
            }
        }
        for(int i = (validaExtremidade(posicaoNoTabuleiro+1) ? 64 : posicaoNoTabuleiro+9) ; i < tabuleiro.getPosicoes().size(); i+=9){
            possiveisMovimentos.add(tabuleiro.getPosicoes().get(i));
            if(verificaPeca(tabuleiro.getPosicoes().get(i) , possiveisMovimentos) || validaExtremidade(i+1)){
                break;
            }
        }
        for(int i = (validaExtremidade(posicaoNoTabuleiro) ? -1 : posicaoNoTabuleiro-9); i >= 0; i-=9){
            possiveisMovimentos.add(tabuleiro.getPosicoes().get(i));
            if(verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos) ||  validaExtremidade(i)){
                break;
            }
        }
        for(int i = posicaoNoTabuleiro + 8; i< tabuleiro.getPosicoes().size(); i+=8){
            possiveisMovimentos.add(tabuleiro.getPosicoes().get(i));
            if(verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos)){
                break;
            }
        }
        for(int i = posicaoNoTabuleiro - 8; i >= 0; i-= 8){
            possiveisMovimentos.add(tabuleiro.getPosicoes().get(i));
            if(verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos)){
                break;
            }
        }
        for(int i = (validaExtremidade(posicaoNoTabuleiro+1) ? 64 : posicaoNoTabuleiro +1) ; i< tabuleiro.getPosicoes().size() ; i++) {
            possiveisMovimentos.add(tabuleiro.getPosicoes().get(i));
            if( verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos) || validaExtremidade(i +1) ){
                break;
            }
        }
        for(int i = (validaExtremidade(posicaoNoTabuleiro+1) ? -1 : posicaoNoTabuleiro - 1) ; i>=0 ; i--) {
            possiveisMovimentos.add(tabuleiro.getPosicoes().get(i));
            if(verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos)  || validaExtremidade(i) ){
                break;
            }
        }
        

        return possiveisMovimentos;
    }

    @Override
    public String toString() {
        return "M";
    }
}

