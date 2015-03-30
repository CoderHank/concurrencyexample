package ch02_basicthreadsynch.e07_usemulticonditioninlock;

/**
 * Created by Hank on 2015/3/30.
 */
public class FileMock {
    private String content[];
    private int index;

    public FileMock(int size, int length){
        content = new String[size];
        for (int i = 0; i < size; i++) {
            StringBuilder buffer = new StringBuilder(length);
            for (int j = 0; j < length; j++) {
                int indice = (int)Math.random()*255;
                buffer.append((char)indice);
            }
            content[i] = buffer.toString();
        }
    }

    public boolean hasMoreLines(){
        return index < content.length;
    }

    public String getLine(){
        if(this.hasMoreLines()){
            System.out.println("Mock:" + index);
            return content[index++];
        }

        return null;
    }
}
