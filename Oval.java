import java.awt.*;

public class Oval extends Ponto {
    int raioA, raioB;

    public void desenha(Color corDesenho, Graphics g) {
        g.setColor(corDesenho);
        g.drawOval(getX()-raioA, getY()-raioB, // centro - raio
                2*raioA,2*raioB); // centro + raio
    }

    public Oval() {
        super(0, 0, Color.black);  // Chama o construtor de Ponto com valores padrão
        setRaioA(0);
        setRaioB(0);
        setCor(Color.black);
    }

    public void setRaioA(int novoRaio) {
        raioA = novoRaio;
    }

    public void setRaioB(int novoRaio) {
        raioB = novoRaio;
    }

    public Oval(int xCentro, int yCentro, int novoRaioA, int novoRaioB, Color novaCor) {
        super(xCentro, yCentro, novaCor); // construtor de Ponto(x,y)
        setRaioA(novoRaioA);
        setRaioB(novoRaioB);
    }

}