package Controller;

import Entity.Student;

import java.io.*;
import java.util.List;

public abstract class BaseManagerFile<T> {
    protected String fileName;
    protected List<Student> dataList;
    protected FileManager fileManager;

    public BaseManagerFile(String fileName, List<Student> dataList) {
        this.fileName = fileName;
        this.dataList = dataList;
        this.fileManager = new FileManager(fileName);
    }



    public void saveDataToFile(List<Student> studentsList) {
        fileManager.writeFile(studentsList);
    }


    public void addData(Student data) {
        dataList.add(data);
        saveDataToFile(dataList);
    }

    public void removeData(Student data) {
        dataList.remove(data);
        saveDataToFile(dataList);
    }

    public void removeDataByIndex(int index) {
        if (index >= 0 && index < dataList.size()) {
            dataList.remove(index);
            saveDataToFile(dataList);
        }
    }

    public List<Student> getDataList() {
        return dataList;
    }

    protected abstract String convertDataToString();

    protected abstract List<T> parseFileContent(String fileContent);
}
