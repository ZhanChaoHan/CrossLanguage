package com.jachs.execute_js;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class JSEngineTest {
	ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
	ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("javascript");

	/***
	 * 执行js命令获取结果集
	 * @throws ScriptException
	 */
	@Test
	public void test1() throws ScriptException {
		Double hour = (Double) scriptEngine.eval("var date = new Date(); date.getHours();");

		System.out.println(hour);
	}

	@Test
	public void test2() throws ScriptException {
		Double sum = (Double) scriptEngine.eval("var a=2;a=a+55;a");

		System.out.println(sum);
	}

	// ------------------------------------------------------------------------------------------
	/***
	 * 传参执行js
	 * @throws ScriptException
	 */
	@Test
	public void test3() throws ScriptException {
		scriptEngine.put("name", "jack");

		String str = (String) scriptEngine.eval("var prefix='hello ';prefix=prefix+name");

		System.out.println(str);
	}
	/***
	 * 传参执行js获取参数
	 * @throws ScriptException
	 */
	@Test
	public void test5() throws ScriptException {
		scriptEngine.put("name", "jack");
		scriptEngine.put("email", "abc@kk.com");
		scriptEngine.put("address", "zoom");
		
		scriptEngine.eval("name=name.toUpperCase();email=email.toUpperCase();address=address.toUpperCase()");
		
		System.out.println(scriptEngine.get("name"));
		System.out.println(scriptEngine.get("email"));
		System.out.println(scriptEngine.get("address"));
	}
}
