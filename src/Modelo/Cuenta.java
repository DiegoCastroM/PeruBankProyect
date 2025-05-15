package Modelo;

public class Cuenta {
        private int id;
        private String tipo;
        private double saldo;
        private double limite; // Solo para algunos tipos
        // Getters y setters básicos
        // ...

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public double getSaldo() {
            return saldo;
        }

        public void setSaldo(double saldo) {
            this.saldo = saldo;
        }

        public double getLimite() {
            return limite;
        }

        public void setLimite(double limite) {
            this.limite = limite;
        }
    }

