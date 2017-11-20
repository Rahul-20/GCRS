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
@Table(name = "BOOK", schema=SchemaConstant.GC_APP_SCHEMA)
public class Book  extends GenericEntity<Long, Book>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8755799199503489635L;

	@Id
	@Column(name = "BOOK_ID", unique=true, nullable=false)
	@TableGenerator(name = "TABLE_GEN", table = "GC_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
		pkColumnValue = "BOOK_SEQ_NEXT_VAL")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    private Long id;

	@NotEmpty
	@Column(name = "NAME", nullable=false, length=100)
    private String name;
	
    private Double price;

    public Book() {
    }

    public Book(String name, Double price) {
        this.name = name;
        this.price = price;
    }

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}