/**
 * Rafael marquez hernandez
 * TDA para guardar y calcular informacion de un viaje
 */

public class tdaViajes {
    //atributos
    private String nombre;
    private String origen;
    private String destino;
    private float distancia;
    private float costo;
    private int numPasajeros;

    //constructor
    public tdaViajes(){
        nombre="";
        origen="";
        destino="";
        distancia= 0.0f;
        costo=0.0f;
        numPasajeros=0;
    }

    //constructor con parametros
    public tdaViajes(String nombre,String origen,String destino,float distancia,float costo,int numPasajeros){
        if (nombre == null || nombre.isEmpty()){
            this.nombre="Sin nombre";
        }
        if (origen == null || origen.isEmpty()){
            origen="Sin origen";
        }
        if (destino == null || destino.isEmpty()){
            destino="Sin destino";
        }
        if (distancia<0){
            distancia=0;
        }
        if (costo<0){
            costo=0;
        }
        if (numPasajeros<0){
            numPasajeros=0;
        }

        this.nombre=nombre;
        this.origen=origen;
        this.destino=destino;
        this.distancia=distancia;
        this.costo=costo;
        this.numPasajeros=numPasajeros;
    }

    //constructor copia
    public tdaViajes(tdaViajes copia){
        this.nombre=copia.nombre;
        this.origen= copia.origen;
        this.destino= copia.destino;
        this.distancia= copia.distancia;
        this.costo= copia.costo;
        this.numPasajeros= copia.numPasajeros;
    }

    //getters y setters
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        if (nombre == null && nombre.isEmpty()){
         nombre=nombre;
        }
    }

    public String getOrigen(){
        return origen;
    }
    public void setOrigen(String origen){
        if (origen == null && nombre.isEmpty()){
            origen=origen;
        }
    }

    public String getDestino(){
        return destino;
    }
    public void setDestino(String destino){
        if (destino == null && destino.isEmpty()){
            destino=destino;
        }
    }

    public float getDistancia(){
        return distancia;
    }
    public void setDistancia(float distancia){
        if (distancia>=0){
            distancia=distancia;
        }
    }

    public float getCosto(){
        return costo;
    }
    public void setCosto(float costo){
        if (costo>=0){
            costo=costo;
        }
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(int numPasajeros) {
        if (numPasajeros>=0){
            numPasajeros=numPasajeros;
        }
    }

    public float calcularTiempo(){
        float velocidad=80;
        if (velocidad>0){
            return distancia/velocidad;
        }
        return 0;
    }

    public float calcularCostoTotal(){
        return costo*numPasajeros;
    }

    //recursividad
    public float calcularCostorecursivo(int pasajeros){
        if (pasajeros<=0){
            return 0;
        }
        return costo+calcularCostorecursivo(pasajeros-1);
    }

    public String mostrarInformacion(){
        return "Nombre:" + nombre+ "\nOrigen:"+origen+"\nDestino:"+destino+"\nDistancia:"+distancia+"km"+"\nCosto x pasajero: $"+costo+
                "\nPasajeros:"+numPasajeros+"\nTiempo:"+calcularTiempo()+"h"+"\nCosto total: $"+ calcularCostoTotal();
    }

    public boolean tienePasajeros(){
        return numPasajeros>0;
    }
}
