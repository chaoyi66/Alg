package playground;

public enum SingleInstance {
    INSTANCE;

    private String tagName;
    public void setTag(String tagName) {
        this.tagName = tagName;
    }

    public String getTag() {
        return tagName;
    }
}
