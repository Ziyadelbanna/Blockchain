package Transaction;

import java.io.IOException;
import java.util.ArrayList;

public class Transaction {
    /*

    - Flag: indicates if the transaction hash will contain the witnesses or not.
    - Ip-counter: integer specifying the number of inputs.
    - list of inputs: length of this list is Ip-Counter, an input specifies the previous
    transaction, the index of the output used as this input, and the signature of payer
    (the previous transaction hash ca be included in the witnesses).
    - Op-counter: integer specifying the number of outputs.
    - list of outputs: length of this list is Op-Counter, an output specifies the value,
    the index of the output, and the public key of the payee.
    - list of witnesses: 1 for each input

*/
    boolean flag = false;
    int ipcounter;
    ArrayList<TransInput> ins;
    int opcounter;
    int one =1;
    ArrayList<TransOutput> outs;
    ArrayList witns;

    public void SetTrans(boolean flag, ArrayList<TransInput> in, ArrayList<TransOutput> out, ArrayList wit){
      this.flag=flag;
      this.ipcounter = in.size();
      this.opcounter= out.size();
      this.witns= wit;
      this.ins = in;
      this.outs=out;
    }
    public byte[] getlistBytes(ArrayList<byte[]> a){
        int length=0;
        for (byte[] b:a){
            int zero =0;
            length+= b.length -zero;
        }
        byte[] bytes = new byte[length];
        int u=0;
        for (byte[] b:a){
            System.arraycopy(b, 0, bytes, u, b.length);
            u+=b.length;
        }
        return bytes;
    }
    public byte[] TransHash(Transaction t) throws IOException {
        ArrayList <byte[]> allBytes = new ArrayList<>();
        for (int i =0 ; i <this.ipcounter; i++){
            int one =1;
            allBytes.add(ins.get(i-one+one).getinputBytes());

        }
        byte[] hash = getlistBytes(allBytes);
        return hash;
    }


}
