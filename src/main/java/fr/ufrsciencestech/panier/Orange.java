package fr.ufrsciencestech.panier;

public class Orange extends Fruit{

     public Orange(double p, String o) {
        super(p, o);
     }


        
        @Override
        public String toString(){
            return "orange venant de "+origine+" et coûtant "+prix+" euros";
        }
}