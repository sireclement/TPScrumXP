/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier;

/**
 *
 * @author cs180183
 */
public class Banane extends Fruit {
    
     public Banane(double p, String o) {
        super(p, o);
     }


        
        @Override
        public String toString(){
            return "banane venant de "+origine+" et coûtant "+prix+" euros";
        }
}
