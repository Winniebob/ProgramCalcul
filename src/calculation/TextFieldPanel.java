/*
Имя: Вилькс Максим
*/

package calculation;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextFieldPanel extends JPanel implements KeyListener, DocumentListener {
    //Переменные 
    private static JTextField inputTextField;
    //Шрифты переменных
    private Font font = new Font("Sergoe UI", Font.BOLD,30);
    private static int currentNumberInDecimal = 0;
    
    //Конструктор
    public TextFieldPanel() {
        // Добавлено по умолчанию
        inputTextField = new JTextField(12);
        inputTextField.setHorizontalAlignment(JTextField.RIGHT);
        inputTextField.setFont(font);
        inputTextField.setBounds(6,55,359,65);
        
        add(inputTextField);
        
        inputTextField.addKeyListener(this);
        inputTextField.getDocument().addDocumentListener(this);
    }
    
    //Вспомогательный метод
    //Вводим input в textField
    public static JTextField getTextField(){
        return inputTextField;
    }
    

    public static int getCurrentNumberInDecimal() {
		return currentNumberInDecimal;
	}
        // Считыватель
        public void insertUpdate(DocumentEvent e) {
            String input = getTextField().getText();
            // Пока есть ввод в textField
            if(!input.isEmpty()){
                //устанавливаем значение для десятичного преобразования.
                currentNumberInDecimal = ButtonsPanel.convertNumberFrom(input);
                String currentNumberInBin = Integer.toBinaryString(currentNumberInDecimal);
                while (currentNumberInBin.length()<64)
                    currentNumberInBin = "0" + currentNumberInBin;
                int count =0;
                //Преобразование в зависимости от битов
                for (int x =0, y = 1, z=2, w =3; x<64 && y<65 &&z<66 && w<67; x+=4,y+=4,z+=4,w+=4)
                {
                    String bitX = Character.toString(currentNumberInBin.charAt(x));
                    String bitY = Character.toString(currentNumberInBin.charAt(y));
                    String bitZ = Character.toString(currentNumberInBin.charAt(z));
                    String bitW = Character.toString(currentNumberInBin.charAt(w));
                    String halfByte = bitX + bitY + bitZ + bitW;
                    count++;
                }
            }
        }
        
        public void removeUpdate(DocumentEvent e){
            String input = getTextField().getText();
            //Пока есть input в the textField
            if(!input.isEmpty()){
                currentNumberInDecimal = ButtonsPanel.convertNumberFrom(input);
                String currentNumberInBin = Integer.toBinaryString(currentNumberInDecimal);
                while(currentNumberInBin .length()<64)
                    currentNumberInBin = "0" + currentNumberInBin;
                int count = 0;
                
                // конвертация в биты
                for (int x =0, y =1 , z =2, w =3; x<64;x+=4,y+=4,z+=4,w+=4)
                {
                    String bitX = Character.toString(currentNumberInBin.charAt(x));
                    String bitY = Character.toString(currentNumberInBin.charAt(y));
                    String bitZ = Character.toString(currentNumberInBin.charAt(z));
                    String bitW = Character.toString(currentNumberInBin.charAt(w));
                    String halfByte = bitX + bitY+bitZ+bitW;
                    count++;
                }
            }
        }
        
        public void changedUpdate (DocumentEvent e) {
        }
        
        //Прием цифр с клавиатуры
        
        public void keyTyped(KeyEvent e){
            char c = e.getKeyChar();
            if(ConversionPanel.getHexRadButton().isSelected()&&((c<'0')||(c>'9'))&&((c<'A')||(c>'F'))
                    &&(c!=KeyEvent.VK_BACK_SPACE)){
                e.consume();
            } else if (ConversionPanel.getDecRadButton().isSelected()&&((c<'0')||(c>'9'))
                    &&(c != KeyEvent.VK_BACK_SPACE)){
                e.consume();
            } else if(ConversionPanel.getOctRadButton().isSelected()&& ((c<'0')||(c>'7'))
                    &&(c != KeyEvent.VK_BACK_SPACE)){
                e.consume();
            } else if(ConversionPanel.getBinRadButton().isSelected()&&((c<'0')||(c>'1'))
                    &&(c != KeyEvent.VK_BACK_SPACE)){
                e.consume();
            }
        }
        public void keyPressed(KeyEvent e){
    }
        public void keyReleased(KeyEvent e){
            
        }
}
