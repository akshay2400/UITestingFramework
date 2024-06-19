package utils;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/config.properties")
public interface TestConfig extends Config{
	
	@Key("BROWSER")
    String getBrowser();
	
	@Key("URL")
    String getUrl();
	
	@Key("SHEET")
	String getSheet();
    
    @Key("SEARCH_ITEM")
	String getItem();

    @Key("MESSAGE")
	String getMessage();

    @Key("PATH")
	String getPath();;
}
