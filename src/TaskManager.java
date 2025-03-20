import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManager {
    private final Map<Integer, Task> tasks;
    private final Map<Integer, Epic> epics;
    private final Map<Integer, Subtask> subtasks;

    public TaskManager() {
        tasks = new HashMap<>();
        epics = new HashMap<>();
        subtasks = new HashMap<>();
    }

    public void createTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void createEpic(Epic epic) {
        epics.put(epic.getId(), epic);
    }

    public void createSubtask(Subtask subtask) {
        subtasks.put(subtask.getId(), subtask);
    }

    public void deleteTask(int taskId) {
        tasks.remove(taskId);
    }

    public void deleteEpic(int epicId) {
        epics.remove(epicId);
    }

    public void deleteSubtask(int subtaskId) {
        subtasks.remove(subtaskId);
    }

    // Новый метод для удаления всех задач
    public void deleteAllTasks() {
        tasks.clear();
    }

    // Новый метод для удаления всех эпиков
    public void deleteAllEpics() {
        epics.clear();
    }

    // Новый метод для удаления всех подзадач
    public void deleteAllSubtasks() {
        subtasks.clear();
    }

    public Task getTaskById(int id) {
        return tasks.get(id);
    }

    public Epic getEpicById(int id) {
        return epics.get(id);
    }

    public Subtask getSubtaskById(int id) {
        return subtasks.get(id);
    }

    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void updateEpic(Epic epic) {
        epics.put(epic.getId(), epic);
    }

    public void updateSubtask(Subtask subtask) {
        subtasks.put(subtask.getId(), subtask);
    }

    public List<Subtask> getSubtasksForEpic(int epicId) {
        return epics.get(epicId).getSubtasks();
    }

    public void printAllTasks() {
        for (Task task : tasks.values()) {
            System.out.println(task);
        }
    }

    public void printAllEpics() {
        for (Epic epic : epics.values()) {
            System.out.println(epic);
        }
    }

    public void printAllSubtasks() {
        for (Subtask subtask : subtasks.values()) {
            System.out.println(subtask);
        }
    }
}
