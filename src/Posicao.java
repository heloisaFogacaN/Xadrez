public class Posicao {
    public boolean getPeca;
    private Peca peca;

    public Peca getPeca() {return peca;}

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    @Override
    public String toString() {
        return "Posicao{" +
                "getPeca=" + getPeca +
                ", peca=" + peca;
    }
}
