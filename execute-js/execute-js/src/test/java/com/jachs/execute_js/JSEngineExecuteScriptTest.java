package com.jachs.execute_js;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Test;

/***
 * 执行脚本<br>
 * ps:以流形式读物理文件不区分文件类型，内容必须符合js规范。
 * @author zhanchaohan
 *
 */
public class JSEngineExecuteScriptTest {
	ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
	ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("javascript");

	private String psPath(String fileName) {
		return JSEngineExecuteScriptTest.class.getResource(fileName).getPath();
	}
	@Test
	public void test1() throws ScriptException, FileNotFoundException {
		Reader read=new FileReader(psPath("/demo.txt"));
		Integer intege=(Integer) scriptEngine.eval(read);
		
		System.out.println(intege);
	}
	@Test
	public void test2() throws Exception{
		Reader read=new FileReader(psPath("/demo1.txt"));
		
		scriptEngine.put("name", "皮皮虾");
		String str=(String) scriptEngine.eval(read);
		
		System.out.println(str);
	}
	//------------------------------------------------------------------
	@Test
	public void test3() throws  Exception {
		Reader read=new FileReader(psPath("/demo2.txt"));
		
		scriptEngine.put("n1", "皮皮虾");
		scriptEngine.put("n2", "打篮球");
		
		scriptEngine.eval(read);
		
		System.out.println(scriptEngine.get("reverseN1"));
		System.out.println(scriptEngine.get("reverseN2"));
	}
	@Test
	public void test5() throws  Exception{
		
	}
}
