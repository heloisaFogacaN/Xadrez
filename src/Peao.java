import java.util.ArrayList;

public class Peao extends Peca {

    private boolean primMov = true;

    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();
        Posicao posicaoAtual = this.getPosicao();
        int posicaoNoTabuleiro = tabuleiro.getPosicoes().indexOf(posicaoAtual);
        if (this.getCor().equals("Preto")) {
            possiveisMovimentos.add(tabuleiro.getPosicoes().get(posicaoNoTabuleiro + 8));
            if (this.primMov) {
                possiveisMovimentos.add(tabuleiro.getPosicoes().get(posicaoNoTabuleiro + 16));
            }
        } else {
            possiveisMovimentos.add(tabuleiro.getPosicoes().get(posicaoNoTabuleiro + 8));
            if (this.primMov) {
                possiveisMovimentos.add(tabuleiro.getPosicoes().get(posicaoNoTabuleiro + 16));
            }
        }


        return null;
    }
}
