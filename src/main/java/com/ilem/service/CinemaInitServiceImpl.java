package com.ilem.service;
import com.ilem.Entities.*;
import com.ilem.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
public class CinemaInitServiceImpl implements ICinemaInitService {
    @Autowired
    private VilleRepository villeRepository;
    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private SalleRepository salleRepository;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private SeanceRepository seanceRepository;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private ProjectionRepository projectionRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private CategorieRepository categorieRepository;

//    @Override
//    public void initVilles() {
//        Stream.of("Casa","Marrakech","Rabat","Tanger").forEach(nameVille->{
//            Ville ville=new Ville();
//            ville.setName(nameVille);
//            villeRepository.save(ville);
//        });
//    }

//    @Override
//    public void initCinemas() {
//villeRepository.findAll().forEach(v->{
//    Stream.of("Megarama","Imax","Pathé")
//            .forEach(nameCinema->{
//                Cinema cinema=new Cinema();
//                cinema.setName(nameCinema);
//                cinema.setNombreSalles(3);
//                cinema.setVille(v);
//                cinemaRepository.save(cinema);
//            });
//});
//    }

//    @Override
//    public void initSalles() {
//cinemaRepository.findAll().forEach(cinema->{
//    for(int i=0;i<cinema.getNombreSalles();i++){
//        Salle salle=new Salle();
//
//        salle.setName("Salle"+(i+1));
//        salle.setCinema(cinema);
//        salle.setNombrePlaces(3);
//        salleRepository.save (salle);
//
//    }
//
//    });
//
//}

//    @Override
//    public void initPlaces() {
//salleRepository.findAll().forEach(salle->{
//    for(int i=0;i<salle.getNombrePlaces();i++){
//        Place place=new Place();
//        place.setNumero(i+1);
//        place.setSalle(salle);
//        placeRepository.save(place);
//    }
//});
//    }

//    @Override
//    public void initSeances() {
//        DateFormat dateFormat=new SimpleDateFormat("HH:mm");
//Stream.of("11:00","13:00","16:00","19:00","21:00").forEach(s->{
//    Seance seance=new Seance();
//    try {
//        seance.setHeureDebut(dateFormat.parse(s));
//        seanceRepository.save(seance);
//    } catch (ParseException e) {
//        throw new RuntimeException(e);
//    }
//});
//    }

//    @Override
//    public void initCategories() {
//Stream.of("Action","Fiction","Comédie","Drama").forEach(c->{
//   Categorie categorie=new Categorie();
//   categorie.setName(c);
//   categorieRepository.save(categorie);
//});
//    }

//    @Override
//    public void initFilms() {
//        Double[] durees=new Double[] {1.0,1.5,2.0,2.5,3.0};
//        List<Categorie> categories = categorieRepository.findAll();
//Stream.of("Harry Poter and the chamber of secrets","Iron Man","Lord of Rings","SpiderMan","Cat Woman").forEach(titreFilm->{
//    Film film=new Film();
//    film.setTitre(titreFilm);
//    film.setDuree(durees[new Random().nextInt(durees.length)]);
//    film.setPhoto(titreFilm.replaceAll(" ",""));
//   //film.setCategorie(categories.get(0));
//    filmRepository.save(film);
//});
//    }

    @Override
    public void initProjections() {
        double[] prix = new double[] {30,100,50,70,90};
        List<Film> films = filmRepository.findAll();
villeRepository.findAll().forEach(ville->{
    ville.getCinemas().forEach(cinema->{
        cinema.getSalles().forEach(salle->{
            int index = new Random().nextInt(films.size());
            Film film = films.get(index);
                seanceRepository.findAll().forEach(seance -> {
                    Projection projection=new Projection();
                    projection.setDateProjection(new Date());
                    projection.setFilm(film);
                    projection.setPrix(prix[new Random().nextInt(prix.length)]);
                    projection.setSalle(salle);
                    projection.setSeance(seance);
                    projectionRepository.save(projection);
                });
            });
        });
    });

    }

//    @Override
//    public void initTickets() {
//projectionRepository.findAll().forEach(p->{
//   p.getSalle().getPlaces().forEach(place->{
//       Ticket ticket=new Ticket();
//       ticket.setPlace(place);
//       ticket.setPrix(p.getPrix());
//       ticket.setProjection(p);
//       ticket.setReserve(false);
//       ticketRepository.save(ticket);
//   });
//});
//    }
}
