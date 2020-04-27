package kkm;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class App extends Task_class{
    public static ArrayList<Integer> listInt;
    public static String[][] listStr;

    public static void main(String[] args) throws IOException, InterruptedException {
        ClassPathXmlApplicationContext worker_val = new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassPathXmlApplicationContext task_val = new ClassPathXmlApplicationContext("applicationContext.xml");

        Worker Worker_val  = worker_val.getBean("workerType", Worker.class);
        Task_class Task_val =  task_val.getBean("workerType", Worker.class);

        worker_val.close();
        task_val.close();

        Worker worker = new Worker();
        worker.work();
    }

}
