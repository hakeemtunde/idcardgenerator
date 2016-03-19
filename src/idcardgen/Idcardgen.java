/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idcardgen;

import com.foresight.crudservice.CrudService;
import com.foresight.crudservice.QueryService;
import com.foresight.entity.Company;
import java.util.List;

/**
 *
 * @author hakeemtunde
 */
public class Idcardgen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Can you see me");
        
        
        
        Company company = new Company();
        company.setId(2);
        company.setAddress("Kaduna2");
        company.setName("International Company");
        // Creating a new transaction
	
       
//        CrudService.persist(company);
        


        // Querying the contents of the database using JPQL query
//		Query q = em.createQuery("SELECT p FROM Company p");
                QueryService.setInstance(CrudService.getEntityManager());
                QueryService.buildQuery("SELECT p FROM Company p");
                
		@SuppressWarnings("unchecked")
		List<Company> results = QueryService.getResult();

		System.out.println("List of products\n----------------");

		for (Company p : results) {

			System.out.println(p.getName() + " (id=" + p.getId() + ")");
		}

		// Closing connection
		CrudService.closeEntityManager();
        
        
    }
    
}
