package com.chakra.root.hrm.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "APP_MODULES")
public class Module implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 67995777444564351L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(name = "MODULE_NAME", nullable = false)
	private String name;

	@Column(name = "MODULE_DESC", nullable = true)
	private String desc;

	@Column(name = "WHOCOLUMN", nullable = true)
	private String who;

	@OneToMany(mappedBy = "module", cascade = CascadeType.ALL)
	private Set<Pages> pages = new HashSet<Pages>();

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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getWho() {
		return who;
	}

	public void setWho(String who) {
		this.who = who;
	}

	public Set<Pages> getPages() {
		return pages;
	}

	public void setPages(Set<Pages> pages) {
		this.pages = pages;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pages == null) ? 0 : pages.hashCode());
		result = prime * result + ((who == null) ? 0 : who.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Module other = (Module) obj;
		if (desc == null) {
			if (other.desc != null)
				return false;
		}
		else if (!desc.equals(other.desc))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		}
		else if (!name.equals(other.name))
			return false;
		if (pages == null) {
			if (other.pages != null)
				return false;
		}
		else if (!pages.equals(other.pages))
			return false;
		if (who == null) {
			if (other.who != null)
				return false;
		}
		else if (!who.equals(other.who))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Module [id=" + id + ", name=" + name + ", desc=" + desc + ", who=" + who
				+ ", pages=" + pages + "]";
	}
}
