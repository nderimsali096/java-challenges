package finki.advanced.exercises.no4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArchiveStore {
    private List<Archive> archives;
    private String finalLog;

    public ArchiveStore() {
        this.archives = new ArrayList<>();
        this.finalLog = "";
    }

    public void archiveItem(Archive item, Date date){
        this.archives.add(item);
        this.finalLog += "Item " + item.getId() + " archived at " + date + "\n";
    }

    public void openItem(int id, Date date) throws NonExistingItemException {
        boolean flag = true;
        Archive currentArchive = null;
        for (Archive archive : this.archives) {
            if (archive.getId() == id) {
                flag = false;
                currentArchive = archive;
                break;
            }
        }
        if (flag) throw new NonExistingItemException("Item with id " + id + " doesn't exist");
        if (currentArchive instanceof LockedArchive) {
            LockedArchive lockedArchive = (LockedArchive) currentArchive;
            if (date.compareTo(lockedArchive.getDateToOpen()) < 0){
                this.finalLog += "Item " + id + " cannot be opened before " + lockedArchive.getDateToOpen() + "\n";
            } else {
                this.finalLog += "Item " + id + " opened at " + date + "\n";
            }
        } else {
            SpecialArchive specialArchive = (SpecialArchive) currentArchive;
            if (specialArchive.setNumberOfOpens()) {
                this.finalLog += "Item " + id + " opened at " + date + "\n";
            } else {
                String subString = "Item " + id + " cannot be opened more than " + specialArchive.getMaxOpen() + " times\n";
                if (!this.finalLog.contains(subString)) this.finalLog += subString;
            }
        }
    }

    public String getLog() {
        return this.finalLog;
    }
}

class NonExistingItemException extends Exception {


    public NonExistingItemException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
