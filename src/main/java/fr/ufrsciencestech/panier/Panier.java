package fr.ufrsciencestech.panier;

import java.util.ArrayList;

public class Panier{

	ArrayList<Orange> listOrange=new ArrayList<Orange>();
	int tailleMax;
	int taille=0;

	public Panier(int t){
		this.tailleMax=t;	
	}
	
	public void setTailleMax(int i){
		this.tailleMax=i;
	}
	
	public void setTaille(int i){
		this.taille=i;
	}
	
	public void setListOrange(Orange o, int i){
		this.listOrange.set(i,o);
	}
	
	public int getTailleMax(){
		return this.tailleMax;	
	}
	
	public int getTaille(){
		return this.taille;	
	}
	
	public Orange getListOrange(int i){
		return listOrange.get(i);	
	}
        
        public ArrayList<Orange> getOranges(){
            return this.listOrange;
        }
        
        public void setOranges(ArrayList<Orange> o){
            this.listOrange=o;
        }
        
        

	public boolean estPlein(){	
		if(getTailleMax()==getTaille())
			return true;
		else
			return false;
	}
	
	public boolean estVide(){
		if(getTaille()==0)
			return true;
		else
			return false;
	}
	
        public boolean ajoute(){
            	if(!estPlein()){
                    this.listOrange.add(new Orange(1,"France"));
                    setTaille(getTaille()+1);
                    return true;
		}
		else{
                    System.out.println("panier plein");
                    return false;	
		}
        }
        
	public boolean ajoute(Orange o){
		if(!estPlein()){
			this.listOrange.add(o);
			setTaille(getTaille()+1);
			return true;
		}
		else{
			System.out.println("panier plein");
			return false;	
		}
			
	}
	
	public void retire(){
		this.listOrange.remove(getTaille()-1);
		setTaille(getTaille()-1);
	}
	
	public double getPrix(){
		double prix=0;
		
		for(int i=0; i<getTaille(); i++)
			prix+=getListOrange(i).getPrix();
			
		return prix;	
	}
        
        @Override
        public String toString(){
            if(taille==0)
                return "Le panier est vide";
            else{
                String res="Le panier contient ";
                for(int i=0;i<taille;i++){
                    if(i==taille-1)
                        res+= "une "+getListOrange(i)+".";
                    else
                        res+= "une "+getListOrange(i)+", ";
                }
                return res;
            }
            
        }

}