package models;

import java.util.ArrayList;

public class Receta {
    private String nombre;
    private String ingrediente;
    private ArrayList<String> listaIngredientes = new ArrayList<>();
    static public ArrayList<Receta> listaRecetas = new ArrayList<>();

    public Receta() {}

    public String getIngrediente(int index) {
        return this.listaIngredientes.get(index);
    }

    public String getNombre() {
        return this.nombre;
    }

    public ArrayList<String> getListaIngredientes() { return this.listaIngredientes; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    public void addIngrediente(String ingrediente) {
        listaIngredientes.add(ingrediente);
    }

    public String ingredientesToString(){
        String ingredientes = "";
        for (int i = 0; i < listaIngredientes.size(); i++) {
            ingredientes = ingredientes.concat(getIngrediente(i)+ ", ");
        }
        return ingredientes;
    }

    public String toString(){
        String receta = "Nombre: " + nombre + "\nIngredientes: ";
        for (int i = 0; i < listaIngredientes.size(); i++) {
            receta = receta.concat("\n"+getIngrediente(i));
        }
        return receta;
    }
}
