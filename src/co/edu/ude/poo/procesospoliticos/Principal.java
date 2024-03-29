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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Crear un objeto de la clase Ciudadano
        Ciudadano ciudadano = new Ciudadano(123456789, 25, "Juan Perez", "Masculino");
        System.out.println("-------------------------");
        System.out.println(ciudadano.toString());
        System.out.println("-------------------------");

        // Crear un objeto de la clase Comuna
        Comuna comuna = new Comuna("Santiago Centro");
        System.out.println("-------------------------");
        System.out.println(comuna.toString());
        System.out.println("-------------------------");

        // Crear un objeto de la clase LocalVotacion
        LocalVotacion localVotacion = new LocalVotacion("Santiago Centro", "Av. Libertador 1234");
        System.out.println("-------------------------");
        System.out.println(localVotacion.toString());
        System.out.println("-------------------------");

        // Crear un objeto de la clase Partido
        Partido partido = new Partido("Partido de la U");
        System.out.println("-------------------------");
        System.out.println(partido.toString());
        System.out.println("-------------------------");

        // Crear un objeto de la clase Candidato
        Candidato candidato = new Candidato(ciudadano, partido, comuna, "Senador");
        System.out.println("-------------------------");
        System.out.println(candidato.toString());
        System.out.println("-------------------------");

        // Crear un objeto de la clase VocalMesa
        VocalMesa vocalMesa = new VocalMesa(ciudadano, 1, "Vocal de mesa");
        System.out.println("-------------------------");
        System.out.println(vocalMesa.toString());
        System.out.println("-------------------------");

        // Crear un objeto de la clase ApoderadoMesa
        ApoderadoMesa apoderadoMesa = new ApoderadoMesa(ciudadano, 123456789);
        System.out.println("-------------------------");
        System.out.println(apoderadoMesa.toString());
        System.out.println("-------------------------");

        // Crear un objeto de la clase MesaVotacion
        MesaVotacion mesaVotacion = new MesaVotacion(1, "Masculino", 100, true, localVotacion, vocalMesa, new ArrayList<ApoderadoMesa>());
        System.out.println("-------------------------");
        System.out.println(mesaVotacion.toString());
        System.out.println("-------------------------");

        // Crear un objeto de la clase Voto
        Voto voto = new Voto(ciudadano, candidato, new Date());
        System.out.println("-------------------------");
        System.out.println(voto.toString());
        System.out.println("-------------------------");
    }
}
