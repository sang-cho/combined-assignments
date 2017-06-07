package com.cooksys.ftd.assignments.socket;

import com.cooksys.ftd.assignments.socket.model.Config;
import com.cooksys.ftd.assignments.socket.model.Student;

import javax.xml.bind.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Shared static methods to be used by both the {@link Client} and {@link Server} classes.
 */
public class Utils {
    /**
     * @return a {@link JAXBContext} initialized with the classes in the
     * com.cooksys.socket.assignment.model package
     */
    public static JAXBContext createJAXBContext() throws JAXBException{
        JAXBContext context=JAXBContext.newInstance(Config.class, Student.class);
        return context;
    }

    /**
     * Reads a {@link Config} object from the given file path.
     *
     * @param configFilePath the file path to the config.xml file
     * @param jaxb the JAXBContext to use
     * @return a {@link Config} object that was read from the config.xml file
     */
    public static Config loadConfig(String configFilePath, JAXBContext jaxb) throws JAXBException, FileNotFoundException{
        Unmarshaller unmarshall = jaxb.createUnmarshaller();
        Config stuff=(Config)unmarshall.unmarshal((new FileInputStream(configFilePath)));
        return stuff;

        //return null; // TODO
    }
}
