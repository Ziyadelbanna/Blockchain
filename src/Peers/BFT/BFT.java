package Peers.BFT;
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
        while (1){
            synchronized (this){
                if (Totalb.size() ==0){
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
        Mblock = Totalb.get(0);
        Totalb.remove(Mblock);
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
        while(Totalb.size()==0){
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
