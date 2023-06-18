
package calculation;

//imports
import java.awt.Color; 
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

// Переменные
public class Frame extends JFrame {
    private TextFieldPanel inputPanel;
    private ConversionPanel basePanel;
    private ButtonsPanel buttonPanel;
    private JToggleButton qword;
    private JButton and,not,or,xor,rsh,lsh;
    private JLabel menu,title;
    
    public Frame(){
        // Конпановка рамки
        setLayout(null);
        
        //Где пользователь вводит текст
        inputPanel = new TextFieldPanel();
        //Установка шрифта
        inputPanel.setFont(new Font("Roboto",Font.PLAIN,30));
        inputPanel.setBackground(new Color(66, 245, 239));
        inputPanel.setForeground(Color.BLACK);
        inputPanel.setBounds(6,55,359,65);
        add(inputPanel);
        
        // Название метки для переключения между режимами калькулятора.
        menu = new JLabel("   \u2630");
        //Установка шрифтов и их границ
        menu.setFont(new Font("Baskerville",Font.PLAIN,20));
        menu.setBounds(2,6,61,37);
        add(menu);
        
        
        //Заголовок Фрейма
        title = new JLabel("Программист");
        title.setFont(new Font("Roboto", Font.BOLD,16));
        title.setBounds(60,14,290,40);
        add(title);
        
        // панель с кнопками hex, bin, dec и oct.
        basePanel = new ConversionPanel();
        basePanel.setBounds(6,153,63,140);
        basePanel.setBorder(new EmptyBorder(0,0,0,0));
        add(basePanel);
        
        //Добавляем кнопки в калькулятор
        buttonPanel = new ButtonsPanel();
        
        // Установка границ размещения кнопок
        buttonPanel.setBounds(6,336,359,231);
        add(buttonPanel);
        
        // Реализация кнопок по нажатию.
        and = new JButton("And");
        and.setBounds(306,295,57,40);
        add(and);
        
        not = new JButton(" Not");
        not.setBounds(246,295,57,40);
        add(not);
        
        xor = new JButton(" Xor");
        xor.setBounds(186,295,57,40);
        add(xor);
        
        or = new JButton(" Or");
        or.setBounds(126,295,57,40);
        add(or);
        
        rsh = new JButton("Rsh");
        rsh.setBounds(67, 295,57,40);
        add(rsh);
        
        lsh = new JButton("Lsh");
        lsh.setBounds(7,295,57,40);
        add(lsh);
        
        // Кнопка для сенсерного управления qword
        qword = new JToggleButton("QWORD");
        qword.setFont(new Font("Lucia Grande", Font.PLAIN,14));
        qword.setBounds(142,245,100,40);
        add(qword);
    
        
}
}
