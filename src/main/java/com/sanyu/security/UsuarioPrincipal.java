package com.sanyu.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sanyu.entity.Contratista;
import com.sanyu.entity.Rol;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UsuarioPrincipal implements UserDetails {
	private Integer documento;
	private String password;
	private String nombre;
	private String telefono;
	private String estadoContratista;
	private Set<Rol> rol;
	private Collection<? extends GrantedAuthority> authorities;

	public UsuarioPrincipal(Integer documento, String password, String nombre, String telefono,
			String estadoContratista, Set<Rol> rol, Collection<? extends GrantedAuthority> authorities) {
		this.documento = documento;
		this.password = password;
		this.nombre = nombre;
		this.telefono = telefono;
		this.estadoContratista = estadoContratista;
		this.rol = rol;
		this.authorities = authorities;
	}

	public static UsuarioPrincipal build(Contratista usuario) {
		List<GrantedAuthority> authorities = usuario.getRol().stream()
				.map(rol -> new SimpleGrantedAuthority(rol.getNombreRol())).collect(Collectors.toList());
		return new UsuarioPrincipal(usuario.getDocumento(), usuario.getPassword(), usuario.getNombre(),
				usuario.getTelefono(), usuario.getEstadoContratista(), usuario.getRol(), authorities);
	}

	public Integer getDocumento() {
		return documento;
	}

	public void setDocumento(Integer documento) {
		this.documento = documento;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEstadoContratista() {
		return estadoContratista;
	}

	public void setEstadoContratista(String estadoContratista) {
		this.estadoContratista = estadoContratista;
	}

	public Set<Rol> getRol() {
		return rol;
	}

	public void setRol(Set<Rol> rol) {
		this.rol = rol;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getUsername() {
		return null;
	}

}