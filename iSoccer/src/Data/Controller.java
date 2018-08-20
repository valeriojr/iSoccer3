package Data;

import java.util.Map;
import java.util.TreeMap;

public abstract class Controller {
    private Model model;
    private Map<String, View> views;
    protected Bundle bundle;

    public Controller(Model model) {
        this.model = model;
        this.views = new TreeMap<String, View>();
        this.bundle = new Bundle();
    }

    public abstract void updateModel();

    public void updateView(String viewName){
        View view = getView(viewName);

        if(view != null){
            view.update();
        }
    }

    public Model getModel(){
        return model;
    }

    public void addView(String viewName, View view){
        views.put(viewName, view);
    }

    public View getView(String viewName){
        return views.get(viewName);
    }

    public Bundle getBundle(){
        return bundle;
    }
}
