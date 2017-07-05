package it.itjustworks.coropaulus;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class ListaCantiTest {

	@Test
	public void testOne() throws FileNotFoundException {
		CoroPaulus coro = new CoroPaulus();
		List<Canto> canti = coro.parseCanti(getFromFile());
		ListaCanti lista = new ListaCanti(canti);
		assertEquals(canti, lista.canti());
		assertEquals(canti.size(), lista.dimensione());
	}
	
	@Test
	public void test() throws IOException {
		CoroPaulus coro = new CoroPaulus();
		ListaCanti canti = coro.listaCanti();
		assertEquals(196, canti.dimensione());
		List<Canto> cantiGiusti = canti.cerca("alleluia");
		assertEquals(17, cantiGiusti.size());
	}
	
	private String getFromFile() throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("src/test/java/it/itjustworks/coropaulus/canti.txt"));
		String response = scanner.useDelimiter("\\Z").next();
		scanner.close();
		return response;
	}
	
}
