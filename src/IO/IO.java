package IO;

import java.io.*;
/**
 *
 * @author fahmy
 */
public class IO {
    public String getInput(String filename){
        FileInputStream in = null;
        try{
            in = new FileInputStream(filename);
            int c;
            String ret = "";
            while((c = in.read()) != -1){
                ret += (char)c;
            }
            in.close();
            return ret;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new String();
        }
    }
    
    public void writeOutput(String filename,String output){
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filename);
            for(int c: output.toCharArray()){
                out.write((char)c);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
