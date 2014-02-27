/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aromatel.erp.dao;

/**
 *
 * @author henriquevalcanaia
 */
import br.com.aromatel.erp.modelo.cadastros.EntityBase;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAOBase<Entity extends EntityBase> implements Serializable {

    private Class<Entity> entityClass;
    private EntityManager em;

    public DAOBase() {
        if (em == null) {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("ERPPU");
            if (factory == null) {
                factory = Persistence.createEntityManagerFactory("ERPPU");
            }
            em = factory.createEntityManager();
        }
    }

    @SuppressWarnings("unchecked")
    public DAOBase(EntityManager em) {
        this.em = em;

        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<Entity>) genericSuperclass.getActualTypeArguments()[0];
    }

    public Entity gravar(Entity e) {
        //if (e.existeNoBanco()) {
        System.out.println("Gravando uhuhu");
        em.merge(e);
        return e;

        /*
         } else {
         em.persist(e);
         return e;
         */
        //}
    }

    public void remove(Entity e) {
        em.remove(e);
    }

    public Entity findByPK(PK id) {
        return em.find(entityClass, id);
    }

    @SuppressWarnings("unchecked")
    public List<Entity> getAll() {
        Query query = getPersistenceContext().createQuery("SELECT o FROM " + entityClass.getName() + " o");
        return (List<Entity>) query.getResultList();
    }

    /**
     * @return referência do componente <code>EntityManager</code>.
     */
    protected EntityManager getPersistenceContext() {
        return this.em;
    }
}
