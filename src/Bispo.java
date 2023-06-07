import java.util.ArrayList;

public class Bispo extends Peca{

    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        Posicao posicaoAtual= this.getPosicao();
        int posicaoNoTabuleiro = tabuleiro.getPosicoes().indexOf(posicaoAtual);
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();
        for(int i = (posicaoNoTabuleiro %8 == 0 ? 64 : posicaoNoTabuleiro+7); i < tabuleiro.getPosicoes().size(); i+=7){
            valida(tabuleiro.getPosicoes().get(i));
            if(i%8==0){
                break;
            }
        }
        //No for, na primeira vez que roda, ele ignora a terceira parte, na segunda ele ignora a primeira, e na terceira ee ignora a segunda
        for(int i = ((posicaoNoTabuleiro + 1) %8 == 0 ? -1 : posicaoNoTabuleiro-7); i >= 0; i-=7){
            //Esse "?" significa um if ternário, onde caso seja vdd ele irá retornar o que está antes dos dois pontos, e caso seja falso oq está depois
            if( (i+1 ) %8==0){
                break;
            }
        }
        for(int i = ((posicaoNoTabuleiro + 1) %8 == 0 ? 64 : posicaoNoTabuleiro+7); i < tabuleiro.getPosicoes().size(); i+=9){
            possiveisMovimentos.add(tabuleiro.getPosicoes().get(i));
            if(i%8==0){
                break;
            }
        }
        for(int i = ((posicaoNoTabuleiro + 1) %8 == 0 ? -1 : posicaoNoTabuleiro+7); i >= 0; i-=9){
            possiveisMovimentos.add(tabuleiro.getPosicoes().get(i));
            if( (i+1) % 8==0){
                break;
            }
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
