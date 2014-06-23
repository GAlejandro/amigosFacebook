/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package amigosfb;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author gus_958
 */
public class algorithm {
    
    ArrayList<persona> personas;
    Random r = new Random();
    ArrayList<persona> amigos1;
    ArrayList<persona> amigos2;
    ArrayList<persona> amigosf;//amigosComun
    ArrayList<persona> amigost;//amigosComun
    ArrayList<persona> amigosc;//amigosAll
    ArrayList<persona> amigosct;//amigosAll
    ArrayList<persona> amigosct2;//amigosAll
    
    public algorithm(){
        personas = new ArrayList<persona>();
        amigos1 = new ArrayList<persona>();
        amigos2 = new ArrayList<persona>();
        amigosf = new ArrayList<persona>();
        amigost = new ArrayList<persona>();
        amigosc = new ArrayList<persona>();
        amigosct = new ArrayList<persona>();
        amigosct2 = new ArrayList<persona>();
    }
    
    void generarPersonas(int n){
        int k = 0;
        String name ="";
        for(int i = 0; i < n; i++){
            k = r.nextInt(2);
            if(k == 0){
                k = r.nextInt(10);
                if(k == 0)
                    name = "Marcela";
                if(k == 1)
                    name = "Sonia";
                if(k == 2)
                    name = "Stephanie";
                if(k == 3)
                    name = "Jeniffer";
                if(k == 4)
                    name = "Lorena";
                if(k == 5)
                    name = "Ashley";
                if(k == 6)
                    name = "Tania";
                if(k == 7)
                    name = "Norma";
                if(k == 8)
                    name = "Maryorie";
                if(k == 9)
                    name = "Manuela";
            }else{
                k = r.nextInt(10);
                if(k == 0)
                    name = "Gustavo";
                if(k == 1)
                    name = "Alejandro";
                if(k == 2)
                    name = "Daniel";
                if(k == 3)
                    name = "Manuel";
                if(k == 4)
                    name = "Uzziel";
                if(k == 5)
                    name = "David";
                if(k == 6)
                    name = "Jorge";
                if(k == 7)
                    name = "Douglas";
                if(k == 8)
                    name = "Alex";
                if(k == 9)
                    name = "Henry";                                
            }
            persona p = new persona(name, personas.size());
            personas.add(p);
        }
    }
    
    void generarAmigos(){
        int k = personas.size();
        int l = 0;
        int m = 0;
        for(int i = 0; i < k; i++){
            l = r.nextInt(personas.size()-1);
            for(int j = 0; j < l; j++){
                personas.get(i).addAmigo1((personas.get(j)));
            }
        }
    }
    
    void imprimirPersonas(int n){
        if(n == 0){
            for(int i = 0; i< amigosf.size(); i++){
                System.out.println(amigosf.get(i).getId());
            }
        }
        if(n == 1){
            for(int i = 0; i < amigosc.size(); i++){
                System.out.println(amigosc.get(i).getId());
            }
        }
        if(n == 2){
            for(int i = 0; i < personas.size(); i++){
                System.out.println(personas.get(i).getId());
            }
        }
    }
    
    void amigosComun(){//clique
        for(int i = 0; i < (personas.size()/2); i++){
            
            amigos1 = personas.get(i).getAmigos();
            amigos2 = personas.get(i+1).getAmigos();
            System.out.println(amigos1.size());
            System.out.println(amigos2.size());
            
            for(int j = 0; j < amigos1.size(); j++){
                for(int k = 0; k < amigos2.size(); k++){
                    if( (amigos1.get(j).equals( (amigos2.get(k)) ))){
                        if(!amigost.contains( (amigos1.get(j)) ))
                            amigost.add( (amigos1.get(j)) );
                        if(!amigost.contains((amigos2.get(k))))
                            amigost.add( (amigos2.get(k)) );
                        
                    }
                }
            }
        }
        if( (amigost.size()) > amigosf.size() )
            amigosf = amigost;
        //imprimirPersonas(0);
    }
    
    void amigosAll(){//vertex cover
        for(int i = 0; i < personas.size(); i++){
            
            amigosct = personas.get(i).getAmigos();
            if( amigosct.size() == (personas.size() - 2)){
                amigosc.add( (personas.get(i)) );
            }else{
                for(int k = 0; k < amigosct.size(); k++){
                    amigosct2 = amigosct.get(k).getAmigos();
                    for(int j = 0; j < amigosct2.size(); j++){
                        if(!amigosct.contains(amigosct2.get(j))){
                            amigosct.add((amigosct2.get(j)));
                        }
                    }
                    if( amigosct.size() == (personas.size() - 2)){
                        if(!amigosc.contains( (personas.get(i)) )){
                            amigosc.add( (personas.get(i)) );;
                        }
                    }
                }
            }
        }
        imprimirPersonas(1);
    }
    
}
