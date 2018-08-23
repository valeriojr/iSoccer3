package Data.SupportData.Views;

import Data.Bundle;
import Data.SupportData.SupportData;
import Data.SupportData.SupportDataController;
import Data.View;

import javax.swing.*;

import java.awt.*;

import static Data.SupportData.SupportData.Type.values;

public class SupportDataViewEdit extends View {

    JComboBox<SupportData.Type> typeSelect;

    public SupportDataViewEdit(SupportDataController supportDataController) {
        super(supportDataController);
        initialize();
    }

    @Override
    protected void initialize() {
        super.initialize();

        typeSelect = new JComboBox<SupportData.Type>(SupportData.Type.values());
        typeSelect.setBorder(BorderFactory.createTitledBorder(SupportData.TYPE));

        typeSelect.setPreferredSize(new Dimension(300, 50));

        mainPanel.add(typeSelect);
    }

    @Override
    public void update() {
        Bundle bundle = controller.getBundle();

        System.out.println("Selected item: " + typeSelect.getSelectedItem());

        bundle.put(SupportData.TYPE, typeSelect.getSelectedItem());
    }

    @Override
    public void clear() {
        typeSelect.setSelectedIndex(-1);
    }
}
