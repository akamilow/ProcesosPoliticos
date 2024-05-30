/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ude.poo.procesospoliticos.modelo.crud;

import co.edu.ude.poo.procesospoliticos.modelo.crud.exceptions.NonexistentEntityException;
import co.edu.ude.poo.procesospoliticos.modelo.crud.exceptions.PreexistingEntityException;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.PartidoModel;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author camil
 */
public class PartidoModelJpaController implements Serializable {

    public PartidoModelJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PartidoModel partidoModel) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(partidoModel);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPartidoModel(partidoModel.getId()) != null) {
                throw new PreexistingEntityException("PartidoModel " + partidoModel + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PartidoModel partidoModel) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            partidoModel = em.merge(partidoModel);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = partidoModel.getId();
                if (findPartidoModel(id) == null) {
                    throw new NonexistentEntityException("The partidoModel with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PartidoModel partidoModel;
            try {
                partidoModel = em.getReference(PartidoModel.class, id);
                partidoModel.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The partidoModel with id " + id + " no longer exists.", enfe);
            }
            em.remove(partidoModel);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PartidoModel> findPartidoModelEntities() {
        return findPartidoModelEntities(true, -1, -1);
    }

    public List<PartidoModel> findPartidoModelEntities(int maxResults, int firstResult) {
        return findPartidoModelEntities(false, maxResults, firstResult);
    }

    private List<PartidoModel> findPartidoModelEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PartidoModel.class));
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

    public PartidoModel findPartidoModel(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PartidoModel.class, id);
        } finally {
            em.close();
        }
    }

    public int getPartidoModelCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PartidoModel> rt = cq.from(PartidoModel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
