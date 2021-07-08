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
	@Autowired
	ContratistaRepository contratistaRepository;

	public UsuarioLogeado comprobar(Credenciales credenciales) {
		Contratista contratista = contratistaRepository.findByDocumento(credenciales.getDocumento()).get();

		if (contratista != null) {
			if (contratista.getDocumento().equals(credenciales.getDocumento())) {
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
