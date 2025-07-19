

import java.util.LinkedList;
import java.util.Queue;
public class QueueLevel {
    private int level; 
    private int quantum;
    private Queue<Process> processQueue;

    public QueueLevel(int level, int quantum) {
        this.level = level;
        this.quantum = quantum;
        this.processQueue = new LinkedList<>();
    }

    public void addProcess(Process p) {
        processQueue.add(p);
    }

    
    public boolean hasNext() {
        return !processQueue.isEmpty();
    }

  
    public Process nextProcess() {
        return processQueue.poll();
    }

  
    public void requeue(Process p) {
        processQueue.add(p);
    }

    public int getQuantum() {
        return quantum;
    }

    public int getLevel() {
        return level;
    }

    public Queue<Process> getQueue() {
        return processQueue;
    }


    
}
