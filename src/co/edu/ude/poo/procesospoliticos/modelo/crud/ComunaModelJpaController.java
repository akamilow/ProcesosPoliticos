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
import co.edu.ude.poo.procesospoliticos.modelo.entidades.LocalvotacionModel;
import java.util.ArrayList;
import java.util.List;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.CandidatoModel;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.ComunaModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author camil
 */
public class ComunaModelJpaController implements Serializable {

    public ComunaModelJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ComunaModel comunaModel) throws PreexistingEntityException, Exception {
        if (comunaModel.getLocalvotacionModelList() == null) {
            comunaModel.setLocalvotacionModelList(new ArrayList<LocalvotacionModel>());
        }
        if (comunaModel.getCandidatoModelList() == null) {
            comunaModel.setCandidatoModelList(new ArrayList<CandidatoModel>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<LocalvotacionModel> attachedLocalvotacionModelList = new ArrayList<LocalvotacionModel>();
            for (LocalvotacionModel localvotacionModelListLocalvotacionModelToAttach : comunaModel.getLocalvotacionModelList()) {
                localvotacionModelListLocalvotacionModelToAttach = em.getReference(localvotacionModelListLocalvotacionModelToAttach.getClass(), localvotacionModelListLocalvotacionModelToAttach.getId());
                attachedLocalvotacionModelList.add(localvotacionModelListLocalvotacionModelToAttach);
            }
            comunaModel.setLocalvotacionModelList(attachedLocalvotacionModelList);
            List<CandidatoModel> attachedCandidatoModelList = new ArrayList<CandidatoModel>();
            for (CandidatoModel candidatoModelListCandidatoModelToAttach : comunaModel.getCandidatoModelList()) {
                candidatoModelListCandidatoModelToAttach = em.getReference(candidatoModelListCandidatoModelToAttach.getClass(), candidatoModelListCandidatoModelToAttach.getDni());
                attachedCandidatoModelList.add(candidatoModelListCandidatoModelToAttach);
            }
            comunaModel.setCandidatoModelList(attachedCandidatoModelList);
            em.persist(comunaModel);
            for (LocalvotacionModel localvotacionModelListLocalvotacionModel : comunaModel.getLocalvotacionModelList()) {
                ComunaModel oldComunaOfLocalvotacionModelListLocalvotacionModel = localvotacionModelListLocalvotacionModel.getComuna();
                localvotacionModelListLocalvotacionModel.setComuna(comunaModel);
                localvotacionModelListLocalvotacionModel = em.merge(localvotacionModelListLocalvotacionModel);
                if (oldComunaOfLocalvotacionModelListLocalvotacionModel != null) {
                    oldComunaOfLocalvotacionModelListLocalvotacionModel.getLocalvotacionModelList().remove(localvotacionModelListLocalvotacionModel);
                    oldComunaOfLocalvotacionModelListLocalvotacionModel = em.merge(oldComunaOfLocalvotacionModelListLocalvotacionModel);
                }
            }
            for (CandidatoModel candidatoModelListCandidatoModel : comunaModel.getCandidatoModelList()) {
                ComunaModel oldComunaOfCandidatoModelListCandidatoModel = candidatoModelListCandidatoModel.getComuna();
                candidatoModelListCandidatoModel.setComuna(comunaModel);
                candidatoModelListCandidatoModel = em.merge(candidatoModelListCandidatoModel);
                if (oldComunaOfCandidatoModelListCandidatoModel != null) {
                    oldComunaOfCandidatoModelListCandidatoModel.getCandidatoModelList().remove(candidatoModelListCandidatoModel);
                    oldComunaOfCandidatoModelListCandidatoModel = em.merge(oldComunaOfCandidatoModelListCandidatoModel);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findComunaModel(comunaModel.getId()) != null) {
                throw new PreexistingEntityException("ComunaModel " + comunaModel + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ComunaModel comunaModel) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ComunaModel persistentComunaModel = em.find(ComunaModel.class, comunaModel.getId());
            List<LocalvotacionModel> localvotacionModelListOld = persistentComunaModel.getLocalvotacionModelList();
            List<LocalvotacionModel> localvotacionModelListNew = comunaModel.getLocalvotacionModelList();
            List<CandidatoModel> candidatoModelListOld = persistentComunaModel.getCandidatoModelList();
            List<CandidatoModel> candidatoModelListNew = comunaModel.getCandidatoModelList();
            List<LocalvotacionModel> attachedLocalvotacionModelListNew = new ArrayList<LocalvotacionModel>();
            for (LocalvotacionModel localvotacionModelListNewLocalvotacionModelToAttach : localvotacionModelListNew) {
                localvotacionModelListNewLocalvotacionModelToAttach = em.getReference(localvotacionModelListNewLocalvotacionModelToAttach.getClass(), localvotacionModelListNewLocalvotacionModelToAttach.getId());
                attachedLocalvotacionModelListNew.add(localvotacionModelListNewLocalvotacionModelToAttach);
            }
            localvotacionModelListNew = attachedLocalvotacionModelListNew;
            comunaModel.setLocalvotacionModelList(localvotacionModelListNew);
            List<CandidatoModel> attachedCandidatoModelListNew = new ArrayList<CandidatoModel>();
            for (CandidatoModel candidatoModelListNewCandidatoModelToAttach : candidatoModelListNew) {
                candidatoModelListNewCandidatoModelToAttach = em.getReference(candidatoModelListNewCandidatoModelToAttach.getClass(), candidatoModelListNewCandidatoModelToAttach.getDni());
                attachedCandidatoModelListNew.add(candidatoModelListNewCandidatoModelToAttach);
            }
            candidatoModelListNew = attachedCandidatoModelListNew;
            comunaModel.setCandidatoModelList(candidatoModelListNew);
            comunaModel = em.merge(comunaModel);
            for (LocalvotacionModel localvotacionModelListOldLocalvotacionModel : localvotacionModelListOld) {
                if (!localvotacionModelListNew.contains(localvotacionModelListOldLocalvotacionModel)) {
                    localvotacionModelListOldLocalvotacionModel.setComuna(null);
                    localvotacionModelListOldLocalvotacionModel = em.merge(localvotacionModelListOldLocalvotacionModel);
                }
            }
            for (LocalvotacionModel localvotacionModelListNewLocalvotacionModel : localvotacionModelListNew) {
                if (!localvotacionModelListOld.contains(localvotacionModelListNewLocalvotacionModel)) {
                    ComunaModel oldComunaOfLocalvotacionModelListNewLocalvotacionModel = localvotacionModelListNewLocalvotacionModel.getComuna();
                    localvotacionModelListNewLocalvotacionModel.setComuna(comunaModel);
                    localvotacionModelListNewLocalvotacionModel = em.merge(localvotacionModelListNewLocalvotacionModel);
                    if (oldComunaOfLocalvotacionModelListNewLocalvotacionModel != null && !oldComunaOfLocalvotacionModelListNewLocalvotacionModel.equals(comunaModel)) {
                        oldComunaOfLocalvotacionModelListNewLocalvotacionModel.getLocalvotacionModelList().remove(localvotacionModelListNewLocalvotacionModel);
                        oldComunaOfLocalvotacionModelListNewLocalvotacionModel = em.merge(oldComunaOfLocalvotacionModelListNewLocalvotacionModel);
                    }
                }
            }
            for (CandidatoModel candidatoModelListOldCandidatoModel : candidatoModelListOld) {
                if (!candidatoModelListNew.contains(candidatoModelListOldCandidatoModel)) {
                    candidatoModelListOldCandidatoModel.setComuna(null);
                    candidatoModelListOldCandidatoModel = em.merge(candidatoModelListOldCandidatoModel);
                }
            }
            for (CandidatoModel candidatoModelListNewCandidatoModel : candidatoModelListNew) {
                if (!candidatoModelListOld.contains(candidatoModelListNewCandidatoModel)) {
                    ComunaModel oldComunaOfCandidatoModelListNewCandidatoModel = candidatoModelListNewCandidatoModel.getComuna();
                    candidatoModelListNewCandidatoModel.setComuna(comunaModel);
                    candidatoModelListNewCandidatoModel = em.merge(candidatoModelListNewCandidatoModel);
                    if (oldComunaOfCandidatoModelListNewCandidatoModel != null && !oldComunaOfCandidatoModelListNewCandidatoModel.equals(comunaModel)) {
                        oldComunaOfCandidatoModelListNewCandidatoModel.getCandidatoModelList().remove(candidatoModelListNewCandidatoModel);
                        oldComunaOfCandidatoModelListNewCandidatoModel = em.merge(oldComunaOfCandidatoModelListNewCandidatoModel);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = comunaModel.getId();
                if (findComunaModel(id) == null) {
                    throw new NonexistentEntityException("The comunaModel with id " + id + " no longer exists.");
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
            ComunaModel comunaModel;
            try {
                comunaModel = em.getReference(ComunaModel.class, id);
                comunaModel.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The comunaModel with id " + id + " no longer exists.", enfe);
            }
            List<LocalvotacionModel> localvotacionModelList = comunaModel.getLocalvotacionModelList();
            for (LocalvotacionModel localvotacionModelListLocalvotacionModel : localvotacionModelList) {
                localvotacionModelListLocalvotacionModel.setComuna(null);
                localvotacionModelListLocalvotacionModel = em.merge(localvotacionModelListLocalvotacionModel);
            }
            List<CandidatoModel> candidatoModelList = comunaModel.getCandidatoModelList();
            for (CandidatoModel candidatoModelListCandidatoModel : candidatoModelList) {
                candidatoModelListCandidatoModel.setComuna(null);
                candidatoModelListCandidatoModel = em.merge(candidatoModelListCandidatoModel);
            }
            em.remove(comunaModel);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ComunaModel> findComunaModelEntities() {
        return findComunaModelEntities(true, -1, -1);
    }

    public List<ComunaModel> findComunaModelEntities(int maxResults, int firstResult) {
        return findComunaModelEntities(false, maxResults, firstResult);
    }

    private List<ComunaModel> findComunaModelEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ComunaModel.class));
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

    public ComunaModel findComunaModel(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ComunaModel.class, id);
        } finally {
            em.close();
        }
    }

    public int getComunaModelCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ComunaModel> rt = cq.from(ComunaModel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
