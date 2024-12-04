package com.example.part5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String FILE_NAME = "client_data.txt";

    public void saveClients(List<Client> clients) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(clients);
        }
    }

    public List<Client> loadClients() throws IOException, ClassNotFoundException {
        File file = new File(FILE_NAME);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Client>) ois.readObject();
        }
    }
}
