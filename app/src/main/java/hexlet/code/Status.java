package hexlet.code;


public final class Status {
    public static final String DELETED = "deleted";
    public static final String ADDED = "added";
    public static final String CHANGED = "changed";
    public static final String UNCHANGED = "unchanged";

    private String statusName;
    private Object newValue;
    private Object oldValue;

    Status(String statusname, Object oldvalue, Object newvalue) {

        this.statusName = statusname;
        this.oldValue = oldvalue;
        this.newValue = newvalue;
    }

    public String getStatusName() {
        return statusName;
    }

    public Object getNewValue() {
        return newValue;
    }

    public Object getOldValue() {
        return oldValue;
    }





}
