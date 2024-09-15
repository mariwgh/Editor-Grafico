import java.awt.*; // para acessar Color e métodos de desenho

public class Linha extends Ponto {
    // herda (x, y) da classe Ponto, que são as coordenadas
    // do ponto inicial da reta; também herda a cor e, em
    // seguida define o ponto final:
    //Ou seja, uma linha reta é uma figura geométrica que tem início em um ponto base inicial e se estende até um ponto final.

    private Ponto pontoFinal;

    public Linha(int x1, int y1, int x2, int y2, Color novaCor) {
        super(x1,y1, novaCor);
        pontoFinal = new Ponto(x2,y2, novaCor);
    }

    public void desenha(Color corDesenho, Graphics g) {
        //sobrepõe-se (overrides) ao mesmo método da classe ancestral Ponto e efetua o desenho de
        //uma linha reta entre (x1,y1) e (x2,y2), usando o método drawLine() do contexto gráfico g, passado como parâmetro

        g.setColor(corDesenho);
        g.drawLine(super.getX(),super.getY(), // ponto inicial herdado
                pontoFinal.getX(), pontoFinal.getY());
    }

    //Crie os getters e setters adequados para a classe Linha

    // Setter para o ponto inicial (herda de Ponto)
    public void setPontoInicial(Ponto pontoInicial) {
        super.setX(pontoInicial.getX());
        super.setY(pontoInicial.getY());
        super.setCor(pontoInicial.getCor());
    }

    // Setter para o ponto final
    public void setPontoFinal(Ponto pontoFinal) {
        this.pontoFinal = pontoFinal;
    }

    // Setter para a cor da linha
    public void setCor(Color novaCor) {
        super.setCor(novaCor);
        pontoFinal.setCor(novaCor);     // Mantém a cor da linha consistente nos dois pontos
    }

    // Getter para o ponto inicial (herda de Ponto)
    public Ponto getPontoInicial() {
        return new Ponto(super.getX(), super.getY(), super.getCor());
    }

    // Getter para o ponto final
    public Ponto getPontoFinal() {
        return pontoFinal;
    }

    // Getter para a cor da linha (herda de Ponto)
    public Color getCor() {
        return super.getCor();
    }
}