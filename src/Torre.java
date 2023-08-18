import java.util.ArrayList;

public class Torre extends Peca {
    private boolean primMov;

    public Torre(String cor, Posicao posicao) {
        super(cor, posicao);
    }

    @Override
    public ArrayList<Posicao> possiveisMovimento(Tabuleiro tabuleiro) {
        Posicao posicaoAtual = this.getPosicao();
        int posicaoNoTabuleiro = tabuleiro.getPosicoes().indexOf(posicaoAtual);
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();
        ArrayList<Posicao> posicoesTabuleiro = tabuleiro.getPosicoes();
        if(primMov){
            if (posicoesTabuleiro.get(posicaoNoTabuleiro - 7).getPeca().getCor().equals("Preto")){

            }

        }

        for (int i = posicaoNoTabuleiro + 8;
             i < tabuleiro.getPosicoes().size();
             i += 8) {
            if (verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos)) {
                break;
            }
        }
        for (int i = posicaoNoTabuleiro - 8;
             i >= 0;
             i -= 8) {
            if (verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos)) {
                break;
            }
        }
        for (int i = (validaExtremidade(posicaoNoTabuleiro + 1) ?
                64 : posicaoNoTabuleiro + 1);
             i < tabuleiro.getPosicoes().size();
             i++) {

            if (verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos) || validaExtremidade(i + 1)) {
                break;
            }
        }

        for (int i = (validaExtremidade(posicaoNoTabuleiro) ?
                -1 : posicaoNoTabuleiro - 1);
             i >= 0;
             i--) {
            if (verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos) || validaExtremidade(i)) {
                break;
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

    @Override
    public String toString() {
        return "T";
    }
}