import java.awt.*;

public class Circulo extends Ponto {
    // herda o ponto central (x, y) da classe Ponto
    int raio;
    Color cor;

    public Circulo (int xCentro, int yCentro, int novoRaio, Color novaCor) {
        super(xCentro, yCentro, novaCor);   // construtor de Ponto(x,y)
        setRaio(novoRaio);
    }

    public void setRaio (int novoRaio) {
        raio = novoRaio;
    }

    public void setCor (Color novaCor) {
        cor = novaCor;
    }

    public void desenha (Color corDesenho, Graphics g) {
        g.setColor(corDesenho);
        g.drawOval(getX() - raio, getY() - raio, // centro - raio
                2 * raio,2 * raio);             // centro + raio
    }


    public String toString() {
        return transformaString("l",5) +

                transformaString(Integer.toString(getX()), 5) +
                transformaString(Integer.toString(getY()), 5) +

                transformaString(Integer.toString(raio), 5) +

                transformaString(Integer.toString(getCor().getRed()),5) +
                transformaString(Integer.toString(getCor().getGreen()),5) +
                transformaString(Integer.toString(getCor().getBlue()),5);
    }
}