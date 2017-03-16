package it.itjustworks.coropaulus;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class CantiParserTest {

	@Test
	public void testOne() throws FileNotFoundException {
		CoroPaulus coro = new CoroPaulus();
		List<Canto> canti = coro.parseCanti(getFromFile());
		assertEquals(189, canti.size());
	}
	
	public void usage() throws IOException {
		CoroPaulus coro = new CoroPaulus();
		List<Canto> canti = coro.prendiCanti();
		canti.toString();
	}
	
	private String getFromFile() throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("src/test/java/it/itjustworks/coropaulus/canti.txt"));
		String response = scanner.useDelimiter("\\Z").next();
		scanner.close();
		return response;
	}
	
}
