package thescore.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import thescore.interfaces.IRecord;

@Entity(name = Newsfeed.ENTITY_NAME)
public class Newsfeed implements IRecord {

	public static final String ENTITY_NAME = "tbl_basta_newsfeed";
	private static final long serialVersionUID = 4776520911339952390L;

	private Integer id;
	private PlayerPerformance performance;
	private String description;
	private Date date;
	
	@Id
	@Override
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	
	@ManyToOne(targetEntity = PlayerPerformance.class)
	@JoinColumn(name = "performanceId")
	public PlayerPerformance getPerformance() {
		return performance;
	}

	public void setPerformance(PlayerPerformance performance) {
		this.performance = performance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Transient
	@Override
	public String getDisplayString() {
		return description;
	}

	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
