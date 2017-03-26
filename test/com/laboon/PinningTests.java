package com.laboon;

import static org.junit.Assert.*;

import org.junit.*;

public class PinningTests{
	
	// Tests toString with a number
	@Test
	public void TestToStringNumber(){
		String str = "1000000";
		ProgramArea pa = new ProgramArea(str);
		String stringRep = pa.toString();
		assertEquals(stringRep.substring(0,7),str);
	}
	
	//Tests toString with an empty string
	@Test
	public void TestToStringSize0(){
		String str = "";
		str=str.concat(" ");
		ProgramArea pa = new ProgramArea(str);
		String stringRep = pa.toString();
		assertEquals(stringRep.substring(0,1),str);
	}
	
	//Tests toString with a size 1 string
	@Test
	public void TestToStringSize1(){
		String str = "1";
		ProgramArea pa = new ProgramArea(str);
		String stringRep = pa.toString();
		assertEquals(stringRep.substring(0,1),str);
	}
	
	//Test get op code. Tries to read 3
	@Test
	public void TestGetOpCode(){
		String str = "1@3$5^7*9";
		ProgramArea pa = new ProgramArea(str);
		char op = pa.getOpCode(0,2);
		assertEquals(op,'3');
	}
	
	// Test get Op Code with negative coordinate.
	@Test
	public void TestGetOpCodeNegative(){
		String str = "1@3$5^7*9";
		ProgramArea pa = new ProgramArea(str);
		char op = pa.getOpCode(-2,0);
		assertEquals(op,(char)0);
	}
	
	// Test get Op Code with above max coordinate value 
	@Test
	public void TestGetOpCodeHigh(){
		String str = "1@3$5^7*9";
		ProgramArea pa = new ProgramArea(str);
		char op = pa.getOpCode(1000,0);
		assertEquals(op,(char)0);
	}
	
	// Test regular Modulo
	@Test
	public void TestModuloNormal(){
		ProgramStack ps = new ProgramStack();
		ProgramArea pa = new ProgramArea("aaaaaaaaaaaaaaa");
		MainPanel mp = new MainPanel();
		ProgramExecutor pe = new ProgramExecutor(mp,ps,pa);
		pe._ps.push(3);
		pe._ps.push(2);
		pe.modulo();
		assertEquals(pe._ps.pop(),1);
	}
	
	// Test regular modulo with the numbers flipped
	@Test
	public void TestModuloFlipped(){
		ProgramStack ps = new ProgramStack();
		ProgramArea pa = new ProgramArea("aaaaaaaaaaaaaaa");
		MainPanel mp = new MainPanel();
		ProgramExecutor pe = new ProgramExecutor(mp,ps,pa);
		pe._ps.push(2);
		pe._ps.push(3);
		pe.modulo();
		assertEquals(pe._ps.pop(),2);
	}
	
	//Test modulo with 1 value on the stack
	@Test
	public void TestModuloOneNumber(){
		ProgramStack ps = new ProgramStack();
		ProgramArea pa = new ProgramArea("aaaaaaaaaaaaaaa");
		MainPanel mp = new MainPanel();
		ProgramExecutor pe = new ProgramExecutor(mp,ps,pa);
		pe._ps.push(2);
		pe.modulo();
		assertEquals(pe._ps.pop(),0);
	}
}