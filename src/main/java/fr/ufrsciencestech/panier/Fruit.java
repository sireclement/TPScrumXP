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
public class Fruit {
    	double prix;
	String origine;

	public Fruit(double p, String o){
		if(p>=0){
			this.prix=p;
			this.origine=o;
		}
		else
			System.out.println("Insérez un prix positif pour l'orange du marchand. UI, on a aussi homme et petit garçon à l'étage.");
	}	
	
	public double getPrix(){
		return this.prix;		
	}
	
	public String getOrigine(){
		return this.origine;	
	}
        
        public void setPrix(double p){
            this.prix=p;
        }
        
        public void setOrigine(String o){
            this.origine=o;
        }

        
        @Override
        public String toString(){
            return "fruit venant de "+origine+" et coûtant "+prix+" euros";
        }
}
