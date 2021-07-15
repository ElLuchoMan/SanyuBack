package com.sanyu.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanyu.entity.Contratista;
import com.sanyu.entity.Credenciales;
import com.sanyu.entity.UsuarioLogeado;
import com.sanyu.repository.ContratistaRepository;

@Service
@Transactional
public class LoginService {
	// Repositorio a utilizar
	@Autowired
	ContratistaRepository contratistaRepository;

	public UsuarioLogeado comprobar(Credenciales credenciales) {
		Contratista contratista = contratistaRepository.findByDocumento(credenciales.getDocumento()).get();
		// Verificar que venga un contratista desde base de datos
		if (contratista != null) {
			// Verificar que el contratista que viene de base de datos sea igual al enviado
			// en el body del login
			if (contratista.getDocumento().equals(credenciales.getDocumento())&& contratista.getPassword().equals(credenciales.getPassword())) {
				// Se crea el objeto que va a responder el método login
				UsuarioLogeado respuesta = new UsuarioLogeado(contratista.getDocumento(), contratista.getNombre(),
						contratista.getRol(), contratista.getEstadoContratista());
				return respuesta;
			} else {
				return null;

			}
		} else {
			return null;
		}
	}
}
