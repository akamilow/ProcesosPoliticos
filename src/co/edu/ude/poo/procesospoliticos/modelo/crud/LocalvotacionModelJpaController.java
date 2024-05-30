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
import co.edu.ude.poo.procesospoliticos.modelo.entidades.MesavotacionModel;
import java.util.ArrayList;
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
        if (localvotacionModel.getMesavotacionModelList() == null) {
            localvotacionModel.setMesavotacionModelList(new ArrayList<MesavotacionModel>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ComunaModel comuna = localvotacionModel.getComuna();
            if (comuna != null) {
                comuna = em.getReference(comuna.getClass(), comuna.getId());
                localvotacionModel.setComuna(comuna);
            }
            List<MesavotacionModel> attachedMesavotacionModelList = new ArrayList<MesavotacionModel>();
            for (MesavotacionModel mesavotacionModelListMesavotacionModelToAttach : localvotacionModel.getMesavotacionModelList()) {
                mesavotacionModelListMesavotacionModelToAttach = em.getReference(mesavotacionModelListMesavotacionModelToAttach.getClass(), mesavotacionModelListMesavotacionModelToAttach.getNumero());
                attachedMesavotacionModelList.add(mesavotacionModelListMesavotacionModelToAttach);
            }
            localvotacionModel.setMesavotacionModelList(attachedMesavotacionModelList);
            em.persist(localvotacionModel);
            if (comuna != null) {
                comuna.getLocalvotacionModelList().add(localvotacionModel);
                comuna = em.merge(comuna);
            }
            for (MesavotacionModel mesavotacionModelListMesavotacionModel : localvotacionModel.getMesavotacionModelList()) {
                LocalvotacionModel oldUbicacionOfMesavotacionModelListMesavotacionModel = mesavotacionModelListMesavotacionModel.getUbicacion();
                mesavotacionModelListMesavotacionModel.setUbicacion(localvotacionModel);
                mesavotacionModelListMesavotacionModel = em.merge(mesavotacionModelListMesavotacionModel);
                if (oldUbicacionOfMesavotacionModelListMesavotacionModel != null) {
                    oldUbicacionOfMesavotacionModelListMesavotacionModel.getMesavotacionModelList().remove(mesavotacionModelListMesavotacionModel);
                    oldUbicacionOfMesavotacionModelListMesavotacionModel = em.merge(oldUbicacionOfMesavotacionModelListMesavotacionModel);
                }
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
            List<MesavotacionModel> mesavotacionModelListOld = persistentLocalvotacionModel.getMesavotacionModelList();
            List<MesavotacionModel> mesavotacionModelListNew = localvotacionModel.getMesavotacionModelList();
            if (comunaNew != null) {
                comunaNew = em.getReference(comunaNew.getClass(), comunaNew.getId());
                localvotacionModel.setComuna(comunaNew);
            }
            List<MesavotacionModel> attachedMesavotacionModelListNew = new ArrayList<MesavotacionModel>();
            for (MesavotacionModel mesavotacionModelListNewMesavotacionModelToAttach : mesavotacionModelListNew) {
                mesavotacionModelListNewMesavotacionModelToAttach = em.getReference(mesavotacionModelListNewMesavotacionModelToAttach.getClass(), mesavotacionModelListNewMesavotacionModelToAttach.getNumero());
                attachedMesavotacionModelListNew.add(mesavotacionModelListNewMesavotacionModelToAttach);
            }
            mesavotacionModelListNew = attachedMesavotacionModelListNew;
            localvotacionModel.setMesavotacionModelList(mesavotacionModelListNew);
            localvotacionModel = em.merge(localvotacionModel);
            if (comunaOld != null && !comunaOld.equals(comunaNew)) {
                comunaOld.getLocalvotacionModelList().remove(localvotacionModel);
                comunaOld = em.merge(comunaOld);
            }
            if (comunaNew != null && !comunaNew.equals(comunaOld)) {
                comunaNew.getLocalvotacionModelList().add(localvotacionModel);
                comunaNew = em.merge(comunaNew);
            }
            for (MesavotacionModel mesavotacionModelListOldMesavotacionModel : mesavotacionModelListOld) {
                if (!mesavotacionModelListNew.contains(mesavotacionModelListOldMesavotacionModel)) {
                    mesavotacionModelListOldMesavotacionModel.setUbicacion(null);
                    mesavotacionModelListOldMesavotacionModel = em.merge(mesavotacionModelListOldMesavotacionModel);
                }
            }
            for (MesavotacionModel mesavotacionModelListNewMesavotacionModel : mesavotacionModelListNew) {
                if (!mesavotacionModelListOld.contains(mesavotacionModelListNewMesavotacionModel)) {
                    LocalvotacionModel oldUbicacionOfMesavotacionModelListNewMesavotacionModel = mesavotacionModelListNewMesavotacionModel.getUbicacion();
                    mesavotacionModelListNewMesavotacionModel.setUbicacion(localvotacionModel);
                    mesavotacionModelListNewMesavotacionModel = em.merge(mesavotacionModelListNewMesavotacionModel);
                    if (oldUbicacionOfMesavotacionModelListNewMesavotacionModel != null && !oldUbicacionOfMesavotacionModelListNewMesavotacionModel.equals(localvotacionModel)) {
                        oldUbicacionOfMesavotacionModelListNewMesavotacionModel.getMesavotacionModelList().remove(mesavotacionModelListNewMesavotacionModel);
                        oldUbicacionOfMesavotacionModelListNewMesavotacionModel = em.merge(oldUbicacionOfMesavotacionModelListNewMesavotacionModel);
                    }
                }
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
            List<MesavotacionModel> mesavotacionModelList = localvotacionModel.getMesavotacionModelList();
            for (MesavotacionModel mesavotacionModelListMesavotacionModel : mesavotacionModelList) {
                mesavotacionModelListMesavotacionModel.setUbicacion(null);
                mesavotacionModelListMesavotacionModel = em.merge(mesavotacionModelListMesavotacionModel);
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
