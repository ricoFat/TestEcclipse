package uqam.note;

import java.awt.HeadlessException;

import javax.swing.JOptionPane;

public  class Table {
  
 // declararion des variables 
	private int nombreEtudiant;
	private double tabNotes[];
	private String tabNom[];
	private double totalNotes ;
	private double noteMoinsEleve;
	private double notePlusEleve;
	private String meilleurEtudiant;
	private String moinsBonEtudiant;
	
	// constructeur sans parametres 
	
	public Table (){
		nombreEtudiant = 0;
		totalNotes = 0;
		noteMoinsEleve = 0;
		notePlusEleve = 0;
		meilleurEtudiant = "";
		moinsBonEtudiant = "";
				
	}
	
	public void lireNombreEtudiant(){
	try {
		nombreEtudiant = Integer.parseInt(JOptionPane.showInputDialog(" Entrez le nombre " + 
		                                         "d'�tudiants inscrit au cours: "));
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		System.out.println("Erreur d'entr�e ");
		e.printStackTrace();
	} catch (HeadlessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	tabNotes = new double [nombreEtudiant];
	tabNom = new String [nombreEtudiant];
		
	}
	// lire les noms et notes 
	public void lireNotes() {
		
		for(int i = 0; i < tabNotes.length ; i++){
			 try {
				tabNom [i]= JOptionPane.showInputDialog("Entrez le nom de l'�tudiant "+ (i+1)+ ": ");
				tabNotes [i]= Double.parseDouble(JOptionPane.showInputDialog("Entrez la note de " + 
				                       tabNom[i] + ": "));
			} catch (HeadlessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 totalNotes = totalNotes + tabNotes[i];
		}
	}
	
	public double moyenne (){
		
	return totalNotes/nombreEtudiant;	
	}
	
	public void dernierEtudiant(){
		
		for(int i = 0 ; i< tabNotes.length ; i++){
			if (tabNotes[i] < noteMoinsEleve){
				noteMoinsEleve = tabNotes[i];
				moinsBonEtudiant = tabNom[i];
			}		
		}
		System.out.println(" "+ moinsBonEtudiant + " a la plus basse note de " + noteMoinsEleve );
	}
		
		public void meilleurEtudiant(){
			
			for(int i = 0 ; i< tabNotes.length ; i++){
				if (tabNotes[i] > notePlusEleve){
				notePlusEleve =	tabNotes[i];
				meilleurEtudiant = tabNom[i];
				}
				
			}
			noteMoinsEleve =  notePlusEleve;
			System.out.println(" " + meilleurEtudiant + " a la plus haute note de " + notePlusEleve);
	}
		
		public void afficherMoyenne(){
			System.out.println(" La moyenne de la classe est: " + moyenne());
		}

	public static void main(String[] args) {

		Table classe = new Table();
		classe.lireNombreEtudiant();
		classe.lireNotes();
		classe.meilleurEtudiant();
		classe.dernierEtudiant();
		classe.afficherMoyenne();
	}

}
