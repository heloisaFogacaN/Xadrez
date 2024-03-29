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
            if (posicoesTabuleiro.get(posicaoNoTabuleiro + 8).getPeca() == null) {
                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 8));
                if (this.primMov) {
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro + 16).getPeca() == null &&
                            posicoesTabuleiro.get(posicaoNoTabuleiro + 16).getPeca() == null) {
                        possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 16));
                    }
                }
            }
            if (!((posicaoNoTabuleiro + 7) >= 64)) {
                if (posicoesTabuleiro.get(posicaoNoTabuleiro + 7).getPeca() != null &&
                        posicoesTabuleiro.get(posicaoNoTabuleiro + 7).getPeca().getCor().equals("Branco") && !validaExtremidade(posicaoNoTabuleiro)) {
                    possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 7));

                }
            }
            if (!((posicaoNoTabuleiro + 9) >= 64)) {
                if (posicoesTabuleiro.get(posicaoNoTabuleiro + 9).getPeca() != null &&
                        posicoesTabuleiro.get(posicaoNoTabuleiro + 9).getPeca().getCor().equals("Branco") && !validaExtremidade(posicaoNoTabuleiro + 1)) {
                    possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 9));

                }
            }
        } else {
            if (posicoesTabuleiro.get(posicaoNoTabuleiro - 8).getPeca() == null) {
                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 8));
                if (this.primMov) {
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro - 16).getPeca() == null &&
                            posicoesTabuleiro.get(posicaoNoTabuleiro - 16).getPeca() == null) {
                        possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 16));
                    }
                }
            }
            if (!((posicaoNoTabuleiro) <= 0)) {
                if (posicoesTabuleiro.get(posicaoNoTabuleiro - 9).getPeca() != null &&
                        posicoesTabuleiro.get(posicaoNoTabuleiro - 9).getPeca().getCor().equals("Preto") && posicaoNoTabuleiro % 8 != 0) {
                    possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 9));

                }
            }
            if (!((posicaoNoTabuleiro) <= 0)) {
                if (posicoesTabuleiro.get(posicaoNoTabuleiro - 7).getPeca() != null &&
                        posicoesTabuleiro.get(posicaoNoTabuleiro - 7).getPeca().getCor().equals("Preto") && (posicaoNoTabuleiro + 1) % 8 != 0) {
                    possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 7));
                }
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

    public boolean promoverPeao(Tabuleiro tabuleiro) {
        if ((tabuleiro.getPosicoes().indexOf(this.getPosicao()) >= 0 && tabuleiro.getPosicoes().indexOf(this.getPosicao()) <= 7) ||
             tabuleiro.getPosicoes().indexOf(this.getPosicao()) >=56 && tabuleiro.getPosicoes().indexOf(this.getPosicao()) <=64) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "P";
    }
}


