import java.io.BufferedWriter;
import java.io.FileWriter;

public class Logger {

    private static Logger instance = null;
    private BufferedWriter bw;

    private Logger() {
        try {
            bw = new BufferedWriter(new FileWriter("log.txt", true));
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }
    public void write(String message){
        try{
            if(bw != null){
                bw.write(message);
                bw.newLine();
                bw.flush();
            }
        }catch(Exception e) {
            e.printStackTrace();
        }

    }
    public void close(){
        try{
            if(bw != null){
                bw.close();
            }
        }catch(Exception e) {
            e.printStackTrace();
        }

    }
    public void setFileName(String fileName){

        try{
            if(bw != null){
                bw.close();
            }
            bw = new BufferedWriter(new FileWriter(fileName, true));
        }catch(Exception e) {
            e.printStackTrace();

    }
}
}
