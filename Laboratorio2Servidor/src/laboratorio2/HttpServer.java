package laboratorio2;
import java.net.*;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.*;
public class HttpServer {
 public static void main(String[] args) throws IOException {
	 while(true) {
	  ServerSocket serverSocket = null;
	  try {
	   serverSocket = new ServerSocket(35001);
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
	   System.out.println("Received: " + inputLine);
	   if (! in .ready()) {
	    break;
	   }
	   String req = null;
	   if(inputLine.contains("GET")){	   
		   StringTokenizer stok = new StringTokenizer(inputLine);
		   stok.nextToken();
		   req = stok.nextToken();
		   String extension = req.substring(req.lastIndexOf("."));
		     if(extension.equals(".png") || extension.equals(".jpg") || extension.equals(".jpeg")) {
		    	BufferedImage bi = ImageIO.read(new File(System.getProperty("user.dir")+req));
		    	out.write("HTTP/2.0 200 OK\n");
	   	     	out.println("\r");
		    	out.write("Content-Type: image/webp,*/*");
		    	ImageIO.write(bi,"PNG",clientSocket.getOutputStream());	    	
		     }else {
		    	 try {
		    		 FileReader f = new FileReader(System.getProperty("user.dir")+req);
		    	     BufferedReader b = new BufferedReader(f);
		    	     String s = b.readLine();
		    	     out.write("HTTP/2.0 200 OK\n");
		    	     out.println("\r");
		    	     while(s != null){
		    	    	 out.write(s);
		    	         s = b.readLine();
		    	     }
		    	    b.close();
		    	    
		    	 }catch(FileNotFoundException f) {
		    		 out.println("HTTP/2.0 404 Not Found");
	                 System.out.println("Not found");
	                 f.printStackTrace();
		    		 out.println("404 Not Found");
		    	 }
		     }
	   	}
	   
	   
	  }
	  //outputLine = "<!DOCTYPE html>" + "<html>" + "<head>" + "<meta charset=\"UTF-8\">" + "<title>Title of the document</title>\n" + "</head>" + "<body>" + "My Web Site" + "</body>" + "</html>" + inputLine;
	  
	  out.println();
	  out.flush();
	  out.close(); in .close();
	  clientSocket.close();
	  serverSocket.close();
	 }
 }
}