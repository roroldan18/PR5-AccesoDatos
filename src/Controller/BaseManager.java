package Controller;

public abstract class BaseManager {
    protected String path;

    public BaseManager(String path) {
        this.path = path;
    }

    public void viewAll(){
        try {
            FileManager fm = new FileManager(path);
            fm.readFile();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void add(Object object){
        try {
            FileManager fm = new FileManager(path);
            fm.writeFile(object.toString());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void remove(String dni){
        try {
            FileManager fm = new FileManager(path);
            fm.removeLine(dni);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
