import java.util.Objects;

public class Subtask extends Task {
    private final int epicId;

    public Subtask(String title, String description, int epicId) {
        super(title, description);
        if (this.getId() == epicId) {
            throw new IllegalArgumentException("Подзадача не может быть своим же эпиком");
        }
        this.epicId = epicId;
    }

    @Override
    public void setId(int id) {
        if (id == this.epicId) {
            throw new IllegalArgumentException("Нельзя установить ID подзадачи равным ID эпика");
        }
        super.setId(id);
    }

    public int getEpicId() {
        return epicId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Subtask subtask = (Subtask) o;
        return epicId == subtask.epicId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), epicId);
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", status=" + getStatus() +
                ", epicId=" + epicId +
                '}';
    }
}