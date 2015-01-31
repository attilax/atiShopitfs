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
 * MallGoods entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see www.attilax.goods.MallGoods
 * @author MyEclipse Persistence Tools
 */

public class MallGoodsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(MallGoodsDAO.class);
	// property constants
	public static final String SHOP_ID = "shopId";
	public static final String GOODS_NAME = "goodsName";
	public static final String CAT_ID = "catId";
	public static final String UCAT_ID = "ucatId";
	public static final String BRAND_ID = "brandId";
	public static final String TYPE_ID = "typeId";
	public static final String GOODS_INTRO = "goodsIntro";
	public static final String GOODS_WHOLESALE = "goodsWholesale";
	public static final String GOODS_NUMBER = "goodsNumber";
	public static final String GOODS_PRICE = "goodsPrice";
	public static final String TRANSPORT_PRICE = "transportPrice";
	public static final String KEYWORD = "keyword";
	public static final String IS_DELETE = "isDelete";
	public static final String IS_BEST = "isBest";
	public static final String IS_NEW = "isNew";
	public static final String IS_HOT = "isHot";
	public static final String IS_PROMOTE = "isPromote";
	public static final String IS_ADMIN_PROMOTE = "isAdminPromote";
	public static final String IS_ON_SALE = "isOnSale";
	public static final String IS_SET_IMAGE = "isSetImage";
	public static final String GOODS_THUMB = "goodsThumb";
	public static final String PV = "pv";
	public static final String FAVPV = "favpv";
	public static final String SORT_ORDER = "sortOrder";
	public static final String LOCK_FLG = "lockFlg";
	public static final String IS_TRANSPORT_TEMPLATE = "isTransportTemplate";
	public static final String TRANSPORT_TEMPLATE_ID = "transportTemplateId";
	public static final String TRANSPORT_TEMPLATE_PRICE = "transportTemplatePrice";

	public void save(MallGoods transientInstance) {
		log.debug("saving MallGoods instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(MallGoods persistentInstance) {
		log.debug("deleting MallGoods instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MallGoods findById(java.lang.Integer id) {
		log.debug("getting MallGoods instance with id: " + id);
		try {
			MallGoods instance = (MallGoods) getSession().get(
					"www.attilax.goods.MallGoods", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<MallGoods> findByExample(MallGoods instance) {
		log.debug("finding MallGoods instance by example");
		try {
			List<MallGoods> results = (List<MallGoods>) getSession()
					.createCriteria("www.attilax.goods.MallGoods")
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
		log.debug("finding MallGoods instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from MallGoods as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<MallGoods> findByShopId(Object shopId) {
		return findByProperty(SHOP_ID, shopId);
	}

	public List<MallGoods> findByGoodsName(Object goodsName) {
		return findByProperty(GOODS_NAME, goodsName);
	}

	public List<MallGoods> findByCatId(Object catId) {
		return findByProperty(CAT_ID, catId);
	}

	public List<MallGoods> findByUcatId(Object ucatId) {
		return findByProperty(UCAT_ID, ucatId);
	}

	public List<MallGoods> findByBrandId(Object brandId) {
		return findByProperty(BRAND_ID, brandId);
	}

	public List<MallGoods> findByTypeId(Object typeId) {
		return findByProperty(TYPE_ID, typeId);
	}

	public List<MallGoods> findByGoodsIntro(Object goodsIntro) {
		return findByProperty(GOODS_INTRO, goodsIntro);
	}

	public List<MallGoods> findByGoodsWholesale(Object goodsWholesale) {
		return findByProperty(GOODS_WHOLESALE, goodsWholesale);
	}

	public List<MallGoods> findByGoodsNumber(Object goodsNumber) {
		return findByProperty(GOODS_NUMBER, goodsNumber);
	}

	public List<MallGoods> findByGoodsPrice(Object goodsPrice) {
		return findByProperty(GOODS_PRICE, goodsPrice);
	}

	public List<MallGoods> findByTransportPrice(Object transportPrice) {
		return findByProperty(TRANSPORT_PRICE, transportPrice);
	}

	public List<MallGoods> findByKeyword(Object keyword) {
		return findByProperty(KEYWORD, keyword);
	}

	public List<MallGoods> findByIsDelete(Object isDelete) {
		return findByProperty(IS_DELETE, isDelete);
	}

	public List<MallGoods> findByIsBest(Object isBest) {
		return findByProperty(IS_BEST, isBest);
	}

	public List<MallGoods> findByIsNew(Object isNew) {
		return findByProperty(IS_NEW, isNew);
	}

	public List<MallGoods> findByIsHot(Object isHot) {
		return findByProperty(IS_HOT, isHot);
	}

	public List<MallGoods> findByIsPromote(Object isPromote) {
		return findByProperty(IS_PROMOTE, isPromote);
	}

	public List<MallGoods> findByIsAdminPromote(Object isAdminPromote) {
		return findByProperty(IS_ADMIN_PROMOTE, isAdminPromote);
	}

	public List<MallGoods> findByIsOnSale(Object isOnSale) {
		return findByProperty(IS_ON_SALE, isOnSale);
	}

	public List<MallGoods> findByIsSetImage(Object isSetImage) {
		return findByProperty(IS_SET_IMAGE, isSetImage);
	}

	public List<MallGoods> findByGoodsThumb(Object goodsThumb) {
		return findByProperty(GOODS_THUMB, goodsThumb);
	}

	public List<MallGoods> findByPv(Object pv) {
		return findByProperty(PV, pv);
	}

	public List<MallGoods> findByFavpv(Object favpv) {
		return findByProperty(FAVPV, favpv);
	}

	public List<MallGoods> findBySortOrder(Object sortOrder) {
		return findByProperty(SORT_ORDER, sortOrder);
	}

	public List<MallGoods> findByLockFlg(Object lockFlg) {
		return findByProperty(LOCK_FLG, lockFlg);
	}

	public List<MallGoods> findByIsTransportTemplate(Object isTransportTemplate) {
		return findByProperty(IS_TRANSPORT_TEMPLATE, isTransportTemplate);
	}

	public List<MallGoods> findByTransportTemplateId(Object transportTemplateId) {
		return findByProperty(TRANSPORT_TEMPLATE_ID, transportTemplateId);
	}

	public List<MallGoods> findByTransportTemplatePrice(
			Object transportTemplatePrice) {
		return findByProperty(TRANSPORT_TEMPLATE_PRICE, transportTemplatePrice);
	}

	public List findAll() {
		log.debug("finding all MallGoods instances");
		try {
			String queryString = "from MallGoods";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public MallGoods merge(MallGoods detachedInstance) {
		log.debug("merging MallGoods instance");
		try {
			MallGoods result = (MallGoods) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MallGoods instance) {
		log.debug("attaching dirty MallGoods instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MallGoods instance) {
		log.debug("attaching clean MallGoods instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}