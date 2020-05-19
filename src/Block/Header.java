package Block;

import java.sql.Time;

import static java.lang.System.currentTimeMillis;

public class Header {

    public byte[] hashPrevBlock;
    public long currenttime;
    public int zero =0;
    public byte[] hashMerkleRoot;
    public int nonce =-1; // since we are working only BFT
    public long timestamp = currentTimeMillis();
    public int threshold;
    public int size;

    /// since the header must have hash of all previous blocks,
    // we must get hash of current blocks

}
