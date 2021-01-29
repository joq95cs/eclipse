package edd;

import java.util.ArrayList;

import java.util.Scanner;

public class Prueba_ArrayList_2 {
    
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        ArrayList <Manga> mangas = new ArrayList <Manga>();
        
        Manga ranma_medio = new Manga("Ranma 1/2", "Rumiko Takahashi", "Shonen", (short)1);
        
        Manga sailor_moon = new Manga("Sailor Moon", "Naoko Takeuchi", "Shojo", (short)5);
        
        Manga dragon_ball = new Manga("Dragon Ball", "Akira Toriyama", "Shonen", (short)42);
        
        Manga cc_sakura = new Manga("Cardcaptor Sakura", "CLAMP", "Shojo", (short)2);
        
        mangas.add(ranma_medio);
        
        mangas.add(sailor_moon);
        
        mangas.add(dragon_ball);
        
        mangas.remove(sailor_moon);
        
        mangas.set(0, cc_sakura);
        
        for(int i=0; i<mangas.size(); i++) {
            
            System.out.println("MANGA " + (i+1) + "\n");
            
            System.out.println(mangas.get(i).muestraAtributos() + "\n");
            
        }
        
    }
    
}

class Manga {
    
    public Manga(String nombre, String autor, String genero, short no_tomo) {
        
        this.nombre = nombre;
        
        this.autor = autor;
        
        this.genero = genero;
        
        this.no_tomo = no_tomo;
        
    }
    
    public String muestraAtributos() {
        
        return "Nombre: " + nombre + "\nAutor: " + autor + "\nNo_tomo: " + no_tomo
                + "\nGénero: " + genero;
        
    }
    
    private String nombre;
    
    private String autor;
    
    private short no_tomo;
    
    private String genero;
    
}
