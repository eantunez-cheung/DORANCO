package fr.doranco.ecommerce.metier;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import fr.doranco.ecommerce.entity.beans.Commande;
import fr.doranco.ecommerce.model.dao.CommandeDao;
import fr.doranco.ecommerce.model.dao.ICommandeDao;

public class CommandeMetier implements ICommandeMetier {

	private ICommandeDao commandeDao = new CommandeDao();
	
	@Override
	public void add(Commande commande) throws Exception {
		if (commande == null
				|| commande.getDateLivraison() == null || commande.getDateCreation() == null
				|| commande.getTotalRemise() == null || commande.getTotalRemise() < 0
				|| commande.getFraisExpedition() == null || commande.getFraisExpedition() < 0
				|| commande.getTotalGeneral() == null || commande.getTotalGeneral() < 0
				|| commande.getAdresseFacturation() == null || commande.getAdresseLivraison() == null
				|| commande.getCartePaiementDefault() == null) {
			throw new IllegalArgumentException("Les param�tres doivent �tre non nuls "
					+ "et les param�tres 'totalRemise', 'fraisExpedition' et 'totalGeneral' doivent �tre positifs !");
		}
		commandeDao.add(commande);
	}

	@Override
	public Commande getCommande(Integer id) throws Exception {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Le param�tre 'id' doit �tre sup�rieur � 0 !");
		}
		return commandeDao.get(Commande.class, id);
	}

	@Override
	public Commande getCommandesByNumero(String numero) throws Exception {
		if (numero == null || numero.trim().isEmpty()) {
			throw new IllegalArgumentException("Le param�tre 'numero' doit �tre non nul et non vide !");
		}
		return commandeDao.getCommandesByNumero(numero);
	}

	@Override
	public Set<Commande> getCommandes() throws Exception {
		return new HashSet<Commande>(commandeDao.getAll(Commande.class));
	}

	@Override
	public Set<Commande> getCommandesByDateCreation(Date dateCreation) throws Exception {
		if (dateCreation == null) {
			throw new IllegalArgumentException("Le param�tre 'dateCreation' doit �tre non nul !");
		}
		return commandeDao.getCommandesByDateCreation(dateCreation);
	}

	@Override
	public Set<Commande> getCommandesByUserId(Integer userId) throws Exception {
		if (userId == null || userId <= 0) {
			throw new IllegalArgumentException("Le param�tre 'userId' doit �tre sup�rieur � 0 !");
		}
		return commandeDao.getCommandesByUserId(userId);
	}

}
