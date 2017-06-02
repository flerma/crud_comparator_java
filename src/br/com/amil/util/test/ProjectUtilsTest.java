package br.com.amil.util.test;

import java.io.File;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import br.com.amil.util.ProjectUtils;

public class ProjectUtilsTest {
	
	@Test
	public void testaRead() {
		File textFile = new File("log_corrida");
        ArrayList<String> list = ProjectUtils.read(textFile);
        assertEquals(24, list.size());
	}
}
