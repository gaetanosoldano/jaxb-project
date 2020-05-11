package jaxb.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Engine {

	public static void main(String[] args) {

	}

	void marshal(Model model) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMdd_HHmm_ss_SS");
		LocalDateTime now = LocalDateTime.now();
		String dateTime = now.format(formatter);
		try {
			JAXBContext jaxb = JAXBContext.newInstance(Model.class);
			Marshaller marshaller = jaxb.createMarshaller();
			marshaller.setProperty("com.sun.xml.internal.bind.xmlHeaders", "\n<!DOCTYPE xml>");
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(model, new FileOutputStream(dateTime + ".xml"));
			marshaller.marshal(model, System.out);
		} catch (JAXBException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	void unmarshal() {
		try {
			File file = new File("xmlfile.xml");
			JAXBContext jaxb = JAXBContext.newInstance(Model.class);
			Unmarshaller unmarshaller = jaxb.createUnmarshaller();
			Model model = (Model) unmarshaller.unmarshal(file);
			System.out.printf("%d %s %s\n", model.getId(), model.getName(), model.getYear());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
