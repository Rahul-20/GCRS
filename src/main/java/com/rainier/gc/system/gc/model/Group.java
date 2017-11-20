package com.rainier.gc.system.gc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.validator.constraints.NotEmpty;

import com.rainier.gc.system.gc.model.generic.GenericEntity;


@Entity
@Table(name = "GC_GROUP", schema=SchemaConstant.GC_APP_SCHEMA)
public class Group extends GenericEntity<Long, Group> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3786127652573709701L;
	@Id
	@Column(name = "GROUP_ID", unique=true, nullable=false)
	@TableGenerator(name = "TABLE_GEN", table = "GC_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
				pkColumnValue = "GROUP_SEQ_NEXT_VAL")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
	private Long id;
	
	public Group() {
	}
	
/*	@ManyToMany(mappedBy = "groups")
	private Set<User> users = new HashSet<User>();	
*/
	@NotEmpty
	@Column(name="GROUP_NAME", unique=true)
	private String groupName;
	
	public Group(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
/*	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
*/
}
