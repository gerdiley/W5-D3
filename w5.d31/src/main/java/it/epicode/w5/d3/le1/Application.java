package it.epicode.w5.d3.le1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Realizzare un'app che consente di inviare messaggi dagli utenti
//Un Messaggio ha  id, testo, data, user_id
//Un Utente ha id, nickname (senza spazi)
//
//Costruisci l'apposita struttura in modo che:
///api/message/1   -> stampi i dati del messaggio
///api/user/bluerock/messages  -> stampi tutti i messaggi dell'utente con nickname 'bluerock'
//

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
