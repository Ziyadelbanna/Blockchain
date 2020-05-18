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
    ArrayList<TransOutput> outs;
    ArrayList witns;

    public void SetTrans( boolean flag, ArrayList<TransInput> in, ArrayList<TransOutput> out, ArrayList wit){
      this.flag=flag;
      this.ipcounter = in.size();
      this.opcounter= out.size();
      this.witns=wit;
      this.ins = in;
      this.outs=out;
    }



}
