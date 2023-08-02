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

        boolean continuarJogo=true;

        do{
            //Escolha da peça
            mostrarTabuleiro(tabuleiro);
            System.out.println("Escolha a peça que você deseja:");
            System.out.println(j1.getPecas());
            int escolhaPeca = scanner.nextInt();
            Peca peca = tabuleiro.getPosicoes().get(escolhaPeca).getPeca();
            j1.getPecas().contains(peca);
            System.out.println(peca);
            // Escolha da posição para o movimento
            System.out.println("Suas posíveis movimentações são:");
            System.out.println(peca.possiveisMovimento((tabuleiro)));
            ArrayList<Posicao> posicoes = peca.possiveisMovimento(tabuleiro);
            System.out.println(posicoes);
            int escolhaPosicao = scanner.nextInt();
            Posicao movimentarPeca = tabuleiro.getPosicoes().get(escolhaPosicao);
            for (Posicao posicao : posicoes) {
                if(posicao.equals(movimentarPeca)){
                    //Movimentação da peça escolhida para a posição desejada
                    j1.moverPeca(peca, movimentarPeca, tabuleiro, j2);
                    System.out.println(validarVitoria(j2));
                }
            }
        } while(continuarJogo);


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
    public static void mostrarTabuleiro(Tabuleiro tabuleiro) {
        int posicao = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (posicao < tabuleiro.getPosicoes().size()) {
                    Peca unidade = tabuleiro.getPosicoes().get(posicao).getPeca();
                    if (unidade != null) {
                        System.out.print("|" + unidade + "| ");
                    } else {
                        System.out.print("| | ");
                    }
                    posicao++;
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
        posicao = 0;
    }
}






