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
import co.edu.ude.poo.procesospoliticos.modelo.entidades.ApoderadoModel;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.LocalvotacionModel;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.MesavotacionModel;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.VocalmesaModel;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.VotoModel;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author camil
 */
public class MesavotacionModelJpaController implements Serializable {

    public MesavotacionModelJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MesavotacionModel mesavotacionModel) throws PreexistingEntityException, Exception {
        if (mesavotacionModel.getVotoModelList() == null) {
            mesavotacionModel.setVotoModelList(new ArrayList<VotoModel>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ApoderadoModel apoderadoModel = mesavotacionModel.getApoderadoModel();
            if (apoderadoModel != null) {
                apoderadoModel = em.getReference(apoderadoModel.getClass(), apoderadoModel.getDni());
                mesavotacionModel.setApoderadoModel(apoderadoModel);
            }
            LocalvotacionModel localvotacion = mesavotacionModel.getLocalvotacion();
            if (localvotacion != null) {
                localvotacion = em.getReference(localvotacion.getClass(), localvotacion.getId());
                mesavotacionModel.setLocalvotacion(localvotacion);
            }
            VocalmesaModel vocalmesa = mesavotacionModel.getVocalmesa();
            if (vocalmesa != null) {
                vocalmesa = em.getReference(vocalmesa.getClass(), vocalmesa.getDni());
                mesavotacionModel.setVocalmesa(vocalmesa);
            }
            List<VotoModel> attachedVotoModelList = new ArrayList<VotoModel>();
            for (VotoModel votoModelListVotoModelToAttach : mesavotacionModel.getVotoModelList()) {
                votoModelListVotoModelToAttach = em.getReference(votoModelListVotoModelToAttach.getClass(), votoModelListVotoModelToAttach.getId());
                attachedVotoModelList.add(votoModelListVotoModelToAttach);
            }
            mesavotacionModel.setVotoModelList(attachedVotoModelList);
            em.persist(mesavotacionModel);
            if (apoderadoModel != null) {
                apoderadoModel.getMesavotacionModelList().add(mesavotacionModel);
                apoderadoModel = em.merge(apoderadoModel);
            }
            if (localvotacion != null) {
                localvotacion.getMesavotacionModelList().add(mesavotacionModel);
                localvotacion = em.merge(localvotacion);
            }
            if (vocalmesa != null) {
                vocalmesa.getMesavotacionModelList().add(mesavotacionModel);
                vocalmesa = em.merge(vocalmesa);
            }
            for (VotoModel votoModelListVotoModel : mesavotacionModel.getVotoModelList()) {
                MesavotacionModel oldMesaOfVotoModelListVotoModel = votoModelListVotoModel.getMesa();
                votoModelListVotoModel.setMesa(mesavotacionModel);
                votoModelListVotoModel = em.merge(votoModelListVotoModel);
                if (oldMesaOfVotoModelListVotoModel != null) {
                    oldMesaOfVotoModelListVotoModel.getVotoModelList().remove(votoModelListVotoModel);
                    oldMesaOfVotoModelListVotoModel = em.merge(oldMesaOfVotoModelListVotoModel);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMesavotacionModel(mesavotacionModel.getNumero()) != null) {
                throw new PreexistingEntityException("MesavotacionModel " + mesavotacionModel + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MesavotacionModel mesavotacionModel) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            MesavotacionModel persistentMesavotacionModel = em.find(MesavotacionModel.class, mesavotacionModel.getNumero());
            ApoderadoModel apoderadoModelOld = persistentMesavotacionModel.getApoderadoModel();
            ApoderadoModel apoderadoModelNew = mesavotacionModel.getApoderadoModel();
            LocalvotacionModel localvotacionOld = persistentMesavotacionModel.getLocalvotacion();
            LocalvotacionModel localvotacionNew = mesavotacionModel.getLocalvotacion();
            VocalmesaModel vocalmesaOld = persistentMesavotacionModel.getVocalmesa();
            VocalmesaModel vocalmesaNew = mesavotacionModel.getVocalmesa();
            List<VotoModel> votoModelListOld = persistentMesavotacionModel.getVotoModelList();
            List<VotoModel> votoModelListNew = mesavotacionModel.getVotoModelList();
            if (apoderadoModelNew != null) {
                apoderadoModelNew = em.getReference(apoderadoModelNew.getClass(), apoderadoModelNew.getDni());
                mesavotacionModel.setApoderadoModel(apoderadoModelNew);
            }
            if (localvotacionNew != null) {
                localvotacionNew = em.getReference(localvotacionNew.getClass(), localvotacionNew.getId());
                mesavotacionModel.setLocalvotacion(localvotacionNew);
            }
            if (vocalmesaNew != null) {
                vocalmesaNew = em.getReference(vocalmesaNew.getClass(), vocalmesaNew.getDni());
                mesavotacionModel.setVocalmesa(vocalmesaNew);
            }
            List<VotoModel> attachedVotoModelListNew = new ArrayList<VotoModel>();
            for (VotoModel votoModelListNewVotoModelToAttach : votoModelListNew) {
                votoModelListNewVotoModelToAttach = em.getReference(votoModelListNewVotoModelToAttach.getClass(), votoModelListNewVotoModelToAttach.getId());
                attachedVotoModelListNew.add(votoModelListNewVotoModelToAttach);
            }
            votoModelListNew = attachedVotoModelListNew;
            mesavotacionModel.setVotoModelList(votoModelListNew);
            mesavotacionModel = em.merge(mesavotacionModel);
            if (apoderadoModelOld != null && !apoderadoModelOld.equals(apoderadoModelNew)) {
                apoderadoModelOld.getMesavotacionModelList().remove(mesavotacionModel);
                apoderadoModelOld = em.merge(apoderadoModelOld);
            }
            if (apoderadoModelNew != null && !apoderadoModelNew.equals(apoderadoModelOld)) {
                apoderadoModelNew.getMesavotacionModelList().add(mesavotacionModel);
                apoderadoModelNew = em.merge(apoderadoModelNew);
            }
            if (localvotacionOld != null && !localvotacionOld.equals(localvotacionNew)) {
                localvotacionOld.getMesavotacionModelList().remove(mesavotacionModel);
                localvotacionOld = em.merge(localvotacionOld);
            }
            if (localvotacionNew != null && !localvotacionNew.equals(localvotacionOld)) {
                localvotacionNew.getMesavotacionModelList().add(mesavotacionModel);
                localvotacionNew = em.merge(localvotacionNew);
            }
            if (vocalmesaOld != null && !vocalmesaOld.equals(vocalmesaNew)) {
                vocalmesaOld.getMesavotacionModelList().remove(mesavotacionModel);
                vocalmesaOld = em.merge(vocalmesaOld);
            }
            if (vocalmesaNew != null && !vocalmesaNew.equals(vocalmesaOld)) {
                vocalmesaNew.getMesavotacionModelList().add(mesavotacionModel);
                vocalmesaNew = em.merge(vocalmesaNew);
            }
            for (VotoModel votoModelListOldVotoModel : votoModelListOld) {
                if (!votoModelListNew.contains(votoModelListOldVotoModel)) {
                    votoModelListOldVotoModel.setMesa(null);
                    votoModelListOldVotoModel = em.merge(votoModelListOldVotoModel);
                }
            }
            for (VotoModel votoModelListNewVotoModel : votoModelListNew) {
                if (!votoModelListOld.contains(votoModelListNewVotoModel)) {
                    MesavotacionModel oldMesaOfVotoModelListNewVotoModel = votoModelListNewVotoModel.getMesa();
                    votoModelListNewVotoModel.setMesa(mesavotacionModel);
                    votoModelListNewVotoModel = em.merge(votoModelListNewVotoModel);
                    if (oldMesaOfVotoModelListNewVotoModel != null && !oldMesaOfVotoModelListNewVotoModel.equals(mesavotacionModel)) {
                        oldMesaOfVotoModelListNewVotoModel.getVotoModelList().remove(votoModelListNewVotoModel);
                        oldMesaOfVotoModelListNewVotoModel = em.merge(oldMesaOfVotoModelListNewVotoModel);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = mesavotacionModel.getNumero();
                if (findMesavotacionModel(id) == null) {
                    throw new NonexistentEntityException("The mesavotacionModel with id " + id + " no longer exists.");
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
            MesavotacionModel mesavotacionModel;
            try {
                mesavotacionModel = em.getReference(MesavotacionModel.class, id);
                mesavotacionModel.getNumero();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mesavotacionModel with id " + id + " no longer exists.", enfe);
            }
            ApoderadoModel apoderadoModel = mesavotacionModel.getApoderadoModel();
            if (apoderadoModel != null) {
                apoderadoModel.getMesavotacionModelList().remove(mesavotacionModel);
                apoderadoModel = em.merge(apoderadoModel);
            }
            LocalvotacionModel localvotacion = mesavotacionModel.getLocalvotacion();
            if (localvotacion != null) {
                localvotacion.getMesavotacionModelList().remove(mesavotacionModel);
                localvotacion = em.merge(localvotacion);
            }
            VocalmesaModel vocalmesa = mesavotacionModel.getVocalmesa();
            if (vocalmesa != null) {
                vocalmesa.getMesavotacionModelList().remove(mesavotacionModel);
                vocalmesa = em.merge(vocalmesa);
            }
            List<VotoModel> votoModelList = mesavotacionModel.getVotoModelList();
            for (VotoModel votoModelListVotoModel : votoModelList) {
                votoModelListVotoModel.setMesa(null);
                votoModelListVotoModel = em.merge(votoModelListVotoModel);
            }
            em.remove(mesavotacionModel);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MesavotacionModel> findMesavotacionModelEntities() {
        return findMesavotacionModelEntities(true, -1, -1);
    }

    public List<MesavotacionModel> findMesavotacionModelEntities(int maxResults, int firstResult) {
        return findMesavotacionModelEntities(false, maxResults, firstResult);
    }

    private List<MesavotacionModel> findMesavotacionModelEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MesavotacionModel.class));
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

    public MesavotacionModel findMesavotacionModel(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MesavotacionModel.class, id);
        } finally {
            em.close();
        }
    }

    public int getMesavotacionModelCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MesavotacionModel> rt = cq.from(MesavotacionModel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
