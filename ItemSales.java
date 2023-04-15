import javax.swing.JOptionPane;


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
    
    public void setItemCode(String code){
        this.itemCode = code;
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

        String code = JOptionPane.showInputDialog(null, "Enter item code");
        setItemCode(code);
    }

    // show input dialog box, ask "Enter the Price: "
    // store the price of an Item.
    // If Price <= 0, "No Zero or Negative Price is allowed." then input again
    // diaplay new Price until price is non-zero and non-negative integer.
    public void enterPrice(){
        int price = Integer.MIN_VALUE;
        do {    
            String temp = JOptionPane.showInputDialog(null, "Enter new price");
            try {
                price = Integer.parseInt(temp);
            } catch (Exception e) {
                System.out.println("No Zero or Negative Price is allowed.");
            }
        } while (price < 0);
        setItemPrice(price);


        
    }

    // return calculated Sales Amount
    public float calSalesAmt(){
        return itemPrice;
    }

    // override to string, print all information
    @Override
    public String toString() {
        return "Item Code: " + itemCode + "\nPrice: " + itemPrice;
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
        System.out.println(i.getItemPrice());

        System.out.println(i);
        System.out.println(i.equals(new HardwareSales(0, "123", 0, 0)));
        System.out.println(i.equals(new HardwareSales(0, "12", 0, 0)));
        System.out.println(i.equals(new Object()));
    }
}