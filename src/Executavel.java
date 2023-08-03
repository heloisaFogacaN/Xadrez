import java.util.ArrayList;
import java.util.Scanner;

public class Executavel {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Jogador j1 = new Jogador("Jorge", "Senh@123");
        Jogador j2 = new Jogador("Wilson", "Wilson");

        Tabuleiro tabuleiro = new Tabuleiro();

        j1.setCor("Preto", tabuleiro);
        j2.setCor("Branco", tabuleiro);

        boolean continuarJogo = true;

        do {
            //Escolha da peça
            mostrarTabuleiro(tabuleiro);
            System.out.println("Escolha a peça que você deseja:");
            int escolhaPeca = scanner.nextInt();

            System.out.println(j2.getCor() + "Cor do jogador 2");
            System.out.println(tabuleiro.getPosicoes().get(escolhaPeca).getPeca().getCor() + " a cor da peça escolhida");

            Peca peca = tabuleiro.getPosicoes().get(escolhaPeca).getPeca();
//            j1.getPecas().contains(peca);
//            System.out.println(peca);
            if(j2.getPecas().contains(peca)) {
                // Escolha da posição para o movimento
                System.out.println("Suas posíveis movimentações são:");
                ArrayList<Posicao> posicoes = peca.possiveisMovimento(tabuleiro);
                int i = 0;
                for (Posicao posicao : posicoes) {
                    i++;
                    System.out.println(tabuleiro.getPosicoes().indexOf(posicao));
                }
                int escolhaPosicao = scanner.nextInt();
                Posicao movimentarPeca = tabuleiro.getPosicoes().get(escolhaPosicao);
                for (Posicao posicao : posicoes) {
                    if (posicao.equals(movimentarPeca)) {
                        //Movimentação da peça escolhida para a posição desejada
                        j2.moverPeca(peca, movimentarPeca, tabuleiro, j1);
                        if(peca instanceof Peao && ((Peao) peca).getPrimMov()){
                            ((Peao) peca).setPrimMov(false);
                        }
                        System.out.println(validarVitoria(j1));
                    }
                }
            } else {
                System.out.println("Essa peça é inválida!");
            }

        } while (continuarJogo);

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