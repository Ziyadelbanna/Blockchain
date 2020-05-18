package Transaction;

//- list of outputs: length of this list is Op-Counter, an output specifies the value,
//the index of the output, and the public key of the payee.

public class TransOutput {
    int opcounter;
    int outindex;
    byte[] publicKey;

}
