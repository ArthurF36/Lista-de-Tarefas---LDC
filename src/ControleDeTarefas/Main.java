package ControleDeTarefas;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        Scanner input = new Scanner (System.in);
        char opMenu;
        String desc;
        int prio, valid;
        Tarefa tarf;
        Lde listTarf = new Lde();
        System.out.println("Programa da lista de tarefas em ordem decrescente.");
        menuTarefas();
        do {
            System.out.println();
            System.out.println("Digite 8 para exibir o menu de opções novamente.");
            System.out.print("Digite aqui: ");
            opMenu = in.next().charAt(0);
            if (opMenu == '1') {
                System.out.print("Informe a descrição da tarefa: ");
                desc = input.nextLine();
                System.out.print("Informe a sua prioridade: ");
                prio = in.nextInt();
                while (prio < 1 || prio > 10) {
                    System.out.print("Valor inválido. Digite um valor positivo não nulo menor ou igual a 10: ");
                    prio = in.nextInt();
                }
                tarf = new Tarefa(desc, prio);
                listTarf.incerirTarf(tarf);
            }
            else if (opMenu == '2') {
                System.out.print("Informe a descrição da tarefa: ");
                desc = input.nextLine();
                tarf = new Tarefa(desc);
                listTarf.qntTarf(tarf);
            }
            else if (opMenu == '3') {
                listTarf.removPrimer();
            }
            else if (opMenu == '4') {
                System.out.print("Informe a descrição da tarefa a ser removida: ");
                desc = input.nextLine();
                tarf = new Tarefa(desc);
                listTarf.removTarf(tarf);
            }
            else if (opMenu == '5') {
                System.out.print("Informe a prioridade para ser exibida: ");
                prio = in.nextInt();
                while (prio < 1 || prio > 10) {
                    System.out.print("Valor inválido. Digite um valor positivo não nulo menor ou igual a 10: ");
                    prio = in.nextInt();
                }
                listTarf.exibePrio(prio);
            }
            else if (opMenu == '6') {
                listTarf.exibeList();
            }
            else if (opMenu == '7') {
                System.out.print("Informe a descrição da tarefa: ");
                desc = input.nextLine();
                System.out.print("Informe sua a nova prioridade: ");
                prio = in.nextInt();
                while (prio < 1 || prio > 10) {
                    System.out.print("Valor inválido. Digite um valor positivo não nulo menor ou igual a 10: ");
                    prio = in.nextInt();
                }
                tarf = new Tarefa(desc);
                listTarf.altTarf(tarf, prio);
            }
            else if (opMenu == '8') {
                menuTarefas();
            }
            else if (opMenu == '0') {
                System.out.println("Fim do programa.");
            }
            else {
                System.out.println("Opção inválida.");
            }
        } while (opMenu != '0');
    }

    public static void menuTarefas() {
        System.out.println("Opções do uso da lista.");
        System.out.println("1 - Inserir uma nova tarefa na lista.");
        System.out.println("2 - Informar a quantidade de tarefas que são executadas antes da desejada.");
        System.out.println("3 - Executar a primeira tarefa da lista.");
        System.out.println("4 - Remover uma tarefa desejada da lista.");
        System.out.println("5 - Exibir as descrições das tarefas de uma determinada prioridade.");
        System.out.println("6 - Exibir todas as tarefas da lista.");
        System.out.println("7 - Alterar a prioridade de uma tarefa");
        System.out.println("0 - Sair do programa.");
    }
}