/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ude.poo.procesospoliticos.modelo.crud;

import co.edu.ude.poo.procesospoliticos.modelo.crud.exceptions.NonexistentEntityException;
import co.edu.ude.poo.procesospoliticos.modelo.crud.exceptions.PreexistingEntityException;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.ApoderadoModel;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.CiudadanoModel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author camil
 */
public class ApoderadoModelJpaController implements Serializable {

    public ApoderadoModelJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ApoderadoModel apoderadoModel) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CiudadanoModel ciudadanoModel = apoderadoModel.getCiudadanoModel();
            if (ciudadanoModel != null) {
                ciudadanoModel = em.getReference(ciudadanoModel.getClass(), ciudadanoModel.getDni());
                apoderadoModel.setCiudadanoModel(ciudadanoModel);
            }
            em.persist(apoderadoModel);
            if (ciudadanoModel != null) {
                ApoderadoModel oldApoderadoModelOfCiudadanoModel = ciudadanoModel.getApoderadoModel();
                if (oldApoderadoModelOfCiudadanoModel != null) {
                    oldApoderadoModelOfCiudadanoModel.setCiudadanoModel(null);
                    oldApoderadoModelOfCiudadanoModel = em.merge(oldApoderadoModelOfCiudadanoModel);
                }
                ciudadanoModel.setApoderadoModel(apoderadoModel);
                ciudadanoModel = em.merge(ciudadanoModel);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findApoderadoModel(apoderadoModel.getDni()) != null) {
                throw new PreexistingEntityException("ApoderadoModel " + apoderadoModel + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ApoderadoModel apoderadoModel) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ApoderadoModel persistentApoderadoModel = em.find(ApoderadoModel.class, apoderadoModel.getDni());
            CiudadanoModel ciudadanoModelOld = persistentApoderadoModel.getCiudadanoModel();
            CiudadanoModel ciudadanoModelNew = apoderadoModel.getCiudadanoModel();
            if (ciudadanoModelNew != null) {
                ciudadanoModelNew = em.getReference(ciudadanoModelNew.getClass(), ciudadanoModelNew.getDni());
                apoderadoModel.setCiudadanoModel(ciudadanoModelNew);
            }
            apoderadoModel = em.merge(apoderadoModel);
            if (ciudadanoModelOld != null && !ciudadanoModelOld.equals(ciudadanoModelNew)) {
                ciudadanoModelOld.setApoderadoModel(null);
                ciudadanoModelOld = em.merge(ciudadanoModelOld);
            }
            if (ciudadanoModelNew != null && !ciudadanoModelNew.equals(ciudadanoModelOld)) {
                ApoderadoModel oldApoderadoModelOfCiudadanoModel = ciudadanoModelNew.getApoderadoModel();
                if (oldApoderadoModelOfCiudadanoModel != null) {
                    oldApoderadoModelOfCiudadanoModel.setCiudadanoModel(null);
                    oldApoderadoModelOfCiudadanoModel = em.merge(oldApoderadoModelOfCiudadanoModel);
                }
                ciudadanoModelNew.setApoderadoModel(apoderadoModel);
                ciudadanoModelNew = em.merge(ciudadanoModelNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = apoderadoModel.getDni();
                if (findApoderadoModel(id) == null) {
                    throw new NonexistentEntityException("The apoderadoModel with id " + id + " no longer exists.");
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
            ApoderadoModel apoderadoModel;
            try {
                apoderadoModel = em.getReference(ApoderadoModel.class, id);
                apoderadoModel.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The apoderadoModel with id " + id + " no longer exists.", enfe);
            }
            CiudadanoModel ciudadanoModel = apoderadoModel.getCiudadanoModel();
            if (ciudadanoModel != null) {
                ciudadanoModel.setApoderadoModel(null);
                ciudadanoModel = em.merge(ciudadanoModel);
            }
            em.remove(apoderadoModel);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ApoderadoModel> findApoderadoModelEntities() {
        return findApoderadoModelEntities(true, -1, -1);
    }

    public List<ApoderadoModel> findApoderadoModelEntities(int maxResults, int firstResult) {
        return findApoderadoModelEntities(false, maxResults, firstResult);
    }

    private List<ApoderadoModel> findApoderadoModelEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ApoderadoModel.class));
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

    public ApoderadoModel findApoderadoModel(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ApoderadoModel.class, id);
        } finally {
            em.close();
        }
    }

    public int getApoderadoModelCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ApoderadoModel> rt = cq.from(ApoderadoModel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
