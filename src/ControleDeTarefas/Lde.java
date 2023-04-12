package ControleDeTarefas;
public class Lde {
    private Node primer;
    private Node ultim;
    private int qnt;
    Node aux;

    public void incerirTarf(Tarefa tarf) {
        Node nvTarf = new Node(tarf);
        if (this.isEmpty() == true) {
            this.primer = nvTarf;
            this.ultim = nvTarf;
        }
        else if (this.primer.getInfo().getPrior() - tarf.getPrior() < 0 && this.primer.getInfo().compareTo(tarf) != 0) {
                nvTarf.setProx(this.primer);
                this.primer.setAnte(nvTarf);
                this.primer = nvTarf;
        }
        else if (this.ultim.getInfo().getPrior() - tarf.getPrior() >= 0 && this.ultim.getInfo().compareTo(tarf) != 0) {
                nvTarf.setAnte(this.ultim);
                this.ultim.setProx(nvTarf);
                this.ultim = nvTarf;
        }
        else {
            aux = this.primer;
            while (aux != null) {
                if (aux.getInfo().compareTo(tarf) == 0) {
                    System.out.println("Não é possível ter mais de uma tarefa com a mesma descrição. Inseção não efetuada.");
                    return;
                }
                else if (aux.getInfo().getPrior() - tarf.getPrior() < 0) {
                    aux.getAnte().setProx(nvTarf);
                    nvTarf.setAnte(aux.getAnte());
                    aux.setAnte(nvTarf);
                    nvTarf.setProx(aux);
                    break;
                }
                else if (aux.getInfo().getPrior() - tarf.getPrior() == 0 && aux.getProx().getInfo().getPrior() - aux.getInfo().getPrior() != 0) {
                    aux.setProx(nvTarf);
                    nvTarf.setAnte(aux);
                    aux.getProx().setAnte(nvTarf);
                    nvTarf.setProx(aux.getProx());
                    break;
                }
                aux = aux.getProx();
            }
        }
        this.qnt++;
        System.out.println("Tarefa inserida.");
    }

    public void qntTarf(Tarefa tarf) {
        int tarfQnt = 0;
        Node aux2;
        if (this.isEmpty() == true) {
            System.out.println("Lista vazia");
        }
        else {
            aux = busqTarf(tarf);
            if (aux == null) {
                System.out.println("Tarefa não registrada na lista.");
                return;
            }
            else {
                aux2 = this.primer;
                while (aux2 != aux) {
                    tarfQnt++;
                    aux2 = aux2.getProx();
                }
            }
            System.out.println("A quantidade de tarefas a serem feitas antes da desejada é " + tarfQnt + ".");
        }
    }

    public void removPrimer() {
        if (this.isEmpty() == true) {
            System.out.println("Lista vazia");
        }
        else {
            this.primer = this.primer.getProx();
            this.primer.setAnte(null);
            System.out.println("Tarefa removida da lista.");
        }
    }

    public void removTarf(Tarefa tarf) {
        Node anter, poster;
        if (this.isEmpty() == true) {
            System.out.println("Lista vazia");
            return;
        }
        else if (this.qnt == 1) {
            if (this.primer.getInfo().compareTo(tarf) != 0) {
                System.out.println("Tarefa não registrada na lista.");
                return;
            }
            this.primer = null;
            this.ultim = null;
        }
        else {
            aux = busqTarf(tarf);
            if (aux == null) {
                System.out.println("Tarefa não registrada na lista.");
                return;
            }
            else {
                if (aux.getInfo().compareTo(this.primer.getInfo()) == 0) {
                    this.primer = this.primer.getProx();
                    this.primer.setAnte(null);
                }
                else if (aux.getInfo().compareTo(this.ultim.getInfo()) == 0) {
                    this.ultim = this.ultim.getAnte();
                    this.ultim.setProx(null);
                }
                else {
                    anter = aux.getAnte();
                    poster = aux.getProx();
                    anter.setProx(poster);
                    poster.setAnte(anter);
                }
            }
        }
        this.qnt--;
        System.out.println("Tarefa removida da lista.");
    }

    public void exibePrio(int prio) {
        int qntPrio = 0;
        boolean valid = false;
        if (this.isEmpty() == true) {
            System.out.println("Lista vazia");
        }
        else {
            aux = this.primer;
            while (aux != null) {
                if (aux.getInfo().getPrior() == prio) {
                    System.out.println(aux.getInfo());
                    qntPrio++;
                    valid = true;
                }
                aux = aux.getProx();
            }
            if (valid == false) {
                System.out.println("A prioridade informada não se encontra na lista.");
            }
            else {
                System.out.println("A quantidade de tarefas com a mesma prioridade é " + qntPrio + ".");
            }
        }
    }

    public void exibeList() {
        if (this.isEmpty() == true) {
            System.out.println("Lista vazia");
        }
        else {
            aux = this.primer;
            while (aux != null) {
                System.out.println(aux.getInfo());
                aux = aux.getProx();
            }
        }
    }

    public void altTarf(Tarefa tarf, int prio) {
        Tarefa alterTarf, primerTarf, ultimTarf;
        Node altera;
        if (this.isEmpty() == true) {
            System.out.println("Lista vazia");
        }
        else {
            altera = busqTarf(tarf);
            if (altera == null) {
                System.out.println("Tarefa não registrada na lista.");
            }
            else {
                altera.getInfo().setPrior(prio);
                alterTarf = altera.getInfo();
                primerTarf = this.primer.getInfo();
                ultimTarf = this.primer.getInfo();
                if (this.qnt == 1) {
                    this.primer = aux;
                    this.ultim = aux;
                }
                else {
                    if (primerTarf.getPrior() - alterTarf.getPrior() < 0 && primerTarf.compareTo(alterTarf) != 0) {
                        aux.setProx(this.primer);
                        this.primer.setAnte(aux);
                        this.primer = aux;
                    }
                    else if (ultimTarf.getPrior() - alterTarf.getPrior() >= 0 && ultimTarf.compareTo(alterTarf) != 0) {
                        this.ultim.setProx(aux);
                        aux.setAnte(this.ultim);
                        this.ultim = aux;
                    }
                    else {
                        aux = this.primer;
                        while (aux != null) {
                            if (aux.getInfo().getPrior() - alterTarf.getPrior() < 0) {
                                aux.getAnte().setProx(altera);
                                altera.setAnte(aux.getAnte());
                                aux.setAnte(altera);
                                altera.setProx(aux);
                                break;
                            }
                            else if (aux.getInfo().getPrior() == alterTarf.getPrior() && aux.getProx().getInfo().compareTo(aux.getInfo()) != 0) {
                                aux.setProx(altera);
                                altera.setAnte(aux);
                                aux.getProx().setAnte(altera);
                                altera.setProx(aux.getProx());
                            }
                        }
                    }
                }
                System.out.println("Prioridade alterada.");
            }
        }
    }

    public Node busqTarf(Tarefa tarf) {
        aux = this.primer;
        while (aux != null) {
            if (aux.getInfo().compareTo(tarf) == 0) {
                return aux;
            }
            aux = aux.getProx();
        }
        return null;
    }

    public boolean isEmpty() {
        if (this.primer == null && this.ultim == null && this.qnt == 0) {
            return true;
        }
        return false;
    }
}