package com.miw.infrastructure.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class MyLogService implements LogService {

	private int level = 0;
	String message = "";
	private String fichero = "C:\\tmp\\fichero.log";
	private FileWriter archivo;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		message = ("Level set to : " + level);
		try {
			crearLog(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.level = level;
	}

	@Override
	public void debug(String message) {
		if (level <= DEBUG) {
			message = ("DEBUG: " + message);
			try {
				crearLog(message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void error(String message) {
		if (level <= ERROR) {
			message = ("ERROR: " + message);
			try {
				crearLog(message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void fatalError(String message) {
		message = ("FATAL ERROR: " + message);
		try {
			crearLog(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void warn(String message) {
		if (level <= WARN) {
			message = ("WARN: " + message);
			try {
				crearLog(message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void crearLog(String message) throws IOException {

		if (new File(fichero).exists() == false) {
			archivo = new FileWriter(new File(fichero), false);
		}
		archivo = new FileWriter(new File(fichero), true);
		Calendar fechaActual = Calendar.getInstance();

		archivo.write((String.valueOf(fechaActual.get(Calendar.DAY_OF_MONTH))
				+ "/" + String.valueOf(fechaActual.get(Calendar.MONTH) + 1)
				+ "/" + String.valueOf(fechaActual.get(Calendar.YEAR)) + ";"
				+ String.valueOf(fechaActual.get(Calendar.HOUR_OF_DAY)) + ":"
				+ String.valueOf(fechaActual.get(Calendar.MINUTE)) + ":" + String
					.valueOf(fechaActual.get(Calendar.SECOND)))
				+ ";"
				+ message
				+ "\r\n");
		archivo.close();
	}

}
