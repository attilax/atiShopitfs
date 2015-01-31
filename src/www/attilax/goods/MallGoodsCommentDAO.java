package www.attilax.goods;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import www.shopx.shopinfo.BaseHibernateDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * MallGoodsComment entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see www.attilax.goods.MallGoodsComment
 * @author MyEclipse Persistence Tools
 */

public class MallGoodsCommentDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(MallGoodsCommentDAO.class);
	// property constants
	public static final String GOODS_ID = "goodsId";
	public static final String USER_ID = "userId";
	public static final String USER_NAME = "userName";
	public static final String CONTENT = "content";
	public static final String IS_VERIFY = "isVerify";

	public void save(MallGoodsComment transientInstance) {
		log.debug("saving MallGoodsComment instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(MallGoodsComment persistentInstance) {
		log.debug("deleting MallGoodsComment instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MallGoodsComment findById(java.lang.Integer id) {
		log.debug("getting MallGoodsComment instance with id: " + id);
		try {
			MallGoodsComment instance = (MallGoodsComment) getSession().get(
					"www.attilax.goods.MallGoodsComment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<MallGoodsComment> findByExample(MallGoodsComment instance) {
		log.debug("finding MallGoodsComment instance by example");
		try {
			List<MallGoodsComment> results = (List<MallGoodsComment>) getSession()
					.createCriteria("www.attilax.goods.MallGoodsComment")
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
		log.debug("finding MallGoodsComment instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from MallGoodsComment as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<MallGoodsComment> findByGoodsId(Object goodsId) {
		return findByProperty(GOODS_ID, goodsId);
	}

	public List<MallGoodsComment> findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List<MallGoodsComment> findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List<MallGoodsComment> findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List<MallGoodsComment> findByIsVerify(Object isVerify) {
		return findByProperty(IS_VERIFY, isVerify);
	}

	public List findAll() {
		log.debug("finding all MallGoodsComment instances");
		try {
			String queryString = "from MallGoodsComment";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public MallGoodsComment merge(MallGoodsComment detachedInstance) {
		log.debug("merging MallGoodsComment instance");
		try {
			MallGoodsComment result = (MallGoodsComment) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MallGoodsComment instance) {
		log.debug("attaching dirty MallGoodsComment instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MallGoodsComment instance) {
		log.debug("attaching clean MallGoodsComment instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}