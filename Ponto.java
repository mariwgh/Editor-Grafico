import java.awt.*; // Abstract Windowing Toolkit

public class Ponto {
    private int x, y;
    private Color cor;

    public Ponto(int cX, int cY, Color qualCor) {
        x = cX;
        y = cy;
        cor = Color.qualCor;
    }

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

    public void desenhar(Color cor, Graphics g) {
        g.setColor(cor);
        g.drawLine(getX(),getY(),getX(),getY());
    }
}