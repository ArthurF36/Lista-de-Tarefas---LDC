package ControleDeTarefas;
public class Tarefa {
    int prior;
    String desc;

    public Tarefa(String desc, int prior) {
        this.desc = desc;
        this.prior = prior;
    }

    public Tarefa(String desc) {
        this.desc = desc;
    }

    public int getPrior() {
        return this.prior;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setPrior(int nvPrior) {
        this.prior = nvPrior;
    }

    public void setDesc(String nvDesc) {
        this.desc = nvDesc;
    }

    public int compareTo(Tarefa comprTarf) {
        int compara;
        compara = this.desc.compareTo(comprTarf.getDesc());
        return compara;
    }

    public String toString() {
        return "Descrição: " + this.desc + ", prioridade: " + this.prior + ".";
    }
}