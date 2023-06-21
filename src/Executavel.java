import java.util.ArrayList;
import java.util.Scanner;
public class Executavel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Jogador j1 = new Jogador("Jorge", "Senh@123");
        Jogador j2 = new Jogador("Wilson", "Wilson");

        Tabuleiro tabuleiro = new Tabuleiro();

        j1.setCor("Branco", tabuleiro);
        j2.setCor("Preto", tabuleiro);
        //Escolha da peça
        System.out.println(j1.getPecas());
        int escolhaPeca = scanner.nextInt();
        Peca peca = j1.getPecas().get(escolhaPeca);
        // Escolha da posição para o movimento
        System.out.println(peca.possiveisMovimento((tabuleiro)));
        ArrayList<Posicao> posicoes = peca.possiveisMovimento(tabuleiro);
        System.out.println(posicoes);
        int escolhaPosicao = scanner.nextInt();
        Posicao posicao = posicoes.get(escolhaPosicao);
        //Movimentação da peça escolhida para a posição desejada
        j1.moverPeca(peca, posicao, tabuleiro, j2);
        System.out.println(validarVitoria(j2));
    }



    private static boolean validarVitoria(Jogador adversario) {
        for (Peca peca : adversario.getPecas()) {
            if (peca instanceof Rei) {
                return false;
            }
            return true;
        }
        return true;
    }
}






