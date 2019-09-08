import java.io.*;
import java.net.*;

public class URLReader {
   public static void main(String[] args) throws Exception {   
   try 
    {
     URL labinfo = new URL("http://laboratorio.is.escuelaing.edu.co:8080/silabinfoap/images/3.jpg");
     //getProtocol, getAuthority, getHost, getPort, getPath, getQuery, getFile, getRef
        System.out.println(" Protocol:"+labinfo.getProtocol() +
                "\n Authority:" + labinfo.getAuthority() + 
                "\n Host:" + labinfo.getHost() + "\n Port:" + labinfo.getPort() + 
                "\n Path:" + labinfo.getPath() + "\n Query:" + labinfo.getQuery() +
                "\n File:" + labinfo.getFile() + "\n Ref:" + labinfo.getRef());
    } catch (MalformedURLException e)
       {
        e.printStackTrace();
       }
   
  }
  
 }