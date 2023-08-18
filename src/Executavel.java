import java.util.ArrayList;
import java.util.Scanner;

public class Executavel {
    static Scanner scanner = new Scanner(System.in);
    static Jogador jogador = null;
    static Jogador adversario = null;
    static Tabuleiro tabuleiro = new Tabuleiro();

    public static void main(String[] args) {

        Jogador j1 = new Jogador("Jorge", "Senh@123");
        Jogador j2 = new Jogador("Wilson", "Wilson");


        j1.setCor("Preto", tabuleiro);
        j2.setCor("Branco", tabuleiro);

        jogador = j1;
        adversario = j2;


        boolean continuarJogo = true;

        do {
            //Escolha da peça
            mostrarTabuleiro();
            System.out.println("Escolha a peça que você deseja:");
            int escolhaPeca = scanner.nextInt();
            if (!passada(escolhaPeca)) {
                System.out.println("Essa peça é inválida!");
            }
        } while (continuarJogo);
    }

    private static boolean passada(int escolhaPeca) {
        Peca peca = tabuleiro.getPosicoes().get(escolhaPeca).getPeca();
        if (jogador.getPecas().contains(peca)) {
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
                    jogador.moverPeca(peca, movimentarPeca, tabuleiro, adversario);
                    primMov(peca);
                    if (peca instanceof Peao) {
                        boolean promover = ((Peao) peca).promoverPeao(tabuleiro);
                        if (promover) {
                            tabuleiro.promover(peca.getPosicao(), promover(peca));
                        }
                    }
//                    System.out.println(validarVitoria(adversario));
                }
            }
            return true;
        }
        return false;
    }

    private static void primMov(Peca peca) {
        if (peca instanceof Peao) {
            if (((Peao) peca).getPrimMov()) {
                ((Peao) peca).setPrimMov(false);
            }
        } else if (peca instanceof Torre) {
            if (((Torre) peca).getPrimMov()) {
                ((Torre) peca).setPrimMov(false);
            }
        } else if (peca instanceof Rei) {
            ((Rei) peca).setPrimMov(false);
        }

    }

    private static void menu() {
        System.out.println("""
                BEM-VINDO!

                Selecione uma das opções:

                1 - Cadastrar jogador
                2 - Começar o jogo
                """);
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                cadastrarJogadores();
                break;
            case 2:
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void cadastrarJogadores() {
        Jogador jogador = null;
        System.out.println("Informe seu nome:");
        jogador.setNome(scanner.next());
        System.out.println("Informe sua senha:");
        jogador.setSenha(scanner.next());
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

    private static Peca promover(Peca peca) {
        System.out.println("""
                Você deseja promover à qual peça?
                                
                1- Rainha
                2- Torre
                3- Bispo
                4- Cavalo
                """);
        int opcao = scanner.nextInt();

        Peca pecaPromovida = null;

        switch (opcao) {
            case 1:
                pecaPromovida = new Rainha("Branco", peca.getPosicao());
                break;
            case 2:
                pecaPromovida = new Torre("Branco", peca.getPosicao());
                break;
            case 3:
                pecaPromovida = new Bispo("Branco", peca.getPosicao());
                break;
            case 4:
                pecaPromovida = new Cavalo("Branco", peca.getPosicao());
                break;
        }
        tabuleiro.promover(pecaPromovida.getPosicao(), pecaPromovida);

        jogador.getPecas().remove(peca);
        jogador.getPecas().add(pecaPromovida);
        return pecaPromovida;
    }

    public static void mostrarTabuleiro() {
        int posicao = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (posicao < tabuleiro.getPosicoes().size()) {
                    Peca unidade = tabuleiro.getPosicoes().get(posicao).getPeca();
                    if (unidade != null) {
                        System.out.print("[ " + unidade + " ]");
                    } else {
                        System.out.print("[   ]");
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

//    public static void mostrarTabuleiro(Tabuleiro tabuleiro) {
//        int posicao = 0;
//
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                if (posicao < tabuleiro.getPosicoes().size()) {
//                    Peca unidade = tabuleiro.getPosicoes().get(posicao).getPeca();
//                    if (unidade != null) {
//                        System.out.print("|" + unidade + "| ");
//                    } else {
//                        System.out.print("| | ");
//                    }
//                    posicao++;
//                } else {
//                    System.out.print("   ");
//                }
//            }
//            System.out.println();
//        }
//        posicao = 0;
//    }
}