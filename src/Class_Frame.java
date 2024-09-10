
package src;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Image;


public class Class_Frame {

    static JFrame frame = new JFrame();
    static Class_WidgetProperties p = new Class_WidgetProperties();


    static void frame_set_properties() {

        Image icon = Toolkit.getDefaultToolkit().getImage("./docs/frame_icon.png");
        frame.setIconImage(icon);
        frame.setTitle("Unit Converter");
        frame.setLayout(null);
        frame.setBounds(p.FRAME_POS_X,p.FRAME_POS_Y,p.FRAME_WIDTH,p.FRAME_HEIGHT);
        frame.getContentPane().setBackground(new java.awt.Color(243, 243, 243));
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
