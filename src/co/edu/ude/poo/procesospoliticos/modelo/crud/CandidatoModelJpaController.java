/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ude.poo.procesospoliticos.modelo.crud;

import co.edu.ude.poo.procesospoliticos.modelo.crud.exceptions.NonexistentEntityException;
import co.edu.ude.poo.procesospoliticos.modelo.crud.exceptions.PreexistingEntityException;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.CandidatoModel;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.CiudadanoModel;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.ComunaModel;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.PartidoModel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author camil
 */
public class CandidatoModelJpaController implements Serializable {

    public CandidatoModelJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CandidatoModel candidatoModel) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CiudadanoModel ciudadanoModel = candidatoModel.getCiudadanoModel();
            if (ciudadanoModel != null) {
                ciudadanoModel = em.getReference(ciudadanoModel.getClass(), ciudadanoModel.getDni());
                candidatoModel.setCiudadanoModel(ciudadanoModel);
            }
            ComunaModel comuna = candidatoModel.getComuna();
            if (comuna != null) {
                comuna = em.getReference(comuna.getClass(), comuna.getId());
                candidatoModel.setComuna(comuna);
            }
            PartidoModel partido = candidatoModel.getPartido();
            if (partido != null) {
                partido = em.getReference(partido.getClass(), partido.getId());
                candidatoModel.setPartido(partido);
            }
            em.persist(candidatoModel);
            if (ciudadanoModel != null) {
                CandidatoModel oldCandidatoModelOfCiudadanoModel = ciudadanoModel.getCandidatoModel();
                if (oldCandidatoModelOfCiudadanoModel != null) {
                    oldCandidatoModelOfCiudadanoModel.setCiudadanoModel(null);
                    oldCandidatoModelOfCiudadanoModel = em.merge(oldCandidatoModelOfCiudadanoModel);
                }
                ciudadanoModel.setCandidatoModel(candidatoModel);
                ciudadanoModel = em.merge(ciudadanoModel);
            }
            if (comuna != null) {
                comuna.getCandidatoModelList().add(candidatoModel);
                comuna = em.merge(comuna);
            }
            if (partido != null) {
                partido.getCandidatoModelList().add(candidatoModel);
                partido = em.merge(partido);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCandidatoModel(candidatoModel.getDni()) != null) {
                throw new PreexistingEntityException("CandidatoModel " + candidatoModel + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CandidatoModel candidatoModel) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CandidatoModel persistentCandidatoModel = em.find(CandidatoModel.class, candidatoModel.getDni());
            CiudadanoModel ciudadanoModelOld = persistentCandidatoModel.getCiudadanoModel();
            CiudadanoModel ciudadanoModelNew = candidatoModel.getCiudadanoModel();
            ComunaModel comunaOld = persistentCandidatoModel.getComuna();
            ComunaModel comunaNew = candidatoModel.getComuna();
            PartidoModel partidoOld = persistentCandidatoModel.getPartido();
            PartidoModel partidoNew = candidatoModel.getPartido();
            if (ciudadanoModelNew != null) {
                ciudadanoModelNew = em.getReference(ciudadanoModelNew.getClass(), ciudadanoModelNew.getDni());
                candidatoModel.setCiudadanoModel(ciudadanoModelNew);
            }
            if (comunaNew != null) {
                comunaNew = em.getReference(comunaNew.getClass(), comunaNew.getId());
                candidatoModel.setComuna(comunaNew);
            }
            if (partidoNew != null) {
                partidoNew = em.getReference(partidoNew.getClass(), partidoNew.getId());
                candidatoModel.setPartido(partidoNew);
            }
            candidatoModel = em.merge(candidatoModel);
            if (ciudadanoModelOld != null && !ciudadanoModelOld.equals(ciudadanoModelNew)) {
                ciudadanoModelOld.setCandidatoModel(null);
                ciudadanoModelOld = em.merge(ciudadanoModelOld);
            }
            if (ciudadanoModelNew != null && !ciudadanoModelNew.equals(ciudadanoModelOld)) {
                CandidatoModel oldCandidatoModelOfCiudadanoModel = ciudadanoModelNew.getCandidatoModel();
                if (oldCandidatoModelOfCiudadanoModel != null) {
                    oldCandidatoModelOfCiudadanoModel.setCiudadanoModel(null);
                    oldCandidatoModelOfCiudadanoModel = em.merge(oldCandidatoModelOfCiudadanoModel);
                }
                ciudadanoModelNew.setCandidatoModel(candidatoModel);
                ciudadanoModelNew = em.merge(ciudadanoModelNew);
            }
            if (comunaOld != null && !comunaOld.equals(comunaNew)) {
                comunaOld.getCandidatoModelList().remove(candidatoModel);
                comunaOld = em.merge(comunaOld);
            }
            if (comunaNew != null && !comunaNew.equals(comunaOld)) {
                comunaNew.getCandidatoModelList().add(candidatoModel);
                comunaNew = em.merge(comunaNew);
            }
            if (partidoOld != null && !partidoOld.equals(partidoNew)) {
                partidoOld.getCandidatoModelList().remove(candidatoModel);
                partidoOld = em.merge(partidoOld);
            }
            if (partidoNew != null && !partidoNew.equals(partidoOld)) {
                partidoNew.getCandidatoModelList().add(candidatoModel);
                partidoNew = em.merge(partidoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = candidatoModel.getDni();
                if (findCandidatoModel(id) == null) {
                    throw new NonexistentEntityException("The candidatoModel with id " + id + " no longer exists.");
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
            CandidatoModel candidatoModel;
            try {
                candidatoModel = em.getReference(CandidatoModel.class, id);
                candidatoModel.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The candidatoModel with id " + id + " no longer exists.", enfe);
            }
            CiudadanoModel ciudadanoModel = candidatoModel.getCiudadanoModel();
            if (ciudadanoModel != null) {
                ciudadanoModel.setCandidatoModel(null);
                ciudadanoModel = em.merge(ciudadanoModel);
            }
            ComunaModel comuna = candidatoModel.getComuna();
            if (comuna != null) {
                comuna.getCandidatoModelList().remove(candidatoModel);
                comuna = em.merge(comuna);
            }
            PartidoModel partido = candidatoModel.getPartido();
            if (partido != null) {
                partido.getCandidatoModelList().remove(candidatoModel);
                partido = em.merge(partido);
            }
            em.remove(candidatoModel);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CandidatoModel> findCandidatoModelEntities() {
        return findCandidatoModelEntities(true, -1, -1);
    }

    public List<CandidatoModel> findCandidatoModelEntities(int maxResults, int firstResult) {
        return findCandidatoModelEntities(false, maxResults, firstResult);
    }

    private List<CandidatoModel> findCandidatoModelEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CandidatoModel.class));
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

    public CandidatoModel findCandidatoModel(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CandidatoModel.class, id);
        } finally {
            em.close();
        }
    }

    public int getCandidatoModelCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CandidatoModel> rt = cq.from(CandidatoModel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
