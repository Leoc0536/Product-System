import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ItemSales {
    // attributes
    private float itemPrice;
    private String itemCode;

    // return item price
    public float getItemPrice(){
        return itemPrice;
    }
    
    // set item price
    public void setItemPrice(float newItemPrice){
        this.itemPrice = newItemPrice;
    }
    
    // get item code
    public String getItemCode(){
        return itemCode;
    }

    // constructor
    public ItemSales(float price, String code){
        this.itemPrice = price;
        this.itemCode = code;
    }

    // dialog box, ask "Please Enter the Item Code = "
    // return Item Code.
    public void enterItemCode(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(); // similar to HTML div
        JLabel result = new JLabel("");
        result.setBounds(10, 70, 250, 25);

        JLabel itemCodeInput = new JLabel("Please Enter the Item Code = ");
        itemCodeInput.setBounds(10, 20, 250, 25);
        
        JTextField textField = new JTextField(20);
        textField.setBounds(10,45,250,25);
        ActionListener input = new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                result.setText("Item Code has changed to: "+ textField.getText());
                itemCode = textField.getText();
            
                frame.setVisible(false);
                frame.setVisible(true);
            }
            
        };
        textField.addActionListener(input);

        panel.setLayout(null);
        panel.setSize(300, 300);

        panel.add(result);
        panel.add(itemCodeInput);
        panel.add(textField);
        frame.add(panel);

        frame.setLocationRelativeTo(null);

        frame.setTitle("Item Code");
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    // show input dialog box, ask "Enter the Price: "
    // store the price of an Item.
    // If Price <= 0, "No Zero or Negative Price is allowed." then input again
    // diaplay new Price until price is non-zero and non-negative integer.
    public void enterPrice(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(); // similar to HTML div
        JLabel result = new JLabel("");
        result.setBounds(10, 70, 250, 25);

        JLabel INPUT = new JLabel("Enter the Price: ");
        INPUT.setBounds(10, 20, 250, 25);
        
        JTextField textField = new JTextField(20);
        textField.setBounds(10,45,250,25);
        ActionListener input = new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText("");
                try {
                    int temp = Integer.parseInt(textField.getText());
                    System.out.println(temp);
                    if(temp <= 0){
                        result.setText("No Zero or Negative Price is allowed.");
                    }
                    else{
                        result.setText("Price has changed to: "+ textField.getText());
                        itemPrice = temp;
                    }
                    
                } catch (NumberFormatException nfe) {
                    result.setText("Please enter an integer");
                }
                frame.setVisible(false);
                frame.setVisible(true);
            }
            
        };
        textField.addActionListener(input);
    
        panel.setLayout(null);
        panel.setSize(300, 300);

        panel.add(result);
        panel.add(INPUT);
        panel.add(textField);
        frame.add(panel);

        frame.setLocationRelativeTo(null);
        frame.setTitle("enterPrice");
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    // return calculated Sales Amount
    public float calSalesAmt(){
        return itemPrice;
    }

    // override to string, print all information
    @Override
    public String toString() {
        return "Item Code" + itemCode + " with Price" + itemPrice;
    }

    // override equals, return true if the object is a instance of the ItemSales class and having the same item Code.
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ItemSales){
            return this.itemCode.equals(((ItemSales) obj).getItemCode());
        }
        return false;
    }
    // testing purpose
    public static void main(String[] args) {
        ItemSales i = new ItemSales(1,"123");
        System.out.println(i.getItemCode());
        i.enterItemCode();
        System.out.println(i.getItemCode());
        i.enterPrice();
        System.out.println(i.equals(new HardwareSales(0, "123", 0, 0)));
        System.out.println(i.equals(new HardwareSales(0, "12", 0, 0)));
        System.out.println(i.equals(new Object()));

    }
}