package com.sanyu.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.sanyu.entity.Jornada;
import com.sanyu.entity.Turno;

@Service
public class ArchivoPlanoService {
	public Turno turnoMasivo = new Turno();
	public Jornada jornada = new Jornada();
	@Autowired
	public TurnoService turnoService;
	private String carpeta = "src/main/java/archivos/";

//metodo para guardar archivo
	public String guardar(MultipartFile file) throws IOException {
		byte[] bytes = file.getBytes();
		Path path = Paths.get(carpeta + file.getOriginalFilename());
		Files.write(path, bytes);
		return path.toString();
	}

	public void subirArchivo(String txt) {
		int auxRegistros = 0;
		try {
			BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(txt), "utf-8"));
			String registro = "";
			while ((registro = buffer.readLine()) != null) {
				auxRegistros++;
				String[] columna = registro.split(",");
				if (auxRegistros == 1) {
					turnoMasivo.setIdTurno(Integer.parseInt(columna[0]));
					turnoMasivo.setFechaInicio(Date.valueOf(columna[1]));
					turnoMasivo.setHoraInicio(String.valueOf(columna[2]));
					turnoMasivo.setHoraFin(String.valueOf(columna[3]));
					turnoMasivo.setLabor(String.valueOf(columna[4]));
					// turno.setJornada(jornada.valueOf(columna[4]));
					turnoService.guardar(turnoMasivo);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
