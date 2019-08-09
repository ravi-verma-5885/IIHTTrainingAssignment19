
/**

 *

 */

package com.iiht.training.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Ravi
 *
 */

@Entity
@Table(name="Subject_DB_TBL")
public class Subject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private long subjectId;

	private String subjectTitle;

	private int durationInHours;
	
	@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
	private Set<Book> refences = new HashSet<>();

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectTitle() {
		return subjectTitle;
	}

	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}

	public int getDurationInHours() {
		return durationInHours;
	}

	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}

	public Set<Book> getRefences() {
		return refences;
	}

	public void setRefences(Set<Book> refences) {
		this.refences = refences;
	}

	public Subject() {
		super();
	}

	public Subject(long subjectId, String subtitle, int durationInHours, Set<Book> refences) {
		super();
		this.subjectId = subjectId;
		this.subjectTitle = subtitle;
		this.durationInHours = durationInHours;
		this.refences = refences;
	}

	public Subject(long subjectId, String subjectTitle, int durationInHours) {
		super();
		this.subjectId = subjectId;
		this.subjectTitle = subjectTitle;
		this.durationInHours = durationInHours;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subtitle=" + subjectTitle + ", durationInHours=" + durationInHours
				+ "]";
	}

}
