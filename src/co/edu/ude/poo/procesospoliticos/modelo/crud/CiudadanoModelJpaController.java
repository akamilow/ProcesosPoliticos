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
import co.edu.ude.poo.procesospoliticos.modelo.entidades.VocalmesaModel;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.ApoderadoModel;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.CandidatoModel;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.CiudadanoModel;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.VotoModel;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author camil
 */
public class CiudadanoModelJpaController implements Serializable {

    public CiudadanoModelJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CiudadanoModel ciudadanoModel) throws PreexistingEntityException, Exception {
        if (ciudadanoModel.getVotoModelList() == null) {
            ciudadanoModel.setVotoModelList(new ArrayList<VotoModel>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            VocalmesaModel vocalmesaModel = ciudadanoModel.getVocalmesaModel();
            if (vocalmesaModel != null) {
                vocalmesaModel = em.getReference(vocalmesaModel.getClass(), vocalmesaModel.getDni());
                ciudadanoModel.setVocalmesaModel(vocalmesaModel);
            }
            ApoderadoModel apoderadoModel = ciudadanoModel.getApoderadoModel();
            if (apoderadoModel != null) {
                apoderadoModel = em.getReference(apoderadoModel.getClass(), apoderadoModel.getDni());
                ciudadanoModel.setApoderadoModel(apoderadoModel);
            }
            CandidatoModel candidatoModel = ciudadanoModel.getCandidatoModel();
            if (candidatoModel != null) {
                candidatoModel = em.getReference(candidatoModel.getClass(), candidatoModel.getDni());
                ciudadanoModel.setCandidatoModel(candidatoModel);
            }
            List<VotoModel> attachedVotoModelList = new ArrayList<VotoModel>();
            for (VotoModel votoModelListVotoModelToAttach : ciudadanoModel.getVotoModelList()) {
                votoModelListVotoModelToAttach = em.getReference(votoModelListVotoModelToAttach.getClass(), votoModelListVotoModelToAttach.getId());
                attachedVotoModelList.add(votoModelListVotoModelToAttach);
            }
            ciudadanoModel.setVotoModelList(attachedVotoModelList);
            em.persist(ciudadanoModel);
            if (vocalmesaModel != null) {
                CiudadanoModel oldCiudadanoModelOfVocalmesaModel = vocalmesaModel.getCiudadanoModel();
                if (oldCiudadanoModelOfVocalmesaModel != null) {
                    oldCiudadanoModelOfVocalmesaModel.setVocalmesaModel(null);
                    oldCiudadanoModelOfVocalmesaModel = em.merge(oldCiudadanoModelOfVocalmesaModel);
                }
                vocalmesaModel.setCiudadanoModel(ciudadanoModel);
                vocalmesaModel = em.merge(vocalmesaModel);
            }
            if (apoderadoModel != null) {
                CiudadanoModel oldCiudadanoModelOfApoderadoModel = apoderadoModel.getCiudadanoModel();
                if (oldCiudadanoModelOfApoderadoModel != null) {
                    oldCiudadanoModelOfApoderadoModel.setApoderadoModel(null);
                    oldCiudadanoModelOfApoderadoModel = em.merge(oldCiudadanoModelOfApoderadoModel);
                }
                apoderadoModel.setCiudadanoModel(ciudadanoModel);
                apoderadoModel = em.merge(apoderadoModel);
            }
            if (candidatoModel != null) {
                CiudadanoModel oldCiudadanoModelOfCandidatoModel = candidatoModel.getCiudadanoModel();
                if (oldCiudadanoModelOfCandidatoModel != null) {
                    oldCiudadanoModelOfCandidatoModel.setCandidatoModel(null);
                    oldCiudadanoModelOfCandidatoModel = em.merge(oldCiudadanoModelOfCandidatoModel);
                }
                candidatoModel.setCiudadanoModel(ciudadanoModel);
                candidatoModel = em.merge(candidatoModel);
            }
            for (VotoModel votoModelListVotoModel : ciudadanoModel.getVotoModelList()) {
                CiudadanoModel oldCiudadanoOfVotoModelListVotoModel = votoModelListVotoModel.getCiudadano();
                votoModelListVotoModel.setCiudadano(ciudadanoModel);
                votoModelListVotoModel = em.merge(votoModelListVotoModel);
                if (oldCiudadanoOfVotoModelListVotoModel != null) {
                    oldCiudadanoOfVotoModelListVotoModel.getVotoModelList().remove(votoModelListVotoModel);
                    oldCiudadanoOfVotoModelListVotoModel = em.merge(oldCiudadanoOfVotoModelListVotoModel);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCiudadanoModel(ciudadanoModel.getDni()) != null) {
                throw new PreexistingEntityException("CiudadanoModel " + ciudadanoModel + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CiudadanoModel ciudadanoModel) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CiudadanoModel persistentCiudadanoModel = em.find(CiudadanoModel.class, ciudadanoModel.getDni());
            VocalmesaModel vocalmesaModelOld = persistentCiudadanoModel.getVocalmesaModel();
            VocalmesaModel vocalmesaModelNew = ciudadanoModel.getVocalmesaModel();
            ApoderadoModel apoderadoModelOld = persistentCiudadanoModel.getApoderadoModel();
            ApoderadoModel apoderadoModelNew = ciudadanoModel.getApoderadoModel();
            CandidatoModel candidatoModelOld = persistentCiudadanoModel.getCandidatoModel();
            CandidatoModel candidatoModelNew = ciudadanoModel.getCandidatoModel();
            List<VotoModel> votoModelListOld = persistentCiudadanoModel.getVotoModelList();
            List<VotoModel> votoModelListNew = ciudadanoModel.getVotoModelList();
            if (vocalmesaModelNew != null) {
                vocalmesaModelNew = em.getReference(vocalmesaModelNew.getClass(), vocalmesaModelNew.getDni());
                ciudadanoModel.setVocalmesaModel(vocalmesaModelNew);
            }
            if (apoderadoModelNew != null) {
                apoderadoModelNew = em.getReference(apoderadoModelNew.getClass(), apoderadoModelNew.getDni());
                ciudadanoModel.setApoderadoModel(apoderadoModelNew);
            }
            if (candidatoModelNew != null) {
                candidatoModelNew = em.getReference(candidatoModelNew.getClass(), candidatoModelNew.getDni());
                ciudadanoModel.setCandidatoModel(candidatoModelNew);
            }
            List<VotoModel> attachedVotoModelListNew = new ArrayList<VotoModel>();
            for (VotoModel votoModelListNewVotoModelToAttach : votoModelListNew) {
                votoModelListNewVotoModelToAttach = em.getReference(votoModelListNewVotoModelToAttach.getClass(), votoModelListNewVotoModelToAttach.getId());
                attachedVotoModelListNew.add(votoModelListNewVotoModelToAttach);
            }
            votoModelListNew = attachedVotoModelListNew;
            ciudadanoModel.setVotoModelList(votoModelListNew);
            ciudadanoModel = em.merge(ciudadanoModel);
            if (vocalmesaModelOld != null && !vocalmesaModelOld.equals(vocalmesaModelNew)) {
                vocalmesaModelOld.setCiudadanoModel(null);
                vocalmesaModelOld = em.merge(vocalmesaModelOld);
            }
            if (vocalmesaModelNew != null && !vocalmesaModelNew.equals(vocalmesaModelOld)) {
                CiudadanoModel oldCiudadanoModelOfVocalmesaModel = vocalmesaModelNew.getCiudadanoModel();
                if (oldCiudadanoModelOfVocalmesaModel != null) {
                    oldCiudadanoModelOfVocalmesaModel.setVocalmesaModel(null);
                    oldCiudadanoModelOfVocalmesaModel = em.merge(oldCiudadanoModelOfVocalmesaModel);
                }
                vocalmesaModelNew.setCiudadanoModel(ciudadanoModel);
                vocalmesaModelNew = em.merge(vocalmesaModelNew);
            }
            if (apoderadoModelOld != null && !apoderadoModelOld.equals(apoderadoModelNew)) {
                apoderadoModelOld.setCiudadanoModel(null);
                apoderadoModelOld = em.merge(apoderadoModelOld);
            }
            if (apoderadoModelNew != null && !apoderadoModelNew.equals(apoderadoModelOld)) {
                CiudadanoModel oldCiudadanoModelOfApoderadoModel = apoderadoModelNew.getCiudadanoModel();
                if (oldCiudadanoModelOfApoderadoModel != null) {
                    oldCiudadanoModelOfApoderadoModel.setApoderadoModel(null);
                    oldCiudadanoModelOfApoderadoModel = em.merge(oldCiudadanoModelOfApoderadoModel);
                }
                apoderadoModelNew.setCiudadanoModel(ciudadanoModel);
                apoderadoModelNew = em.merge(apoderadoModelNew);
            }
            if (candidatoModelOld != null && !candidatoModelOld.equals(candidatoModelNew)) {
                candidatoModelOld.setCiudadanoModel(null);
                candidatoModelOld = em.merge(candidatoModelOld);
            }
            if (candidatoModelNew != null && !candidatoModelNew.equals(candidatoModelOld)) {
                CiudadanoModel oldCiudadanoModelOfCandidatoModel = candidatoModelNew.getCiudadanoModel();
                if (oldCiudadanoModelOfCandidatoModel != null) {
                    oldCiudadanoModelOfCandidatoModel.setCandidatoModel(null);
                    oldCiudadanoModelOfCandidatoModel = em.merge(oldCiudadanoModelOfCandidatoModel);
                }
                candidatoModelNew.setCiudadanoModel(ciudadanoModel);
                candidatoModelNew = em.merge(candidatoModelNew);
            }
            for (VotoModel votoModelListOldVotoModel : votoModelListOld) {
                if (!votoModelListNew.contains(votoModelListOldVotoModel)) {
                    votoModelListOldVotoModel.setCiudadano(null);
                    votoModelListOldVotoModel = em.merge(votoModelListOldVotoModel);
                }
            }
            for (VotoModel votoModelListNewVotoModel : votoModelListNew) {
                if (!votoModelListOld.contains(votoModelListNewVotoModel)) {
                    CiudadanoModel oldCiudadanoOfVotoModelListNewVotoModel = votoModelListNewVotoModel.getCiudadano();
                    votoModelListNewVotoModel.setCiudadano(ciudadanoModel);
                    votoModelListNewVotoModel = em.merge(votoModelListNewVotoModel);
                    if (oldCiudadanoOfVotoModelListNewVotoModel != null && !oldCiudadanoOfVotoModelListNewVotoModel.equals(ciudadanoModel)) {
                        oldCiudadanoOfVotoModelListNewVotoModel.getVotoModelList().remove(votoModelListNewVotoModel);
                        oldCiudadanoOfVotoModelListNewVotoModel = em.merge(oldCiudadanoOfVotoModelListNewVotoModel);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ciudadanoModel.getDni();
                if (findCiudadanoModel(id) == null) {
                    throw new NonexistentEntityException("The ciudadanoModel with id " + id + " no longer exists.");
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
            CiudadanoModel ciudadanoModel;
            try {
                ciudadanoModel = em.getReference(CiudadanoModel.class, id);
                ciudadanoModel.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ciudadanoModel with id " + id + " no longer exists.", enfe);
            }
            VocalmesaModel vocalmesaModel = ciudadanoModel.getVocalmesaModel();
            if (vocalmesaModel != null) {
                vocalmesaModel.setCiudadanoModel(null);
                vocalmesaModel = em.merge(vocalmesaModel);
            }
            ApoderadoModel apoderadoModel = ciudadanoModel.getApoderadoModel();
            if (apoderadoModel != null) {
                apoderadoModel.setCiudadanoModel(null);
                apoderadoModel = em.merge(apoderadoModel);
            }
            CandidatoModel candidatoModel = ciudadanoModel.getCandidatoModel();
            if (candidatoModel != null) {
                candidatoModel.setCiudadanoModel(null);
                candidatoModel = em.merge(candidatoModel);
            }
            List<VotoModel> votoModelList = ciudadanoModel.getVotoModelList();
            for (VotoModel votoModelListVotoModel : votoModelList) {
                votoModelListVotoModel.setCiudadano(null);
                votoModelListVotoModel = em.merge(votoModelListVotoModel);
            }
            em.remove(ciudadanoModel);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CiudadanoModel> findCiudadanoModelEntities() {
        return findCiudadanoModelEntities(true, -1, -1);
    }

    public List<CiudadanoModel> findCiudadanoModelEntities(int maxResults, int firstResult) {
        return findCiudadanoModelEntities(false, maxResults, firstResult);
    }

    private List<CiudadanoModel> findCiudadanoModelEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CiudadanoModel.class));
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

    public CiudadanoModel findCiudadanoModel(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CiudadanoModel.class, id);
        } finally {
            em.close();
        }
    }

    public int getCiudadanoModelCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CiudadanoModel> rt = cq.from(CiudadanoModel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
