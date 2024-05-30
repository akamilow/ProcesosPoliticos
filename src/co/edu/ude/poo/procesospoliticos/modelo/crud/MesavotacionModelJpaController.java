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
import co.edu.ude.poo.procesospoliticos.modelo.entidades.MesavotacionModel;
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
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LocalvotacionModel ubicacion = mesavotacionModel.getUbicacion();
            if (ubicacion != null) {
                ubicacion = em.getReference(ubicacion.getClass(), ubicacion.getId());
                mesavotacionModel.setUbicacion(ubicacion);
            }
            em.persist(mesavotacionModel);
            if (ubicacion != null) {
                ubicacion.getMesavotacionModelList().add(mesavotacionModel);
                ubicacion = em.merge(ubicacion);
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
            LocalvotacionModel ubicacionOld = persistentMesavotacionModel.getUbicacion();
            LocalvotacionModel ubicacionNew = mesavotacionModel.getUbicacion();
            if (ubicacionNew != null) {
                ubicacionNew = em.getReference(ubicacionNew.getClass(), ubicacionNew.getId());
                mesavotacionModel.setUbicacion(ubicacionNew);
            }
            mesavotacionModel = em.merge(mesavotacionModel);
            if (ubicacionOld != null && !ubicacionOld.equals(ubicacionNew)) {
                ubicacionOld.getMesavotacionModelList().remove(mesavotacionModel);
                ubicacionOld = em.merge(ubicacionOld);
            }
            if (ubicacionNew != null && !ubicacionNew.equals(ubicacionOld)) {
                ubicacionNew.getMesavotacionModelList().add(mesavotacionModel);
                ubicacionNew = em.merge(ubicacionNew);
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
            LocalvotacionModel ubicacion = mesavotacionModel.getUbicacion();
            if (ubicacion != null) {
                ubicacion.getMesavotacionModelList().remove(mesavotacionModel);
                ubicacion = em.merge(ubicacion);
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
