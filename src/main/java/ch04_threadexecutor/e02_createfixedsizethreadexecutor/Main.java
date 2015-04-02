package ch04_threadexecutor.e02_createfixedsizethreadexecutor;


/**
 * Created by Hank on 2015/4/2.
 */
public class Main {
    public static void main(String[] args){
        Server server = new Server();
        for (int i = 0; i < 100; i++) {
            Task task = new Task("Task_" + i);

            server.executeTask(task);
        }

        server.endServer();
    }
}
