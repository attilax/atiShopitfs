/**
 * 
 */
package com.attilax.cfg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;
import www.Hbx4shp;
import www.attilax.goods.MallGoods;
import www.attilax.lang.ref.RefX;

import com.attilax.core;
import com.attilax.acc.AccX;
import com.attilax.api.Handler;
import com.attilax.api.HandlerChain;
import com.attilax.ref.FldMapX;
import com.attilax.time.timeUtil;
import com.attilax.withdraw.Withdraw;

/**
 * @author ASIMO
 *
 */
public class ApiInier {
	public static void main(String[] args) {
		try {
			
		} catch (Throwable e) {
			 
		}
	}

		/**
		@author attilax 老哇的爪子
		@since   p1q d_40_37
		 
		 */
	public void ini() {
		HandlerChain.mp.put("addGoods",  new Handler() {

			@Override
			public Object handleReq(Object arg) throws Exception {
				  MallGoods g=new MallGoods();
				 JSONObject jo=JSONObject.fromObject(arg.toString());
				  RefX.copyProperties(jo,g);
				  g.setBrandId(1);
				  if(g.getGoodsThumb()==null || g.getGoodsThumb().trim().length()==0)
					  g.setGoodsThumb("uploadfiles/goods/2010/11/29/thumb_2010112903480063.jpg");
				  if(g.getCatId()==null)
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
				  g.setAddTime(timeUtil.getTimestamp());
				 System.out.println(core.toJsonStrO88(g));
				 // g.setShopId(jo.getInt("shop_id"));
			  Hbx4shp.getStance().save(g);
				return "";
			}});
		
		
		HandlerChain.reg("draw",  new Handler(){

			@Override
			public Object handleReq(Object arg) throws Exception {
				JSONObject jo=JSONObject.fromObject(arg);
				Map  FldmapTable=new HashMap();
				FldmapTable.put("alipay","acc");
				Withdraw o=new Withdraw();
				RefX.copyProperties(jo, o);
				o.setAddtime(timeUtil.getTimestamp());
				FldMapX.process(jo,o,FldmapTable);
				  Hbx4shp.getStance().save(o);
				return "";
			}});
		
		HandlerChain.reg("recharge",  new Handler(){

			@Override
			public Object handleReq(Object arg) throws Exception {
				JSONObject jo = null;
				try {
					  jo=JSONObject.fromObject(arg);
				} catch (Exception e) {
				 	 throw new RuntimeException("json fmt err",e);
				}
		 
			
				int uid=jo.getInt("uid");
				double amt=jo.getDouble("amount");
				AccX ac=IocX.getBean(AccX.class);
				ac.recharge(uid, amt);
			List li=	ac.findByUid(uid);
				return core.toJsonStrO88(li);
			}});
		
		HandlerChain.reg("amount",  new Handler(){

			@Override
			public Object handleReq(Object arg) throws Exception {
				JSONObject jo=JSONObject.fromObject(arg);
				int uid=jo.getInt("uid");
				AccX ac=IocX.getBean(AccX.class);
			List li=	ac.findByUid(uid);
				return  core.toJsonStrO88(li);
			}});
		
		Set<String> keyset=HandlerChain.mp.keySet();
		for (String ky : keyset) {
			String unikey=ky.toLowerCase().trim();
			if(HandlerChain.mp.get(unikey)==null )
				HandlerChain.reg(unikey,(Handler) HandlerChain.mp.get(ky));
		}
		
	}

}
