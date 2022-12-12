/**
 * recurso
 */
public class recurso {
    private long n;
    recurso(){
        n = 0;
    }

    public void inc(){++n;}
    public long observer(){return n;}
}
