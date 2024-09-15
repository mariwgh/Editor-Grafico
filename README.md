# Projeto II - Editor Gráfico em Java

Para criarmos um programa de desenho geométrico, precisamos criar classes que representem
as diversas figuras geométricas, como ponto, reta, circulo, elipse, dentre outras.
Este projeto é um programa que deverá ler um arquivo texto que contenha as descrições geométricas das figuras,
armazenando-as em um vetor de figuras geométricas e, em seguida, permitirá desenhar novas
figuras geométricas, gravá-las em um arquivo texto e, em outras execuções, recuperar os objetos
gravados e refazer as figuras na tela.
As figuras geométricas serão descritas vetorialmente, ou seja, levando em conta as suas
coordenadas e medidas no plano bidimensional, com parâmetros geométricos de posicionamento.

## Tabela de Conteúdos

- [Descrição](#descrição)
- [Detalhes](#detalhes)
- [Autores](#autores)
- [Funcionalidades](#funcionalidades-levando-em-conta-o-que-já-desenvolvemos)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Pré-requisitos](#pré-requisitos)
- [Instalação](#instalação)
- [Links Úteis](#links-úteis)
- [Convenções de Código](#convenções-de-código)

## Detalhes

- Início: 14/09/2024
- Término: 30/09/2024 (no classroom)
  
## Autores

- Mariana Marietti - Desenvolvedor
- Rafaelly Silva - Desenvolvedor

## Funcionalidades (levando em conta o que já desenvolvemos)

1. Solicitar e desenhar oval, círculo.
2. Derivar a classe Retângulo a partir de Ponto e implementar sua solicitação e desenho.
3. Derivar a classe Polilinha e implementar sua solicitação e desenho.
4. Escolher a cor atual de desenho, a partir do que as novas figuras serão desenhadas nessa cor.
5. Salvar em um arquivo as figuras armazenadas no vetor, de modo que seja possível recuperá-las numa nova execução do programa, mediante o botão btnAbrir. Use os métodos toString() dos objetos gráficos para gerar a cadeia com os atributos geométricos da figura geométrica que será gravada no arquivo.
6. Implementar um botão [Selecionar] que, quando clicado, solicite a digitação de um índice
do vetor de figuras geométricas, desenhe a figura correspondente com 2 pixels a mais de
espessura e também a inclua em um vetor de índices de figuras geométricas selecionadas.
7. Mudar a cor das figuras geométricas selecionadas.
8. Somar um deslocamento (delta X, delta Y) nas figuras geométricas selecionadas,
redesenhando-as.
9. Apagar as figuras geométricas selecionadas do desenho principal (as figuras deixam de
ser selecionadas).
10. Limpar o vetor de figuras geométricas selecionadas, redesenhando o desenho principal.
11. Limpar o vetor de figuras geométricas do desenho principal e a área de desenho.

## Tecnologias Utilizadas

- Java 11
- Swing para interface gráfica
- AWT para manipulação de gráficos

## Pré-requisitos

- Slide do Chico e conta no GitHub
- Java Development Kit (JDK): O projeto requer a linguagem Java, então você deve ter o JDK instalado (preferencialmente a versão mais recente).
- Bibliotecas de Interface Gráfica:
    - Swing (javax.swing): Utilizado para criar a interface gráfica do usuário (GUI).
    - AWT (java.awt): Utilizado para manipulação de gráficos e cores, bem como eventos relacionados a janelas e componentes gráficos.
- IDE de Desenvolvimento: O projeto pode ser desenvolvido em qualquer IDE que suporte Java, como:
    - IntelliJ IDEA
- Pré-requisitos de Conhecimento:
    - Orientação a Objetos (OO): É essencial ter um bom entendimento de conceitos como herança, polimorfismo e encapsulamento, uma vez que as figuras geométricas (como ponto, linha, círculo) são derivadas de uma classe base.
    - Manipulação de Arquivos: O programa lê e grava figuras geométricas em arquivos de texto. É necessário saber como trabalhar com classes como FileReader, BufferedReader, FileWriter, etc.
    - Manipulação de Eventos: O projeto faz uso de ouvintes de eventos, como ActionListener e MouseListener, para responder a cliques de botões e interações do mouse.
    - Desenho Gráfico: Conhecimento sobre o uso da classe Graphics e seus métodos, como drawLine(), drawOval(), e drawRect() para desenhar as figuras no painel gráfico.
- Ferramentas e Componentes Relevantes:
    - JFrame: Para a janela principal do aplicativo.
    - JPanel: Para o painel de desenho e armazenamento de botões.
    - JButton: Para os botões que permitem selecionar figuras geométricas (ponto, linha, círculo, etc.).
    - JFileChooser: Para abrir e salvar arquivos com as descrições das figuras geométricas.
    - JDesktopPane e JInternalFrame: Utilizados para gerenciar janelas-filhas dentro do programa.

## Instalação

1. Instalar o JDK (Java Development Kit):
  - Passo 1: Acesse o site oficial da Oracle ou Adoptium (para versões OpenJDK).
  - Passo 2: Baixe e instale o JDK mais recente. (Durante a instalação, certifique-se de adicionar o Java ao PATH do sistema.)

2. Instalar o IntelliJ IDEA (ou outra IDE):
  - Passo 1: Acesse o site oficial do IntelliJ IDEA.
  - Passo 2: Baixe e instale a versão Community (gratuita) ou a versão Ultimate (paga).
  - Passo 3: Durante a instalação, aceite as opções padrão e selecione o JDK instalado na etapa anterior como o SDK padrão.

3. Instalar o Git:
  - Passo 1: Acesse o site oficial do Git e baixe o instalador:
  - Passo 2: Execute o instalador e siga as etapas de instalação. Durante a instalação, você pode manter as opções padrão. Certifique-se de marcar a opção para adicionar o Git ao PATH do sistema.
  - Passo 3: Verifique a instalação.
      Abra o Prompt de Comando e digite: git --version

4. Conectar o Github:
   - Passo 1: Vá para File > Settings > Version Control > GitHub > e conecte sua conta.
    
5. Abrir o repositório no Intellij:
  - Passo 1: Abra o IntelliJ e selecione Get from VCS para abrir o repositório do projeto (selecione por Github).
  - Passo 2: Certifique de selecionar pelo GitHub e que o directory esteja em um local seguro (caso o Intellij não o reconheça como, digite no terminal (View > Tool Windows > Terminal): git config --global --add safe.directory <caminho_do_projeto>
  - Passo 3: Faça as mudanças necessárias e de commit selecionando os arquivos, não esqueça de dar push também. (Logo, os arquivos irão aparecer para todos os colaboradores no projeto no GitHub.)
  - Passo 4: Para executar o projeto, apenas clique no botão de play.

## Links Úteis

- [Programação gráfica em Java com Swing](http://www.guj.com.br/java.tutorial.artigo.38.1.guj)
- [Sobre JFileChoose](http://java.sun.com/docs/books/tutorial/uiswing/components/filechooser.html)
- [Sobre JFileChoose 2](http://www.guj.com.br/posts/list/56458.java)

## Convenções de Código (a editar)
- Usar indentação de 4 espaços.
- Nomear variáveis e métodos em inglês.
- Seguir o padrão de nomenclatura camelCase para métodos e variáveis.
