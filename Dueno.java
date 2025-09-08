public class Dueno {
        private long id;
        private String nombreCompleto;
        private String telefono;
        private String email;
        private String direccion;
        private Paciente[] mascotas;

        /*
         * Getters y Setters
         */
        public long getId() { return id; }
        public void setId(long id) { this.id = id; }

        public String getnombreCompleto() { return nombreCompleto; }
        public void setnombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

        public String getTelefono() { return telefono; }
        public void setTelefono(String telefono) { this.telefono = telefono; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getDireccion() { return direccion; }
        public void setDireccion(String direccion) { this.direccion = direccion; }

        public Paciente[] getMascotas() { return mascotas; }
        public void setMascotas(Paciente[] mascotas) { this.mascotas = mascotas; }

        public void actualizarTelefono(String telefono) {
            this.telefono = telefono;
        }

        public void actualizarEmail(String email) {
            this.email = email;
        }

        // Constructor completo
        public Dueno(long id, String nombreCompleto, String telefono, String email, String direccion) {
            this.id = id;
            setnombreCompleto(nombreCompleto);
            setTelefono(telefono);
            setEmail(email);
            setDireccion(direccion);
            this.mascotas = new Paciente[2];// se  inicializa aqui para las mascotas
        }

        // Constructor reducido (valores por defecto)
        public Dueno(long id, String nombreCompleto, String telefono) {
            this(id, nombreCompleto, telefono, null, "Sin dirección");
        }

        //Metodo resumen
        public String resumen() {
            return "Dueño #" + id + " | " + nombreCompleto + " | Mascotas: " +
                    (mascotas != null ? mascotas.length : 0);
        }

        //Metodo asignar una mascota
        // index >= 0 && index < mascotas.length se asegura que el indice este dentro d elos limites validos del arreglo
        public void agregarMascota(Paciente mascota, int index) {
            if (mascotas != null && index >= 0 && index < mascotas.length) {
                this.mascotas[index] = mascota;
            }
        }
    }


