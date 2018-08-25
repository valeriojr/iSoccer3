package Data.Resources.VehicleData;

import MVC.Model;

public class VehicleData implements Model {
    public static final String ID = "Identificador do veículo", TYPE = "Tipo de veículo";
    enum Type {ÔNIBUS, CARRO, AVIÃO}

    private String id;
    private Type type;

    public VehicleData(){
        this.id = null;
        this.type = null;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("%s: %s\n%s: %s\n", ID, id, TYPE, type);
    }
}
