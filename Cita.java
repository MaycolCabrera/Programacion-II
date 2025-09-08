import java.time.LocalDateTime;

public class Cita {
        private long id;
        private Paciente paciente;
        private Dueno dueno;
        private LocalDateTime fecha;
        private String motivo;
        private EstadoCita estado;

        // Getters y Setters
        public long getId() { return id; }
        public void setId(long id) { this.id = id; }

        public Paciente getPaciente() { return paciente; }
        public void setPaciente(Paciente paciente) { this.paciente = paciente; }

        public Dueno getDueno() { return dueno; }
        public void setDueno(Dueno dueno) { this.dueno = dueno; }

        public LocalDateTime getFecha() { return fecha; }
        public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

        public String getMotivo() { return motivo; }
        public void setMotivo(String motivo) { this.motivo = motivo; }

        public EstadoCita getEstadoCita() { return estado; }
        public void setEstadoCita(EstadoCita estado) { this.estado = estado; }

        // Enum con los estados posibles
        public enum EstadoCita {
            PENDIENTE,
            ATENDIDA,
            CANCELADA,
            REAGENDADA
        }

        // Constructor completo
        public Cita(long id, Paciente paciente, Dueno dueno, LocalDateTime fecha, String motivo) {
            this.id = id;
            this.paciente = paciente;
            this.dueno = dueno;
            this.fecha = fecha;
            this.motivo = motivo;
            this.estado = EstadoCita.PENDIENTE;
        }

        // Constructor reducido (valores por defecto)
        public Cita(long id, Paciente paciente, Dueno dueno) {
            this(id, paciente, dueno, null, null);
        }

        // Métodos para cambiar el estado
        public void marcarAtendida() {
            if (estado == EstadoCita.PENDIENTE || estado == EstadoCita.REAGENDADA) {
                this.estado = EstadoCita.ATENDIDA;
            }
        }

        public void cancelar(String motivoCancelacion) {
            if (estado == EstadoCita.PENDIENTE || estado == EstadoCita.REAGENDADA) {
                this.estado = EstadoCita.CANCELADA;
                this.motivo = motivoCancelacion;
            }
        }

        public void reagendar(LocalDateTime nuevaFecha) {
            if (estado == EstadoCita.PENDIENTE || estado == EstadoCita.REAGENDADA) {
                if (nuevaFecha.isAfter(LocalDateTime.now())) {
                    this.fecha = nuevaFecha;
                    this.estado = EstadoCita.REAGENDADA;
                }
            }
        }

        // Método resumen
        public String resumen() {
            return "Cita #" + id +
                    " | Paciente: " + (paciente != null ? paciente.getNombre() : "sin asignar") +
                    " | Dueño: " + (dueno != null ? dueno.getnombreCompleto() : "sin asignar") +
                    " | Fecha: " + (fecha != null ? fecha.toString() : "sin fecha") +
                    " | Motivo: " + (motivo != null ? motivo : "no especificado") +
                    " | Estado: " + estado;
        }
    }