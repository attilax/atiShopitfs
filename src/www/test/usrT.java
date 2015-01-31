/**
 * 
 */
package www.test;

import java.util.List;

import www.attilax.lang.JsonX;
import www.shopx.shopinfo.MallShopInfoDAO;
import www.shopx.userx.MallUserInfo;
import www.shopx.userx.MallUserInfoDAO;
import www.shopx.userx.MallUsersDAO;

/**
 * @author ASIMO
 *
 */
public class usrT {

	/**
	@author attilax 老哇的爪子
	@since   p1p e_49_38
	 
	 */
	public static void main(String[] args) {
		MallUsersDAO d=new MallUsersDAO();
		List li=d.findByUserName("attilax");
		System.out.println(JsonX.toJsonStrO88(li.get(0)));

	}

}
