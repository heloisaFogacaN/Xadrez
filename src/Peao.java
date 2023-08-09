import java.util.ArrayList;

public class Peao extends Peca {

    private boolean primMov = true;

    public Peao(String cor, Posicao posicao) {
        super(cor, posicao);
    }


    @Override
    public ArrayList<Posicao> possiveisMovimento(Tabuleiro tabuleiro) {
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();
        Posicao posicaoAtual = this.getPosicao();
        int posicaoNoTabuleiro = tabuleiro.getPosicoes().indexOf(posicaoAtual);

        ArrayList<Posicao> posicoesTabuleiro = tabuleiro.getPosicoes();
        if (this.getCor().equals("Preto")) {
            if(posicoesTabuleiro.get(posicaoNoTabuleiro+8).getPeca() ==null) {
                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 8));
                if (this.primMov) {
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro+16).getPeca() == null &&
                            posicoesTabuleiro.get(posicaoNoTabuleiro + 16).getPeca() == null) {
                        possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 16));
                    }
                }
            }
            if (posicoesTabuleiro.get(posicaoNoTabuleiro+9).getPeca() != null &&
                    posicoesTabuleiro.get(posicaoNoTabuleiro+9).getPeca().getCor().equals("Branco") && !validaExtremidade(posicaoNoTabuleiro+1)){
                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro+9));

            }
            if (posicoesTabuleiro.get(posicaoNoTabuleiro+7).getPeca() != null &&
                    posicoesTabuleiro.get(posicaoNoTabuleiro+7).getPeca().getCor().equals("Branco") && !validaExtremidade(posicaoNoTabuleiro) &&
                    posicoesTabuleiro.get(posicaoNoTabuleiro+15) == null){
                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro+7));

            }
        } else{
            if(posicoesTabuleiro.get(posicaoNoTabuleiro-8).getPeca() ==null) {
                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 8));
                if (this.primMov) {
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro-16).getPeca() == null &&
                            posicoesTabuleiro.get(posicaoNoTabuleiro - 16).getPeca() == null) {
                        possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 16));
                    }
                }
            }
            if (posicoesTabuleiro.get(posicaoNoTabuleiro-9).getPeca() != null &&
                    posicoesTabuleiro.get(posicaoNoTabuleiro-9).getPeca().getCor().equals("Preto")  && posicaoNoTabuleiro % 8 != 0){
                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro-9));

            }
            if (posicoesTabuleiro.get(posicaoNoTabuleiro-7).getPeca() != null &&
                    posicoesTabuleiro.get(posicaoNoTabuleiro-7).getPeca().getCor().equals("Preto")  && (posicaoNoTabuleiro + 1) % 8 != 0){
                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro-7));

            }
        }
        return possiveisMovimentos;
    }


    public boolean getPrimMov() {
        return primMov;
    }

    public void setPrimMov(boolean primMov) {
        this.primMov = primMov;
    }

//    public boolean promoverPeao(Posicao posicao, Peao peca) {
//        for(int i=0;i<64;i++){
//            if(peca.getPosicao()=8 && peca.getPosicao() <= 15){
//
//            }
//        }
//        return false;
//    }

    @Override
    public String toString() {
        return "P";
    }
}


