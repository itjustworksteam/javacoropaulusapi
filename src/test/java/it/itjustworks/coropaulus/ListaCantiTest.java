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
	public void testToString() throws FileNotFoundException {
		CoroPaulus coro = new CoroPaulus();
		List<Canto> canti = coro.parseCanti(getFromFile());
		ListaCanti lista = new ListaCanti(canti);
		lista.cerca("amare oltre");
		assertEquals(1, lista.trovati());
		assertEquals("Ho trovato 1 canto. Eccolo:\n\n"
				+ "amare oltre --> https://docs.google.com/viewerng/viewer?url=http://coropaulus.altervista.org/tuttiICanti/amare_oltre.pdf\n\n", lista.prettyToString());
	}
	
	@Test
	public void testNessunCantoTrovato() throws FileNotFoundException {
		CoroPaulus coro = new CoroPaulus();
		List<Canto> canti = coro.parseCanti(getFromFile());
		ListaCanti lista = new ListaCanti(canti);
		lista.cerca("buongiorno");
		assertEquals(0, lista.trovati());
		assertEquals("nessun canto trovato", lista.prettyToString());
	}
	
	@Test
	public void testMoltiCanti() throws FileNotFoundException {
		CoroPaulus coro = new CoroPaulus();
		List<Canto> canti = coro.parseCanti(getFromFile());
		ListaCanti lista = new ListaCanti(canti);
		lista.cerca("alleluia");
		assertEquals(16, lista.trovati());
		assertNotEquals("nessun canto trovato", lista.prettyToString());
	}
	
	public void test() throws IOException {
		CoroPaulus coro = new CoroPaulus();
		ListaCanti canti = coro.listaCanti();
		assertEquals(196, canti.dimensione());
		canti.cerca("alleluia");
		assertEquals(17, canti.trovati());
	}
	
	private String getFromFile() throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("src/test/java/it/itjustworks/coropaulus/canti.txt"));
		String response = scanner.useDelimiter("\\Z").next();
		scanner.close();
		return response;
	}
	
}
