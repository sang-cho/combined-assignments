package com.cooksys.ftd.assignments.socket;

import com.cooksys.ftd.assignments.socket.model.Config;
import com.cooksys.ftd.assignments.socket.model.Student;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;

public class Client {

    /**
     * The client should load a {@link com.cooksys.ftd.assignments.socket.model.Config} object from the
     * <project-root>/config/config.xml path, using the "port" and "host" properties of the embedded
     * {@link com.cooksys.ftd.assignments.socket.model.RemoteConfig} object to create a socket that connects to
     * a {@link Server} listening on the given host and port.
     *
     * The client should expect the server to send a {@link com.cooksys.ftd.assignments.socket.model.Student} object
     * over the socket as xml, and should unmarshal that object before printing its details to the console.
     */
    public static void main(String[] args) {
        Config leconfig= null;
        try {
            leconfig = Utils.loadConfig("C:/Users/sangc/code/combined-assignments/5-socket-io-serialization/config/config.xml",Utils.createJAXBContext());
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try(Socket socket=new Socket(leconfig.getRemote().getHost(), leconfig.getRemote().getPort());
        DataInputStream input=new DataInputStream(socket.getInputStream());) {
            Unmarshaller unmarshaller = Utils.createJAXBContext().createUnmarshaller();

            Student sadstudent = (Student) unmarshaller.unmarshal(input);
            System.out.println(sadstudent);


        }catch(IOException|JAXBException e){
            System.err.println("Nu uh uh...whats the magic word....");

        }

        // TODO
    }
}
