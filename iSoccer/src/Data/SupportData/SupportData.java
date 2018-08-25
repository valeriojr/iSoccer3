package Data.SupportData;

import MVC.Model;

public class SupportData implements Model {
    public static final String TYPE = "Tipo de apoio";
    public static double[] pricing = {25.0, 35.0, 50.0};

    public enum Type {JÚNIOR, SÊNIOR, ELITE}

    private Type type;
    private boolean situation;

    public SupportData() {
        type = Type.JÚNIOR;
        situation = true;
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

    public Type getType() {
        return type;
    }

    public double getPricing(){
        return pricing[type.ordinal()];
    }

    public boolean getSituation(){
        return situation;
    }

    public void setSituation(boolean situation) {
        this.situation = situation;
    }
}
