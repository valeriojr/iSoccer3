package Data.SupportData;

import Data.Model;

public class SupportData extends Model {
    public static final String TYPE = "Tipo de apoio";
    public static double[] pricing = {25.0, 35.0, 50.0};

    public enum Type {JÚNIOR, SÊNIOR, ELITE}

    private Type type;

    public SupportData(Type type){
        this.type = type;
    }

    public SupportData() {
        type = Type.JÚNIOR;
    }

    @Override
    public String toString() {
        if(type == null){
            System.out.println("Tipo: Null");
            return "";
        }
        return String.format("%s: %s", TYPE, type);
    }

    public void setType(Type type) {
        this.type = type;
    }
}
