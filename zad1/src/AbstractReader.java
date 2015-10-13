/**
 * Created by kamil on 07.10.15.
 */
public abstract class AbstractReader {
    protected String zdanie, zapam, tmp;
    protected String loacalAddress;
    protected int poczatek,koniec,liczbaLinkow;
    public abstract void read(String address, boolean wszystkieLinki, boolean aktualnaDomena) throws Exception;
}
