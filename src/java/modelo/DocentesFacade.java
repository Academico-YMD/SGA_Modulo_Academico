/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.Docentes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Yaritza
 */
@Stateless
public class DocentesFacade extends AbstractFacade<Docentes> {

    @PersistenceContext(unitName = "SGAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocentesFacade() {
        super(Docentes.class);
    }
    
}
