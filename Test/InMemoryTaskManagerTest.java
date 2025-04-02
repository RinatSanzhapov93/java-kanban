import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class InMemoryTaskManagerTest {
    private TaskManager manager;

    @BeforeEach
    void setUp() {
        manager = Managers.getDefault();
    }

    @Test
    void shouldAddAndFindDifferentTaskTypes() {
        // Тест для задач
        Task task = new Task("Task", "Desc");
        int taskId = manager.createTask(task);
        assertNotNull(manager.getTask(taskId));

        // Тест для эпиков
        Epic epic = new Epic("Epic", "Desc");
        int epicId = manager.createEpic(epic);
        assertNotNull(manager.getEpic(epicId));

        Subtask subtask = new Subtask("Subtask", "Desc", epicId);
        int subtaskId = manager.createSubtask(subtask);
        assertNotNull(manager.getSubtask(subtaskId));
    }

    @Test
    void generatedAndManualIdsShouldNotConflict() {
        Task task1 = new Task("Task 1", "Desc");
        int autoId = manager.createTask(task1);

        Task task2 = new Task("Task 2", "Desc");
        task2.setId(autoId + 1);
        int manualId = manager.createTask(task2);

        assertNotEquals(autoId, manualId);
        assertNotNull(manager.getTask(autoId));
        assertNotNull(manager.getTask(manualId));
    }
}