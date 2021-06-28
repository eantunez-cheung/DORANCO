package fr.doranco.rest.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employes {

	List<Employe> employeList;

	public List<Employe> getEmployeList() {
		return employeList;
	}
}
