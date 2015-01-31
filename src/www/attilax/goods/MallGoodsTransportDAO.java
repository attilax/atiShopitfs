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
 * MallGoodsTransport entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see www.attilax.goods.MallGoodsTransport
 * @author MyEclipse Persistence Tools
 */

public class MallGoodsTransportDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(MallGoodsTransportDAO.class);
	// property constants
	public static final String SHOP_ID = "shopId";
	public static final String TRANSPORT_NAME = "transportName";
	public static final String DESCRIPTION = "description";
	public static final String CONTENT = "content";

	public void save(MallGoodsTransport transientInstance) {
		log.debug("saving MallGoodsTransport instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(MallGoodsTransport persistentInstance) {
		log.debug("deleting MallGoodsTransport instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MallGoodsTransport findById(java.lang.Integer id) {
		log.debug("getting MallGoodsTransport instance with id: " + id);
		try {
			MallGoodsTransport instance = (MallGoodsTransport) getSession()
					.get("www.attilax.goods.MallGoodsTransport", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<MallGoodsTransport> findByExample(MallGoodsTransport instance) {
		log.debug("finding MallGoodsTransport instance by example");
		try {
			List<MallGoodsTransport> results = (List<MallGoodsTransport>) getSession()
					.createCriteria("www.attilax.goods.MallGoodsTransport")
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
		log.debug("finding MallGoodsTransport instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from MallGoodsTransport as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<MallGoodsTransport> findByShopId(Object shopId) {
		return findByProperty(SHOP_ID, shopId);
	}

	public List<MallGoodsTransport> findByTransportName(Object transportName) {
		return findByProperty(TRANSPORT_NAME, transportName);
	}

	public List<MallGoodsTransport> findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List<MallGoodsTransport> findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findAll() {
		log.debug("finding all MallGoodsTransport instances");
		try {
			String queryString = "from MallGoodsTransport";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public MallGoodsTransport merge(MallGoodsTransport detachedInstance) {
		log.debug("merging MallGoodsTransport instance");
		try {
			MallGoodsTransport result = (MallGoodsTransport) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MallGoodsTransport instance) {
		log.debug("attaching dirty MallGoodsTransport instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MallGoodsTransport instance) {
		log.debug("attaching clean MallGoodsTransport instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}