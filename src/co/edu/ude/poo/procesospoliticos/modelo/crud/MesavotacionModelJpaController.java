/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ude.poo.procesospoliticos.modelo.crud;

import co.edu.ude.poo.procesospoliticos.modelo.crud.exceptions.NonexistentEntityException;
import co.edu.ude.poo.procesospoliticos.modelo.crud.exceptions.PreexistingEntityException;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.MesavotacionModel;
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
public class MesavotacionModelJpaController implements Serializable {

    public MesavotacionModelJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MesavotacionModel mesavotacionModel) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mesavotacionModel);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMesavotacionModel(mesavotacionModel.getNumero()) != null) {
                throw new PreexistingEntityException("MesavotacionModel " + mesavotacionModel + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MesavotacionModel mesavotacionModel) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mesavotacionModel = em.merge(mesavotacionModel);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = mesavotacionModel.getNumero();
                if (findMesavotacionModel(id) == null) {
                    throw new NonexistentEntityException("The mesavotacionModel with id " + id + " no longer exists.");
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
            MesavotacionModel mesavotacionModel;
            try {
                mesavotacionModel = em.getReference(MesavotacionModel.class, id);
                mesavotacionModel.getNumero();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mesavotacionModel with id " + id + " no longer exists.", enfe);
            }
            em.remove(mesavotacionModel);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MesavotacionModel> findMesavotacionModelEntities() {
        return findMesavotacionModelEntities(true, -1, -1);
    }

    public List<MesavotacionModel> findMesavotacionModelEntities(int maxResults, int firstResult) {
        return findMesavotacionModelEntities(false, maxResults, firstResult);
    }

    private List<MesavotacionModel> findMesavotacionModelEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MesavotacionModel.class));
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

    public MesavotacionModel findMesavotacionModel(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MesavotacionModel.class, id);
        } finally {
            em.close();
        }
    }

    public int getMesavotacionModelCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MesavotacionModel> rt = cq.from(MesavotacionModel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
