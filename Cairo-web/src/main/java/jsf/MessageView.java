/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import ejb.NewsEntity;
import ejb.NewsEntityFacadeLocal;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author ferrycode
 */
@ManagedBean(name="MessageView")
@RequestScoped

public class MessageView implements Serializable{
    @EJB
    private NewsEntityFacadeLocal newsEntityFacade;
    private NewsEntity NewsEntity;

    /**
     * Creates a new instance of MessageView
     */
    public MessageView() {
         this.NewsEntity =new NewsEntity();
    }
    
     public NewsEntity getMessage() {
        return NewsEntity;
    }
     
     public int getNumberOfMessages() {
        return newsEntityFacade.findAll().size();
    }
     
     public String postMessage() {
        this.newsEntityFacade.create(NewsEntity);
        return "theendTemplate";
    }
     
     
     
     private static final long serialVersionUID = 1L;
	
	private String localeCode;
	
	private static Map<String,Object> countries;
	static{
		countries = new LinkedHashMap<String,Object>();
		countries.put("English", Locale.ENGLISH); //label, value
		countries.put("عربي",new Locale("ar","EG"));
                //countries.put("french", new Locale("ar"));
	}

	public Map<String, Object> getCountriesInMap() {
		return countries;
	}

	
	public String getLocaleCode() {
		return localeCode;
	}


	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}


	public void countryLocaleCodeChanged(ValueChangeEvent e){
		
		String newLocaleValue = e.getNewValue().toString();
		
		//loop a map to compare the locale code
        for (Map.Entry<String, Object> entry : countries.entrySet()) {
        
        	if(entry.getValue().toString().equals(newLocaleValue)){
        		
        		FacesContext.getCurrentInstance()
        			.getViewRoot().setLocale((Locale)entry.getValue());
        		
        	}
        }

	}
}
