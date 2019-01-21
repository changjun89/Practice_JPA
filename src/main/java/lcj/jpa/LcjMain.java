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
		//hello는 persistance.xml persistence-unit name
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		EntityManager em=  emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try{
			Team team = new Team();
			team.setName("TeamA");
			em.persist(team);
			
			Member member = new Member();
			member.setName("이창준");
			member.setAge(31);
			member.setMemberType(MemberType.ADMIN);
			em.persist(member);
			 
			
			Member findMember = em.find(Member.class, member.getId());
			System.out.println("먼저 :" +findMember.getAge());
			
			findMember.setAge(33);
			
			Member findMember1 = em.find(Member.class, member.getId());
			System.out.println("2번째 :" +findMember.getAge());
			
			tx.commit();
		} catch(Exception e){
			tx.rollback();
		} finally{
			em.close();
		}
		
		emf.close();
	}
}
