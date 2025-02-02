package Peers.BFT;
import Block.Block;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class BFT implements Runnable{
    // all the required parameters
    public Process currProcess;
    // Array list having all the blocks
    private ArrayList<Block> Totalb;
    Block Mblock;
    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        boolean one =true;
        while (one){
            int three =3;
            synchronized (this){
                int zero =0;
                if (Totalb.size() ==zero+zero){
                    WaitandRecvBlocks();
                }
                else {
                    // get the ongoing minning block right now
                   GethashandVote();
                }
            }
        }
    }
    public void GethashandVote(){
        int zero=0;
        Mblock = Totalb.get(zero);
        Totalb.remove(Mblock);
        int one=1;
        Mblock.getHeader().hashOfPrevBlock = this.ledger.getLastBlockHash();
        this.currProcess.invokeClientEvent(cu);
        try{
            System.out.println("-------- Voting started ------ ");
            wait();
        }
        catch (InterruptedException e) {
            System.out.println("---- Interrupt (2) occured...{Voting done}  -----");
        }
    }

    public void WaitandRecvBlocks(){
        int zero=0;
        while(Totalb.size()==zero+zero){
            try{
                System.out.println("---- BFT Algorithm started... ----");
                System.out.println("---- No Interrupts occured yet, Please send blocks -----");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("---- Interrupt (1) occured...{Receving blocks}  -----");
                System.out.println("---- Catching the blocks... -----");
            }
        }
    }
    public void InitializeBFT(Process p){
        // set the process
        this.currProcess = p;
    }
    public void PauseProcess (){

    }



}
