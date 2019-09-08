package laboratorio2;
 import java.net.*;
 import java.io.*;
 public class EchoServer {
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
    clientSocket = serverSocket.accept();
   } catch (IOException e) {
    System.err.println("Accept failed.");
    System.exit(1);
   }
   PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
   BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
   String inputLine, outputLine, f;
   f = "cos";
   while ((inputLine = in .readLine()) != null) {       
       if(inputLine.length() >= 4 && inputLine.substring(0,4).equals("fun:")){
           String st = inputLine.substring(4,inputLine.length());           
           if(st.equals("sin") || st.equals("cos") || st.equals("tan")){
               f = st;
               out.println(st);
           }else {
               out.println("función no definida");
           }
       }else{
           double num = Double.parseDouble(inputLine);
           if(f.equals("cos")){
               out.println("El coseno es -> "+Math.cos(num));
           }else if(f.equals("sin")){
               out.println("El seno es -> "+Math.sin(num));
           }else if(f.equals("tan")){
        	   try {
        		   double n = Math.tan(num);
        		   out.println("La tangente es -> "+n);
        	   }catch(Exception e) {
        		   out.println("La tangente no se puede calcular para el valor -> "+num);
        	   }               
           }
       }
   }
   out.close(); in .close();
   clientSocket.close();
   serverSocket.close();
  }
 }
