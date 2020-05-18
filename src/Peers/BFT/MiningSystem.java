package Peers.BFT;


import java.net.InetAddress;
import java.net.UnknownHostException;

public class MiningSystem {
    public BFT newBFT;
    public String address;
    public int portNo =0;
    Process Currprocss;
    public MiningSystem(BFT currBFT) throws UnknownHostException {
        this.newBFT = currBFT;
        InetAddress inetAddress = InetAddress.getByName(address);


    }
}
