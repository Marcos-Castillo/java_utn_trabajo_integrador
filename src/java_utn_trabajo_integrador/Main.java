package java_utn_trabajo_integrador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Resultado> resultados = leerResultados("resultados.csv");
        List<Pronostico> pronosticos = leerPronosticos("pronostico.csv");

        Map<String, Integer> puntosPorPronostico = new HashMap<>();
        for (Pronostico pronostico : pronosticos) {
            String equipo1 = pronostico.getPartido().getEquipoLocal().getNombre();
            String equipo2 = pronostico.getPartido().getEquipoVisitante().getNombre();
            int puntos = calcularPuntos(pronostico, resultados);
            puntosPorPronostico.put(equipo1 + " vs " + equipo2, puntos);
        }

        System.out.println("Puntos por pronóstico:");
        for (Map.Entry<String, Integer> entry : puntosPorPronostico.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " puntos");
        }
    }

    private static List<Resultado> leerResultados(String archivo) {
        List<Resultado> resultados = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                String equipo1 = campos[0].trim();
                int goles1 = Integer.parseInt(campos[1].trim());
                int goles2 = Integer.parseInt(campos[2].trim());
                String equipo2 = campos[3].trim();
                Resultado resultado = new Resultado(new Equipo(equipo1), goles1, new Equipo(equipo2), goles2);
                resultados.add(resultado);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultados;
    }

    private static List<Pronostico> leerPronosticos(String archivo) {
        List<Pronostico> pronosticos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String[] equipos = br.readLine().split(",");
            String[] resultados = br.readLine().split(",");
            for (int i = 0; i < equipos.length; i++) {
                String equipo1 = equipos[i].trim();
                String equipo2 = equipos[++i].trim();
                String resultado = resultados[i / 2].trim();
                Pronostico pronostico = new Pronostico(new Partido(new Equipo(equipo1), new Equipo(equipo2), null),
                        ResultadoEnum.valueOf(resultado));
                pronosticos.add(pronostico);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pronosticos;
    }

private static int calcularPuntos(Pronostico pronostico, List<Resultado> resultados) {
  /*  Partido partido = pronostico.getPartido();
    ResultadoEnum resultadoPronostico = pronostico.getResultado();

    for (Resultado resultado : resultados) {
        Partido partidoResultado = new Partido(resultado.getEquipo2(), resultado.getEquipo2(),
                resultado.getGolesEquipo1(), resultado.getEquipo2());
        if (partidoResultado.equals(partido)) {
            ResultadoEnum resultadoReal = resultado.getGolesEquipo1() > resultado.getEquipo2()
                    ? ResultadoEnum.GANA_1
                    : resultado.getGolesEquipo1() < resultado.getEquipo2()
                            ? ResultadoEnum.GANA_2
                            : ResultadoEnum.EMPATE;
            if (resultadoPronostico == resultadoReal) {
                return resultadoPronostico.getPuntos();
            }
        }
    }*/

    return 0;
}
}
	