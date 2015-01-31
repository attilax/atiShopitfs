/**
 * 
 */
package com.attilax.acc;

import www.Hbx4shp;

import com.attilax.tryX;
import com.attilax.cfg.IocX;

/**
 * @author ASIMO
 * 
 */
public class accTest {

	/**
	 * @author attilax 老哇的爪子
	 * @since p1t 10_a_h
	 */
	public static void main(String[] args) {

		int uid = 8;
		double amt = 0.13;
		AccX ac=IocX.getBean(AccX.class);
		ac.recharge(uid, amt);
		System.out.println("--");

	}

	private static void recharge(int uid, double amt) {
		Acc a = null;
		try {

			a = new AccDAO().findByUid(uid).get(0);
		} catch (IndexOutOfBoundsException e) {
			a = new Acc();
			a.setAmount(0d);
			a.setUid(uid);
		} 

		a.setAmount(a.getAmount() + amt);
		Hbx4shp.getStance().merge(a);
	}

}
