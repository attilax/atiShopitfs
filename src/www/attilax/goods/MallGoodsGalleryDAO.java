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
 * MallGoodsGallery entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see www.attilax.goods.MallGoodsGallery
 * @author MyEclipse Persistence Tools
 */

public class MallGoodsGalleryDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(MallGoodsGalleryDAO.class);
	// property constants
	public static final String GOODS_ID = "goodsId";
	public static final String IMG_URL = "imgUrl";
	public static final String IMG_DESC = "imgDesc";
	public static final String THUMB_URL = "thumbUrl";
	public static final String IMG_ORIGINAL = "imgOriginal";
	public static final String IS_SET = "isSet";
	public static final String IMG_SIZE_ID = "imgSizeId";

	public void save(MallGoodsGallery transientInstance) {
		log.debug("saving MallGoodsGallery instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(MallGoodsGallery persistentInstance) {
		log.debug("deleting MallGoodsGallery instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MallGoodsGallery findById(java.lang.Integer id) {
		log.debug("getting MallGoodsGallery instance with id: " + id);
		try {
			MallGoodsGallery instance = (MallGoodsGallery) getSession().get(
					"www.attilax.goods.MallGoodsGallery", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<MallGoodsGallery> findByExample(MallGoodsGallery instance) {
		log.debug("finding MallGoodsGallery instance by example");
		try {
			List<MallGoodsGallery> results = (List<MallGoodsGallery>) getSession()
					.createCriteria("www.attilax.goods.MallGoodsGallery")
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
		log.debug("finding MallGoodsGallery instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from MallGoodsGallery as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<MallGoodsGallery> findByGoodsId(Object goodsId) {
		return findByProperty(GOODS_ID, goodsId);
	}

	public List<MallGoodsGallery> findByImgUrl(Object imgUrl) {
		return findByProperty(IMG_URL, imgUrl);
	}

	public List<MallGoodsGallery> findByImgDesc(Object imgDesc) {
		return findByProperty(IMG_DESC, imgDesc);
	}

	public List<MallGoodsGallery> findByThumbUrl(Object thumbUrl) {
		return findByProperty(THUMB_URL, thumbUrl);
	}

	public List<MallGoodsGallery> findByImgOriginal(Object imgOriginal) {
		return findByProperty(IMG_ORIGINAL, imgOriginal);
	}

	public List<MallGoodsGallery> findByIsSet(Object isSet) {
		return findByProperty(IS_SET, isSet);
	}

	public List<MallGoodsGallery> findByImgSizeId(Object imgSizeId) {
		return findByProperty(IMG_SIZE_ID, imgSizeId);
	}

	public List findAll() {
		log.debug("finding all MallGoodsGallery instances");
		try {
			String queryString = "from MallGoodsGallery";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public MallGoodsGallery merge(MallGoodsGallery detachedInstance) {
		log.debug("merging MallGoodsGallery instance");
		try {
			MallGoodsGallery result = (MallGoodsGallery) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MallGoodsGallery instance) {
		log.debug("attaching dirty MallGoodsGallery instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MallGoodsGallery instance) {
		log.debug("attaching clean MallGoodsGallery instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}