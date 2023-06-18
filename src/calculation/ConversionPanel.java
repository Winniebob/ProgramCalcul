/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ConversionPanel extends JPanel implements ActionListener {
    
    private static JRadioButton hex;
    private static JRadioButton dec;
    private static JRadioButton oct;
    private static JRadioButton bin;
    private ButtonGroup baseButtonGroup;
    
    // Конструктор
        public ConversionPanel() {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setBorder(BorderFactory.createTitledBorder(""));
            
            hex = new JRadioButton("Hex");
            dec = new JRadioButton("Dec");
            oct = new JRadioButton("Oct");
            bin = new JRadioButton("Bin");
            
            baseButtonGroup = new ButtonGroup();
            
            // Добавим кнопки в группу
            baseButtonGroup.add(hex);
            baseButtonGroup.add(dec);
            dec.setSelected(true);
            baseButtonGroup.add(oct);
            baseButtonGroup.add(bin);
            
            // Добавим на панель
            add(hex);
            add(dec);
            add(oct);
            add(bin);
            
            // Добавим срабатывание
            
            hex.addActionListener(this);
            oct.addActionListener(this);
            dec.addActionListener(this);
            bin.addActionListener(this);
            
        }
        // Вспомогательный метод для кнопок с которыми взаимодействует пользователь
        
        public static JRadioButton getHexRadButton() { return hex;}
        public static JRadioButton getOctRadButton() {return oct;}
        public static JRadioButton getDecRadButton() {return dec;}
        public static JRadioButton getBinRadButton() {return bin;}
        
        // Срабатывание
        
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==hex){
                int number = TextFieldPanel.getCurrentNumberInDecimal();
                
                if(number != 0){
                    // Преобразовывавем число в шеснадцатиричное
                    TextFieldPanel.getTextField().setText(ButtonsPanel.convertNumberTo(number));
                }
                
                // устанавливаем значение для A,B,C,D,E,F - true
                ButtonsPanel.getButton(6).setEnabled(true);
                ButtonsPanel.getButton(7).setEnabled(true);
                ButtonsPanel.getButton(12).setEnabled(true);
                ButtonsPanel.getButton(13).setEnabled(true);
                ButtonsPanel.getButton(18).setEnabled(true);
                ButtonsPanel.getButton(19).setEnabled(true);
                
                // Устанавливаем значения для остальных
                ButtonsPanel.getButton(8).setEnabled(true);
		ButtonsPanel.getButton(9).setEnabled(true);
		ButtonsPanel.getButton(10).setEnabled(true);
			
		ButtonsPanel.getButton(14).setEnabled(true);
		ButtonsPanel.getButton(15).setEnabled(true);
		ButtonsPanel.getButton(16).setEnabled(true);
			
		ButtonsPanel.getButton(20).setEnabled(true);
		ButtonsPanel.getButton(21).setEnabled(true);
		ButtonsPanel.getButton(22).setEnabled(true);
		ButtonsPanel.getButton(27).setEnabled(true);
            }
            
            if(e.getSource() == dec){
                
                int number = TextFieldPanel.getCurrentNumberInDecimal();
                
                if(number !=0){
                    //Конвертируем числа
                    TextFieldPanel.getTextField().setText(ButtonsPanel.convertNumberTo(number));
                }
                
                // устанавливаем значение для A,B,C,D,E,F - false
                    
                ButtonsPanel.getButton(6).setEnabled(false);
                ButtonsPanel.getButton(7).setEnabled(false);
                ButtonsPanel.getButton(12).setEnabled(false);
                ButtonsPanel.getButton(13).setEnabled(false);
                ButtonsPanel.getButton(18).setEnabled(false);
                ButtonsPanel.getButton(19).setEnabled(false);
                
                // Устанавилваем для всех остальных номеров - true
                
                ButtonsPanel.getButton(8).setEnabled(true);
		ButtonsPanel.getButton(9).setEnabled(true);
		ButtonsPanel.getButton(10).setEnabled(true);
				
		ButtonsPanel.getButton(14).setEnabled(true);
		ButtonsPanel.getButton(15).setEnabled(true);
		ButtonsPanel.getButton(16).setEnabled(true);
				
		ButtonsPanel.getButton(20).setEnabled(true);
		ButtonsPanel.getButton(21).setEnabled(true);
		ButtonsPanel.getButton(22).setEnabled(true);
		ButtonsPanel.getButton(27).setEnabled(true);
            }
            if(e.getSource()==oct){
                
                int number = TextFieldPanel.getCurrentNumberInDecimal();
                
                if (number != 0){
                    // конвертируем номера для окт
                    TextFieldPanel.getTextField().setText(ButtonsPanel.convertNumberTo(number));
                }
                
                    // устанавливаем значение для A,B,C,D,E,F - false
                    
                    ButtonsPanel.getButton(6).setEnabled(false);
                    ButtonsPanel.getButton(7).setEnabled(false);
                    ButtonsPanel.getButton(12).setEnabled(false);
                    ButtonsPanel.getButton(13).setEnabled(false);
                    ButtonsPanel.getButton(18).setEnabled(false);
                    ButtonsPanel.getButton(19).setEnabled(false);
                    
                    //устанавливае 8 и 9 - false
                    ButtonsPanel.getButton(9).setEnabled(false);
                    ButtonsPanel.getButton(10).setEnabled(false);
                    
                    // Для всех остальных - true
                    ButtonsPanel.getButton(8).setEnabled(true);
			
                    ButtonsPanel.getButton(14).setEnabled(true);
                    ButtonsPanel.getButton(15).setEnabled(true);
                    ButtonsPanel.getButton(16).setEnabled(true);
			
                    ButtonsPanel.getButton(20).setEnabled(true);
                    ButtonsPanel.getButton(21).setEnabled(true);
                    ButtonsPanel.getButton(22).setEnabled(true);
                    ButtonsPanel.getButton(27).setEnabled(true);
                
                }
                if (e.getSource()==bin){
                    int number = TextFieldPanel.getCurrentNumberInDecimal();
                    
                    if(number != 0){
                        // Конвертируем номер для bin
                        TextFieldPanel.getTextField().setText(ButtonsPanel.convertNumberTo(number));
                    }
                    	
			ButtonsPanel.getButton(6).setEnabled(false);
			ButtonsPanel.getButton(7).setEnabled(false);
			ButtonsPanel.getButton(12).setEnabled(false);
			ButtonsPanel.getButton(13).setEnabled(false);
			ButtonsPanel.getButton(18).setEnabled(false);
			ButtonsPanel.getButton(19).setEnabled(false);
			
			
			ButtonsPanel.getButton(8).setEnabled(false);
			ButtonsPanel.getButton(9).setEnabled(false);
			ButtonsPanel.getButton(10).setEnabled(false);
			
			ButtonsPanel.getButton(14).setEnabled(false);
			ButtonsPanel.getButton(15).setEnabled(false);
			ButtonsPanel.getButton(16).setEnabled(false);
			
			ButtonsPanel.getButton(21).setEnabled(false);
			ButtonsPanel.getButton(22).setEnabled(false);
                        
                }
        }
    
    
}
