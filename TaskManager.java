import java.util.List;
import java.util.ArrayList;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void add(String description) {
        Task task = new Task(description);

        if (!this.tasks.contains(task)) {
            this.tasks.add(new Task(description));
        }

    }

    public void updateDescription(int id, String description) {
        for (Task task : this.tasks) {
            if (task.getID() == id) {
                task.setDesciption(description);
                task.setUpdatedAt();
                break;
            }
        }
    }

    public void updateStatus(int id, String status) {
        for (Task task : this.tasks) {
            if (task.getID() == id) {
                task.setStatus(status);
                task.setUpdatedAt();
                break;
            }
        }
    }

    public void delete(int id) {

        Task temp = null;

        for(Task task: this.tasks){
            if(task.getID() == id){
                temp = task;
                break;
            }
        }

        this.tasks.remove(temp);
    }

    public void printDone() {
        this.tasks.stream()
            .filter(task -> task.getStatus().equalsIgnoreCase("done"))
            .forEach(task -> System.out.println(task));
    }

    public void printInProgress() {
         this.tasks.stream()
            .filter(task -> task.getStatus().equalsIgnoreCase("in-progress"))
            .forEach(task -> System.out.println(task));
    }

    public void printAll() {
        this.tasks.stream()
                .forEach(task -> System.out.println(task));
    }
}
