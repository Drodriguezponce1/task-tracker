import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task{
    private static int identifier = 1;
    private int id;
    private String description, status;
    private LocalDateTime createdAt, updatedAt;

    public Task(){
        this.id = identifier;
        identifier++;
        this.description = "na";
        this.status = "in progress";
        this.createdAt = LocalDateTime.now();
    }

    public Task(String description){
        this.id = identifier;
        identifier++;
        this.description = description;
        this.status = "in progress";
        this.createdAt = LocalDateTime.now();
    }

    public int getID(){
        return this.id;
    }

    public String getDescription(){
        return this.description;
    }

    public String getStatus(){
        return this.status;
    }

    public String getCreatedAt(){
        return this.createdAt.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }

    @Override
    public String toString(){
        return "[ID: " + this.getID() + ", Description: " + this.getDescription() +", Status: " + this.getStatus() +", Created at: " + this.getCreatedAt() + "]";
    }


}