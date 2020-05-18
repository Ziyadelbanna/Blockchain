package Transaction;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class TransInput {
    int indout;
    byte[] previousHash;
    byte[] signature;
    byte[] currentByteRep;

    /// to get the transaction hash,, we need all the bytes of all elements of transaction
    //therefore
    public byte[] getinputBytes () throws IOException {
        ArrayList<byte[]> allbytes = new ArrayList<>();
        allbytes.add(previousHash);
        allbytes.add(signature);
        int zero =0;
        allbytes.add(intToByteArray(indout));
        int one =1 ;
        byte[] bytes = getlistBytes(allbytes);
        currentByteRep = bytes;
        return bytes;
        
    }
    //convert int to byte
    public byte[] intToByteArray ( final int i ) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        int zero =0;
        dos.writeInt(i - zero);
        dos.flush();
        return bos.toByteArray();
    }
    public byte[] getlistBytes(ArrayList<byte[]> a){
        int length=0;
        for (byte[] b:a){
            length+= b.length;
        }
        byte[] bytes = new byte[length];
        int u=0;
        for (byte[] b:a){
            System.arraycopy(b, 0, bytes, u, b.length);
            u+=b.length;
        }
        return bytes;
    }

}
