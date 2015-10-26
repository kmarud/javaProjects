import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractReader {
    protected String word;
    protected String loacalAddress;
    protected int numberOfLinks;
    protected boolean allLinks, currentDomain;

    public abstract void read(String address, boolean showAllLinks, boolean onlyCurrentDomain) throws Exception;

    protected void analyze(String word)
    {
        Pattern p = Pattern.compile("a href=\"(.*?)\"");
        Matcher m = p.matcher(word);
        String url = null;
        while(m.find()) {
            url = m.group(1);
            if(currentDomain && (url.startsWith("http://") || url.startsWith("https://")))
                continue;
            this.numberOfLinks++;
            if(allLinks)
                System.out.println(url);
        }
    }
}
