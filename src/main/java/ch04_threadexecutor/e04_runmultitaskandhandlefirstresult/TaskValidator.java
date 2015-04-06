package ch04_threadexecutor.e04_runmultitaskandhandlefirstresult;

import java.util.concurrent.Callable;

/**
 * Created by Hank on 2015/4/4.
 */
public class TaskValidator implements Callable<String> {

    private UserValidator validator;
    private String user;
    private String password;

    public TaskValidator(UserValidator validator, String user, String password){
        this.validator = validator;
        this.user = user;
        this.password = password;
    }

    @Override
    public String call() throws Exception{
        if( ! validator.validate(user ,password)){
            System.out.printf("%s: The user has not been found\n", validator.getName());
            throw new Exception("Error validating user");
        }

        System.out.printf("%s: The user has been found\n", validator.getName());

        return validator.getName();
    }
}
