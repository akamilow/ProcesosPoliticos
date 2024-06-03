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
import co.edu.ude.poo.procesospoliticos.modelo.entidades.CandidatoModel;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.CiudadanoModel;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.MesavotacionModel;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.VotoModel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author camil
 */
public class VotoModelJpaController implements Serializable {

    public VotoModelJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(VotoModel votoModel) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CandidatoModel candidato = votoModel.getCandidato();
            if (candidato != null) {
                candidato = em.getReference(candidato.getClass(), candidato.getDni());
                votoModel.setCandidato(candidato);
            }
            CiudadanoModel ciudadano = votoModel.getCiudadano();
            if (ciudadano != null) {
                ciudadano = em.getReference(ciudadano.getClass(), ciudadano.getDni());
                votoModel.setCiudadano(ciudadano);
            }
            MesavotacionModel mesa = votoModel.getMesa();
            if (mesa != null) {
                mesa = em.getReference(mesa.getClass(), mesa.getNumero());
                votoModel.setMesa(mesa);
            }
            em.persist(votoModel);
            if (candidato != null) {
                candidato.getVotoModelList().add(votoModel);
                candidato = em.merge(candidato);
            }
            if (ciudadano != null) {
                ciudadano.getVotoModelList().add(votoModel);
                ciudadano = em.merge(ciudadano);
            }
            if (mesa != null) {
                mesa.getVotoModelList().add(votoModel);
                mesa = em.merge(mesa);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVotoModel(votoModel.getId()) != null) {
                throw new PreexistingEntityException("VotoModel " + votoModel + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(VotoModel votoModel) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            VotoModel persistentVotoModel = em.find(VotoModel.class, votoModel.getId());
            CandidatoModel candidatoOld = persistentVotoModel.getCandidato();
            CandidatoModel candidatoNew = votoModel.getCandidato();
            CiudadanoModel ciudadanoOld = persistentVotoModel.getCiudadano();
            CiudadanoModel ciudadanoNew = votoModel.getCiudadano();
            MesavotacionModel mesaOld = persistentVotoModel.getMesa();
            MesavotacionModel mesaNew = votoModel.getMesa();
            if (candidatoNew != null) {
                candidatoNew = em.getReference(candidatoNew.getClass(), candidatoNew.getDni());
                votoModel.setCandidato(candidatoNew);
            }
            if (ciudadanoNew != null) {
                ciudadanoNew = em.getReference(ciudadanoNew.getClass(), ciudadanoNew.getDni());
                votoModel.setCiudadano(ciudadanoNew);
            }
            if (mesaNew != null) {
                mesaNew = em.getReference(mesaNew.getClass(), mesaNew.getNumero());
                votoModel.setMesa(mesaNew);
            }
            votoModel = em.merge(votoModel);
            if (candidatoOld != null && !candidatoOld.equals(candidatoNew)) {
                candidatoOld.getVotoModelList().remove(votoModel);
                candidatoOld = em.merge(candidatoOld);
            }
            if (candidatoNew != null && !candidatoNew.equals(candidatoOld)) {
                candidatoNew.getVotoModelList().add(votoModel);
                candidatoNew = em.merge(candidatoNew);
            }
            if (ciudadanoOld != null && !ciudadanoOld.equals(ciudadanoNew)) {
                ciudadanoOld.getVotoModelList().remove(votoModel);
                ciudadanoOld = em.merge(ciudadanoOld);
            }
            if (ciudadanoNew != null && !ciudadanoNew.equals(ciudadanoOld)) {
                ciudadanoNew.getVotoModelList().add(votoModel);
                ciudadanoNew = em.merge(ciudadanoNew);
            }
            if (mesaOld != null && !mesaOld.equals(mesaNew)) {
                mesaOld.getVotoModelList().remove(votoModel);
                mesaOld = em.merge(mesaOld);
            }
            if (mesaNew != null && !mesaNew.equals(mesaOld)) {
                mesaNew.getVotoModelList().add(votoModel);
                mesaNew = em.merge(mesaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = votoModel.getId();
                if (findVotoModel(id) == null) {
                    throw new NonexistentEntityException("The votoModel with id " + id + " no longer exists.");
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
            VotoModel votoModel;
            try {
                votoModel = em.getReference(VotoModel.class, id);
                votoModel.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The votoModel with id " + id + " no longer exists.", enfe);
            }
            CandidatoModel candidato = votoModel.getCandidato();
            if (candidato != null) {
                candidato.getVotoModelList().remove(votoModel);
                candidato = em.merge(candidato);
            }
            CiudadanoModel ciudadano = votoModel.getCiudadano();
            if (ciudadano != null) {
                ciudadano.getVotoModelList().remove(votoModel);
                ciudadano = em.merge(ciudadano);
            }
            MesavotacionModel mesa = votoModel.getMesa();
            if (mesa != null) {
                mesa.getVotoModelList().remove(votoModel);
                mesa = em.merge(mesa);
            }
            em.remove(votoModel);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<VotoModel> findVotoModelEntities() {
        return findVotoModelEntities(true, -1, -1);
    }

    public List<VotoModel> findVotoModelEntities(int maxResults, int firstResult) {
        return findVotoModelEntities(false, maxResults, firstResult);
    }

    private List<VotoModel> findVotoModelEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VotoModel.class));
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

    public VotoModel findVotoModel(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VotoModel.class, id);
        } finally {
            em.close();
        }
    }

    public int getVotoModelCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VotoModel> rt = cq.from(VotoModel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
