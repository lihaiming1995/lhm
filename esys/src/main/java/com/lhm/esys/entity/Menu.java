/**
 * 
 */
package com.qfedu.esys.entity;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author cailei
 *
 */
@Entity
@Table(name="sys_menu")
/*@JsonIgnoreProperties(value={""}) */ 
public class Menu {
	@SuppressWarnings("unused")
	private final static Logger LOG = LogManager.getLogger(Menu.class);
	@Id
	@Column(length=50)
	private String id;
	
	@Column(length=50)
	private String name;
	
	@Column(length=50)
	private String no;
	
	@Column(length=50)
	private String icon;
	@Column(length=50)
	
	private String resource;
	@Column(length=50)
	
	private String resourceType;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}

	public List<Menu> getChildren(){
		return children;
	}
	/*@JsonBackReference*/
	public void setChildren(List<Menu> children) {
		this.children = children;
	}

	@ManyToOne
	@JoinColumn(name="parent_id")
	private Menu parent;
	
	@JsonIgnore
	@OneToMany(mappedBy="parent",fetch=FetchType.EAGER)
	private  List<Menu> children;
	
	
	
	
	
}
