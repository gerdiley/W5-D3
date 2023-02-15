package it.epicode.w5.d3.le1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.w5.d3.le1.entities.Utente;
import it.epicode.w5.d3.le1.repositories.UtenteRepo;

@Service
public class UtenteSrv {
	
	@Autowired
	UtenteRepo ur;
	
	public Utente save(Utente u) {
		return ur.save(u);
	}
}
