import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SubtaskTest {
    @Test
    void testCannotBeItsOwnEpicOnCreation() {
        Task temp = new Task("Temp", "Temp");
        temp.setId(1);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Subtask("Invalid", "Desc", 1).setId(1);
                }
        );
        assertEquals("Нельзя установить ID подзадачи равным ID эпика", exception.getMessage());
    }

    @Test
    void testNormalSubtaskCreation() {
        assertDoesNotThrow(() -> {
            Subtask subtask = new Subtask("Valid", "Desc", 1);
            subtask.setId(2);
        });
    }

    @Test
    void testGetEpicId() {
        Subtask subtask = new Subtask("Test", "Desc", 5);
        assertEquals(5, subtask.getEpicId());
    }

    @Test
    void testEqualsAndHashCode() {
        Subtask subtask1 = new Subtask("Sub 1", "Desc", 1);
        subtask1.setId(10);
        Subtask subtask2 = new Subtask("Sub 2", "Desc", 1);
        subtask2.setId(10);

        assertEquals(subtask1, subtask2);
        assertEquals(subtask1.hashCode(), subtask2.hashCode());
    }

    @Test
    void testToString() {
        Subtask subtask = new Subtask("Title", "Desc", 1);
        subtask.setId(5);
        subtask.setStatus(TaskStatus.IN_PROGRESS);

        String expected = "Subtask{id=5, title='Title', description='Desc', status=IN_PROGRESS, epicId=1}";
        assertEquals(expected, subtask.toString());
    }
}