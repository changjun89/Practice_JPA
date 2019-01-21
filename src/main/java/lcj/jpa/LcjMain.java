package lcj.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import lcj.jpa.entity.Member;
import lcj.jpa.entity.MemberType;
import lcj.jpa.entity.Team;

public class LcjMain {
	
	public static void main(String[] args) {
		//hello�� persistance.xml persistence-unit name
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		EntityManager em=  emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try{
			Team team = new Team();
			team.setName("TeamA");
			
			Member member = new Member();
			member.setName("이창준");
			member.setAge(31);
			member.setMemberType(MemberType.ADMIN);
			member.setTeam(team);
			
			Member member1 = new Member();
			member1.setName("이창");
			member1.setAge(32);
			member1.setMemberType(MemberType.ADMIN);
			member1.setTeam(team);
			
			em.persist(team);
			em.persist(member);
			em.persist(member1);
			
			em.flush();
			em.clear();
			 
			Member findMember = em.find(Member.class, member.getId());
			
			List<Member> list = findMember.getTeam().getMembers();
			
			for(Member members : list) {
				System.out.println(members.toString());
			}
			System.out.println("팀이름 : "+findMember.getTeam().getName());
			
			tx.commit();
		} catch(Exception e){
			tx.rollback();
		} finally{
			em.close();
		}
		
		emf.close();
	}
}
