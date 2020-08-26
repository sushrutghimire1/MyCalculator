package Design.buttons;

import javax.swing.*;
import java.awt.*;

public class ButtonAdd {

    public void initiate(Panel panel){
        JButton button = new JButton();
        String value = "+";
        button.setText(value);
        panel.add(button);

    }
}
