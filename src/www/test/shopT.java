/**
 * 
 */
package www.test;

 
import java.util.List;

import com.attilax.persistence.DbutilX;

import www.Hbx4shp;
import www.attilax.lang.JsonX;
 
import www.shopx.shopinfo.MallShopInfoDAO;

/**
 * @author ASIMO
 *
 */
public class shopT {

	/**
	@author attilax ���۵�צ��
	@since   p1p e_l_c
	 
	 */
	public static void main(String[] args) {
	 @SuppressWarnings("rawtypes")
	// List li=Hbx4shp.getStance().findByHql(" from MallUsers ");
	//List li=	Hbx4shp.getStance().findBySql("SELECT * FROM `mall_shop_info` where user_id=8");
	 String sql=  "SELECT * FROM `mall_goods` where shop_id=8 limit 0,10";
	 sql="SELECT * FROM `mall_order_info` where shop_id=5";
	 sql=" SELECT * FROM  mall_user_info   where  user_id=8 ";
	 sql= " SELECT * FROM `mall_shop_info` sp left join  mall_user_info  ui on  sp.user_id=ui.user_id as uid where sp.user_id=8 ";
	//sql="SELECT sp.*,ui.user_mobile FROM `mall_shop_info` sp left join  mall_user_info  ui on  sp.user_id=ui.user_id where sp.user_id=8";
	 //List li=  new DbutilX().findBySql(sql);
	// update  mall_user_info set user_truename='名字' ,user_mobile='1358891563' ,user_address='地址信息2'  where user_id=8 ;
	  sql= " update mall_shop_info set shop_intro='myintro5' where shop_id=8 ";
	//  sql=sql+" ; update  mall_user_info set  user_mobile='1358891563'    where user_id=8 ";
	  sql=sql+" ;\r\n "+" update  mall_user_info set user_truename='名字5' ,user_mobile='1358891563' ,user_address='地址信息2'  where user_id=8";
	 
	  sql="  SELECT * FROM  mall_user_info   where  user_id=8 ";
	  sql=sql+"; update mall_shop_info set shop_intro='myintro6' where shop_id=8 ";
	  sql="SELECT * FROM `mall_order_goods` where order_id=1";
		
	// sql=" SELECT * FROM  mall_user_info   where  user_id=8 ";
	  List li= 	Hbx4shp.getStance().findBySql(sql);
	 System.out.println(JsonX.toJsonStrO88(li));
//		MallShopInfoDAO d=new MallShopInfoDAO();
//		List li=d.findAll();
//		System.out.println(JsonX.toJsonStrO88(li));
		

	}

}
