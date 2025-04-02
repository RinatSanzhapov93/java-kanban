import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryHistoryManagerTest {
    private HistoryManager historyManager;

    @BeforeEach
    void setUp() {
        historyManager = Managers.getDefaultHistory();
    }

    @Test
    void shouldPreserveTaskDataInHistory() {
        Task original = new Task("Original", "Desc");
        original.setId(1);
        original.setStatus(TaskStatus.IN_PROGRESS);

        historyManager.add(original);
        Task fromHistory = historyManager.getHistory().get(0);

        assertEquals(original.getId(), fromHistory.getId());
        assertEquals(original.getTitle(), fromHistory.getTitle());
        assertEquals(original.getDescription(), fromHistory.getDescription());
        assertEquals(original.getStatus(), fromHistory.getStatus());
    }

    @Test
    void shouldHandleDifferentTaskTypesInHistory() {
        Task task = new Task("Task", "Desc");
        task.setId(1);
        Epic epic = new Epic("Epic", "Desc");
        epic.setId(2);
        Subtask subtask = new Subtask("Subtask", "Desc", 2);
        subtask.setId(3);

        historyManager.add(task);
        historyManager.add(epic);
        historyManager.add(subtask);

        List<Task> history = historyManager.getHistory();
        assertEquals(3, history.size());
        assertTrue(history.contains(task));
        assertTrue(history.contains(epic));
        assertTrue(history.contains(subtask));
    }
}