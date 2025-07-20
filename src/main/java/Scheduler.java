
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ruba
 */
public class Scheduler {
    
    private int currentTime = 0;
    private Dispatcher dispatcher = new Dispatcher();

    public void schedule(List<QueueLevel> queues) {
        boolean allQueuesEmpty;

        do {
            allQueuesEmpty = true;

            for (QueueLevel queue : queues) {
                if (!queue.hasNext()) continue;

                allQueuesEmpty = false;

                int quantum = queue.getQuantum();

                Process currentProcess = queue.nextProcess();

                // Skip if the process hasn't arrived yet
                if (currentProcess.getArrivalTime() > currentTime) {
                    queue.requeue(currentProcess); // Push it back to be tried later
                    continue;
                }

                dispatcher.contextSwitch(null, currentProcess); // Load process (no previous needed here)

                int execTime = Math.min(quantum, currentProcess.getRemainingTime());
                System.out.println("[Scheduler] Executing PID: " + currentProcess.getPid() +
                                   " for " + execTime + " units. Current Time: " + currentTime);

                // Simulate execution by increasing current time and decreasing remaining time
                currentTime += execTime;
                currentProcess.setRemainingTime(currentProcess.getRemainingTime() - execTime);

                // Check if finished
                if (currentProcess.getRemainingTime() == 0) {
                    currentProcess.setStatus("Finished");
                    System.out.println("[Scheduler] Process PID " + currentProcess.getPid() + " finished at time " + currentTime);
                } else {
                    currentProcess.setStatus("Ready");
                    queue.requeue(currentProcess); // Re-add to queue for next round
                }

                System.out.println(); // Line break for clarity
            }

        } while (!allQueuesEmpty);

        System.out.println(" [Scheduler] All processes completed. Final Time: " + currentTime);
    }
}

