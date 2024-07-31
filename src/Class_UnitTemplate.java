package src;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.*;



public class Class_UnitTemplate {

    Class_Frame fc = new Class_Frame();


    static boolean field_value_validation(String field_value) {
        boolean val_pass = false;
        try {
            Double.parseDouble(field_value);
            val_pass = true;
        }
        catch (NumberFormatException e) {}
        
        return val_pass;
    }


    static double convert_value(double value, double conv_from, double conv_to) {
        double new_value = value / conv_from * conv_to;
        return new_value;
    }


    static String gen_result_to_display (double converted_value) {
        String converted_value_str;

        if ((int)converted_value < converted_value) {
            converted_value_str = String.format("%.2f", converted_value);
        }
        else {
            converted_value_str = String.format("%.0f", converted_value);
        }
        return converted_value_str;
    }


    public void frame_set_properties_wrapper() {
        fc.frame_set_properties();
    }
    

    public void add_converter(String title, HashMap<String, String> hash_map, int x_grid, int y_grid) {

        
        Class_WidgetProperties p = new Class_WidgetProperties();
        
        int x_push = x_grid * (p.WIDGET_WIDTH + 30);
        int y_push = y_grid * (p.WIDGET_HEIGHT * 9);
    
        // COMBO BOX OPTIONS
        ArrayList<String> hash_map_al = new ArrayList<>(hash_map.keySet());
        int hash_map_size = hash_map_al.size();
        String[] combo_box_options = new String[hash_map_size];
        for (int i = 0; i < hash_map_size; i++) {
            combo_box_options[i] = hash_map_al.get(i);
        }
        Arrays.sort(combo_box_options);


        // WIDGETS CREATION
        Font combo_box_font_style = new Font("Times New Roman", Font.PLAIN, 14);
        Font label_font_style = new Font("Times New Roman", Font.PLAIN, 14);
        Font field_font_style = new Font("Times New Roman", Font.BOLD, 14);
        Font label_title_font_style = new Font("Times New Roman", Font.PLAIN, 18);

        JTextField field_from = new JTextField();
        field_from.setFont(field_font_style);
        field_from.setHorizontalAlignment(JTextField.RIGHT);
        
        JTextField field_to = new JTextField();
        field_to.setFont(field_font_style);
        field_to.setHorizontalAlignment(JTextField.RIGHT);

        JComboBox<String> combo_box_unit_from = new JComboBox<>(combo_box_options);
        JComboBox<String> combo_box_unit_to = new JComboBox<>(combo_box_options);

        combo_box_unit_from.setFont(combo_box_font_style);
        combo_box_unit_to.setFont(combo_box_font_style);
        
        Color label_color = new Color(70, 70, 70);
        JLabel label_title = new JLabel(title, SwingConstants.CENTER);
        JLabel label_from = new JLabel("From");
        JLabel label_to = new JLabel("To");
        JLabel label_from_2nd = new JLabel("From");
        JLabel label_to_2nd = new JLabel("To");
        label_title.setFont(label_title_font_style);
        label_title.setForeground(label_color);

        Component[] label_array = {
            label_from,
            label_to,
            label_from_2nd,
            label_to_2nd,
        };

        for (Component widget : label_array) {
           widget.setFont(label_font_style);
           widget.setForeground(label_color);
        }


        JButton button = new JButton("Convert");
        button.setFont(label_font_style);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String field_from_value = field_from.getText();

                if (field_value_validation(field_from_value)) {

                    double field_from_value_dbl = Double.parseDouble(field_from_value);
                    
                    String unit_from_key = combo_box_unit_from.getItemAt(combo_box_unit_from.getSelectedIndex());
                    String unit_from_value = hash_map.get(unit_from_key);
                    double unit_from_dbl = Double.parseDouble(unit_from_value);
                    
                    String unit_to_key = combo_box_unit_to.getItemAt(combo_box_unit_to.getSelectedIndex());
                    String unit_to_value = hash_map.get(unit_to_key);
                    double unit_to_dbl = Double.parseDouble(unit_to_value);

                    Double converted_value = convert_value(field_from_value_dbl, unit_from_dbl, unit_to_dbl);
                    field_to.setText(gen_result_to_display(converted_value));
                }
                else {
                    JOptionPane.showMessageDialog(fc.frame, "Invalid value. Try again.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        

        // WIDGETS POS
        label_title.setBounds(p.BASE_X + x_push, p.getPosY(-1) + y_push, p.WIDGET_WIDTH, p.WIDGET_HEIGHT);
        field_from.setBounds(p.BASE_X + x_push, p.getPosY(0) + y_push, p.WIDGET_WIDTH, p.WIDGET_HEIGHT);
        combo_box_unit_from.setBounds(p.BASE_X + x_push, p.getPosY(1) + y_push, p.WIDGET_WIDTH, p.WIDGET_HEIGHT);
        combo_box_unit_to.setBounds(p.BASE_X + x_push, p.getPosY(2) + y_push, p.WIDGET_WIDTH, p.WIDGET_HEIGHT);
        field_to.setBounds(p.BASE_X + x_push, p.getPosY(3) + y_push, p.WIDGET_WIDTH, p.WIDGET_HEIGHT);
        
        label_from.setBounds(p.BASE_X - p.X_DIFF_TEXT, p.getPosY(1), p.WIDGET_WIDTH, p.WIDGET_HEIGHT);
        label_to.setBounds(p.BASE_X - p.X_DIFF_TEXT, p.getPosY(2), p.WIDGET_WIDTH, p.WIDGET_HEIGHT);

        label_from_2nd.setBounds(p.BASE_X - p.X_DIFF_TEXT, p.getPosY(1) + y_push, p.WIDGET_WIDTH, p.WIDGET_HEIGHT);
        label_to_2nd.setBounds(p.BASE_X - p.X_DIFF_TEXT, p.getPosY(2) + y_push, p.WIDGET_WIDTH, p.WIDGET_HEIGHT);

        button.setBounds(p.BASE_X + x_push, p.getPosY(4.5) + y_push, p.WIDGET_WIDTH, p.WIDGET_HEIGHT);
        
        Component[] widgets_array = {
            label_title,
            field_from,
            combo_box_unit_from,
            combo_box_unit_to,
            field_to,
            label_from,
            label_to,
            label_from_2nd,
            label_to_2nd,
            button
        };

        for (Component widget : widgets_array) {
           fc.frame.add(widget);
        }

    }
}
