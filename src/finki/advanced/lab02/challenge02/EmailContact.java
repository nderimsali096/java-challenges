package finki.advanced.lab02.challenge02;

public class EmailContact extends Contact{
    private final String email;

    public EmailContact(String date, String email) {
        super(date);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getType() {
        return "Email";
    }
}
