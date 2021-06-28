package fr.doranco.jaxws;

import java.util.List;

import javax.jws.WebService;

import fr.doranco.entity.Etudiant;
import fr.doranco.jaxws.dao.EtudiantDao;
import fr.doranco.jaxws.dao.IEtudiantDao;

@WebService(endpointInterface = "fr.doranco.jaxws.EtudiantService",
			serviceName = "EtudiantService",
			portName = "EtudiantPort")
public class EtudiantService implements IEtudiantService {

	IEtudiantDao etudiantDao = new EtudiantDao();
	
	@Override
	public Etudiant addEtudiant(Etudiant etudiant) throws Exception {
		if (etudiant == null
				|| etudiant.getNom() == null || etudiant.getNom().isEmpty()
				|| etudiant.getPrenom() == null || etudiant.getPrenom().isEmpty()
				|| etudiant.getSpecialite() == null || etudiant.getSpecialite().isEmpty()) {
			
			throw new IllegalArgumentException("Les param�tres 'nom', 'prenom' et 'specialite' doivent �tre non nuls et non vides !");
		}
		if (etudiant.getAge() != null && etudiant.getAge() <= 0) {
			throw new IllegalArgumentException("L'�ge doit �tre positif !");
		}
		return etudiantDao.addEtudiant(etudiant);
	}

	@Override
	public List<Etudiant> getEtudiants() throws Exception {
		return etudiantDao.getEtudiants();
	}

	@Override
	public Etudiant getEtudiantById(Integer id) throws Exception {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("L'id de l'�tudiant � rechercher doit �tre positif");
		}
		Etudiant etudiant = etudiantDao.getEtudiantbyId(id);
		if (etudiant == null) {
			throw new Exception("l'�tudiant avec l'id '" + id + "' n'existe pas !");
		}
		return etudiant;
	}

}
