import java.awt.*;
import java.awt.event.*;
//JFrame está disponível no pacote javax.swing,
import javax.swing.*;

// Para criar formulários em Java, devemos criar uma classe que seja herança da classe JFrame. JFrame é um container para
//componentes visuais de interface com o usuário.

// Em princípio, quando o programa começa a ser executado, haverá uma janela sem desenho algum,
//figuras geométricas que nosso editor desenhará serão traçadas numa janela auxiliar, no modelo MDI (Multiple Document Interface).

public class Editor extends JFrame {
    //declararemos os controles visuais (Botões, rótulos e caixas de edição).
    private JButton btnPonto, btnLinha, btnCirculo, btnElipse, btnCor, btnAbrir, btnSalvar, btnApagar, btnSair;
    private JPanel pnlBotoes;                   //controles terão de ser instanciados (criados), e associados a um container como JPanel ( controle que armazena outros controles)
    static private JInternalFrame frame;        //criaremos uma janela-filha vazia.


    // MUDANCAS P PODER RODAR (ALEM DE SHOW -> SET VISIBLE):
    private static final int tamanho_inicial = 100;  // Ou outro valor que faça sentido
    private static int quantidade_figuras_vetor = 0;


    static private MeuJPanel pnlDesenho;
    private static Ponto[] figuras = new Ponto[tamanho_inicial];

    public Editor() {
        // construtor de Editor que criará o JFrame, colocará seu título,
        // estabelecerá um tamanho para o formulário e o exibirá

        super("Editor Gráfico");        // cria o JFrame e coloca um título

        // cria os botões do editor
        Icon imgAbrir = new ImageIcon("D:/PROJETO II/imagens/abrir.jpg");         //criamos um objeto da classe Icon, usando o seu construtor que
                                                            //recebe o nome de um arquivo de imagem como parâmetro.
        //criamos cada botão e passamos o ícone como parâmetro, além do título que desejamos para o botão:
        btnAbrir = new JButton("Abrir", imgAbrir);
        btnSalvar = new JButton("Salvar", new ImageIcon("D:/PROJETO II/imagens/salvar.jpg"));
        btnPonto = new JButton("Ponto", new ImageIcon("D:/PROJETO II/imagens/ponto.jpg"));
        btnLinha = new JButton("Linha", new ImageIcon("D:/PROJETO II/imagens/linha.jpg"));
        btnCirculo = new JButton("Circulo", new ImageIcon("D:/PROJETO II/imagens/circulo.jpg"));
        btnElipse = new JButton("Elipse", new ImageIcon("D:/PROJETO II/imagens/elipse.jpg"));
        btnCor = new JButton("Cores", new ImageIcon("D:/PROJETO II/imagens/cores.jpg"));
        btnApagar = new JButton("Apagar", new ImageIcon("D:/PROJETO II/imagens/apagar.jpg"));
        btnSair = new JButton("Sair", new ImageIcon("D:/PROJETO II/imagens/sair.jpg"));


        // cria o JPanel que armazenará os botões
        pnlBotoes = new JPanel();
        // cria o layout usado para dispor fisicamente os botões
        FlowLayout flwBotoes = new FlowLayout();
        // informa que os componentes do pnlBotoes serão dispostos em forma livre
        pnlBotoes.setLayout(flwBotoes);

        // adiciona os controles visuais (botões) ao painel de botões, de cima para baixo, da esquerda para direita.
        pnlBotoes.add(btnAbrir);
        btnAbrir.addActionListener(new FazAbertura());

        pnlBotoes.add(btnSalvar);
        pnlBotoes.add(btnPonto);
        pnlBotoes.add(btnLinha);
        pnlBotoes.add(btnCirculo);
        pnlBotoes.add(btnElipse);
        pnlBotoes.add(btnCor);
        pnlBotoes.add(btnApagar);
        pnlBotoes.add(btnSair);

        setSize(700,500);   // dimensões do formulário em pixels
        setVisible(true);               // exibe o formulário

        Container cntForm = getContentPane();       // acessa o painel de conteúdo do frame
        cntForm.setLayout(new BorderLayout());
        cntForm.add(pnlBotoes , BorderLayout.NORTH);


        JDesktopPane panDesenho = new JDesktopPane();
        cntForm.add(panDesenho);

        //instanciamos a variável frame e associamos, após essa instanciação, a janela-filha chamada frame com o JDesktopPane que a gerenciará
        frame = new JInternalFrame("Nenhum arquivo aberto", true, true, true, true);
        panDesenho.add(frame);

        //this indica justamente o objeto JFrame que estamos construindo no momento).
        //metade do formulario
        frame.setSize(this.getWidth() / 2,this.getHeight() / 2);
        frame.setVisible(true);         // Mostra a janela interna  //frame.show();

        //para nao ser transparente
        frame.setOpaque(true);


        pnlDesenho = new MeuJPanel();                   //instanciar o painel de desenhos,
        Container cntFrame = frame.getContentPane();    // criar container dentro da janela-filha frame,
        cntFrame.add(pnlDesenho);                       // associar o painel a esse container.


        setSize(700,500);       // dimensões do formulário em pixels
        setVisible(true);                   // show();   // exibe o formulário
    }

    public static void desenharObjetos (Graphics g) {
        pnlDesenho.paintComponent(g);
    }


    public static void main(String[] args) {
        Editor aplicacao = new Editor();    //objeto que representa a aplicação;

        aplicacao.addWindowListener (
                new WindowAdapter () {      // cria instância da interface
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );
    }


    private class FazAbertura implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser arqEscolhido = new JFileChooser ();
            arqEscolhido.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = arqEscolhido.showOpenDialog(Editor.this);
            //código de verificação se um arquivo foi selecionado e obter seu nome
            if (result == JFileChooser.APPROVE_OPTION) {
                File arquivo = arqEscolhido.getSelectedFile();
                System.out.println("Processando "+arquivo.getName());
            }

            try {
                BufferedReader arqFiguras = new BufferedReader( new FileReader (arquivo.getName()) );

                try {
                    String linha = arqFiguras.readLine();
                    while (linha != null) {
                        String tipo = linha.substring(0,5).trim();
                        int xBase = Integer.parseInt(linha.substring(5,10).trim());
                        int yBase = Integer.parseInt(linha.substring(10,15).trim());
                        int corR = Integer.parseInt(linha.substring(15,20).trim());
                        int corG = Integer.parseInt(linha.substring(20,25).trim());
                        int corB = Integer.parseInt(linha.substring(25,30).trim());
                        Color cor = new Color(corR, corG, corB);

                        switch (tipo.charAt(0)) {
                            case 'p' : // figura é um ponto
                                figuras.insereAposFim(new ListaSimples.NoLista(

                                        new Ponto(xBase, yBase, cor), null)
                                );
                                break;

                            case 'l' : // figura é uma linha
                                int xFinal =Integer.parseInt(linha.substring(30,35).trim());
                                int yFinal =Integer.parseInt(linha.substring(35,40).trim());
                                figuras.insereAposFim(new ListaSimples.NoLista(
                                        new Linha(xBase, yBase, xFinal, yFinal, cor), null)
                                );
                                break;

                            case 'c' : // figura é um círculo
                                int raio =Integer.parseInt(linha.substring(30,35).trim());
                                figuras.insereAposFim(new ListaSimples.NoLista(
                                        new Circulo(xBase, yBase, raio, cor), null)
                                );
                                break;

                            case 'o' : // figura é uma oval
                                int raioA =Integer.parseInt(linha.substring(30,35).trim());
                                int raioB =Integer.parseInt(linha.substring(35,40).trim());
                                figuras.insereAposFim(new ListaSimples.NoLista(
                                        new Oval(xBase, yBase, raioA, raioB, cor), null)
                                );
                                break;
                        }

                        linha = arqFiguras.readLine();
                    }

                    arqFiguras.close();
                    frame.setTitle(arquivo.getName());
                    desenharObjetos(pnlDesenho.getGraphics());
                }

                catch (IOException ioe){
                    System.out.println("Erro de leitura no arquivo");
                }
            }

            catch (FileNotFoundException e) {
                System.out.println("Arquivo não pôde ser aberto");
            }
        }
    }


    private class MeuJPanel extends JPanel {
        public void paintComponent(Graphics g) {
            for (int atual = 0; atual < quantidade_figuras_vetor; atual++) {
                Ponto figuraAtual = (Ponto) figuras[atual];
                figuraAtual.desenhar(figuraAtual.getCor(), g);
            }
        }

        //Observe o uso do método desenhar() de cada elemento recuperado do vetor. Cada figura é obtida
        //da posição do vetor atualmente acessada e tratado como um objeto da classe ancestral Ponto,
        //que funciona como uma classe unificadora de todas as classes dela derivadas.

        //se a figura for uma linha reta, será chamado o método desenhar() da classe Linha, e se a figura for uma instância
        // de círculo, será chamado o método desenhar() de Circulo.
    }

}