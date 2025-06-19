import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task{
    private static int identifier = 0;
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

    public void setDesciption(String description){
        this.description = description;
    }

    public void setUpdatedAt(){
        this.updatedAt = LocalDateTime.now();
    }

    public String getStatus(){
        return this.status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getCreatedAt(){
        return this.createdAt.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }

    public String getUpdatedAt(){
        return this.createdAt.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }

    @Override
    public int hashCode(){
        int hash = 32;
        hash = 31 * hash + this.description.hashCode();

        return hash;
    }

    @Override
    public boolean equals(Object other){
        if(this == other){
            return true;
        }

        if(other == null){
            return false;
        }

        if(!(other instanceof Task)){
            return false;
        }

        Task o = (Task) other;

        return this.description.equalsIgnoreCase(o.getDescription());
    }


    @Override
    public String toString(){
        return updatedAt != null? "[ID: " + this.getID() + ", Description: " + this.getDescription() +", Status: " + this.getStatus() +
            ", Created at: " + this.getCreatedAt() + ", Updated at: " + this.getUpdatedAt() + "]"

            :"[ID: " + this.getID() + ", Description: " + this.getDescription() +", Status: " + this.getStatus() +", Created at: " + this.getCreatedAt() + "]";
    }


}