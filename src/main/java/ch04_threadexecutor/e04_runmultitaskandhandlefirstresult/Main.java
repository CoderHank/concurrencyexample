package ch04_threadexecutor.e04_runmultitaskandhandlefirstresult;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Hank on 2015/4/4.
 */
public class Main {

    public static void main(String[] args){
        String username = "test";
        String password = "test";

        UserValidator ldapValidator = new UserValidator("LDAP");
        UserValidator dbValidator = new UserValidator("DataBase");

        TaskValidator ldapTask = new TaskValidator(ldapValidator, username, password);
        TaskValidator dbTask = new TaskValidator(dbValidator, username, password);

        List<TaskValidator> taskList = new ArrayList<TaskValidator>();
        taskList.add(ldapTask);
        taskList.add(dbTask);

        ExecutorService executor = Executors.newCachedThreadPool();
        String result;
        try{
            result = executor.invokeAny(taskList);
            System.out.printf("Main: Result: %s\n", result);
        }catch(Exception e){
            e.printStackTrace();
        }
        executor.shutdown();
        System.out.printf("Main: End of the Execution\n");
    }
}
