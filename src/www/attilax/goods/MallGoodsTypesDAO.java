package www.attilax.goods;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import www.shopx.shopinfo.BaseHibernateDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * MallGoodsTypes entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see www.attilax.goods.MallGoodsTypes
 * @author MyEclipse Persistence Tools
 */

public class MallGoodsTypesDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(MallGoodsTypesDAO.class);
	// property constants
	public static final String TYPE_NAME = "typeName";
	public static final String IS_SHOW = "isShow";

	public void save(MallGoodsTypes transientInstance) {
		log.debug("saving MallGoodsTypes instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(MallGoodsTypes persistentInstance) {
		log.debug("deleting MallGoodsTypes instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MallGoodsTypes findById(java.lang.Integer id) {
		log.debug("getting MallGoodsTypes instance with id: " + id);
		try {
			MallGoodsTypes instance = (MallGoodsTypes) getSession().get(
					"www.attilax.goods.MallGoodsTypes", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<MallGoodsTypes> findByExample(MallGoodsTypes instance) {
		log.debug("finding MallGoodsTypes instance by example");
		try {
			List<MallGoodsTypes> results = (List<MallGoodsTypes>) getSession()
					.createCriteria("www.attilax.goods.MallGoodsTypes")
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
		log.debug("finding MallGoodsTypes instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from MallGoodsTypes as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<MallGoodsTypes> findByTypeName(Object typeName) {
		return findByProperty(TYPE_NAME, typeName);
	}

	public List<MallGoodsTypes> findByIsShow(Object isShow) {
		return findByProperty(IS_SHOW, isShow);
	}

	public List findAll() {
		log.debug("finding all MallGoodsTypes instances");
		try {
			String queryString = "from MallGoodsTypes";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public MallGoodsTypes merge(MallGoodsTypes detachedInstance) {
		log.debug("merging MallGoodsTypes instance");
		try {
			MallGoodsTypes result = (MallGoodsTypes) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MallGoodsTypes instance) {
		log.debug("attaching dirty MallGoodsTypes instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MallGoodsTypes instance) {
		log.debug("attaching clean MallGoodsTypes instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}