/**
 * 
 */
package com.attilax.withdraw;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.attilax.core;
import com.attilax.ref.FldMapX;
import com.attilax.time.timeUtil;

import www.Hbx4shp;
import www.attilax.lang.ref.RefX;

/**
 * @author ASIMO
 *
 */
public class withdrawTest {

	/**
	@author attilax 老哇的爪子
	@since   p1s e_8_r
	 
	 */
	public static void main(String[] args) {
		Map  m=new HashMap();
		m.put("uid", 8);
		m.put("amount", 12.67);
		m.put("alipay", "attialx@qq.com");
		String json_s=core.toJsonStrO88(m);
		JSONObject jo=JSONObject.fromObject(json_s);
		
		Map  FldmapTable=new HashMap();
		FldmapTable.put("alipay","acc");
		Withdraw o=new Withdraw();
		RefX.copyProperties(jo, o);
		o.setAddtime(timeUtil.getTimestamp());
		FldMapX.process(jo,o,FldmapTable);
		 Hbx4shp.getStance().save(o);
		System.out.println(core.toJsonStrO88(o));
		 
		

	}

}
