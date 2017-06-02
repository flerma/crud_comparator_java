package br.com.amil.entity.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.amil.entity.Volta;
import br.com.amil.util.ProjectUtils;

public class VoltaTest {
	
	@Test
	public void getLogCorridaVoltas() {
		File textFile = new File("log_corrida");
        ArrayList<String> list = ProjectUtils.read(textFile);
        list.remove(0);
        List<Volta> voltas = new Volta().getLogCorridaVoltas(list);
        assertEquals(23, list.size());
	}

}
