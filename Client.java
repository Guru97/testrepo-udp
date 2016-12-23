import java.io.*;
import java.net.*;
class Client
{
public static void main(String[] args)throws Exception
{
 DataInputStream in=new DataInputStream(System.in);
 DatagramSocket cs=new DatagramSocket();
 InetAddress ipAddress=InetAddress.getByName("10.1.5.163");
 String sen,nsen;
 do
 {
  byte[] sd=new byte[20];
  byte[] rd=new byte[20];
  sen=in.readLine();
  sd=sen.getBytes();
  DatagramPacket sp=new DatagramPacket(sd,sd.length,ipAddress,6789);
  cs.send(sp);   
  DatagramPacket rp=new DatagramPacket(rd,rd.length);
  cs.receive(rp);
  nsen=new String(rp.getData());
  System.out.println("From Server:"+nsen);
 }
 while(sen.compareTo("close")!=0);
 cs.close();
}
}