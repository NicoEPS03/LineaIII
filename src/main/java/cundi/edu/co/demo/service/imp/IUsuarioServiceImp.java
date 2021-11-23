package cundi.edu.co.demo.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cundi.edu.co.demo.entity.Usuario;
import cundi.edu.co.demo.exception.ArgumentRequiredException;
import cundi.edu.co.demo.exception.IntegridadException;
import cundi.edu.co.demo.exception.ModelNotFoundException;
import cundi.edu.co.demo.repository.IUsuarioRepo;
import cundi.edu.co.demo.service.IUsuarioService;
import org.springframework.security.core.GrantedAuthority;

@Service
public class IUsuarioServiceImp implements IUsuarioService, UserDetailsService{
	
	@Autowired
	private IUsuarioRepo repo;

	@Override
	public Page<Usuario> retornarPaginado(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario retonarPorId(Integer id) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardar(Usuario objeto) throws IntegridadException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(Usuario objeto) throws ArgumentRequiredException, ModelNotFoundException, IntegridadException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(int idObjeto) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repo.findOneByNick(username);		
		if(usuario == null)
			new UsernameNotFoundException("----Usuario no encontrado");
		
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority(usuario.getRol().getNombre()));
		
		UserDetails ud = new User(usuario.getNick(), usuario.getClave(), roles);
		return ud;
	}

}
