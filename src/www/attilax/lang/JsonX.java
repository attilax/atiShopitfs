/**
 * 
 */
package www.attilax.lang;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author ASIMO
 *
 */
public class JsonX {

	/**
	@author attilax 老哇的爪子
	@since   p1p e_q_46
	 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public static String toJsonStrO88(final Object objOrArr) {
		// attilax 鑰佸搰鐨勭埅瀛�涓嬪崍02:08:01 2014-5-12
//   涓嬪崍07:17:11 2014-9-1  鑰佸搰鐨勭埅瀛� Attilax
		try {
			return JSONObject.fromObject(objOrArr).toString(2);
		} catch (Exception e) {
			return JSONArray.fromObject(objOrArr).toString(2);
		}
		 
	}

}
