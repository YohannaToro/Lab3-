package laboratorio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.*;
import java.io.*;

import com.sun.org.apache.xerces.internal.util.URI;
//ejercicio 4.5

public class HttpServer2 {
	 public static void main(String[] args) throws IOException {
		  ServerSocket serverSocket = null;
		  try {
		   serverSocket = new ServerSocket(35000);
		  } catch (IOException e) {
		   System.err.println("Could not listen on port: 35000.");
		   System.exit(1);
		  }
		  Socket clientSocket = null;
		  try {
		   System.out.println("Listo para recibir ...");
		   clientSocket = serverSocket.accept();
		  } catch (IOException e) {
		   System.err.println("Accept failed.");
		   System.exit(1);
		  }
		  PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		  BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		  String inputLine, outputLine;
		  while ((inputLine = in .readLine()) != null) {
			  BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			     //String st = bf.readLine();
			     URL url = new URL(inputLine);
			     String extension = inputLine.substring(inputLine.lastIndexOf("."));
			     if(!(extension.equals(".png") || extension.equals(".jpg") || extension.equals(".jpeg"))) {
			    	 extension = ".html";
			     }
			     bf = new BufferedReader(new InputStreamReader(url.openStream()));
			     File res = new File(System.getProperty("user.dir")+"/resultado"+System.currentTimeMillis()+extension);
			        PrintWriter print = new PrintWriter(res);
			        String s = bf.readLine();
			        String rta = "";
			        while(s != null){
			        	rta+=s;	            
			            s = bf.readLine();
			        }
			        print.write(rta);
			        out.println(rta);
			        print.close();
		}
		  outputLine = "<!DOCTYPE html>" + "<html>" + "<head>" + "<meta charset=\"UTF-8\">" + "<title>Title of the document</title>\n" + "</head>" + "<body>" + "My Web Site" + "</body>" + "</html>" + inputLine;
		  out.println("HTTP/1.1 200 OK");
		  out.println("content-type: "+"text/html");
		  out.println();
		  out.flush();
		  out.println(outputLine);
		  out.close(); in .close();
		  clientSocket.close();
		  serverSocket.close();
		 }
}
