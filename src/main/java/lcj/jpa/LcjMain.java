package lcj.jpa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import lcj.jpa.entity.Member;
import lcj.jpa.entity.MemberType;
import lcj.jpa.entity.Team;

public class LcjMain {
	
	public static void main(String[] args) {
		//hello persistance.xml persistence-unit name
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		EntityManager em=  emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try{
			Team team = new Team();
			team.setName("TeamA");
			em.persist(team);
			
			Member member1 = new Member();
			member1.setName("이창준");
			member1.setAge(32);
			member1.setMemberType(MemberType.ADMIN);
			member1.setTeam(team);
			
			em.persist(member1);
			em.flush();
			em.clear();
			
			Member findMember = em.find(Member.class, member1.getId());
			em.close();
			Team team2 = findMember.getTeam();
			
			team2.getName();
			
			//em.detach(findMember);
			
			
			findMember.setName("하하하");
			
			tx.commit();
		} catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		} finally{
			em.close();
		}
		
		emf.close();
	}
}
