package ControleDeTarefas;
public class Node {
    private Tarefa info;
    private Node ante;
    private Node prox;

    public Node(Tarefa nvTarf) {
        this.info = nvTarf;
    }

    public Tarefa getInfo() {
        return this.info;
    }

    public Node getAnte() {
        return this.ante;
    }

    public Node getProx() {
        return this.prox;
    }

    public void setInfo(Tarefa nvInfo) {
        this.info = nvInfo;
    }

    public void setAnte(Node nvAnte) {
        this.ante = nvAnte;
    }

    public void setProx(Node nvProx) {
        this.prox = nvProx;
    }
}
