public class HardwareSales extends ItemSales {
   
    // attribtues
    float delivery;
    float installationFee;

    // return delivery
    public float getDelivery() {
        return delivery;
    }

    // set new delivery fee
    public void setDelivery(float delivery) {
        this.delivery = delivery;
    }

    // return installation fee
    public float getInstallationFee() {
        return installationFee;
    }

    // set new installation fee
    public void setInstallationFee(float installationFee) {
        this.installationFee = installationFee;
    }
    
    // constructor
    public HardwareSales(float price, String code, float Delivery, float InstallationFee){
        super(price, code);
        this.delivery = Delivery;
        this.installationFee = InstallationFee;
    }
    
    // sales amount = item price (float) + delivery (float)+ instsallation fee (float)
    public float calSalesAmt(){
        return super.getItemPrice() + delivery + installationFee;
    }

    // override toString, print all information regarding Hardware Sales Object.
    @Override
    public String toString() {
        return super.toString() + ".\nDelivery Fee: " + delivery + " and Installation Fee: "+installationFee;
    }
}
