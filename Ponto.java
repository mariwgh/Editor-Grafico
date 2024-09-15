import java.awt.*; // Abstract Windowing Toolkit
// para acessar Color e métodos de desenho

//A classe base (classe ancestral ou classe superior) do nosso programa de desenho de figuras
//geométricas será a classe Ponto, que informa um local no espaço bidimensional, ou seja, na tela
//do programa. Um ponto, ou local no espaço bidimensional, é representado por uma coordenada
// x,y), e uma cor, que será a cor de desenho do ponto.

public class Ponto {
    private int x, y;
    private Color cor;

    //A tela do computador, onde serão desenhadas as figuras geométricas, também é um plano
    //cartesiano.

    //A criação de um objeto é feita através de um procedimento especial,
    //chamado construtor. O construtor de uma classe descreve as operações que são realizadas com
    //os campos da classe quando um objeto dessa classe passa a ser usado.

    public Ponto(int cX, int cY, Color qualCor) {
        //Quando criamos um objeto da classe Ponto, precisamos colocar os valores de x, y e cor nos campos desse objeto.
        x = cX;
        y = cY;
        cor = qualCor;          // cor = Color.qualCor;
    }

    // Abaixo temos os getters e setters da classe Ponto:

    public void setX(int novoX) {
        x = novoX;
    }

    public void setY(int novoY) {
        y = novoY;
    }

    public void setCor(Color novaCor) {
        cor = novaCor;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getCor() {
        return cor;
    }

    //contexto gráfico = g (um plano cartesiano, com coordenadas (x,y), sobre a qual o objeto é desenho.
    public void desenhar(Color cor, Graphics g) {
        // desenha o ponto e pinta da cor indicada
        g.setColor(cor);
        g.drawLine(getX(),getY(),getX(),getY());
        //assim, para desenharmos um único ponto é preciso desenhar uma linha reta que comece e termine na mesma coordenada.
        //getX() e getY() são os valores dos campos X e Y do TPonto que estamos desenhando.
    }
}