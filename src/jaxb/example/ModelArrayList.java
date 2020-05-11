package jaxb.example;

import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ModelArrayList<T> implements Iterable<T> {

	private ArrayList<T> arrayList;
	
	public ModelArrayList() {
		this.arrayList = new ArrayList<T>();
	}
	
	@XmlAnyElement(lax=true)
	public ArrayList<T> getArrayList() {
		return arrayList;
	}

	public void setArrayList(ArrayList<T> arrayList) {
		this.arrayList = arrayList;
	}

	@Override
	public Iterator<T> iterator() {
		return arrayList.iterator();
	}

}
