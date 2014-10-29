package pro.util;
import java.util.*;

public class changeLocale {
	
	private Locale current;
	public void setCurrent(Locale cur)
	{
		this.current = cur;
	}
	
    public Map getLocales() {
        Map locales =new Hashtable(2);
        ResourceBundle bundle = ResourceBundle.getBundle("globalMessages" , current);
        //locales.put(bundle.getString("pro.en"), Locale.US);
        locales.put(bundle.getString("pro.cn"), Locale.CHINA);
        return locales;
    }
}

