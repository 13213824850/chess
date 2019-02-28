package com.onlinechese;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.onlinechese.cheserules.CheseCode;
import com.onlinechese.cheserules.Rule;
import com.onlinechese.cheserules.RuleUtil;
import com.onlinechese.constant.GameMessage;
import com.onlinechese.entys.UserInfo;
import com.onlinechese.vo.CheseIndex;
import com.onlinechese.vo.PlayInfo;

public class TestCheses {
	/*int [][]cheses;
	public static int[] a= {1,2,3};
	@Before
	public void init() {
		cheses = RuleUtil.initCheckerboard();
	}
	@Test
	public void testsub() {
		String url = "http://local:3306/1";
		System.out.println(url.substring(url.lastIndexOf("/")));
	}
	
	@Test
	public void test() {
		cheses[4][4] = -6;
		//System.out.println(Rule.checkRules(cheses, 4, 4, 4, 0));
		System.out.println("res"+Rule.jiangJun(cheses, -6));
		
	}
	@Test
	public void testhourse() {
		boolean checkRules = Rule.checkRules(cheses, 1, 0, 0, 2);
		boolean checkRules2 = Rule.checkRules(cheses, 1, 0, 0, 1);
		System.out.println( checkRules + " " + checkRules2);
	}
	
	@Test
	public void testEmnu() {
		CheseIndex ch = new CheseIndex();
		GameMessage gm = GameMessage.matchCode(101);
		System.out.println(gm.getMessage());
	}
	@Test
	public void testMap() {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(3, 33);
		map.put(1, 11);
		map.put(2, 22);
		List<Map.Entry<Integer, Integer>> lists = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
		lists.sort((pool1,pool2) -> pool1.getValue() - pool2.getValue());
		System.out.println(lists.get(4));
	}
	@Test
	public void teststatic() {
		remove(a);
		System.out.println(a[0]);
	}
	public void remove(int [] a1) {
		a1[0] = 456;
	}
	@Test
	public void testDay() {
		Date date = new Date();
		System.err.println(date.getTime());
		System.out.println(date.getDate());
		System.out.println(date.getHours());
		System.out.println(date.getYear());
	}
	@Test
	public void testMapList() {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(3, 33);
		map.put(1, 11);
		map.put(2, 22);
	}*/
	
}
