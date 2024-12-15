package uc;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Color;


public class Class_Rect extends JPanel {

    Class_WidgetProperties p = new Class_WidgetProperties();
    int rect_width;
    int rect_height; 
    int RECT_DIFF = 7;
    int width_adj;
    int height_adj;
    String OS = System.getProperty("os.name").toLowerCase();
    Boolean os_linux = OS.indexOf("linux") >= 0;


    @Override
    protected void paintComponent(Graphics g) {
        if (os_linux) {
            width_adj = 2;
            height_adj = 2;
        }
        else {
            width_adj = 4;
            height_adj = 3;
        }
        rect_width = p.FRAME_WIDTH - RECT_DIFF*width_adj;
        rect_height = p.FRAME_HEIGHT  - RECT_DIFF*height_adj - 30;
        
        
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.draw3DRect(RECT_DIFF, RECT_DIFF, rect_width, rect_height, true);
    }
}
