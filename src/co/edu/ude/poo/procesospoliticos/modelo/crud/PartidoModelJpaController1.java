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
import co.edu.ude.poo.procesospoliticos.modelo.entidades.PartidoModel;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author camil
 */
public class PartidoModelJpaController1 implements Serializable {

    public PartidoModelJpaController1(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PartidoModel partidoModel) throws PreexistingEntityException, Exception {
        if (partidoModel.getCandidatoModelList() == null) {
            partidoModel.setCandidatoModelList(new ArrayList<CandidatoModel>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<CandidatoModel> attachedCandidatoModelList = new ArrayList<CandidatoModel>();
            for (CandidatoModel candidatoModelListCandidatoModelToAttach : partidoModel.getCandidatoModelList()) {
                candidatoModelListCandidatoModelToAttach = em.getReference(candidatoModelListCandidatoModelToAttach.getClass(), candidatoModelListCandidatoModelToAttach.getDni());
                attachedCandidatoModelList.add(candidatoModelListCandidatoModelToAttach);
            }
            partidoModel.setCandidatoModelList(attachedCandidatoModelList);
            em.persist(partidoModel);
            for (CandidatoModel candidatoModelListCandidatoModel : partidoModel.getCandidatoModelList()) {
                PartidoModel oldPartidoOfCandidatoModelListCandidatoModel = candidatoModelListCandidatoModel.getPartido();
                candidatoModelListCandidatoModel.setPartido(partidoModel);
                candidatoModelListCandidatoModel = em.merge(candidatoModelListCandidatoModel);
                if (oldPartidoOfCandidatoModelListCandidatoModel != null) {
                    oldPartidoOfCandidatoModelListCandidatoModel.getCandidatoModelList().remove(candidatoModelListCandidatoModel);
                    oldPartidoOfCandidatoModelListCandidatoModel = em.merge(oldPartidoOfCandidatoModelListCandidatoModel);
                }
            }
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
            PartidoModel persistentPartidoModel = em.find(PartidoModel.class, partidoModel.getId());
            List<CandidatoModel> candidatoModelListOld = persistentPartidoModel.getCandidatoModelList();
            List<CandidatoModel> candidatoModelListNew = partidoModel.getCandidatoModelList();
            List<CandidatoModel> attachedCandidatoModelListNew = new ArrayList<CandidatoModel>();
            for (CandidatoModel candidatoModelListNewCandidatoModelToAttach : candidatoModelListNew) {
                candidatoModelListNewCandidatoModelToAttach = em.getReference(candidatoModelListNewCandidatoModelToAttach.getClass(), candidatoModelListNewCandidatoModelToAttach.getDni());
                attachedCandidatoModelListNew.add(candidatoModelListNewCandidatoModelToAttach);
            }
            candidatoModelListNew = attachedCandidatoModelListNew;
            partidoModel.setCandidatoModelList(candidatoModelListNew);
            partidoModel = em.merge(partidoModel);
            for (CandidatoModel candidatoModelListOldCandidatoModel : candidatoModelListOld) {
                if (!candidatoModelListNew.contains(candidatoModelListOldCandidatoModel)) {
                    candidatoModelListOldCandidatoModel.setPartido(null);
                    candidatoModelListOldCandidatoModel = em.merge(candidatoModelListOldCandidatoModel);
                }
            }
            for (CandidatoModel candidatoModelListNewCandidatoModel : candidatoModelListNew) {
                if (!candidatoModelListOld.contains(candidatoModelListNewCandidatoModel)) {
                    PartidoModel oldPartidoOfCandidatoModelListNewCandidatoModel = candidatoModelListNewCandidatoModel.getPartido();
                    candidatoModelListNewCandidatoModel.setPartido(partidoModel);
                    candidatoModelListNewCandidatoModel = em.merge(candidatoModelListNewCandidatoModel);
                    if (oldPartidoOfCandidatoModelListNewCandidatoModel != null && !oldPartidoOfCandidatoModelListNewCandidatoModel.equals(partidoModel)) {
                        oldPartidoOfCandidatoModelListNewCandidatoModel.getCandidatoModelList().remove(candidatoModelListNewCandidatoModel);
                        oldPartidoOfCandidatoModelListNewCandidatoModel = em.merge(oldPartidoOfCandidatoModelListNewCandidatoModel);
                    }
                }
            }
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
            List<CandidatoModel> candidatoModelList = partidoModel.getCandidatoModelList();
            for (CandidatoModel candidatoModelListCandidatoModel : candidatoModelList) {
                candidatoModelListCandidatoModel.setPartido(null);
                candidatoModelListCandidatoModel = em.merge(candidatoModelListCandidatoModel);
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
