/**
 * 
 */
package www.attilax.lang.ref;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;

import net.sf.json.JSONObject;
import www.attilax.goods.MallGoods;

/**
 * @author ASIMO
 * 
 */
public class RefX {

	/**
	 * @author attilax 老哇的爪子
	 * @since p1q d_37_54
	 */
	public static void copyProperties(JSONObject jo, Object g) {
		Field[] fds = g.getClass().getDeclaredFields();
		for (Field field : fds) {
			Set st = jo.keySet();
			for (Object stItem : st) {
				String jsonKeyname = stItem.toString();
				if (field.getName().toLowerCase()
						.equals(jsonKeyname.replaceAll("_", ""))) {
					try {
						BeanUtils.copyProperty(g, field.getName(),
								jo.get(jsonKeyname));
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
	}

}
