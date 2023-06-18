package calculation;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

// Добавляем кнопки и действия при их нажатии
public class ButtonsPanel extends JPanel implements ActionListener {
    
    // объявляем все кнопки используекмые в калькуляторе при нажатии
    
    private static String  buttonText[] = {"\u2191", "Mod","CE","C","\u232b","\u00F7",
                    "A","B","7","8","9","\u00D7",
                    "C","D","4","5","6","\u2212",
                    "E","F","1","2","3","+",
                    "(", ")", "\u00B1","0",".","="};
    private static JButton buttons[] = new JButton[buttonText.length];
    private int count = 0; // Счетчик
    //шрифт
    private Font font = new Font("",Font.PLAIN,13);
    
    // Используется для вычисления
    private int firstNum = 0;
    private int secondNum = 0;
    
    // Используется для выполнения операций 
    private String operation ="";
    // результат отображаемый в текстовом поле
    private int result = 0;
    // вывод 
    private String output ="";
    
    // Конструктор
    public ButtonsPanel(){
        for (int i = 0; i<buttons.length;i++){
        buttons[i] = new JButton(buttonText[i]);
        buttons[i].setFont(new Font("",Font.PLAIN,13));
        if (buttonText[i].matches("[A-F]")){
            buttons[i].setEnabled(false);
        }
    }
     // Для кнопок, использующих gridBagLayout
     setLayout(new GridBagLayout());
     GridBagConstraints c = new GridBagConstraints();
     c.anchor = GridBagConstraints.PAGE_START;
     c.fill = GridBagConstraints.BOTH;
     c.weightx = .20;
     c.weighty = .20;
     c.insets = new Insets(1,1,1,2);
     
     for (int i = 0; i <5;i++){
         for (int j =0; j<6;j++){
             c.gridx = j;
             c.gridy = i;
             
             add(buttons[count++],c);
         }
     }
     // Добавляем действие для кнопок.
     for (int i = 0; i<buttons.length;i++){
        buttons[i].addActionListener(this);
    }
    }
    // Другие методы
    protected static JButton getButton(int i) {
        return buttons[i];
    }
   
    // Преобразует число из строки в цело число и выполняет преобразование 

 
    
    protected static int convertNumberFrom (String number){
        if(ConversionPanel.getHexRadButton().isSelected()){
            return Integer.valueOf(number,16).intValue();
        }else if ((ConversionPanel.getDecRadButton().isSelected())){
            return Integer.valueOf(number,10).intValue();
        }else if ((ConversionPanel.getOctRadButton().isSelected()))
        {
            return Integer.valueOf(number,8).intValue();
        }else if((ConversionPanel.getBinRadButton().isSelected())){
            return Integer.valueOf(number,2).intValue();
        }
        return 0;
    }
    
    protected static String convertNumberTo(int number){
        if(ConversionPanel.getHexRadButton().isSelected()){
            return Integer.toHexString(number);
        } else if (ConversionPanel.getDecRadButton().isSelected()){
            return Integer.toString(number);
        } else if(ConversionPanel.getOctRadButton().isSelected()){
            return Integer.toOctalString(number);
        }else if(ConversionPanel.getBinRadButton().isSelected()){
            return Integer.toBinaryString(number);
        }
        return "";
    }
    
    // Добавим действие при нажатии на кнопки
    @Override
    public void actionPerformed(ActionEvent e){
        // Проверяет нажатые кнопки и выполняет соответсвуюеще действие.
        //Если нажата цифра/ буква добавляет ввод в текстовое поле
        // Строка 1 для калькулятороа
        if(e.getSource() == buttons[2]){
            String input = TextFieldPanel.getTextField().getText();
            if (input != null && input.length()>0){
                TextFieldPanel.getTextField().setText("");
            }
        }
        if(e.getSource() == buttons[4]){
            String input = TextFieldPanel.getTextField().getText();
            if(input!=null && input.length()>0){
                TextFieldPanel.getTextField().setText(input.substring(0,input.length()-1));
            }
        }
        //Деление
        if(e.getSource()== buttons[5]) {
            String input = TextFieldPanel.getTextField().getText();
            firstNum  = convertNumberFrom(input);
            TextFieldPanel.getTextField().setText("");
            operation = "/";
        }
       
        if(e.getSource() == buttons[6]){
            String input = TextFieldPanel.getTextField().getText();
            TextFieldPanel.getTextField().setText(input+"A");
        }
        
        if(e.getSource() == buttons[7]){
            String input = TextFieldPanel.getTextField().getText();
            TextFieldPanel.getTextField().setText(input+"B");
        }
        if (e.getSource() == buttons[8]) {
            String input = TextFieldPanel.getTextField().getText();
            TextFieldPanel.getTextField().setText(input + "7");
		}
	if (e.getSource() == buttons[9]) {
            String input = TextFieldPanel.getTextField().getText();
            TextFieldPanel.getTextField().setText(input + "8");
		}
	if (e.getSource() == buttons[10]) {
            String input = TextFieldPanel.getTextField().getText();
            TextFieldPanel.getTextField().setText(input + "9");
		}
		//multiply
	if (e.getSource() == buttons[11]) {
            String input = TextFieldPanel.getTextField().getText();
            firstNum = convertNumberFrom(input);
            TextFieldPanel.getTextField().setText("");
            operation = "*";
		}
        if (e.getSource() == buttons[12]) {
            String input = TextFieldPanel.getTextField().getText();
            TextFieldPanel.getTextField().setText(input + "C");
		}
	if (e.getSource() == buttons[13]) {
            String input = TextFieldPanel.getTextField().getText();
            TextFieldPanel.getTextField().setText(input + "D");
		}
	if (e.getSource() == buttons[14]) {
            String input = TextFieldPanel.getTextField().getText();
            TextFieldPanel.getTextField().setText(input + "4");
		}
	if (e.getSource() == buttons[15]) {
            String input = TextFieldPanel.getTextField().getText();
            TextFieldPanel.getTextField().setText(input + "5");
		}
	if (e.getSource() == buttons[16]) {
            String input = TextFieldPanel.getTextField().getText();
            TextFieldPanel.getTextField().setText(input + "6");
		}
	if (e.getSource() == buttons[17]) {
            String input = TextFieldPanel.getTextField().getText();
            firstNum = convertNumberFrom(input);
            TextFieldPanel.getTextField().setText("");
            operation = "-";
        }
         //строка 4
        if (e.getSource() == buttons[18]) {
            String input = TextFieldPanel.getTextField().getText();
            TextFieldPanel.getTextField().setText(input + "E");
		}
        if (e.getSource() == buttons[19]) {
            String input = TextFieldPanel.getTextField().getText();
            TextFieldPanel.getTextField().setText(input + "F");
		}
        if (e.getSource() == buttons[20]) {
            String input = TextFieldPanel.getTextField().getText();
            TextFieldPanel.getTextField().setText(input + "1");
		}
        if (e.getSource() == buttons[21]) {
            String input = TextFieldPanel.getTextField().getText();
            TextFieldPanel.getTextField().setText(input + "2");
		}
        if (e.getSource() == buttons[22]) {
            String input = TextFieldPanel.getTextField().getText();
            TextFieldPanel.getTextField().setText(input + "3");
		}
        if (e.getSource() == buttons[23]) {
            String input = TextFieldPanel.getTextField().getText();
            firstNum = convertNumberFrom(input);
            TextFieldPanel.getTextField().setText("");
            operation = "+";
		}
         //Строка 5
        if (e.getSource() == buttons[24]) {
            String input = TextFieldPanel.getTextField().getText();
            TextFieldPanel.getTextField().setText(input + "(");
		}
		if (e.getSource() == buttons[25]) {
            String input = TextFieldPanel.getTextField().getText();
            TextFieldPanel.getTextField().setText(input + ")");
		}
	if (e.getSource() == buttons[27]) {
            String input = TextFieldPanel.getTextField().getText();
            TextFieldPanel.getTextField().setText(input + "0");
        }
         //Когда не используется hex//dec//bin
        
         if (e.getSource() == buttons[28]) {
            String input = TextFieldPanel.getTextField().getText();
            TextFieldPanel.getTextField().setText(input + ".");
         }
         //
         if (e.getSource() == buttons[29]) {
			// for performing regular calculations(addition, subtraction, * and /
			if (operation == "mod") {
				String input = TextFieldPanel.getTextField().getText();
				secondNum = convertNumberFrom(input);
				result = firstNum % secondNum;
				output = convertNumberTo(result);
				TextFieldPanel.getTextField().setText(output);
			}
			//action for division of two numbers
			else if (operation == "/") {
				String input = TextFieldPanel.getTextField().getText();
				secondNum = convertNumberFrom(input);
				if(secondNum == 0) {
					result = 0;
					output = "Infinity";
				}
				else {
					result = firstNum / secondNum;
					output = convertNumberTo(result);
				}
				TextFieldPanel.getTextField().setText(output);
			} 
			//action for multiplication of two numbers
			else if (operation == "*") {
				String input = TextFieldPanel.getTextField().getText();
				secondNum = convertNumberFrom(input);
				result = firstNum * secondNum;
				output = convertNumberTo(result);
				TextFieldPanel.getTextField().setText(output);
			} 
			//action for subtraction of two numbers
			else if (operation == "-") {
				String input = TextFieldPanel.getTextField().getText();
				secondNum = convertNumberFrom(input);
				result = firstNum - secondNum;
				output = convertNumberTo(result);
				TextFieldPanel.getTextField().setText(output);
			} 
			//action for addition of two numbers
			else if (operation == "+") {
				String input = TextFieldPanel.getTextField().getText();
				secondNum = convertNumberFrom(input);
				result = firstNum + secondNum;
				output = convertNumberTo(result);
				TextFieldPanel.getTextField().setText(output);
			}
		}
	}

        
    }
   
