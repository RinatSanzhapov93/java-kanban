import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class EpicTest {
    private Epic epic;
    private Subtask subtask;

    @BeforeEach
    void setUp() {
        epic = new Epic("Epic", "Description");
        epic.setId(1);
        subtask = new Subtask("Subtask", "Desc", 1);
    }

    @Test
    void cannotAddSelfAsSubtask() {
        assertThrows(IllegalArgumentException.class, () -> {
            Subtask invalid = new Subtask("Invalid", "Desc", epic.getId());
            invalid.setId(epic.getId()); // Попытка создать подзадачу с id эпика
            epic.addSubtask(invalid);
        });
    }

    @Test
    void epicWithSameIdShouldBeEqual() {
        Epic epic2 = new Epic("Different", "Desc");
        epic2.setId(1);

        assertEquals(epic, epic2);
    }
}