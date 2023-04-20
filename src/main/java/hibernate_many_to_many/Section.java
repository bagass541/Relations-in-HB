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
@Table(name = "section")
public class Section {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST})
	@JoinTable(name = "child_section", 
				joinColumns = @JoinColumn(name = "section_id"), 
				inverseJoinColumns = @JoinColumn(name = "child_id"))
	private List<Child> children;
	
	public void addChildToSection(Child child)
	{
		if(children == null)
		{
			children = new ArrayList<>();
		}
		children.add(child);
	}

	@Override
	public String toString() {
		return "Section [id=" + id + ", name=" + name + "]";
	}

	public List<Child> getChildren() {
		return children;
	}

	public void setChildren(List<Child> children) {
		this.children = children;
	}

	public Section() {
	}

	public Section( String name) {
		this.name = name;
	}
	
	
	
	
}
