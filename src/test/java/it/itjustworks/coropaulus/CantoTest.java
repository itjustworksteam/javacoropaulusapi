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
	
}
