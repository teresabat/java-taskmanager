package javaTaskManager;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
	private static ArrayList<Task> tasks = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("1. Adicionar tarefa");
			System.out.println("2. Listar tarefas");
			System.out.println("3. Completar tarefa");
			System.out.println("4. Sair");
			System.out.println("Escolha uma opção: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // consume newline

			switch (choice) {
			case 1:
				addTask(scanner);
				break;
			case 2:
				listTasks();
				break;
			case 3:
				completeTask(scanner);
				break;
			case 4:
				System.out.println("Saindo...");
				return;
			default:
				System.out.println("Opção inválida.");

			}
		}

	}

	private static void addTask(Scanner scanner) {
		System.out.print("Digite a descrição da tarefa: ");
		String description = scanner.nextLine();
		tasks.add(new Task(description));
		System.out.println("Tarefa adicionada!");
	}

	private static void listTasks() {
		if (tasks.isEmpty()) {
			System.out.println("Nenhuma tarefa adicionada.");
		} else {
			for (int i = 0; i < tasks.size(); i++) {
				Task task = tasks.get(i);
				System.out
						.println((i + 1) + ". " + task.getDescription() + (task.isCompleted() ? " (completada)" : ""));
			}
		}
	}

	private static void completeTask(Scanner scanner) {
		listTasks();
		System.out.print("Digite o número da tarefa a completar: ");
		int taskNumber = scanner.nextInt();
		if (taskNumber > 0 && taskNumber <= tasks.size()) {
			Task task = tasks.get(taskNumber - 1);
			task.complete();
			System.out.println("Tarefa completada!");
		} else {
			System.out.println("Número de tarefa inválido.");
		}
	}
}
