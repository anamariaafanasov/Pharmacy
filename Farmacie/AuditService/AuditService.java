package Farmacie.AuditService;

import java.io.*;
import java.sql.Timestamp;
import java.util.Date;

public class AuditService {
    Timestamp time;
    private static AuditService auditService;
    public static AuditService AuditService(){
        if(auditService==null){
            auditService= new AuditService();
            return auditService;
        }
        return auditService;
    }

    public void addFunction(String calledMethod, String path)throws IOException {

        FileWriter fileWriter=new FileWriter(path,true);
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);

        time=new Timestamp(System.currentTimeMillis());
        Thread t = new Thread();
        printWriter.println(calledMethod+","+time+","+t.getName());

        printWriter.flush();
        printWriter.close();


    }
}
