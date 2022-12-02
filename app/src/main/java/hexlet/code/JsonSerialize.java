package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class JsonSerialize {
    private List<Map<String, Object>> added = new ArrayList<>();
    private List<Map<String, Object>> deleted = new ArrayList<>();
    private List<List<Map<String, Object>>> changed = new ArrayList<>();
    private List<Map<String, Object>> unchanged = new ArrayList<>();

    public List<Map<String, Object>> getAdded() {
        return added;
    }

    public void setAdded(List<Map<String, Object>> add) {
        this.added = add;

    }

    public List<Map<String, Object>> getDeleted() {
        return deleted;
    }

    public void setDeleted(List<Map<String, Object>> del) {
        this.deleted = del;
    }

    public List<List<Map<String, Object>>> getChanged() {
        return changed;
    }

    public void setChanged(List<List<Map<String, Object>>> change) {
        this.changed = change;
    }

    public List<Map<String, Object>> getUnchanged() {
        return unchanged;
    }

    public void setUnchanged(List<Map<String, Object>> unchange) {
        this.unchanged = unchange;
    }
}


