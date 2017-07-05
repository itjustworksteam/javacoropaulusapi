package it.itjustworks.coropaulus;

import static org.junit.Assert.*;

import org.junit.Test;

public class CantoTest {

	@Test
	public void testOne() {
		Canto canto = new Canto("nome", "url");
		assertEquals("nome", canto.nome());
		assertEquals("url", canto.url());
	}
	
	@Test
	public void testTwo() {
		Canto canto = new Canto("nome", "url");
		assertEquals("Canto{nome=nome, url=url}", canto.toString());
	}
	
	@Test
	public void testThree() {
		Canto canto = new Canto("nome", "url");
		assertEquals(cantoPrettyToStringOutput(), canto.prettyToString());
	}
	
	private String cantoPrettyToStringOutput() {
		return "nome --> https://docs.google.com/viewerng/viewer?url=url\n";
	}
	
}
