package Data;

import javax.swing.*;

public abstract class View {
    protected static final String EMPTY_LABEL = "-";
    protected Controller controller;

    protected JPanel mainPanel;

    public View(Controller controller) {
        this.controller = controller;
    }

    protected void initialize(){
        mainPanel = new JPanel();
    }

    public abstract void update();

    public JPanel getMainPanel(){
        return mainPanel;
    }

    protected abstract void clear();
}