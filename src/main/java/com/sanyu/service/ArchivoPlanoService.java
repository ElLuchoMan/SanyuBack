package com.sanyu.service;

import java.io.BufferedReader;
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
import com.sanyu.repository.ContratistaRepository;
import com.sanyu.repository.JornadaRepository;

@Service
public class ArchivoPlanoService {
	public Turno turnoMasivo = new Turno();
	public Jornada jornada = new Jornada();
	// Servicio a utilizar
	@Autowired
	public TurnoService turnoService;
	// Repositorio para conocer la jornada cargada
	@Autowired
	public JornadaRepository jornadaRepository;
	// Directorio donde se almacenarán los archivos
	private String carpeta = "src/main/java/archivos/";
	@Autowired
	public ContratistaRepository contratistaRepository;

	// Método para guardar los archivos
	public String guardar(MultipartFile file) throws IOException {
		byte[] bytes = file.getBytes();
		Path path = Paths.get(carpeta + file.getOriginalFilename());
		Files.write(path, bytes);
		return path.toString();
	}

	// Método para registrar los datos del archivo
	@SuppressWarnings("resource")
	public void subirArchivo(String txt) {
		@SuppressWarnings("unused")
		int auxRegistros = 0;
		try {
			BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(txt), "utf-8"));
			String registro = "";
			while ((registro = buffer.readLine()) != null) {
				turnoMasivo = new Turno();
				auxRegistros++;
				String[] columna = registro.split(",");
				turnoMasivo.setFechaInicio(Date.valueOf(columna[0]));
				turnoMasivo.setFechaFin(Date.valueOf(columna[1]));
				turnoMasivo.setHoraInicio(String.valueOf(columna[2]));
				turnoMasivo.setHoraFin(String.valueOf(columna[3]));
				turnoMasivo.setLabor(String.valueOf(columna[4]));
				turnoMasivo.setEstadoTurno("Activo");
				// Condición para saber si se registra o se actualiza turno
				if (columna[5].equals("null")) {
					turnoMasivo.setIdTurno(null);
				} else {
					turnoMasivo.setIdTurno(Integer.parseInt(columna[5]));
				}
				// Get de la jornada para asignarla en el turno
				jornada = jornadaRepository.findById(Integer.parseInt(columna[6])).get();
				Integer documento = Integer.parseInt(columna[7]);
				turnoMasivo.setJornada(jornada);
				Turno turnoAux = turnoService.guardar(turnoMasivo);
				// Se Asigna el turno al contratista si su documento existe
				turnoService.asignarContratista(documento, turnoAux.getIdTurno());
				// Se limpia el objeto para permitir inserción de todos los turnos disponibles
				turnoMasivo = null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
