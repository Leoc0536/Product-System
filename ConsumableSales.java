public class ConsumableSales extends ItemSales {
    // attributes
    private int qtySold;
    
    // return quantity sold
    public int getQtySold() {
        return this.qtySold;
    }

    // set new quantity sold
    public void setQtySold(int qtySold) {
        this.qtySold = qtySold;
    }

    // constructor
    public ConsumableSales(float price, String code, int sold){
        super(price, code);
        this.qtySold = sold;
    }
    
    // return calculated sales amount
    public float calSalesAmt(){
        return super.getItemPrice() * qtySold;
    }

    // override toString, print all information regarding Consumable Sales obejct.
    @Override
    public String toString() {
        return super.toString() + " and quantity sold " + this.qtySold;
    }
}
