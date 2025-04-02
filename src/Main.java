public class Main {
    public static void main(String[] args) {
        TaskManager manager = Managers.getDefault();

        Task task1 = new Task("Купить продукты", "Сходить в магазин");
        int taskId1 = manager.createTask(task1);

        Epic epic1 = new Epic("Подготовка к отпуску", "Список дел перед отпуском");
        int epicId1 = manager.createEpic(epic1);

        Subtask subtask1 = new Subtask("Купить билеты", "Зайти на AviaSales", epicId1);
        int subtaskId1 = manager.createSubtask(subtask1);

        System.out.println("Все задачи:");
        manager.getAllTasks().forEach(System.out::println);

        System.out.println("\nВсе эпики:");
        manager.getAllEpics().forEach(System.out::println);

        System.out.println("\nВсе подзадачи:");
        manager.getAllSubtasks().forEach(System.out::println);

        manager.getTask(taskId1);
        manager.getEpic(epicId1);
        manager.getSubtask(subtaskId1);

        System.out.println("\nИстория просмотров:");
        manager.getHistory().forEach(System.out::println);
    }
}