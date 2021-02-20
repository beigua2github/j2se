package videochatroom;

import java.io.IOException;
import java.net.*;

public class UDPTransmit extends Thread{
    DatagramSocket ds;
    DatagramPacket pack;
    String address;
    String data;
    int port;
    boolean cycle;

    public UDPTransmit(DatagramSocket ds, String data, String address, int port, boolean cycle) {
        this.ds = ds;
        this.data = data;
        this.address = address;
        this.port = port;
        this.cycle = cycle;
        setPack();
    }

    public void setPack(){
        byte[] bData = data.getBytes();
        InetSocketAddress addr = new InetSocketAddress(address, port);
        pack = new DatagramPacket(bData, bData.length, addr);
    }

    public void run(){
        if(cycle){
            for (; ; ) {
                try {
                    ds.send(pack);
                    sleep(20000); //20��
                } catch (IOException ex) {
                } catch (InterruptedException ex1) {
                }
            }
        } else {
            try {
                ds.send(pack);
            } catch (IOException ex2) {
            }
        }
    }
}
