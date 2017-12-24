import java.net.*;
import java.util.*;
public class ComputerB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Thread readData;
        ReceiveLetter rec = new ReceiveLetter(10024);
        try {readData= new Thread(rec);
            readData.start();
            byte[] buffer = new byte[1];
            InetAddress address = InetAddress.getByName("127.0.0.1");
            DatagramPacket datapack = new DatagramPacket(buffer,buffer.length, address,10029);
            DatagramSocket postman = new DatagramSocket();
            System.out.println("input the message to computer B");
            while (in.hasNext()) {
                String mess = in.nextLine();
                buffer = mess.getBytes();
                if (mess.length() == 0) {
                    System.exit(0);
                }
                buffer = mess.getBytes();
                datapack.setData(buffer);
                postman.send(datapack);
//                System.out.println("input continue");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
