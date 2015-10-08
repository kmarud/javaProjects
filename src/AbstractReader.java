/**
 * Created by kamil on 07.10.15.
 */
public abstract class AbstractReader {
    protected String zdanie;
    protected String loacalAddress;
    protected int poczatek,koniec,liczbaLinkow;
    public abstract void read(String address, boolean wszystkieLinki) throws Exception;
}
