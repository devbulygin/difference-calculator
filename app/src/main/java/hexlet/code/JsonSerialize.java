package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class JsonSerialize {
    private List<Map<String, Object>> add = new ArrayList<>();
    private List<Map<String, Object>> del = new ArrayList<>();
    private List<List<Map<String, Object>>> chang = new ArrayList<>();
    private List<Map<String, Object>> unchang = new ArrayList<>();


    public List<Map<String, Object>> getAdded() {
        return add;
    }

    public void setAdded(List<Map<String, Object>> added) {
        this.add = added;
    }

    public List<Map<String, Object>> getDeleted() {
        return del;
    }

    public void setDeleted(List<Map<String, Object>> deleted) {
        this.del = deleted;
    }


    public List<Map<String, Object>> getUnchanged() {

        return unchang;
    }

    public void setUnchanged(List<Map<String, Object>> unchanged) {

        this.unchang = unchanged;
    }

    public List<List<Map<String, Object>>> getChanged() {

        return chang;
    }

    public void setChanged(List<List<Map<String, Object>>> changed) {

        this.chang = changed;
    }
}


