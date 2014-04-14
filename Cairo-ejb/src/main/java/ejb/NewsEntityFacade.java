/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ferrycode
 */
@Stateless
public class NewsEntityFacade extends AbstractFacade<NewsEntity> implements NewsEntityFacadeLocal {
    @PersistenceContext(unitName = "com.ferrycode_Cairo-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NewsEntityFacade() {
        super(NewsEntity.class);
    }
    
}
