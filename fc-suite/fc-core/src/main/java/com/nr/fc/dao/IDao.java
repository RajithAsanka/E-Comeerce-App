/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.dao;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Amith Fernando
 */
public interface IDao<T, PK extends Serializable> {

    /**
     * Save the given entity object
     *
     * @param t persist.ence entrity object to be saved
     * @return persisted entity object.
     */
    T create(T t);

    /**
     * Read the entity object for given primary key
     *
     * @param id primary key to read the entity
     * @return entity object for given primary key
     */
    T read(PK id);

    /**
     * Update the given entity object.
     *
     * @param t update the entity object
     * @return updated enitity object
     */
    T update(T t);

    /**
     * Delete the given entity object.
     *
     * @param t delete the entity object
     */
    void delete(T t);

    /**
     * Fetch all the entity objects from given table.
     *
     * @return all entity object in the db
     */
    List<T> findAll();

    public List<T> findbyQuery(String query, Map<String, Object> params);

    public T findbyQuerySingle(String query, Map<String, Object> params);

    public List<T> findNamedQuery(String query, Map<String, Object> params);

    public List<T> findNamedQueryLimit(String query, Map<String, Object> params, int limit);

    public List<T> findbyQueryLimit(String query, Map<String, Object> params, int limit);

    public T findSingleNamedQuery(String query, Map<String, Object> params);

    /**
     *
     * @author Mohamed Sayyaff
     * @param mainClass T Entity class initialization
     * @param colomn {@link String} which entity variable
     * @param value {@link String} value for that variable
     * @return {@link List} T
     */
    public List<T> findByLike(Class<T> mainClass, String colomn, String value);

    /**
     * @author Mohamed Sayyaff
     * @param query
     * @param params
     * @param criteria T
     * @param mainClass {@link Class} T
     * @param buildPredicate {@link Predicate}[]
     * @return {@link List} T
     */
     // public List<T> findByCriteria(Class<T> mainClass,PK criteria,List<Root<T>> trailRooty);
    
     public List<Object[]> findNativeQuery(String query, Map<String, Object> params);
     /**
      * 
      * @param query
      * @param params
      * @return 
      */
     public List<BigInteger> findNativeQueryIntegerList(String query, Map<String, Object> params);
}
