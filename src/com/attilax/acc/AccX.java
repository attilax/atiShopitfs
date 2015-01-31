/**
 * 
 */
package com.attilax.acc;

import com.attilax.persistence.Hbx;
import com.google.inject.Inject;

import www.Hbx4shp;

/**
 * @author ASIMO
 *
 */
public class AccX  extends AccDAO{
	
	@Inject
	Hbx px;
	public   void recharge(int uid, double amt) {
		Acc a = null;
		try {

			a = new AccDAO().findByUid(uid).get(0);
		} catch (IndexOutOfBoundsException e) {
			a = new Acc();
			a.setAmount(0d);
			a.setUid(uid);
		} 

		a.setAmount(a.getAmount() + amt);
		px.merge(a);
	}

}
