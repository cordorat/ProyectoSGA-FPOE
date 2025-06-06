/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uvpalmira.fpoe.persistence.jpa.dao;

import co.edu.uvpalmira.fpoe.persistence.jpa.exceptions.NonexistentEntityException;
import co.edu.uvpalmira.fpoe.persistence.jpa.entity.AbstractEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.io.Serializable;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 *
 * @author Antonio J. Vélez Q.
 * @param <T> Entidad que hereda de co.avsoft.persistence.entity.AbstractEntity
 */
public abstract class AbstractDAO<T extends AbstractEntity> implements Serializable {

    private final Class<T> entityClass;

    protected EntityManagerFactory emf = null;

    public AbstractDAO(Class<T> entityClass, EntityManagerFactory emf) {
        this.entityClass = entityClass;
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(T entity) throws SQLIntegrityConstraintViolationException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(T entity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            entity = em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = entity.getId();
                if (find(id) == null) {
                    throw new NonexistentEntityException("The waste with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException
    {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            T entity;
//            try {
//                entity = em.getReference(T.class, id);
//                entity.getCode();
//            } catch (EntityNotFoundException enfe) {
//                throw new NonexistentEntityException("The waste with id " + id + " no longer exists.", enfe);
//            }
//            em.remove(entity);
//            em.getTransaction().commit();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
    }

    public List<T> findEntities() {
        return findEntities(true, -1, -1, null);
    }

    public List<T> findEntities(String orderBy) {
        return findEntities(true, -1, -1, orderBy);
    }

    public List<T> findEntities(int maxResults, int firstResult) {
        return findEntities(false, maxResults, firstResult, null);
    }

    public List<T> findEntities(int maxResults, int firstResult, String orderedBy) {
        return findEntities(false, maxResults, firstResult, orderedBy);
    }

    @SuppressWarnings("unchecked")
    private List<T> findEntities(boolean all, int maxResults, int firstResult, String orderedBy) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            
            Root<T> root = cq.from(entityClass); // +
//            cq.select(cq.from(entityClass));
            cq.select(root);
            if (orderedBy != null) { // +
                cq.orderBy(em.getCriteriaBuilder().asc(root.get(orderedBy)));
            }
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public T find(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(entityClass, id);
        } finally {
            em.close();
        }
    }

    @SuppressWarnings("unchecked")
    public int count() {
        EntityManager em = getEntityManager();
        try {
//            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
//            Root<T> rt = cq.from(entityClass);
//            cq.select(em.getCriteriaBuilder().count(rt));
//            Query q = em.createQuery(cq);
//            return ((Long) q.getSingleResult()).intValue();
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<T> rt = cq.from(entityClass);
            cq.select(em.getCriteriaBuilder().count(rt));
            @SuppressWarnings("unchecked")
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public void save(T entity) throws SQLIntegrityConstraintViolationException, Exception {

        if (entity.getId() == null || entity.getId() == 0) {
            this.create(entity);
        } else {
            this.edit(entity);
        }
    }

}
