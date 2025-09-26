public class Expresiones {

    static class InvalidChoiceException extends Exception {
        public InvalidChoiceException(String mensaje) {
            super(mensaje);
        }
    }

    static class AttackMissedException extends Exception {
        public AttackMissedException(String mensaje) {
            super(mensaje);
        }
    }
}

