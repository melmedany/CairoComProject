/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import ejb.NewsEntity;
import ejb.NewsEntityFacadeLocal;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ferrycode
 */
@ManagedBean(name="MessageView")
@RequestScoped

public class MessageView {
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
}
