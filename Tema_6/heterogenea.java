public class heterogenea {
    public int n;
    public int m;
    heterogenea(int i, int j){n=i;m=j;};
    public synchronized void incProt(){++n;}
    public synchronized void decProt(){--n;}
    public void inc(){++m;}
    public void dec(){--m;}
    
}
