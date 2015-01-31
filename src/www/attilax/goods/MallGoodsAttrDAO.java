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
 * MallGoodsAttr entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see www.attilax.goods.MallGoodsAttr
 * @author MyEclipse Persistence Tools
 */

public class MallGoodsAttrDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(MallGoodsAttrDAO.class);
	// property constants
	public static final String GOODS_ID = "goodsId";
	public static final String ATTR_ID = "attrId";
	public static final String ATTR_VALUES = "attrValues";

	public void save(MallGoodsAttr transientInstance) {
		log.debug("saving MallGoodsAttr instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(MallGoodsAttr persistentInstance) {
		log.debug("deleting MallGoodsAttr instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MallGoodsAttr findById(java.lang.Integer id) {
		log.debug("getting MallGoodsAttr instance with id: " + id);
		try {
			MallGoodsAttr instance = (MallGoodsAttr) getSession().get(
					"www.attilax.goods.MallGoodsAttr", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<MallGoodsAttr> findByExample(MallGoodsAttr instance) {
		log.debug("finding MallGoodsAttr instance by example");
		try {
			List<MallGoodsAttr> results = (List<MallGoodsAttr>) getSession()
					.createCriteria("www.attilax.goods.MallGoodsAttr")
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
		log.debug("finding MallGoodsAttr instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from MallGoodsAttr as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<MallGoodsAttr> findByGoodsId(Object goodsId) {
		return findByProperty(GOODS_ID, goodsId);
	}

	public List<MallGoodsAttr> findByAttrId(Object attrId) {
		return findByProperty(ATTR_ID, attrId);
	}

	public List<MallGoodsAttr> findByAttrValues(Object attrValues) {
		return findByProperty(ATTR_VALUES, attrValues);
	}

	public List findAll() {
		log.debug("finding all MallGoodsAttr instances");
		try {
			String queryString = "from MallGoodsAttr";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public MallGoodsAttr merge(MallGoodsAttr detachedInstance) {
		log.debug("merging MallGoodsAttr instance");
		try {
			MallGoodsAttr result = (MallGoodsAttr) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MallGoodsAttr instance) {
		log.debug("attaching dirty MallGoodsAttr instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MallGoodsAttr instance) {
		log.debug("attaching clean MallGoodsAttr instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}