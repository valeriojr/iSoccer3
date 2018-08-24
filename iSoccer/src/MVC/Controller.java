package MVC;

import Util.Bundle;
import Util.EmptyView;

public abstract class Controller {
    private Model model;
    protected View view;
    protected Bundle bundle;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.bundle = new Bundle();
    }

    public Controller(Model model) {
        this.model = model;
        this.view = null;
        this.bundle = new Bundle();
        setView(new EmptyView(this));
    }

    public abstract void updateModel();

    public void updateView(){
        if(view != null){
            view.update();
        }
    }

    public Model getModel(){
        return model;
    }

    public void setView(View view){
        this.view = view;
    }

    public View getView(){
        return view;
    }

    public Bundle getBundle() {
        return bundle;
    }
}
