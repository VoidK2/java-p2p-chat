import java.net.*;
public class ReceiveLetter implements Runnable{
    int port;
    ReceiveLetter(int port){
        this.port=port;
    }
    public void run(){
        DatagramPacket pack = null;
        DatagramSocket postman=null;
        byte data[] = new byte[8192];
        try{
            pack=new DatagramPacket(data,data.length);
            postman = new DatagramSocket(port);
        }
        catch(Exception e){
            System.out.println(" Computer error");
        }
        while(true){
            if(postman==null)
                break;
            else
                try{postman.receive(pack);
                    String message = new String(pack.getData(),0,pack.getLength());
                    System.out.printf("%25s\n","收到"+message);
                }catch (Exception e){
                    System.out.println("rl error");
                }
        }
    }

}
