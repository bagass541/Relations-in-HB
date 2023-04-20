package hibernate_many_to_many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "children")
public class Child {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String firstName;
	
	@Column(name = "age")
	private int age;
	
	@ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST})
	@JoinTable(name = "child_section", 
				joinColumns = @JoinColumn(name = "child_id"), 
				inverseJoinColumns = @JoinColumn(name = "section_id"))
	private List<Section> sections;


	public void addSectionToChild(Section section)
	{
		if(sections == null)
		{
			sections = new ArrayList<>();
		}
		sections.add(section);
	}
	
	public Child() {
	}


	public Child(String firstName, int age) {
		super();
		this.firstName = firstName;
		this.age = age;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public List<Section> getSections() {
		return sections;
	}


	public void setSections(List<Section> sections) {
		this.sections = sections;
	}


	@Override
	public String toString() {
		return "Child [id=" + id + ", firstName=" + firstName + ", age=" + age + "]";
	}
	
	
	
	
}
