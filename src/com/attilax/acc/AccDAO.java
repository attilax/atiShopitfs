package com.attilax.acc;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import www.shopx.shopinfo.BaseHibernateDAO;

/**
 * A data access object (DAO) providing persistence and search support for Acc
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.attilax.acc.Acc
 * @author MyEclipse Persistence Tools
 */

public class AccDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(AccDAO.class);
	// property constants
	public static final String UID = "uid";
	public static final String AMOUNT = "amount";

	public void save(Acc transientInstance) {
		log.debug("saving Acc instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Acc persistentInstance) {
		log.debug("deleting Acc instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Acc findById(java.lang.Integer id) {
		log.debug("getting Acc instance with id: " + id);
		try {
			Acc instance = (Acc) getSession().get("com.attilax.acc.Acc", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Acc> findByExample(Acc instance) {
		log.debug("finding Acc instance by example");
		try {
			List<Acc> results = (List<Acc>) getSession()
					.createCriteria("com.attilax.acc.Acc")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Acc instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Acc as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Acc> findByUid(Object uid) {
		return findByProperty(UID, uid);
	}

	public List<Acc> findByAmount(Object amount) {
		return findByProperty(AMOUNT, amount);
	}

	public List findAll() {
		log.debug("finding all Acc instances");
		try {
			String queryString = "from Acc";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Acc merge(Acc detachedInstance) {
		log.debug("merging Acc instance");
		try {
			Acc result = (Acc) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Acc instance) {
		log.debug("attaching dirty Acc instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Acc instance) {
		log.debug("attaching clean Acc instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}