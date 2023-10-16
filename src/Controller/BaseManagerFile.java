package Controller;

import java.io.*;
import java.util.List;

public abstract class BaseManagerFile<T> {
    protected String fileName;
    protected List<T> dataList;
    protected FileManager fileManager;

    public BaseManagerFile(String fileName, List<T> dataList) {
        this.fileName = fileName;
        this.dataList = dataList;
        this.fileManager = new FileManager(fileName);
    }

    public void loadDataFromFile() {
        String fileContent = fileManager.readFile();
        // Parse file content and populate the dataList (e.g., convert from text to objects)
        // Example: dataList = parseFileContent(fileContent);
    }

    public void saveDataToFile() {
        String fileContent = convertDataToString(); // Convert the dataList to a string representation
        fileManager.writeFile(fileContent);
    }

    public void addData(T data) {
        dataList.add(data);
        saveDataToFile();
    }

    public void removeData(T data) {
        dataList.remove(data);
        saveDataToFile();
    }

    public void removeDataByIndex(int index) {
        if (index >= 0 && index < dataList.size()) {
            dataList.remove(index);
            saveDataToFile();
        }
    }

    public List<T> getDataList() {
        return dataList;
    }

    protected abstract String convertDataToString();

    protected abstract List<T> parseFileContent(String fileContent);
}
