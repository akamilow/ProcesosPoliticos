/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ude.poo.procesospoliticos.modelo.crud;

import co.edu.ude.poo.procesospoliticos.modelo.crud.exceptions.NonexistentEntityException;
import co.edu.ude.poo.procesospoliticos.modelo.crud.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.ComunaModel;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.LocalvotacionModel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author camil
 */
public class LocalvotacionModelJpaController implements Serializable {

    public LocalvotacionModelJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(LocalvotacionModel localvotacionModel) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ComunaModel comuna = localvotacionModel.getComuna();
            if (comuna != null) {
                comuna = em.getReference(comuna.getClass(), comuna.getId());
                localvotacionModel.setComuna(comuna);
            }
            em.persist(localvotacionModel);
            if (comuna != null) {
                comuna.getLocalvotacionModelList().add(localvotacionModel);
                comuna = em.merge(comuna);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLocalvotacionModel(localvotacionModel.getId()) != null) {
                throw new PreexistingEntityException("LocalvotacionModel " + localvotacionModel + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(LocalvotacionModel localvotacionModel) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LocalvotacionModel persistentLocalvotacionModel = em.find(LocalvotacionModel.class, localvotacionModel.getId());
            ComunaModel comunaOld = persistentLocalvotacionModel.getComuna();
            ComunaModel comunaNew = localvotacionModel.getComuna();
            if (comunaNew != null) {
                comunaNew = em.getReference(comunaNew.getClass(), comunaNew.getId());
                localvotacionModel.setComuna(comunaNew);
            }
            localvotacionModel = em.merge(localvotacionModel);
            if (comunaOld != null && !comunaOld.equals(comunaNew)) {
                comunaOld.getLocalvotacionModelList().remove(localvotacionModel);
                comunaOld = em.merge(comunaOld);
            }
            if (comunaNew != null && !comunaNew.equals(comunaOld)) {
                comunaNew.getLocalvotacionModelList().add(localvotacionModel);
                comunaNew = em.merge(comunaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = localvotacionModel.getId();
                if (findLocalvotacionModel(id) == null) {
                    throw new NonexistentEntityException("The localvotacionModel with id " + id + " no longer exists.");
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
            LocalvotacionModel localvotacionModel;
            try {
                localvotacionModel = em.getReference(LocalvotacionModel.class, id);
                localvotacionModel.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The localvotacionModel with id " + id + " no longer exists.", enfe);
            }
            ComunaModel comuna = localvotacionModel.getComuna();
            if (comuna != null) {
                comuna.getLocalvotacionModelList().remove(localvotacionModel);
                comuna = em.merge(comuna);
            }
            em.remove(localvotacionModel);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<LocalvotacionModel> findLocalvotacionModelEntities() {
        return findLocalvotacionModelEntities(true, -1, -1);
    }

    public List<LocalvotacionModel> findLocalvotacionModelEntities(int maxResults, int firstResult) {
        return findLocalvotacionModelEntities(false, maxResults, firstResult);
    }

    private List<LocalvotacionModel> findLocalvotacionModelEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(LocalvotacionModel.class));
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

    public LocalvotacionModel findLocalvotacionModel(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(LocalvotacionModel.class, id);
        } finally {
            em.close();
        }
    }

    public int getLocalvotacionModelCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<LocalvotacionModel> rt = cq.from(LocalvotacionModel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
