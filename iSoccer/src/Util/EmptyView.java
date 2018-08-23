package Util;

import Data.Controller;
import Data.View;

public class EmptyView extends View {
    public EmptyView(Controller controller) {
        super(controller);
        initialize();
    }

    @Override
    protected void initialize() {
        super.initialize();
    }

    @Override
    public void update() {

    }

    @Override
    public void clear() {

    }
}
