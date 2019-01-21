package lcj.jpa.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Member {
		
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="USERNAME", nullable=false, length=20)
	private String name;
	
	private int age;
	
	@Enumerated(EnumType.STRING)
	private MemberType memberType;
	
	@Lob
	private String contents;
	
//	@Column(name="TEAM_Id")
//	private Long teamId;
	
	@ManyToOne
	@JoinColumn(name="TEAM_ID")
	private Team team;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public MemberType getMemberType() {
		return memberType;
	}

	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

//	public Long getTeamId() {
//		return teamId;
//	}
//
//	public void setTeamId(Long teamId) {
//		this.teamId = teamId;
//	}

	
		
}
