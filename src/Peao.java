import java.util.ArrayList;

public class Peao extends Peca {

    private boolean primMov = true;

    public Peao(String cor){
        super(cor);
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
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro + 16).getPeca() == null) {
                        possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 16));
                    }
                }
            }
            if (posicoesTabuleiro.get(posicaoNoTabuleiro+9).getPeca().getCor().equals("Branco") && !validaExtremidade(posicaoNoTabuleiro+1)){
                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro+9));

            }
            if (posicoesTabuleiro.get(posicaoNoTabuleiro+7).getPeca().getCor().equals("Branco") && !validaExtremidade(posicaoNoTabuleiro)){
                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro+7));

            }
        } else{
            if(posicoesTabuleiro.get(posicaoNoTabuleiro-8).getPeca() == null) {
                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 8));
                if (this.primMov) {
                    if (tabuleiro.getPosicoes().get(posicaoNoTabuleiro - 16) .getPeca() == null) {
                        possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 16));
                    }
                }
            }
            if (posicoesTabuleiro.get(posicaoNoTabuleiro-9).getPeca().getCor().equals("Preto")  && posicaoNoTabuleiro % 8 != 0){
                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro-9));

            }
            if (posicoesTabuleiro.get(posicaoNoTabuleiro-7).getPeca().getCor().equals("Preto")  && (posicaoNoTabuleiro + 1) % 8 != 0){
                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro-7));

            }
        }
        return possiveisMovimentos;
    }

    @Override
    public String toString() {
        return "Peao{" +
                "primMov=" + primMov +
                ", " + super.toString();
    }
}


