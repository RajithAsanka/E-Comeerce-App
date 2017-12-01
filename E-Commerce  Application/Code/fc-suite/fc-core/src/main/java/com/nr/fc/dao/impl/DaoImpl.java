
package com.nr.fc.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.nr.fc.dao.IDao;
import java.math.BigInteger;

/**
 *
 * @author Amith Fernando
 * @param <T>
 * @param <PK>
 */
public abstract class DaoImpl<T, PK extends Serializable> implements IDao<T, PK> {

    /* Persistence Entity class type. */
    protected Class<T> entityClass;

    /* Entity manager to perform DAO operations. */
    @PersistenceContext
    protected EntityManager entityManager;

    /**
     * Constructor
     */
    @SuppressWarnings("unchecked")
    public DaoImpl() {

        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    @Override
    public T create(T t) {

        this.entityManager.persist(t);
        return t;
    }

    @Override
    public T read(PK id) {
        return this.entityManager.find(entityClass, id);
    }

    @Override
    public T update(T t) {

        return this.entityManager.merge(t);
    }

    @Override
    public void delete(T t) {

        t = this.entityManager.merge(t);
        this.entityManager.remove(t);
    }

    @Override
    public List<T> findAll() {
        Query query = entityManager.createQuery("FROM " + entityClass.getName() + " c");
        return (List<T>) query.getResultList();
    }

    @Override
    public List<T> findNamedQuery(String query, Map<String, Object> params) {
        javax.persistence.Query q = this.entityManager.createNamedQuery(query);
        for (Map.Entry<String, Object> en : params.entrySet()) {
            String object = en.getKey();
            Object value = en.getValue();
            q.setParameter(object, value);
        }
        return q.getResultList();
    }

    @Override
    public List<T> findNamedQueryLimit(String query, Map<String, Object> params, int limit) {
        javax.persistence.Query q = this.entityManager.createNamedQuery(query);
        for (Map.Entry<String, Object> en : params.entrySet()) {
            String object = en.getKey();
            Object value = en.getValue();
            q.setParameter(object, value);
        }
        q.setMaxResults(limit);
        return q.getResultList();
    }

    @Override
    public List<T> findbyQueryLimit(String query, Map<String, Object> params, int limit) {
        javax.persistence.Query q = this.entityManager.createQuery(query);
        for (Map.Entry<String, Object> en : params.entrySet()) {
            String object = en.getKey();
            Object value = en.getValue();
            q.setParameter(object, value);
        }
        q.setMaxResults(limit);
        return q.getResultList();
    }

    @Override
    public List<T> findbyQuery(String query, Map<String, Object> params) {
        javax.persistence.Query q = this.entityManager.createQuery(query);
        for (Map.Entry<String, Object> en : params.entrySet()) {
            String object = en.getKey();
            Object value = en.getValue();
            q.setParameter(object, value);
        }
        return q.getResultList();
    }

    @Override
    public T findbyQuerySingle(String query, Map<String, Object> params) {
        javax.persistence.Query q = this.entityManager.createQuery(query);
        for (Map.Entry<String, Object> en : params.entrySet()) {
            String object = en.getKey();
            Object value = en.getValue();
            q.setParameter(object, value);
        }
        try {
            return (T) q.getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    @Override
    public T findSingleNamedQuery(String query, Map<String, Object> params) {
        try {
            javax.persistence.Query q = this.entityManager.createNamedQuery(query);
            for (Map.Entry<String, Object> en : params.entrySet()) {
                String object = en.getKey();
                Object value = en.getValue();
                q.setParameter(object, value);
            }
            return (T) q.getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    @Override
    public List<T> findByLike(Class<T> mainClass, String colomn, String value) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(mainClass);

        Root<T> root = query.from(mainClass);
        query.where(builder.like(root.<String>get(colomn), builder.parameter(String.class, "param")));

        TypedQuery<T> tq = entityManager.createQuery(query);
        tq.setParameter("param", value + "%");
        List<T> list = tq.getResultList();
        return list;
    }

    @Override
    public List<Object[]> findNativeQuery(String query, Map<String, Object> params) {
        javax.persistence.Query q = this.entityManager.createNativeQuery(query);
        for (Map.Entry<String, Object> en : params.entrySet()) {
            String object = en.getKey();
            Object value = en.getValue();
            q.setParameter(object, value);
        }
        return q.getResultList();
    }

    @Override
    public List<BigInteger> findNativeQueryIntegerList(String query, Map<String, Object> params) {

        javax.persistence.Query q = this.entityManager.createNativeQuery(query);
        for (Map.Entry<String, Object> en : params.entrySet()) {
            String object = en.getKey();
            Object value = en.getValue();
            q.setParameter(object, value);
        }
        return q.getResultList();

    }

//    @Override
//    public List<T> findByCriteria(Class<T> mainClass,PK criteria,List<Root<T>> trailRooty){
//      CriteriaBuilder builder=entityManager.getCriteriaBuilder();
//      List<T> result = null; 
//      
//      try{
//        CriteriaQuery<T> query = builder.createQuery(mainClass);
//        Root<T> trailRoot = query.from(mainClass);
//        query.select(trailRoot).distinct(true).where(buildPredicate(criteria,builder,trailRooty));
//        result=entityManager.createQuery(query).getResultList();
//      }catch(Exception e){
//        return null;
//      }
//      return result;
//    }
//    
//    private Predicate[] buildPredicate(PK entitleGroupCriteria,CriteriaBuilder builder,List<RootList> rootList){
//      
//      List<Predicate> predicate = new ArrayList<>();
// 
//      for(RootList obj :rootList){
//        Predicate predictFeeCategory = builder.equal(obj.getTrailRoot(),entitleGroupCriteria.getFeeCategory());
//        predicate.add(predictFeeCategory);
//        obj.getTrailRoot();
//      }
//      if(entitleGroupCriteria.getFeeCategory() !=null && !entitleGroupCriteria.getFeeCategory().equalsIgnoreCase("")){
//        
//        Path<FeeCategory> path = trailRoot.join("feeCategory").get("feeCategory");
//        Predicate predictFeeCategory = builder.equal(path,entitleGroupCriteria.getFeeCategory());
//        predicate.add(predictFeeCategory);
//      }
//    }
}
