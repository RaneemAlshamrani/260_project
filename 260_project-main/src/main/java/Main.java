/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ragha
 */

//import java.util.ArrayList;
//import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        //temp only to test
        Process p1 = new Process(1, 0, 5, 1);
        Process p2 = new Process(2, 2, 7, 2);
        Process p3 = new Process(3, 4, 3, 3);
        
        
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        
        
        QueueLevel high = new QueueLevel(1, 2);   // High priority - RR with quantum 2
        QueueLevel medium = new QueueLevel(2, 4); // Medium - RR with quantum 4
        QueueLevel low = new QueueLevel(3, 6);    // Low - RR with quantum 6

        Process[] allProcesses = {p1, p2, p3};

        for (Process p : allProcesses) {
            switch (p.getPriorityLevel()) {
                case 1 -> high.addProcess(p);
                case 2 -> medium.addProcess(p);
                case 3 -> low.addProcess(p);
            }
        }

        System.out.println("High Priority Queue:");
        for (Process p : high.getQueue()) {
            System.out.println(p);
        }

        System.out.println("\nMedium Priority Queue:");
        for (Process p : medium.getQueue()) {
            System.out.println(p);
        }

        System.out.println("\nLow Priority Queue:");
        for (Process p : low.getQueue()) {
            System.out.println(p);
        }
        
        Dispatcher dispatcher = new Dispatcher();

        System.out.println("\n--- Dispatcher Test ---");

        // Simulate context switching between p1 -> p2 -> p3
        dispatcher.contextSwitch(null, p1); // First process, no current process
        dispatcher.contextSwitch(p1, p2);   // Switch from p1 to p2
        dispatcher.contextSwitch(p2, p3);   // Switch from p2 to p3
        dispatcher.contextSwitch(p3, null); // Last process finishes (optional)
        
        System.out.println("[Dispatcher] All processes have finished execution.");

    }
}
        
        /*
        
        بعد ما نخلص كل الكلاسات : 

        // إنشاء الطوابير المختلفة مع Quantum مختلف لكل واحدة
        QueueLevel highPriority = new QueueLevel(2, "High Priority");
        QueueLevel mediumPriority = new QueueLevel(4, "Medium Priority");
        QueueLevel lowPriority = new QueueLevel(6, "Low Priority");

        // إنشاء العمليات وإسنادها للطوابير بناءً على الأولوية
        highPriority.addProcess(new Process(1, 0, 6, 1));
        mediumPriority.addProcess(new Process(2, 0, 8, 2));
        lowPriority.addProcess(new Process(3, 0, 12, 3));

        // ترتيب الطوابير حسب الأولوية
        List<QueueLevel> queues = new ArrayList<>();
        queues.add(highPriority);
        queues.add(mediumPriority);
        queues.add(lowPriority);

        // تشغيل الجدولة
        Scheduler scheduler = new Scheduler();
        scheduler.schedule(queues);
    }
}
*/
    


