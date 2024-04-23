package co.edu.ude.poo.procesospoliticos;


import co.edu.ude.poo.procesospoliticos.modelo.entidades.Candidato;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.Ciudadano;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.Comuna;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.Partido;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.VocalMesa;
import co.edu.ude.poo.procesospoliticos.modelo.crud.CandidatoCrud;
import co.edu.ude.poo.procesospoliticos.modelo.crud.CiudadanoCrud;
import co.edu.ude.poo.procesospoliticos.modelo.crud.VocalMesaCrud;


public class Principal {
    
    public static void main(String[] args) {
        Partido partido1 = new Partido("Partido liberal");
        Partido partido2 = new Partido("Partido conservador");
        Partido partido3 = new Partido("Partido verde");

        Comuna comuna1 = new Comuna("Cali");
        Comuna comuna2 = new Comuna("Bogota");
        
        Ciudadano ciudadano1 = new Ciudadano(1001, 25, "Juan Perez", "Masculino");
        Ciudadano ciudadano2 = new Ciudadano(1002, 30, "Maria Gonzales", "Femenino");
        Ciudadano ciudadano3 = new Ciudadano(1003, 55, "Santiago Montoya", "Masculino");
        Ciudadano ciudadano4 = new Ciudadano(1004, 20, "Camilo Castellar", "Masculino");
        Ciudadano ciudadano5 = new Ciudadano(1005, 40, "Luisa Osorio", "Femenino");
        Ciudadano ciudadano6 = new Ciudadano(1006, 35, "Andres Escobar", "Masculino");
        Ciudadano ciudadano7 = new Ciudadano(1007, 24, "Daniela Guzman", "Femenino");
        Ciudadano ciudadano8 = new Ciudadano(1008, 60, "Pablo Ramirez", "Masculino");
        Ciudadano ciudadano9 = new Ciudadano(1009, 28, "Dilan Mercado", "Masculino");
        
        VocalMesa vocal1 = new VocalMesa(ciudadano1, 01, "Presidente");
        VocalMesa vocal2 = new VocalMesa(ciudadano2, 02, "Secretario");
        VocalMesa vocal3 = new VocalMesa(ciudadano3, 03, "Tesorero");

        Candidato candidato1 = new Candidato(ciudadano5, partido1, comuna1, "Alcalde");
        Candidato candidato2 = new Candidato(ciudadano6, partido2, comuna2, "Senador");
        Candidato candidato3 = new Candidato(ciudadano7, partido3, comuna1, "Gobernador");


        // CRUD Ciudadano
        CiudadanoCrud ciudadanoCrud = new CiudadanoCrud();

        try {
            ciudadanoCrud.agregarCiudadano(ciudadano1);
            ciudadanoCrud.agregarCiudadano(ciudadano2);
            ciudadanoCrud.agregarCiudadano(ciudadano3);
            ciudadanoCrud.agregarCiudadano(ciudadano4);
            ciudadanoCrud.agregarCiudadano(ciudadano5);
            ciudadanoCrud.agregarCiudadano(ciudadano6);
            ciudadanoCrud.agregarCiudadano(ciudadano7);
            ciudadanoCrud.agregarCiudadano(ciudadano8);
            ciudadanoCrud.agregarCiudadano(ciudadano9);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //CRUD Candidato
        CandidatoCrud candidatoCrud = new CandidatoCrud();

        try {
            candidatoCrud.agregarCandidato(candidato1);
            candidatoCrud.agregarCandidato(candidato2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

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
        
    
        //CRUD VocalMesa
        VocalMesaCrud vocalMesaCrud = new VocalMesaCrud();

        try {
            vocalMesaCrud.agregarVocalMesa(vocal1);
            vocalMesaCrud.agregarVocalMesa(vocal2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            vocalMesaCrud.actualizarVocalMesa(vocal1, vocal3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(vocalMesaCrud.listarVocales());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
