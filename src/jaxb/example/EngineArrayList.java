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

public class EngineArrayList {

	public static void main(String[] args) {

	}

	<T> void marshal(ModelArrayList<T> arrayList) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMdd_HHmm_ss_SS");
		LocalDateTime now = LocalDateTime.now();
		String dateTime = now.format(formatter);
		try {
			JAXBContext jaxb = JAXBContext.newInstance(ModelArrayList.class, Model.class);
			Marshaller marshaller = jaxb.createMarshaller();
			marshaller.setProperty("com.sun.xml.internal.bind.xmlHeaders", "\n<!DOCTYPE xml>");
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(arrayList, new FileOutputStream(dateTime + ".xml"));
			marshaller.marshal(arrayList, System.out);
		} catch (JAXBException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	<T> void unmarshal() {
		try {
			File file = new File("xmlfile.xml");
			JAXBContext jaxb = JAXBContext.newInstance(ModelArrayList.class, Model.class);
			Unmarshaller unmarshaller = jaxb.createUnmarshaller();
			ModelArrayList<T> arrayList = (ModelArrayList<T>) unmarshaller.unmarshal(file);
			Marshaller marshaller = jaxb.createMarshaller();
			marshaller.setProperty("com.sun.xml.internal.bind.xmlHeaders", "\n<!DOCTYPE xml>");
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(arrayList, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
