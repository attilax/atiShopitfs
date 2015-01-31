/**
 * 
 */
package www.attilax.goods;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;

import www.Hbx4shp;
import www.attilax.lang.ref.RefX;
import net.sf.json.JSONObject;

import com.attilax.core;
import com.attilax.cfg.ApiInier;
import com.attilax.io.filex;
import com.attilax.io.pathx;
import com.attilax.net.websitex;

/**
 * @author ASIMO
 *
 */
public class addGoodTest {

	/**
	@author attilax 老哇的爪子
	 * @throws UnsupportedEncodingException 
	@since   p1q c_56_41
	 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		
//		Object obj=new Object();
//		obj.method="showGoodsList";
//		obj.param="select * form table111  where xxx";
//		String json=Obj2json(obj);
//		String url="http://hostxxxxx/api.jsp?data="+urlEncode(json)
		
		  String f=pathx.classPath(addGoodTest.class)+"/good.json";
		  String t=filex.read(f, "utf-8");
		//  MallGoods g = aaa(t);
		// System.out.println(core.toJsonStrO88(g));
		 // g.setShopId(jo.getInt("shop_id"));
			String t_urlencode=URLEncoder.encode(t,"utf8");
			 
			String url="http://localhost:8090/shopitfs/api.jsp?data="+t_urlencode;
		//	url="http://192.168.1.33/vod/api.jsp?sign=xxxx&submethod=postDownTaskBackfeed4notice&param=%7B%22dsId%22%3A1554%2C%22equipmentId%22%3A1081%7D&appid=863778010205109";
			System.out.println(url);
			System.out.println(websitex.WebpageContent(url));;
		  System.out.println("--f");

	}

	private static MallGoods aaa(String t) {
		MallGoods g=new MallGoods();
		  JSONObject jo=JSONObject.fromObject(t);
		  RefX.copyProperties(jo,g);
		 
			 
			
	 
		  g.setBrandId(1);
		  g.setGoodsThumb("uploadfiles/goods/2010/11/29/thumb_2010112903480063.jpg");
		  g.setCatId(6);
		  g.setFavpv(0);
		  g.setGoodsNumber(99);
		  g.setIsAdminPromote(true);
		  g.setIsBest(false);
		  g.setIsDelete(true);
		  g.setIsHot(false);g.setIsPromote(false);
		  g.setIsNew(false);
		  g.setIsOnSale(true);g.setIsSetImage(true);g.setKeyword("");g.setLockFlg(false);
		  g.setSortOrder(true);
		  g.setPv(0);
		  g.setUcatId(37);
		return g;
	}

}
