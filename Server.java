import java.io.*;
import java.net.*;
class Server
{
public static void main(String[] args)throws Exception
{
 DataInputStream in=new DataInputStream(System.in);
 DatagramSocket ss=new DatagramSocket(6789);
 byte[] sd=new byte[30];
 byte[] rd=new byte[20];
 String sen,nsen;
 try
 {
   do
   {
     DatagramPacket rp=new DatagramPacket(rd,rd.length);
     ss.receive(rp);
      sen=new String(rp.getData());
      InetAddress ip=rp.getAddress();
      int port=rp.getPort();
      System.out.println("From Client:"+sen);       
      nsen=in.readLine();
      sd=nsen.getBytes();
      DatagramPacket sp=new DatagramPacket(sd,sd.length,ip,port);
      ss.send(sp); 
    }
    while(sen.compareTo("close")!=0);
    ss.close();
  }
catch(Exception ex)
{
System.out.println("The exception is"+ex);
}
}
}  