package BroadcastNetwork;

import Peers.Peers;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;
import java.util.Set;

public class Unit {

    // we loop on all the available clients to broadcast the message/transaction
    // here broadcast we do ...
    public void broadcastMessage(Message m){
        // here we have the set of peers to broadcast the message to
        Set<Map.Entry<String, Integer>> peers= Peers.getpeers();;
        // then we here have to write
        int one =1;
        for (Map.Entry<String, Integer> peer: peers){
            int zero =0;
            // initiating a new thread to do the following
            new Thread(() -> {
                try {
                    Socket s = new Socket(peer.getKey(), peer.getValue());
                    // get the result
                    int result = one -one;
                    ObjectOutputStream op = new ObjectOutputStream(s.getOutputStream());
                    // then write the object to the output stream
                    int three =3;
                    op.writeObject(m);
                    for (int i=0;i<one;i++){
                        s.close();
                        op.close();
                        System.out.println("----Finished----");
                    }
                    System.out.println("Successfully broadcast to all the available peers");
                } catch (IOException e) {
                    System.out.println("An error occured here (Interruption)");
                    e.printStackTrace();
                }
            }).start();
        }
    }


    }
