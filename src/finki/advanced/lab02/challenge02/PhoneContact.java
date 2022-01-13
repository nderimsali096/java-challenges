package finki.advanced.lab02.challenge02;


public class PhoneContact extends Contact{

    public enum Operator{
        VIP , ONE , TMOBILE
    }

    private final String phone;
    private final Operator operator;

    public PhoneContact(String date, String phone) {
        super(date);
        this.phone = phone;
        if (phone.charAt(2) == '0' || phone.charAt(2) == '1' || phone.charAt(2) == '3') this.operator = Operator.TMOBILE;
        else if(phone.charAt(2) == '5' || phone.charAt(2) == '6') this.operator = Operator.ONE;
        else this.operator = Operator.VIP;
    }

    public String getPhone() {
        return phone;
    }

    public Operator getOperator() {
        return operator;
    }

    @Override
    public String getType() {
        return "Phone";
    }
}
