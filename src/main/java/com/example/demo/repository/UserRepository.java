package com.example.demo.repository;

import role.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static final String ADDRESS_FILE = "src/main/resources/Users.csv";

    public User getUser (String login, String password){
        List<User> users = readUsersFromCSV(ADDRESS_FILE);
        for (User u : users) {
            if (login.equals(u.getLogin())&&password.equals(u.getPassword())){
                return u;
            }
        }
        return null;
    }

    public List<User>  getAllUsers (){
        return readUsersFromCSV(ADDRESS_FILE);
    }

    private static List<User> readUsersFromCSV(String fileName) {
        List<User> users = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {

            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                User user = createUser(attributes);
                users.add(user);
                line = br.readLine();
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return users;
    }

    private static User createUser(String[] metadata) {
        int id = Integer.parseInt(metadata[0]);
        String role = metadata[1];
        String login = metadata[2];
        String password = metadata[3];
        String email = metadata[4];
        return new User(id, role, login, password, email);
    }

    public void addUser (User user) throws FileNotFoundException {
        try(FileWriter writer = new FileWriter(ADDRESS_FILE, true))
        {
            writer.append("\n");
            writer.append(String.valueOf(user.getId()));
            writer.append(",");
            writer.append(user.getRole());
            writer.append(",");
            writer.append(user.getLogin());
            writer.append(",");
            writer.append(user.getPassword());
            writer.append(",");
            writer.append(user.getEmail());

            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
