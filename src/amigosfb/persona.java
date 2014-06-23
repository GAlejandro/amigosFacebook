/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package amigosfb;

import java.util.ArrayList;

/**
 *
 * @author gus_958
 */
public class persona {
    
    String nombre = "";
    ArrayList<persona> amigos;
    int id = 0;
    
    persona(String name, int ide){
        amigos = new ArrayList<persona>();
        id = ide;
        nombre = name;
    }
    
    public int getId(){
        return id;
    }
    
    public ArrayList<persona> getAmigos(){
        return amigos;
    }
    
    public void addAmigo1(persona p){
        if(!amigos.contains(p) && (p.getId()) != id){
            amigos.add(p);
            p.addAmigo2(p);
        }
    }
    
    public void addAmigo2(persona p){
        if(!amigos.contains(p)){
            amigos.add(p);
        }
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    void agregarAmigo(persona p){
        amigos.add(p);
    }
    
    void eliminarAmigo(int n){
        amigos.remove(n);
    }
    
    persona obtenerAmigo(int n){
        if(n < amigos.size())
            return amigos.get(n);
        else
            return null;
    }
    
}
