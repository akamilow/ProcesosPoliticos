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
import co.edu.ude.poo.procesospoliticos.modelo.entidades.CiudadanoModel;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.VocalmesaModel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author camil
 */
public class VocalmesaModelJpaController implements Serializable {

    public VocalmesaModelJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(VocalmesaModel vocalmesaModel) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CiudadanoModel ciudadanoModel = vocalmesaModel.getCiudadanoModel();
            if (ciudadanoModel != null) {
                ciudadanoModel = em.getReference(ciudadanoModel.getClass(), ciudadanoModel.getDni());
                vocalmesaModel.setCiudadanoModel(ciudadanoModel);
            }
            em.persist(vocalmesaModel);
            if (ciudadanoModel != null) {
                VocalmesaModel oldVocalmesaModelOfCiudadanoModel = ciudadanoModel.getVocalmesaModel();
                if (oldVocalmesaModelOfCiudadanoModel != null) {
                    oldVocalmesaModelOfCiudadanoModel.setCiudadanoModel(null);
                    oldVocalmesaModelOfCiudadanoModel = em.merge(oldVocalmesaModelOfCiudadanoModel);
                }
                ciudadanoModel.setVocalmesaModel(vocalmesaModel);
                ciudadanoModel = em.merge(ciudadanoModel);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVocalmesaModel(vocalmesaModel.getDni()) != null) {
                throw new PreexistingEntityException("VocalmesaModel " + vocalmesaModel + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(VocalmesaModel vocalmesaModel) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            VocalmesaModel persistentVocalmesaModel = em.find(VocalmesaModel.class, vocalmesaModel.getDni());
            CiudadanoModel ciudadanoModelOld = persistentVocalmesaModel.getCiudadanoModel();
            CiudadanoModel ciudadanoModelNew = vocalmesaModel.getCiudadanoModel();
            if (ciudadanoModelNew != null) {
                ciudadanoModelNew = em.getReference(ciudadanoModelNew.getClass(), ciudadanoModelNew.getDni());
                vocalmesaModel.setCiudadanoModel(ciudadanoModelNew);
            }
            vocalmesaModel = em.merge(vocalmesaModel);
            if (ciudadanoModelOld != null && !ciudadanoModelOld.equals(ciudadanoModelNew)) {
                ciudadanoModelOld.setVocalmesaModel(null);
                ciudadanoModelOld = em.merge(ciudadanoModelOld);
            }
            if (ciudadanoModelNew != null && !ciudadanoModelNew.equals(ciudadanoModelOld)) {
                VocalmesaModel oldVocalmesaModelOfCiudadanoModel = ciudadanoModelNew.getVocalmesaModel();
                if (oldVocalmesaModelOfCiudadanoModel != null) {
                    oldVocalmesaModelOfCiudadanoModel.setCiudadanoModel(null);
                    oldVocalmesaModelOfCiudadanoModel = em.merge(oldVocalmesaModelOfCiudadanoModel);
                }
                ciudadanoModelNew.setVocalmesaModel(vocalmesaModel);
                ciudadanoModelNew = em.merge(ciudadanoModelNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = vocalmesaModel.getDni();
                if (findVocalmesaModel(id) == null) {
                    throw new NonexistentEntityException("The vocalmesaModel with id " + id + " no longer exists.");
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
            VocalmesaModel vocalmesaModel;
            try {
                vocalmesaModel = em.getReference(VocalmesaModel.class, id);
                vocalmesaModel.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vocalmesaModel with id " + id + " no longer exists.", enfe);
            }
            CiudadanoModel ciudadanoModel = vocalmesaModel.getCiudadanoModel();
            if (ciudadanoModel != null) {
                ciudadanoModel.setVocalmesaModel(null);
                ciudadanoModel = em.merge(ciudadanoModel);
            }
            em.remove(vocalmesaModel);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<VocalmesaModel> findVocalmesaModelEntities() {
        return findVocalmesaModelEntities(true, -1, -1);
    }

    public List<VocalmesaModel> findVocalmesaModelEntities(int maxResults, int firstResult) {
        return findVocalmesaModelEntities(false, maxResults, firstResult);
    }

    private List<VocalmesaModel> findVocalmesaModelEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VocalmesaModel.class));
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

    public VocalmesaModel findVocalmesaModel(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VocalmesaModel.class, id);
        } finally {
            em.close();
        }
    }

    public int getVocalmesaModelCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VocalmesaModel> rt = cq.from(VocalmesaModel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
