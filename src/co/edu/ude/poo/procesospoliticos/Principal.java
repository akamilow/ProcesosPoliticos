package co.edu.ude.poo.procesospoliticos;

import co.edu.ude.poo.procesospoliticos.modelo.entidades.ApoderadoMesa;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.Candidato;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.Ciudadano;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.Comuna;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.LocalVotacion;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.MesaVotacion;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.Partido;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.VocalMesa;
import co.edu.ude.poo.procesospoliticos.modelo.entidades.Voto;

import java.util.ArrayList;
import java.util.Date;

import co.edu.ude.poo.procesospoliticos.modelo.crud.ApoderadoMesaCrud;
import co.edu.ude.poo.procesospoliticos.modelo.crud.CandidatoCrud;
import co.edu.ude.poo.procesospoliticos.modelo.crud.CiudadanoCrud;
import co.edu.ude.poo.procesospoliticos.modelo.crud.ComunaCrud;
import co.edu.ude.poo.procesospoliticos.modelo.crud.LocalVotacionCrud;
import co.edu.ude.poo.procesospoliticos.modelo.crud.MesaVotacionCrud;
import co.edu.ude.poo.procesospoliticos.modelo.crud.PartidoCrud;
import co.edu.ude.poo.procesospoliticos.modelo.crud.VocalMesaCrud;
import co.edu.ude.poo.procesospoliticos.modelo.crud.VotoCrud;

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
        
        ApoderadoMesa apoderado1 = new ApoderadoMesa(ciudadano1, 001);
        ApoderadoMesa apoderado2 = new ApoderadoMesa(ciudadano2, 002);
        ArrayList<ApoderadoMesa> apoderados1 = new ArrayList<ApoderadoMesa>();
        apoderados1.add(apoderado1);
        apoderados1.add(apoderado2);

        ApoderadoMesa apoderado3 = new ApoderadoMesa(ciudadano3, 003);
        ApoderadoMesa apoderado4 = new ApoderadoMesa(ciudadano4, 004);
        ArrayList<ApoderadoMesa> apoderados2 = new ArrayList<ApoderadoMesa>();
        apoderados2.add(apoderado3);
        apoderados2.add(apoderado4);

        VocalMesa vocal1 = new VocalMesa(ciudadano3, 01, "Presidente");
        VocalMesa vocal2 = new VocalMesa(ciudadano4, 02, "Secretario");

        LocalVotacion local1 = new LocalVotacion(comuna1,"Colegio San Juan");
        LocalVotacion local2 = new LocalVotacion(comuna2, "Colegio San Pedro");

        Candidato candidato1 = new Candidato(ciudadano5, partido1, comuna1, "Alcalde");
        Candidato candidato2 = new Candidato(ciudadano6, partido2, comuna2, "Senador");

        MesaVotacion mesa1 = new MesaVotacion(1,"Femenino", 100, true, local1, vocal1, apoderados1);
        MesaVotacion mesa2 = new MesaVotacion(2,"Masculino", 200, true, local2, vocal2, apoderados2);

        Voto voto = new Voto(ciudadano4, candidato1, new Date());

        
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

        try {
            System.out.println(ciudadanoCrud.contarCiudadanos());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(ciudadanoCrud.buscarCiudadano(1001));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
            ciudadanoCrud.actualizarCiudadano(ciudadano1, ciudadano9);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            ciudadanoCrud.eliminarCiudadano(1009);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(ciudadanoCrud.listarCiudadanos());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
        //CRUD Partido
        PartidoCrud partidoCrud = new PartidoCrud();

        try {
            partidoCrud.agregarPartido(partido1);
            partidoCrud.agregarPartido(partido2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(partidoCrud.contarPartidos());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        
        try {
            System.out.println(partidoCrud.buscarPartido("Parido liberal"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            partidoCrud.actualizarPartido(partido1.getNombrePartido(), partido3.getNombrePartido());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
            partidoCrud.eliminarPartido(partido3.getNombrePartido());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
            System.out.println(partidoCrud.listarPartidos());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        

        //CRUD Comuna
        ComunaCrud comunaCrud = new ComunaCrud();

        try {
            comunaCrud.agregarComuna(comuna1);
            comunaCrud.agregarComuna(comuna2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(comunaCrud.contarComunas());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        
        try {
            System.out.println(comunaCrud.buscarComuna("Cali"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            comunaCrud.actualizarComuna(comuna1.getComuna(), comuna2.getComuna());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            comunaCrud.eliminarComuna(comuna2.getComuna());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(comunaCrud.listarComunas());
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
            System.out.println(candidatoCrud.contarCandidatos());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        try {
            System.out.println(candidatoCrud.buscarCandidato(1004));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            candidatoCrud.actualizarCandidato(ciudadano5, partido3, comuna2, "Gobernador");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            candidatoCrud.eliminarCandidato(1005);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(candidatoCrud.listarCandidatos());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        //CRUD ApoderadoMesa
        ApoderadoMesaCrud apoderadoMesaCrud = new ApoderadoMesaCrud();

        try {
            apoderadoMesaCrud.agregarApoderadoMesa(apoderado1);
            apoderadoMesaCrud.agregarApoderadoMesa(apoderado2);
            apoderadoMesaCrud.agregarApoderadoMesa(apoderado3);
            apoderadoMesaCrud.agregarApoderadoMesa(apoderado4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(apoderadoMesaCrud.contarApoderados());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(apoderadoMesaCrud.buscarApoderadoMesa(001));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            apoderadoMesaCrud.actualizarApoderadoMesa(apoderado1, apoderado2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            apoderadoMesaCrud.eliminarApoderadoMesa(1001);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(apoderadoMesaCrud.listarApoderados());
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
            System.out.println(vocalMesaCrud.contarVocales());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(vocalMesaCrud.buscarVocalMesa(01));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            vocalMesaCrud.actualizarVocalMesa(ciudadano3, 03, "Vocal de mesa SUPLENTE");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            vocalMesaCrud.eliminarVocalMesa(1003);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(vocalMesaCrud.listarVocales());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        //CRUD LocalVotacion
        LocalVotacionCrud localVotacionCrud = new LocalVotacionCrud();

        try {
            localVotacionCrud.agregarLocalVotacion(local1);
            localVotacionCrud.agregarLocalVotacion(local2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(localVotacionCrud.contarLocalVotaciones());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(localVotacionCrud.buscarLocalVotacion("Colegio San Juan"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            localVotacionCrud.actualizarLocalVotacion(local1, local2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            localVotacionCrud.eliminarLocalVotacion("Colegio San Juan");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //CRUD MesaVotacion
        MesaVotacionCrud mesaVotacionCrud = new MesaVotacionCrud();

        try {
            mesaVotacionCrud.agregarMesaVotacion(mesa1);
            mesaVotacionCrud.agregarMesaVotacion(mesa2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            mesaVotacionCrud.contarMesas();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(mesaVotacionCrud.buscarMesaVotacion(1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            mesaVotacionCrud.actualizarMesaVotacion(1, mesa2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            mesaVotacionCrud.eliminarMesaVotacion(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(mesaVotacionCrud.listarMesas());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //CRUD Voto
        VotoCrud votoCrud = new VotoCrud();

        try {
            votoCrud.agregarVoto(voto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            votoCrud.contarVotos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(votoCrud.buscarVoto(1004));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            votoCrud.actualizarVoto(voto, voto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
            votoCrud.eliminarVoto(1004);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(votoCrud.listarVotos());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
