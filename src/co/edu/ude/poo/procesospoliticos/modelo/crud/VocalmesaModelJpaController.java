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
import co.edu.ude.poo.procesospoliticos.modelo.entidades.MesavotacionModel;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.VocalmesaModel;
import java.util.ArrayList;
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
        if (vocalmesaModel.getMesavotacionModelList() == null) {
            vocalmesaModel.setMesavotacionModelList(new ArrayList<MesavotacionModel>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CiudadanoModel ciudadanoModel = vocalmesaModel.getCiudadanoModel();
            if (ciudadanoModel != null) {
                ciudadanoModel = em.getReference(ciudadanoModel.getClass(), ciudadanoModel.getDni());
                vocalmesaModel.setCiudadanoModel(ciudadanoModel);
            }
            List<MesavotacionModel> attachedMesavotacionModelList = new ArrayList<MesavotacionModel>();
            for (MesavotacionModel mesavotacionModelListMesavotacionModelToAttach : vocalmesaModel.getMesavotacionModelList()) {
                mesavotacionModelListMesavotacionModelToAttach = em.getReference(mesavotacionModelListMesavotacionModelToAttach.getClass(), mesavotacionModelListMesavotacionModelToAttach.getNumero());
                attachedMesavotacionModelList.add(mesavotacionModelListMesavotacionModelToAttach);
            }
            vocalmesaModel.setMesavotacionModelList(attachedMesavotacionModelList);
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
            for (MesavotacionModel mesavotacionModelListMesavotacionModel : vocalmesaModel.getMesavotacionModelList()) {
                VocalmesaModel oldVocalmesaOfMesavotacionModelListMesavotacionModel = mesavotacionModelListMesavotacionModel.getVocalmesa();
                mesavotacionModelListMesavotacionModel.setVocalmesa(vocalmesaModel);
                mesavotacionModelListMesavotacionModel = em.merge(mesavotacionModelListMesavotacionModel);
                if (oldVocalmesaOfMesavotacionModelListMesavotacionModel != null) {
                    oldVocalmesaOfMesavotacionModelListMesavotacionModel.getMesavotacionModelList().remove(mesavotacionModelListMesavotacionModel);
                    oldVocalmesaOfMesavotacionModelListMesavotacionModel = em.merge(oldVocalmesaOfMesavotacionModelListMesavotacionModel);
                }
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
            List<MesavotacionModel> mesavotacionModelListOld = persistentVocalmesaModel.getMesavotacionModelList();
            List<MesavotacionModel> mesavotacionModelListNew = vocalmesaModel.getMesavotacionModelList();
            if (ciudadanoModelNew != null) {
                ciudadanoModelNew = em.getReference(ciudadanoModelNew.getClass(), ciudadanoModelNew.getDni());
                vocalmesaModel.setCiudadanoModel(ciudadanoModelNew);
            }
            List<MesavotacionModel> attachedMesavotacionModelListNew = new ArrayList<MesavotacionModel>();
            for (MesavotacionModel mesavotacionModelListNewMesavotacionModelToAttach : mesavotacionModelListNew) {
                mesavotacionModelListNewMesavotacionModelToAttach = em.getReference(mesavotacionModelListNewMesavotacionModelToAttach.getClass(), mesavotacionModelListNewMesavotacionModelToAttach.getNumero());
                attachedMesavotacionModelListNew.add(mesavotacionModelListNewMesavotacionModelToAttach);
            }
            mesavotacionModelListNew = attachedMesavotacionModelListNew;
            vocalmesaModel.setMesavotacionModelList(mesavotacionModelListNew);
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
            for (MesavotacionModel mesavotacionModelListOldMesavotacionModel : mesavotacionModelListOld) {
                if (!mesavotacionModelListNew.contains(mesavotacionModelListOldMesavotacionModel)) {
                    mesavotacionModelListOldMesavotacionModel.setVocalmesa(null);
                    mesavotacionModelListOldMesavotacionModel = em.merge(mesavotacionModelListOldMesavotacionModel);
                }
            }
            for (MesavotacionModel mesavotacionModelListNewMesavotacionModel : mesavotacionModelListNew) {
                if (!mesavotacionModelListOld.contains(mesavotacionModelListNewMesavotacionModel)) {
                    VocalmesaModel oldVocalmesaOfMesavotacionModelListNewMesavotacionModel = mesavotacionModelListNewMesavotacionModel.getVocalmesa();
                    mesavotacionModelListNewMesavotacionModel.setVocalmesa(vocalmesaModel);
                    mesavotacionModelListNewMesavotacionModel = em.merge(mesavotacionModelListNewMesavotacionModel);
                    if (oldVocalmesaOfMesavotacionModelListNewMesavotacionModel != null && !oldVocalmesaOfMesavotacionModelListNewMesavotacionModel.equals(vocalmesaModel)) {
                        oldVocalmesaOfMesavotacionModelListNewMesavotacionModel.getMesavotacionModelList().remove(mesavotacionModelListNewMesavotacionModel);
                        oldVocalmesaOfMesavotacionModelListNewMesavotacionModel = em.merge(oldVocalmesaOfMesavotacionModelListNewMesavotacionModel);
                    }
                }
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
            List<MesavotacionModel> mesavotacionModelList = vocalmesaModel.getMesavotacionModelList();
            for (MesavotacionModel mesavotacionModelListMesavotacionModel : mesavotacionModelList) {
                mesavotacionModelListMesavotacionModel.setVocalmesa(null);
                mesavotacionModelListMesavotacionModel = em.merge(mesavotacionModelListMesavotacionModel);
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
