/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ragha
 */
public class Process {
    private int pid;             // Unique process ID
    private int arrivalTime;     // Time at which the process arrives
    private int burstTime;       // Total CPU time required by the process
    private int remainingTime;   // Remaining time left to finish the process
    private int priorityLevel;   // Priority level (used to assign to different queues)
    private String status;       // Process status: Ready, Running, Finished

    // Constructor to initialize the process
    public Process(int pid, int arrivalTime, int burstTime, int priorityLevel) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime; // Initially, remaining time equals burst time
        this.priorityLevel = priorityLevel;
        this.status = "Ready"; // Default status when process is created
    }

    // Getters
    public int getPid() {
        return pid;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }
    public String getStatus() {
        return status;
    }

    // Setter for remaining time (used when the process executes partially)
    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }
     public void setStatus(String status) {
        this.status = status;
    }

    // toString() method for easy printing of process information
    @Override
    public String toString() {
        return "P" + pid + " [Arrival=" + arrivalTime + ", Burst=" + burstTime +
                ", Remaining=" + remainingTime + ", Priority=" + priorityLevel + ", Status=" + status + "]";
    }
}


