package finki.advanced.lab02.challenge02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Contact {
    private final String date;

    public Contact(String date) {
        this.date = date;
    }

    public boolean isNewerThan(Contact c) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date contactDate = simpleDateFormat.parse(c.getDate());
        Date thisDate = simpleDateFormat.parse(this.getDate());
        return thisDate.compareTo(contactDate) > 0;
    }

    public abstract String getType();

    public String getDate() {
        return date;
    }
}
