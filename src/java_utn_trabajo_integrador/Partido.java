package java_utn_trabajo_integrador;

public class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private ResultadoEnum resultado;

    public Partido(Equipo equipoLocal, Equipo equipoVisitante, ResultadoEnum resultado) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.resultado = resultado;
    }

    public Partido(Equipo equipo2, Equipo equipo22, ResultadoEnum golesEquipo1, Equipo equipo23) {
		// TODO Auto-generated constructor stub
	}

	public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public ResultadoEnum getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoEnum resultado) {
        this.resultado = resultado;
    }
}
