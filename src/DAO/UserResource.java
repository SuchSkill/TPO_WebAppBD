package DAO;

public class UserResource {
    private int id;
    private String name;
    private String text;

    @Override
    public String toString() {
        return "UserResource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserResource(int id, String name, String text) {

        this.id = id;
        this.name = name;
        this.text = text;
    }
}
