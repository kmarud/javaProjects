/**
 * Created by kamil on 07.10.15.
 */
public abstract class AbstractReader {
    protected String zdanie, zapam, tmp;
    protected String loacalAddress;
    protected int first,last,numberOfLinks;
    protected boolean allLinks, currentDomain;

    public abstract void read(String address, boolean allLin, boolean aktualnaDomena) throws Exception;

    protected void analyze(String word)
    {
        while (word.contains("a href") && word.contains("</a>")) {
            first = word.indexOf("<a href=");
            last = word.indexOf("</a>");
            tmp = word.substring(first + 9, last);
            if (tmp.startsWith("http") && currentDomain) {
                word = word.replaceFirst("<a href=", "");
                word = word.replaceFirst("</a>", "");
                continue;
            }
            this.numberOfLinks++;
            if (allLinks)
                System.out.println(tmp);
            word = word.replaceFirst("<a href=", "");
            word = word.replaceFirst("</a>", "");
        }
        if (word.contains("a href")) {
            zapam += word;
            first = word.indexOf("<a href=");
        }
        if (word.contains("</a>")) {
            if (!zapam.equals(word))
                zapam += word;
            last = zapam.indexOf("</a>");
            tmp = zapam.substring(first + 9, last);
            if (tmp.startsWith("http") && currentDomain)
                return;
            this.numberOfLinks++;
            if (allLinks)
                System.out.println(tmp);
            zapam = "";
        }
    }
}
