/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ude.poo.procesospoliticos.modelo.crud;

import co.edu.ude.poo.procesospoliticos.modelo.crud.exceptions.NonexistentEntityException;
import co.edu.ude.poo.procesospoliticos.modelo.crud.exceptions.PreexistingEntityException;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.UsuarioModel;
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
public class UsuarioModelJpaController implements Serializable {

    public UsuarioModelJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UsuarioModel usuarioModel) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuarioModel);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsuarioModel(usuarioModel.getDni()) != null) {
                throw new PreexistingEntityException("UsuarioModel " + usuarioModel + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UsuarioModel usuarioModel) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            usuarioModel = em.merge(usuarioModel);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuarioModel.getDni();
                if (findUsuarioModel(id) == null) {
                    throw new NonexistentEntityException("The usuarioModel with id " + id + " no longer exists.");
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
            UsuarioModel usuarioModel;
            try {
                usuarioModel = em.getReference(UsuarioModel.class, id);
                usuarioModel.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuarioModel with id " + id + " no longer exists.", enfe);
            }
            em.remove(usuarioModel);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UsuarioModel> findUsuarioModelEntities() {
        return findUsuarioModelEntities(true, -1, -1);
    }

    public List<UsuarioModel> findUsuarioModelEntities(int maxResults, int firstResult) {
        return findUsuarioModelEntities(false, maxResults, firstResult);
    }

    private List<UsuarioModel> findUsuarioModelEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UsuarioModel.class));
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

    public UsuarioModel findUsuarioModel(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UsuarioModel.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioModelCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UsuarioModel> rt = cq.from(UsuarioModel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
