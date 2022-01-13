package finki.advanced.exercises.no4;


import java.util.Date;

public abstract class Archive {
    private int id;
    private Date dateArchived;

    public Archive(int id, Date dateArchived) {
        this.id = id;
        this.dateArchived = dateArchived;
    }

    public Archive(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Date getDateArchived() {
        return dateArchived;
    }
}

class LockedArchive extends Archive {

    private final Date dateToOpen;

    public LockedArchive(int id, Date dateArchived, Date dateToOpen) {
        super(id, dateArchived);
        this.dateToOpen = dateToOpen;
    }

    public LockedArchive(int id, Date dateToOpen) {
        super(id);
        this.dateToOpen = dateToOpen;
    }

    public Date getDateToOpen() {
        return dateToOpen;
    }
}

class SpecialArchive extends Archive {
    private final int maxOpen;
    private int numberOfOpens;

    public SpecialArchive(int id, Date dateArchived, int maxOpen) {
        super(id, dateArchived);
        this.maxOpen = maxOpen;
        this.numberOfOpens = 0;
    }

    public SpecialArchive(int id, int maxOpen) {
        super(id);
        this.maxOpen = maxOpen;
        this.numberOfOpens = 0;
    }

    public int getMaxOpen() {
        return maxOpen;
    }

    public boolean setNumberOfOpens() {
        this.numberOfOpens++;
        return this.numberOfOpens < this.maxOpen;
    }
}
