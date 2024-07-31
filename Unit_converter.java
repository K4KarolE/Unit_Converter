import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;


import javax.swing.*;

public class unit_converter {
    public static void main(String[] args) {
        
        // UNIT MAP
        HashMap<String, String> map_mass = new HashMap<>();
        map_mass.put("Kilogram [kg]", "1");
        map_mass.put("Hectogram [hg]", "10");
        map_mass.put("Dekagram [dag]", "100");
        map_mass.put("Gram [g]", "1000");
        map_mass.put("Ton [t]", "0.001");
        map_mass.put("Pound [lbs]", "2.2046226218");
        map_mass.put("Stone [st]", "0.1574730444");
        map_mass.put("Ounce [oz]", "35.27396195");


        // COMBO BOX OPTIONS
        ArrayList<String> map_mass_al = new ArrayList<>(map_mass.keySet());
        int map_mass_size = map_mass_al.size();
        String[] combo_box_options = new String[map_mass_size];
        for (int i = 0; i < map_mass_size; i++) {
            combo_box_options[i] = map_mass_al.get(i);
        }



        // WIDGETS CREATION
        JFrame frame = new JFrame();

        Font combo_box_font_style = new Font("Arial", Font.PLAIN, 14);
        Font label_font_style = new Font("Arial", Font.BOLD, 13);

        JComboBox<String> combo_box_unit_from = new JComboBox<>(combo_box_options);
        JComboBox<String> combo_box_unit_to = new JComboBox<>(combo_box_options);

        combo_box_unit_from.setFont(combo_box_font_style);
        combo_box_unit_to.setFont(combo_box_font_style);
        
        JLabel label = new JLabel();
        JLabel label_from = new JLabel();
        JLabel label_to= new JLabel();
        label_from.setText("From");
        label_from.setFont(label_font_style);
        label_to.setText("To");
        label_to.setFont(label_font_style);


        JButton button = new JButton("Go");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String unit_from = combo_box_unit_from.getItemAt(combo_box_unit_from.getSelectedIndex());
                String unit_to= combo_box_unit_to.getItemAt(combo_box_unit_to.getSelectedIndex());
                label.setText(map_mass.get(unit_from) + " >>> " + map_mass.get(unit_to));
            }
        });
        

        // WIDGETS POS
        int FRAME_WIDTH = 300;
        int FRAME_HEIGHT = 250;
        int FRAME_POS_X = 800;
        int FRAME_POS_Y = 600;
        int BASE_X = 80;
        int BASE_Y = 50;
        int X_DIFF_TEXT = 40;
        int Y_DIFF = 30;

        combo_box_unit_from.setBounds(BASE_X, BASE_Y, 140, 25);
        combo_box_unit_to.setBounds(BASE_X, BASE_Y + Y_DIFF, 140, 25);
        label_from.setBounds(BASE_X-X_DIFF_TEXT, BASE_Y + 2, 140, 20);
        label_to.setBounds(BASE_X-X_DIFF_TEXT, BASE_Y + Y_DIFF + 2, 140, 20);
        label.setBounds(90, 150, 400, 100);
        button.setBounds(100, 120, 90, 20);
        
        Component[] widgets_array = {
            combo_box_unit_from,
            combo_box_unit_to,
            label_from,
            label_to,
            label,
            button
        };

        for (Component widget : widgets_array) {
           frame.add(widget);
        }

     
        
        frame.setLayout(null);
        frame.setVisible(true);
        // frame.getContentPane().setLayout(null);
        frame.setBounds(FRAME_POS_X,FRAME_POS_Y,FRAME_WIDTH,FRAME_HEIGHT);
        
        
    }
}
