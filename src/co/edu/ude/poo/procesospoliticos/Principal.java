package co.edu.ude.poo.procesospoliticos;

import co.edu.ude.poo.procesospoliticos.vistas.gui.VentanaPrincipal;

import co.edu.ude.poo.procesospoliticos.modelo.entidades.Candidato;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.Ciudadano;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.Comuna;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.Partido;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.VocalMesa;
import co.edu.ude.poo.procesospoliticos.modelo.crud.CandidatoCrud;
import co.edu.ude.poo.procesospoliticos.modelo.crud.CiudadanoCrud;
import co.edu.ude.poo.procesospoliticos.modelo.crud.ComunaCrud;
import co.edu.ude.poo.procesospoliticos.modelo.crud.VocalMesaCrud;
import co.edu.ude.poo.procesospoliticos.modelo.crud.PartidoCrud;


public class Principal {
    
    public static void main(String[] args) {
        
        /*
        VentanaPrincipal v1 = new VentanaPrincipal();
        v1.setLocationRelativeTo(null);
        //v1.setExtendedState(VentanaPrincipal.MAXIMIZED_BOTH);
        v1.setVisible(true);
        */
        
        Partido partido1 = new Partido(1, "Partido liberal");
        Partido partido2 = new Partido(2, "Partido conservador");

        // CRUD Partido
        PartidoCrud partido = new PartidoCrud();

        try {
            partido.agregarPartido(1, partido1);
            partido.agregarPartido(2, partido2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Comuna comuna1 = new Comuna("Cali");
        Comuna comuna2 = new Comuna("Bogota");

        // CRUD Comuna
        ComunaCrud comuna = new ComunaCrud();

        try {
            comuna.agregarComuna(comuna1);
            comuna.agregarComuna(comuna2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        Ciudadano ciudadano1 = new Ciudadano(1001, 25, "Juan Perez", "Masculino");
        Ciudadano ciudadano2 = new Ciudadano(1002, 30, "Maria Gonzales", "Femenino");
        Ciudadano ciudadano3 = new Ciudadano(1004, 20, "Camilo Castellar", "Masculino");

        // CRUD Ciudadano
        CiudadanoCrud ciudadanoCrud = new CiudadanoCrud();

        try {
            ciudadanoCrud.agregarCiudadano(ciudadano1);
            ciudadanoCrud.agregarCiudadano(ciudadano2);
            ciudadanoCrud.agregarCiudadano(ciudadano3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        Candidato candidato1 = new Candidato(ciudadano1, partido1, comuna1, "Alcalde");
        Candidato candidato2 = new Candidato(ciudadano2, partido2, comuna2, "Senador");

        //CRUD Candidato
        CandidatoCrud candidatoCrud = new CandidatoCrud();

        try {
            candidatoCrud.agregarCandidato(candidato1);
            candidatoCrud.agregarCandidato(candidato2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /*
        try {
            candidatoCrud.actualizarCandidato(candidato1, candidato3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(candidatoCrud.listarCandidatos());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        */
        
    }
}
