import java.awt.*; // para acessar Color e métodos de desenho

public class Linha extends Ponto {
    // herda (x, y) da classe Ponto, que são as coordenadas
    // do ponto inicial da reta; também herda a cor e, em
    // seguida define o ponto final:

    private Ponto pontoFinal;

    public Linha(int x1, int y1, int x2, int y2, Color novaCor) {
        super(x1,y1, novaCor);
        pontoFinal = new Ponto(x2,y2, novaCor);
    }

    public void desenha(Color corDesenho, Graphics g) {
        g.setColor(corDesenho);
        g.drawLine(super.getX(),super.getY(), // ponto inicial
                pontoFinal.getX(), pontoFinal.getY());
    }

    //Crie os getters e setters adequados para a classe Linha.
}
