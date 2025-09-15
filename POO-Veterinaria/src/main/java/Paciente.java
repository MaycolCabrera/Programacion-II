public class Paciente {

        private long id;
        private String nombre;
        private String especie;
        private String raza;
        private int edadMeses;
        private double pesoKg;

        /*
         * Getters
         * Setters
         */
        public long getId() { return id; }
        public void setId(long id) { this.id = id; }
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        public String getEspecie() { return especie; }
        public void setEspecie(String especie) { this.especie = especie; }
        public String getRaza() { return raza; }
        public void setRaza(String raza) { this.raza = raza; }
        public int getEdadMeses() { return edadMeses; }
        public void setEdadMeses(int edadMeses){ this.edadMeses = edadMeses; }
        public double getpesokg() { return pesoKg; }
        public void setpesoKg(double pesoKg){ this.pesoKg = pesoKg; }

        // Constructor Completo
        public Paciente(long id, String nombre, String especie, String raza, int edadMeses, double pesoKg) {
            this.id = id;
            this.nombre = nombre;
            this.especie = especie;
            this.raza = raza;
            this.edadMeses = edadMeses;
            this.pesoKg = pesoKg;
        }

        // Constructor con valores por defecto
        public Paciente(long id, String nombre, String especie) {
            this(id, nombre, especie, "mestizo", 1, 1.0);
        }

        public void actualizarPeso(double nuevoPeso){
            setpesoKg(nuevoPeso);
        }

        public void cumplirMes(){
            this.edadMeses++;
        }

        public boolean esCachorro() {
            return getEdadMeses() < 12;
        }

        //Metodo resumen
        public String resumen() {
            return "Paciente[" + id + "] " + nombre + " (" + especie + ", " + raza +
                    ", " + edadMeses + " meses, " + pesoKg + " kg)";
        };
}
