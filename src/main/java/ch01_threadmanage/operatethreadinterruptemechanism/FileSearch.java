package ch01_threadmanage.operatethreadinterruptemechanism;

import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * Created by Hank on 2015/3/20.
 */
public class FileSearch implements Runnable {
    private String initPath;
    private String fileName;

    public FileSearch(String initPath, String fileName){
        this.initPath = initPath;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        Path path = Paths.get(initPath);
        if(Files.isDirectory(path)){
            try{
                directoryProcess(path);
            }catch (InterruptedException e){
                System.out.printf("%s: The search has been interrupted", Thread.currentThread().getName());
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }

    private void directoryProcess(Path path) throws InterruptedException, IOException{

        Stream<Path> subPaths = Files.list(path);

        if(subPaths != null){
            Iterator<Path> iterator = subPaths.iterator();
            Path subPath;
            while(iterator.hasNext()) {
                subPath = iterator.next();
                if(Files.isDirectory(subPath)){
                    directoryProcess(subPath);
                }else{
                    fileProcess(subPath);
                }
            }

        }

        if(Thread.interrupted()){
            throw new InterruptedException();
        }
    }


    private void fileProcess(Path path) throws InterruptedException{
        if(StringUtils.equals(path.getFileName().toString(), this.fileName)){
            System.out.printf("%s : %s\n", Thread.currentThread().getName(), path.toString());
        }

        if(Thread.interrupted()){
            throw new InterruptedException();
        }
    }
}
