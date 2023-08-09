import java.util.ArrayList;

public class Jogador {
    private String nome;
    private String senha;
    private String cor;
    private String pontos;
    private ArrayList<Peca> pecas;

    public Jogador(String nome, String senha){
        this.nome=nome;
        this.senha=senha;
        this.pecas= new ArrayList<>();

    }
    public boolean moverPeca(Peca peca, Posicao posicao, Tabuleiro tabuleiro, Jogador adversario) {
        Peca pecaAdversaria = posicao.getPeca();
        boolean valida=peca.mover(tabuleiro, posicao);
        if(posicao.getPeca() != null){
            adversario.pecas.remove(posicao.getPeca());
        }
        return true;
    }

    public void setCor(String cor, Tabuleiro tabuleiro) {
        this.cor = cor;
        for(Posicao posicao : tabuleiro.getPosicoes()){
            if(posicao.getPeca() != null && posicao.getPeca().getCor().equals(this.cor)){
                this.pecas.add( posicao.getPeca());
            }
        }
    }

    public ArrayList<Peca> getPecas() {
        return pecas;
    }

    public String getCor() {
        return cor;
    }

    public boolean proporEmpate(Jogador jogador) {
        return true;
    }

    public void desistir() {

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
