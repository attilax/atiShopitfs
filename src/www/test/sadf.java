/**
 * 
 */
package www.test;

/**
 * @author ASIMO
 *
 */
public class sadf {

	public static void main(String[] args) {
		String url = "http://attilax.vicp.cc:39332/shopitfs/api.jsp?data={%0D%0A%22method%22%3A%22showGoodsList%22%2C%0D%0A%22param%22%3A%22SELECT+*+FROM+%60mall_goods%60+where+shop_id%3D8+limit+0%2C100%22%0D%0A}%0D%0A";
		String result="null";     
		HttpGet httpGet=new HttpGet(url);//编者按：与HttpPost区别所在，这里是将参数在地址中传递  
		HttpResponse response=new DefaultHttpClient().execute(httpGet);  
		if(response.getStatusLine().getStatusCode()==200){  
			      HttpEntity entity=response.getEntity();  
			      result=EntityUtils.toString(entity, HTTP.UTF_8);  
		}  

	}
}
