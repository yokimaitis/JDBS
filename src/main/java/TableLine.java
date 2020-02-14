public class TableLine {
    private String nameField;
    private Integer idField;

    public TableLine(String nameField, Integer idField) {
        this.nameField = nameField;
        this.idField = idField;
    }

    public String getNameField() {
        return nameField;
    }

    public Integer getIdField() {
        return idField;
    }

    public void setNameField(String nameField) {
        this.nameField = nameField;
    }

    public void setIdField(Integer idField) {
        this.idField = idField;
    }

    public TableLine() {
    }
}
