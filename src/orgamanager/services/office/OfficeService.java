package orgamanager.services.office;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

// TODO delete class, if other services and orm use cases exists
public class OfficeService { // TODO describe usage of service layer

	// encapsulate database interaction
	// look at database with firefox addon sqlite manager, see orgamanager.sql
	
//	public List<InvoiceRecipient> getInvoiceRecipients(){
//		String PERSISTENCE_UNIT_NAME = "OrgaManager"; // see META-INF persistence.xml
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME); // see JPA book p 57
//		EntityManager em = emf.createEntityManager();
//		String qs = "select r from InvoiceRecipient r";
//		Query q = em.createQuery(qs); // find all entries
//		List<InvoiceRecipient> recipientsList = q.getResultList();
//		int size = recipientsList.size();
//		if (size == 0) { // no entries
//			return null;
//		}
//		em.close(); // close 1
//		emf.close(); // close 2
//		return recipientsList;
//	}
//	
//	public InvoiceRecipient getDefaultInvoiceRecipient(){ // service layer pattern // TODO test
//		// JPA EclipseLink, create emf, em and close afterwards!
//		String PERSISTENCE_UNIT_NAME = "OrgaManager"; // see META-INF persistence.xml
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME); // see JPA book p 57
//		EntityManager em = emf.createEntityManager();
//		String qs = "select r from InvoiceRecipient r";
//		Query q = em.createQuery(qs); // find all entries
//		List<InvoiceRecipient> recipientsList = q.getResultList();
//		int size = recipientsList.size();
//		System.out.println("Size: " + size + ";");
//		InvoiceRecipient defaultRecipient = null;
//		if (size == 0) { // no entries
//			defaultRecipient = new InvoiceRecipient();
//			recipientsList.add(defaultRecipient);
//		} else {
//			String searchCriteriaLastName = "Aal";
//			Long recId;
//			for (InvoiceRecipient rec : recipientsList) {
//				String lastName = rec.getLastName();
//				if (lastName.equals(searchCriteriaLastName)) {
//					recId = rec.getId();
//					defaultRecipient = em.find(InvoiceRecipient.class, recId);
//					break;
//				}
//			}
//		}
//		em.persist(defaultRecipient); // set object to state managed
//		em.getTransaction().begin(); // start synchronizing
//		em.getTransaction().commit(); // start to work
//		em.close(); // close 1
//		emf.close(); // close 2
//		return defaultRecipient;
//	}
	
}
