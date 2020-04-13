
public class Task implements Comparable<Task> {
    int priority = 0;
    String task;
    boolean done;

    public Task(int priorityIn, String taskIn){
        this.priority = priorityIn;
        this.task = taskIn;
        this.done = false;

    }

    public int getPriority(){return this.priority;}

    public String getTask(){return this.task;}

    public boolean getDone(){return this.done;}

    public void markDone(){this.done = true;}


    @Override
    public int compareTo(Task o) {

        if(priority < o.getPriority()){
            return 1;
        }
        else if(priority > o.getPriority()){
            return -1;
        }

        else{

        return 0;}
    }
}
