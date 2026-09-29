/**
 * clase hija
 */
public class ViajeEspecial extends tdaViajes {
    //atributo
    private String tipoViaje;

    //constructor
    public ViajeEspecial(){
        super();
        tipoViaje="Normal";
    }

    //constructor con parametro
    public ViajeEspecial(String nombre,String origen,String destino,float distancia,float costo,int numPasajeros,String tipoViaje){
        super(nombre,origen,destino,distancia,costo,numPasajeros);
        if (tipoViaje == null || tipoViaje.isEmpty()){
            this.tipoViaje="Normal";
        }else {
            this.tipoViaje= tipoViaje;
        }
    }

    //getter y stter
    public String getTipoViaje(){

        return tipoViaje;
    }
    public void setTipoViaje(String tipoViaje){
        if (tipoViaje == null && tipoViaje.isEmpty()){
            this.tipoViaje=tipoViaje;
        }
    }

    public String mostarViaje(){
        return "Tipo de viaje:"+ tipoViaje;
    }
}
