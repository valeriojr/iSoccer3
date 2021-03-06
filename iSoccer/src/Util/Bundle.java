package Util;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Bundle {
    private Map<String, Object> objects;
    private boolean overwrite;

    public Bundle(){
        objects = new TreeMap<String, Object>();
        overwrite = true;
    }

    public void put(String key, Object value){
        if(overwrite){
            if(objects.get(key) != null){
                objects.remove(key);
            }
        }

        objects.put(key, value);
    }

    public Object getObject(String key){
        System.out.println("Returning " + objects.get(key) + " with key " + key);
        return objects.get(key);
    }

    public Integer getInt(String key){
        return (Integer) objects.get(key);
    }

    public String getString(String key){
        return (String) objects.get(key);
    }

    public Boolean getBoolean(String key){
        return (Boolean) objects.get(key);
    }

    public Date getDate(String key) {
        return (Date) objects.get(key);
    }

    public void setOverwrite(boolean overwrite){
        this.overwrite = overwrite;
    }

    public Double getDouble(String key) {
        return (Double) objects.get(key);
    }
}
