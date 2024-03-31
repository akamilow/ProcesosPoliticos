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

public class Principal {
    
    public static void main(String[] args) {
        
        Ciudadano ciudadano_candidato = new Ciudadano(123456789, 25, "Juan Perez", "Masculino");
        System.out.println("-------------------------");
        System.out.println(ciudadano_candidato.toString());
        System.out.println("-------------------------");

        
        Ciudadano ciudadano_vocal = new Ciudadano(987654321, 30, "Maria Lopez", "Femenino");
        System.out.println("-------------------------");
        System.out.println(ciudadano_vocal.toString());
        System.out.println("-------------------------");

        
        Ciudadano ciudadano_apoderado1 = new Ciudadano(123436433, 25, "Santaigo Lopez", "Masculino");
        System.out.println("-------------------------");
        System.out.println(ciudadano_apoderado1.toString());
        System.out.println("-------------------------");
        
        
        Ciudadano ciudadano_apoderado2 = new Ciudadano(430433643, 20, "Alfonso Guzman", "Masculino");
        System.out.println("-------------------------");
        System.out.println(ciudadano_apoderado2.toString());
        System.out.println("-------------------------");

        
        Ciudadano ciudadano = new Ciudadano(1401928928, 20, "Camilo", "Masculino");
        System.out.println("-------------------------");
        System.out.println(ciudadano.toString());
        System.out.println("-------------------------");


        Comuna comuna = new Comuna("Cartagena");
        System.out.println("-------------------------");
        System.out.println(comuna.toString());
        System.out.println("-------------------------");

        
        LocalVotacion localVotacion = new LocalVotacion(comuna.getComuna(), "Av. Libertador 1234");
        System.out.println("-------------------------");
        System.out.println(localVotacion.toString());
        System.out.println("-------------------------");

        
        Partido partido = new Partido("Partido de la U");
        System.out.println("-------------------------");
        System.out.println(partido.toString());
        System.out.println("-------------------------");

        
        Candidato candidato = new Candidato(ciudadano_candidato, partido, comuna, "Senador");
        System.out.println("-------------------------");
        System.out.println(candidato.toString());
        System.out.println("-------------------------");

        
        VocalMesa vocalMesa = new VocalMesa(ciudadano_vocal, 1, "Vocal de mesa");
        System.out.println("-------------------------");
        System.out.println(vocalMesa.toString());
        System.out.println("-------------------------");
        
        
        ApoderadoMesa apoderadoMesa1 = new ApoderadoMesa(ciudadano_apoderado1, 123456789);
        ApoderadoMesa apoderadoMesa2 = new ApoderadoMesa(ciudadano_apoderado2, 987654321);
        ArrayList<ApoderadoMesa> apoderadosMesa = new ArrayList<ApoderadoMesa>();
        apoderadosMesa.add(apoderadoMesa1);
        apoderadosMesa.add(apoderadoMesa2);
        System.out.println("-------------------------");
        System.out.println(apoderadoMesa1.toString());
        System.out.println(apoderadoMesa2.toString());
        System.out.println("-------------------------");
        
        
        MesaVotacion mesaVotacion = new MesaVotacion(1, "Masculino", 100, true, localVotacion, vocalMesa, apoderadosMesa);
        System.out.println("-------------------------");
        System.out.println(mesaVotacion.toString());
        System.out.println("-------------------------");
        
        
        Voto voto = new Voto(ciudadano, candidato, new Date());
        System.out.println("-------------------------");
        System.out.println(voto.toString());
        System.out.println("-------------------------");
    }
}
