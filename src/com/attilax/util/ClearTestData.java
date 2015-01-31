/**
 * 
 */
package com.attilax.util;

import java.util.List;

import com.attilax.coll.ListX;
import com.attilax.collection.listUtil;
import com.attilax.io.filex;
import com.hp.hpl.sparta.xpath.ThisNodeTest;

/**
 * @author ASIMO
 *
 */
public class ClearTestData {

	/**
	@author attilax 老哇的爪子
	@since   p1d a_48_w
	 
	 */
	public static void main(String[] args) {
		
	//	ClearTestData.class.getGenericSuperclass()

		String f="C:\\Users\\ASIMO\\Desktop\\测试数据清空.txt";
		List<String> li=	filex.read2list(f);
		for (String line : li) {
			System.out.println("truncate table "+line +";");
		}

		

	}

}
