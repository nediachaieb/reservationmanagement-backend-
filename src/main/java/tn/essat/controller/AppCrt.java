package tn.essat.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.essat.dao.IAdherant;
import tn.essat.dao.IAdministrateur;
import tn.essat.dao.IReservation;
import tn.essat.dao.ITerrain;
import tn.essat.dao.IUserDao;
import tn.essat.model.Adherant;
import tn.essat.model.Reservation;
import tn.essat.model.Terrain;



@CrossOrigin("*")
@RestController
@RequestMapping("/back")

public class AppCrt {
	   @Autowired
	    private IAdherant dao_adherant;

	    @Autowired
	    private IAdministrateur dao_admin;

	    @Autowired
	    private IReservation dao_reservation;

	    @Autowired
	    private ITerrain dao_terrain;
	    
	    @Autowired
		IUserDao dao_user;

	    // ********   api Terrain ***********

	    @GetMapping("/terrains")
	    public List<Terrain> getAllTerrains() {
	        return dao_terrain.findAll();
	    }
	    
	    
	    
	    @GetMapping("/terrains/{id}")
		public Terrain terrainById(@PathVariable int id) {

			Optional<Terrain> terrain = dao_terrain.findById(id);

			if (terrain.isPresent()) {
				return terrain.get();
			} else {
				return null;
			}
		}
	    
	    
	    @PostMapping("/addTerrains")
	    public Terrain addTerrain(@RequestBody Terrain terrain) {
	        return dao_terrain.save(terrain);
	    }

	    
	    @DeleteMapping("/terrains/{id}")
	    public void deleteTerrain(@PathVariable int id) {
	    	dao_terrain.deleteById(id);
	    }

	 // ********   api Adherant ***********

	    @GetMapping("/adherants")
	    public List<Adherant> getAllAdherants() {
	        return dao_adherant.findAll();
	    }
	    
	    
	    @GetMapping("/adherants/{id}")
		public Adherant adherantById(@PathVariable int id) {

			Optional<Adherant> adherant = dao_adherant.findById(id);

			if (adherant.isPresent()) {
				return adherant.get();
			} else {
				return null;
			}
		}
	    
	    
	    
	    @PostMapping("/addAdherant")
	    public Adherant addAdherant(@RequestBody Adherant adherant) {
	        return dao_adherant.save(adherant);
	    }

	    
	    
	    @DeleteMapping("/adherants/{id}")
	    public void deleteAdherant(@PathVariable int id) {
	    	dao_adherant.deleteById(id);
	    }

	    // ********   api reservation ***********


	    @GetMapping("/reservations")
	    public List<Reservation> getAllReservations() {
	        return dao_reservation.findAll();
	    }
	    
	    
	    @GetMapping("/reservations/{id}")
		public Reservation reservationById(@PathVariable int id) {

			Optional<Reservation> reservation = dao_reservation.findById(id);

			if (reservation.isPresent()) {
				return reservation.get();
			} else {
				return null;
			}
		}
	    
	  
	    
	    @PostMapping("/addReservation")
	    public Reservation addReservation(@RequestBody Reservation reservation) {
	        return dao_reservation.save(reservation);
	    }

	    @DeleteMapping("/reservations/{id}")
	    public void deleteReservation(@PathVariable int id) {
	    	dao_reservation.deleteById(id);
	    }
	  
}
