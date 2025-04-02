import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    void tasksWithSameIdShouldBeEqual() {
        Task task1 = new Task("Task 1", "Description");
        task1.setId(1);
        Task task2 = new Task("Task 2", "Different description");
        task2.setId(1);

        assertEquals(task1, task2);
        assertEquals(task1.hashCode(), task2.hashCode());
    }

    @Test
    void taskShouldPreserveFieldsWhenAddedToManager() {
        TaskManager manager = Managers.getDefault();
        Task original = new Task("Original", "Desc");
        original.setStatus(TaskStatus.IN_PROGRESS);

        int id = manager.createTask(original);
        Task saved = manager.getTask(id);

        assertEquals(original.getTitle(), saved.getTitle());
        assertEquals(original.getDescription(), saved.getDescription());
        assertEquals(original.getStatus(), saved.getStatus());
    }
}