package com.chakra.root.hrm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "APP_PAGES")
public class Pages implements Serializable {

	private static final long serialVersionUID = -4198250177901866382L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(name = "PAGE_NAME", nullable = false)
	private String name;

	@Column(name = "PAGE_DESC", nullable = true)
	private String desc;

	@NotEmpty
	@Column(name = "UPDATE_RIGHT", nullable = false)
	private boolean update;

	@NotEmpty
	@Column(name = "SAVE_RIGHT", nullable = false)
	private boolean save;

	@NotEmpty
	@Column(name = "SEARCH_RIGHT", nullable = false)
	private boolean search;

	@NotEmpty
	@Column(name = "VIEW_RIGHT", nullable = false)
	private boolean view;

	@NotEmpty
	@Column(name = "DELETE_RIGHT", nullable = false)
	private boolean delete;

	@NotEmpty
	@Column(name = "ADMIN_RIGHT", nullable = false)
	private boolean adminOnly;

	@Column(name = "WHOCOLUMN", nullable = true)
	private String who;

	@ManyToOne(optional = false)
	@JoinColumn(name = "MODULE_ID")
	private Module module;

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

	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}

	public boolean isSave() {
		return save;
	}

	public void setSave(boolean save) {
		this.save = save;
	}

	public boolean isSearch() {
		return search;
	}

	public void setSearch(boolean search) {
		this.search = search;
	}

	public boolean isView() {
		return view;
	}

	public void setView(boolean view) {
		this.view = view;
	}

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	public boolean isAdminOnly() {
		return adminOnly;
	}

	public void setAdminOnly(boolean adminOnly) {
		this.adminOnly = adminOnly;
	}

	public String getWho() {
		return who;
	}

	public void setWho(String who) {
		this.who = who;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (adminOnly ? 1231 : 1237);
		result = prime * result + (delete ? 1231 : 1237);
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((module == null) ? 0 : module.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (save ? 1231 : 1237);
		result = prime * result + (search ? 1231 : 1237);
		result = prime * result + (update ? 1231 : 1237);
		result = prime * result + (view ? 1231 : 1237);
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
		Pages other = (Pages) obj;
		if (adminOnly != other.adminOnly)
			return false;
		if (delete != other.delete)
			return false;
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
		if (module == null) {
			if (other.module != null)
				return false;
		}
		else if (!module.equals(other.module))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		}
		else if (!name.equals(other.name))
			return false;
		if (save != other.save)
			return false;
		if (search != other.search)
			return false;
		if (update != other.update)
			return false;
		if (view != other.view)
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
		return "Pages [id=" + id + ", name=" + name + ", desc=" + desc + ", update="
				+ update + ", save=" + save + ", search=" + search + ", view=" + view
				+ ", delete=" + delete + ", adminOnly=" + adminOnly + ", who=" + who
				+ ", module=" + module + "]";
	}

}
