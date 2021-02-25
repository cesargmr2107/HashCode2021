public class Transit {
    public Car coche;
    public Street calle;
    public int contador;

    public Transit(Car coche, Street calle){
        this.coche = coche;
        this.calle = calle;
        this.contador = calle.tiempo;
    }
}
