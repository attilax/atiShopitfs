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
 * MallGoodsShipping entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see www.attilax.goods.MallGoodsShipping
 * @author MyEclipse Persistence Tools
 */

public class MallGoodsShippingDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(MallGoodsShippingDAO.class);
	// property constants
	public static final String GOODS_ID = "goodsId";
	public static final String SHIPPING_ID = "shippingId";
	public static final String SHIPPING_FEE = "shippingFee";

	public void save(MallGoodsShipping transientInstance) {
		log.debug("saving MallGoodsShipping instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(MallGoodsShipping persistentInstance) {
		log.debug("deleting MallGoodsShipping instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MallGoodsShipping findById(java.lang.Integer id) {
		log.debug("getting MallGoodsShipping instance with id: " + id);
		try {
			MallGoodsShipping instance = (MallGoodsShipping) getSession().get(
					"www.attilax.goods.MallGoodsShipping", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<MallGoodsShipping> findByExample(MallGoodsShipping instance) {
		log.debug("finding MallGoodsShipping instance by example");
		try {
			List<MallGoodsShipping> results = (List<MallGoodsShipping>) getSession()
					.createCriteria("www.attilax.goods.MallGoodsShipping")
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
		log.debug("finding MallGoodsShipping instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from MallGoodsShipping as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<MallGoodsShipping> findByGoodsId(Object goodsId) {
		return findByProperty(GOODS_ID, goodsId);
	}

	public List<MallGoodsShipping> findByShippingId(Object shippingId) {
		return findByProperty(SHIPPING_ID, shippingId);
	}

	public List<MallGoodsShipping> findByShippingFee(Object shippingFee) {
		return findByProperty(SHIPPING_FEE, shippingFee);
	}

	public List findAll() {
		log.debug("finding all MallGoodsShipping instances");
		try {
			String queryString = "from MallGoodsShipping";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public MallGoodsShipping merge(MallGoodsShipping detachedInstance) {
		log.debug("merging MallGoodsShipping instance");
		try {
			MallGoodsShipping result = (MallGoodsShipping) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MallGoodsShipping instance) {
		log.debug("attaching dirty MallGoodsShipping instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MallGoodsShipping instance) {
		log.debug("attaching clean MallGoodsShipping instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}