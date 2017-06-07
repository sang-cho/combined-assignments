package com.cooksys.ftd.assignments.socket;

import com.cooksys.ftd.assignments.socket.model.Config;
import com.cooksys.ftd.assignments.socket.model.Student;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Utils {

    /**
     * Reads a {@link Student} object from the given file path
     *
     * @param studentFilePath the file path from which to read the student config file
     * @param jaxb the JAXB context to use during unmarshalling
     * @return a {@link Student} object unmarshalled from the given file path
     */
    public static Student loadStudent(String studentFilePath, JAXBContext jaxb) throws JAXBException,FileNotFoundException {
        Unmarshaller unmarshaller= jaxb.createUnmarshaller();
        Student student=(Student)unmarshaller.unmarshal(new FileInputStream(studentFilePath));
        return student;
        //return null; // TODO
    }

    /**
     * The server should load a {@link com.cooksys.ftd.assignments.socket.model.Config} object from the
     * <project-root>/config/config.xml path, using the "port" property of the embedded
     * {@link com.cooksys.ftd.assignments.socket.model.LocalConfig} object to create a server socket that
     * listens for connections on the configured port.
     *
     * Upon receiving a connection, the server should unmarshal a {@link Student} object from a file location
     * specified by the config's "studentFilePath" property. It should then re-marshal the object to xml over the
     * socket's output stream, sending the object to the client.
     *
     * Following this transaction, the server may shut down or listen for more connections.
     */
    public static void main(String[] args) {
        Config config= null;
        try {
            config = loadConfig("C:/Users/sangc/code/combined-assignments/5-socket-io-serialization/config/config.xml", createJAXBContext());
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try(ServerSocket serversocket= new ServerSocket(config.getLocal().getPort());
        Socket clientsocket=serversocket.accept();
            DataOutputStream out=new DataOutputStream(clientsocket.getOutputStream());){



            Student miserableStudent=loadStudent("C:/Users/sangc/code/combined-assignments/5-socket-io-serialization/config/student.xml",createJAXBContext());

            Marshaller marshall=createJAXBContext().createMarshaller();
            marshall.marshal(miserableStudent,out);

        }
        catch(IOException | JAXBException e){
            System.err.println("No soup for you.");
        }
        // TODO
    }
}
